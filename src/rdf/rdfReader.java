package rdf;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;

import java.io.InputStream;

/**
 * reads rdf xml or rdf turtle files
 */
public class rdfReader {

    /**
     * reads an RDF XML file
     * @param modelLocation location of the rdf file
     * @return model
     */
    public static Model readRDFXML(String modelLocation) {
        Model model = ModelFactory.createDefaultModel();

        // use the FileManager to find the input file
        InputStream in = FileManager.get().open(modelLocation);
        if (in == null) {
            throw new IllegalArgumentException(
                    "File: " + modelLocation + " not found");
        }

        // read the RDF/XML file
        model.read(in, null);

        return model;
    }

    /**
     * reads an RDF Turtle file
     * @param modelLocation location of the rdf file
     * @return model
     */
    public static Model readRDFTurtle(String modelLocation) {

        return null;
    }

}
