import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.rdf.model.*;
import org.apache.jena.util.FileManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.InputStream;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        /*System.out.println("Hello World!");

        Model m = ModelFactory.createDefaultModel();

        String NS = "http://example.com/test/";

        Resource r = m.createResource (NS + "r");
        Property p = m.createProperty (NS + "p");

        r.addProperty (p, "hello world", XSDDatatype.XSDstring);

        m.write (System.out, "Turtle");*/

        // create an empty model
        Model model = ModelFactory.createDefaultModel();

        // use the FileManager to find the input file
        InputStream in = FileManager.get().open( "test.xml" );
        if (in == null) {
            throw new IllegalArgumentException(
                    "File: " + "test.xml" + " not found");
        }

        // read the RDF/XML file
        model.read(in, null);

        // write it to standard out
        model.write(System.out);
    }
}
