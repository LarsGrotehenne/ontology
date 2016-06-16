package functionalities;


import org.apache.jena.rdf.model.Model;

/**
 * Created by Lars on 16.06.2016.
 */
public class B_Browsing extends FunctionObject {
    /**
     * constructor
     *
     * @param _model current model
     */
    public B_Browsing(Model _model) {
        super(_model);
    }

    @Override
    public void start() {
        System.out.println("Zurzeit keine Functionalitaeten.");
    }

    @Override
    public String getIdentifier() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
