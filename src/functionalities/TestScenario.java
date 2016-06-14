package functionalities;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;

/**
 * Created by Lars on 14.06.2016.
 */
public class TestScenario extends FunctionObject {
    public TestScenario(Model _model) {
        super(_model);
    }

    @Override
    public void start() {
        // Create a new query
        String queryString =
                "PREFIX vcard: <http://www.w3.org/2001/vcard-rdf/3.0#>" +
                        "SELECT ?fullname " +
                        "WHERE {" +
                        "      ?user vcard:FN ?fullname . " +
                        "      }";

        Query query = QueryFactory.create(queryString);

        // Execute the query and obtain results
        QueryExecution qe = QueryExecutionFactory.create(query, model);
        ResultSet results = qe.execSelect();

        // Output query results
        ResultSetFormatter.out(System.out, results, query);

        // Important – free up resources used running the query
        qe.close();
    }

    @Override
    public String getIdentifier() {
        return "test";
    }

    @Override
    public String getDescription() {
        return "Fuehrt eine Test Sparql-Anfrage auf das Test-Modell aus.";
    }
}
