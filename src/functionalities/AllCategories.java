package functionalities;

import helpers.queries;
import org.apache.jena.rdf.model.Model;

/**
 * Created by Lars on 25.07.2016.
 */
public class AllCategories extends FunctionObject {
    /**
     * constructor
     *
     * @param _model current model
     */
    public AllCategories(Model _model) {
        super(_model);
    }

    @Override
    public void start() {
        queries.getAllCategories(model);
    }

    @Override
    public String getDescription() {
        return "Gibt alle Algorithmen zurück.";
    }

    @Override
    public String getIdentifier() {
        return "algorithms";
    }
}
