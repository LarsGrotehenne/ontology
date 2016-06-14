package functionalities;

import org.apache.jena.rdf.model.Model;

/**
 * Created by Lars on 14.06.2016.
 */
public abstract class Scenario extends FunctionObject {
    public Scenario(Model _model) {
        super(_model);
    }

    @Override
    public void start() {
        System.out.println("Zurzeit keine Functionalitaeten.");
    }
}
