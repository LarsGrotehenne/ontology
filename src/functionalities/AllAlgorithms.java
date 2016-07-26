package functionalities;

import helpers.queries;
import org.apache.jena.rdf.model.Model;

/**
 * Created by Lars on 25.07.2016.
 */
public class AllAlgorithms extends FunctionObject {
    /**
     * constructor
     *
     * @param _model current model
     */
    public AllAlgorithms(Model _model) {
        super(_model);
    }

    @Override
    public void start() {
        queries.getAllAlgorithms(model);
    }

    @Override
    public String getDescription() {
        return "Gibt alle Algorithmen zurueck.";
    }

    @Override
    public String getIdentifier() {
        return "allAlgorithms";
    }
}
