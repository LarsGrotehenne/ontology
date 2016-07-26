package functionalities;

import helpers.queries;
import org.apache.jena.rdf.model.Model;

/**
 * Created by Lars on 25.07.2016.
 */
public class AllProperties extends FunctionObject {
    /**
     * constructor
     *
     * @param _model current model
     */
    public AllProperties(Model _model) {
        super(_model);
    }

    @Override
    public void start() {
        queries.getAllProperties(model);
    }

    @Override
    public String getDescription() {
        return "Gibt alle Eigenschaften zurueck.";
    }

    @Override
    public String getIdentifier() {
        return "properties";
    }
}
