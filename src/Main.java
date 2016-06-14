import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;
import org.apache.jena.util.FileManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.InputStream;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    // create an empty model
    public static Model model = ModelFactory.createDefaultModel();

    public static void main(String[] args) {
        System.out.println("Read RDF XML File");
        readRDFXML();
        System.out.println("---------------------------------------------");
        System.out.println("Sparql");
        sparqlQuery();
    }

    public static void sparqlQuery() {
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

    public static void readRDFXML() {

        // use the FileManager to find the input file
        InputStream in = FileManager.get().open("rdf/test.xml");
        if (in == null) {
            throw new IllegalArgumentException(
                    "File: " + "rdf/test.xml" + " not found");
        }

        // read the RDF/XML file
        model.read(in, null);

        // write it to standard out
        model.write(System.out);

    }

    public static void createModel() {
        System.out.println("Hello World!");

        Model m = ModelFactory.createDefaultModel();

        String NS = "http://example.com/test/";

        Resource r = m.createResource (NS + "r");
        Property p = m.createProperty (NS + "p");

        r.addProperty (p, "hello world", XSDDatatype.XSDstring);

        m.write (System.out, "Turtle");
    }
}
