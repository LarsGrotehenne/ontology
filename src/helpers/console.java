package helpers;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Lars on 15.06.2016.
 */
public class console {

    public static String readLine()
    {
        String s = "";
        try {
            InputStreamReader converter = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(converter);
            s = in.readLine();
        } catch (Exception e) {
            System.out.println("Error! Exception: "+e);
        }
        return s;
    }

    public static String getCorrectOutputFormat() {
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

        return outputFormat;
    }
}
