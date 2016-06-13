import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.rdf.model.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Model m = ModelFactory.createDefaultModel();

        String NS = "http://example.com/test/";

        Resource r = m.createResource (NS + "r");
        Property p = m.createProperty (NS + "p");

        r.addProperty (p, "hello world", XSDDatatype.XSDstring);

        m.write (System.out, "Turtle");
    }
}
