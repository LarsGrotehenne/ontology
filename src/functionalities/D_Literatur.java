package functionalities;

import org.apache.jena.rdf.model.Model;

/**
 * Created by Lars on 16.06.2016.
 */
public class D_Literatur extends FunctionObject {
    /**
     * constructor
     *
     * @param _model current model
     */
    public D_Literatur(Model _model) {
        super(_model);
    }

    @Override
    public void start() {
        System.out.println("Zurzeit keine Functionalitaeten.");
    }

    @Override
    public String getIdentifier() {
        return "literatur";
    }

    @Override
    public String getDescription() {
        return "Ausgabe der Literatur zu einem oder mehreren Clustering-Algorithmen";
    }
}
