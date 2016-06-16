import functionalities.*;
import helpers.console;
import org.apache.jena.rdf.model.Model;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import rdf.rdfReader;

import java.util.ArrayList;

public class Main extends rdfReader {

    /**
     * Logger for Jena
     */
    private static final Logger logger = LogManager.getLogger(Main.class);

    /**
     * read the model from RDF file
     */
    public static Model model = rdfReader.readRDFTurtle("rdf/test.ttl");

    /**
     * create and save functionalities
     */
    public static ArrayList<FunctionObject> functionalities = new ArrayList<FunctionObject>() {
        {
            add(new A_Scenario(model));
            add(new B_Browsing(model));
            add(new C_Eigenschaften(model));
            add(new D_Literatur(model));
            add(new WriteModel(model));
            add(new TestScenario(model));
        }
    };

    /**
     * Main-Method of the program
     * @param args
     */
    public static void main(String[] args) {

        //main loop to choose functionalities
        while (true) {
            printDescriptionString();
            String function = console.readLine();
            for (FunctionObject k: functionalities) {
                if (k.getIdentifier().equals(function)) {
                    k.start();
                }
            }
            endOfOutput();
        }
    }

    /**
     * prints all descriptions of the different functionalities
     */
    private static void printDescriptionString() {
        System.out.println(" ");
        System.out.println("Folgende Funktionen koennen durch die Eingabe des entsprechenden Namens erreicht werden:");
        for( FunctionObject k: functionalities )
        {
            System.out.println(k.getIdentifier() + ":   " + k.getDescription());
        }
        System.out.println(" ");
    }

    /**
     * some end and new lines
     */
    private static void endOfOutput() {
        System.out.println("---------------------------------------------");
        System.out.println(" ");
        System.out.println(" ");
    }

    /**
     * old way to creating models without rdf-Files
     */
    /*public static void createModel() {
        System.out.println("Hello World!");

        Model m = ModelFactory.createDefaultModel();

        String NS = "http://example.com/test/";

        Resource r = m.createResource (NS + "r");
        Property p = m.createProperty (NS + "p");

        r.addProperty (p, "hello world", XSDDatatype.XSDstring);

        m.write (System.out, "Turtle");
    }*/
}
