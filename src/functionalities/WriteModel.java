package functionalities;

import helpers.console;
import org.apache.jena.rdf.model.Model;

import java.util.function.Function;

/**
 * Created by Lars on 14.06.2016.
 */
public class WriteModel extends FunctionObject {
    public WriteModel(Model _model) {
        super(_model);
    }

    @Override
    public void start() {

        String outputFormat = null;

        boolean incorrectFormat = true;
        while (incorrectFormat) {
            System.out.println("Es gibt verschiedene Ausgabeformate, \n" +
                    "vorne stehen die entsprechenden einzugebenen Abkuerzungen: \n" +
                    "TTL: Turtle\n" +
                    "XML: RDF XML\n" +
                    "NT: N-Triples\n" +
                    "N3: N3\n" +
                    "JSON-LD: JSON LD\n" +
                    "RDF/JSON: RDF JSON\n");

            //getting output Format
            outputFormat = console.readLine();

            if (outputFormat.equals("TTL") || outputFormat.equals("XML") || outputFormat.equals("NT") || outputFormat.equals("N3") || outputFormat.equals("JSON-LD") || outputFormat.equals("RDF/JSON")) {
                incorrectFormat = false;
            }
            else {
                System.out.println("Ungueltiges Ausgabeformat!");
            }
        }

        if(outputFormat.equals("XML")) {
            outputFormat = "RDF/XML";
        }

        // write it to standard out
         model.write(System.out, outputFormat);
        //model.write(System.out);
    }

    @Override
    public String getIdentifier() {
        return "writeModel";
    }

    @Override
    public String getDescription() {
        return "Gibt das gesammte Modell wieder.";
    }
}
