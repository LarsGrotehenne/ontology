package functionalities;

import org.apache.jena.rdf.model.Model;

/**
 * Created by Lars on 16.06.2016.
 */
public class C_Eigenschaften extends FunctionObject {
    /**
     * constructor
     *
     * @param _model current model
     */
    public C_Eigenschaften(Model _model) {
        super(_model);
    }

    @Override
    public void start() {
        System.out.println("Zurzeit keine Functionalitaeten.");
    }

    @Override
    public String getIdentifier() {
        return "eigenschaften";
    }

    @Override
    public String getDescription() {
        return "Ausgabe der Eigenschaften zu einem oder mehreren Clustering-Algorithmus";
    }
}
