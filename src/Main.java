import functionalities.FunctionObject;
import functionalities.ScenarioA;
import functionalities.TestScenario;
import functionalities.WriteModel;
import helpers.console;
import org.apache.jena.rdf.model.Model;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import rdf.rdfReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main extends rdfReader {

    private static final Logger logger = LogManager.getLogger(Main.class);

    // read the model from RDF file
    public static Model model = rdfReader.readRDFTurtle("rdf/test.ttl");

    //create and save functionalities
    public static ArrayList<FunctionObject> functionalities = new ArrayList<FunctionObject>() {
        {
            add(new ScenarioA(model));
            add(new WriteModel(model));
            add(new TestScenario(model));
        }
    };

    public static void main(String[] args) {

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

    private static void printDescriptionString() {
        System.out.println(" ");
        System.out.println("Folgende Funktionen koennen durch die Eingabe des entsprechenden Namens erreicht werden:");
        for( FunctionObject k: functionalities )
        {
            System.out.println(k.getIdentifier() + ":   " + k.getDescription());
        }
        System.out.println(" ");
    }

    private static void endOfOutput() {
        System.out.println("---------------------------------------------");
        System.out.println(" ");
        System.out.println(" ");
    }

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
