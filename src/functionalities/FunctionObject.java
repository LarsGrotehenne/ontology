package functionalities;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

/**
 * Created by Lars on 14.06.2016.
 */
public abstract class FunctionObject {

    public Model model = ModelFactory.createDefaultModel();

    public FunctionObject(Model _model) {
        this.model = _model;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public abstract void start();

    public abstract String getIdentifier();

    public abstract String getDescription();
}
