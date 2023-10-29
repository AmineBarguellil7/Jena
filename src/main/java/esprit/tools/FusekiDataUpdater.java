package esprit.tools;


import org.apache.jena.fuseki.server.DataService;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.query.Dataset;
import org.apache.jena.query.DatasetFactory;
import org.apache.jena.fuseki.server.DataAccessPoint;
import org.apache.jena.query.DatasetAccessor;
import org.apache.jena.query.DatasetAccessorFactory;
import org.apache.jena.fuseki.server.DataServiceFactory;




public class FusekiDataUpdater {
    public void updateDataToFuseki(Model dataModel, String fusekiServiceEndpoint) {
        // Create a dataset using the provided data model
        Dataset dataset = DatasetFactory.create(dataModel);

        // Create a DataService
        DataService dataService = DataServiceFactory.create(dataset);

        // Create a DataAccessPoint for your Fuseki service
        String datasetURI = fusekiServiceEndpoint + "/data";
        DataAccessPoint dataAccessPoint = new DataAccessPoint(datasetURI, dataService);
        DatasetAccessor accessor = DatasetAccessorFactory.createHTTP(dataAccessPoint);

        // Now you can use the accessor to update the dataset
        accessor.putModel(dataModel);
    }
}







