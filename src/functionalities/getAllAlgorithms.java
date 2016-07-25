package functionalities;

import helpers.queries;
import org.apache.jena.rdf.model.Model;

/**
 * Created by Lars on 25.07.2016.
 */
public class getAllAlgorithms extends FunctionObject {
    /**
     * constructor
     *
     * @param _model current model
     */
    public getAllAlgorithms(Model _model) {
        super(_model);
    }

    @Override
    public void start() {
        queries.getAllAlgorithms(model);
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
