package functionalities;

import helpers.queries;
import org.apache.jena.rdf.model.Model;

/**
 * Created by Lars on 25.07.2016.
 */
public class AllClustertypes extends FunctionObject {
    /**
     * constructor
     *
     * @param _model current model
     */
    public AllClustertypes(Model _model) {
        super(_model);
    }

    @Override
    public void start() {
        queries.getAllClustertypes(model);
    }

    @Override
    public String getDescription() {
        return "Gibt alle Clustertypen zurueck.";
    }

    @Override
    public String getIdentifier() {
        return "allClustertypes";
    }
}
