package functionalities;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

/**
 * Created by Lars on 14.06.2016.
 */
public abstract class FunctionObject {

    /**
     * new public model variable
     */
    public Model model = ModelFactory.createDefaultModel();

    /**
     * constructor
     * @param _model current model
     */
    public FunctionObject(Model _model) {
        this.model = _model;
    }

    /**
     * @return model
     */
    public Model getModel() {
        return model;
    }

    /**
     * sets a new model
     * @param model
     */
    public void setModel(Model model) {
        this.model = model;
    }

    /**
     * initial method for the functions
     */
    public abstract void start();

    /**
     * @return the identifier of the function
     */
    public abstract String getIdentifier();

    /**
     * @return the description of the function
     */
    public abstract String getDescription();
}
