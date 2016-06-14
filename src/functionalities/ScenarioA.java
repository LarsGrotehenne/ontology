package functionalities;

import org.apache.jena.rdf.model.Model;

/**
 * Selektion von einem oder mehreren Clusteringalgorithmen durch das Angeben
 * unterschiedlicher Eigenschaften.
 */
public class ScenarioA extends Scenario {
    public ScenarioA(Model _model) {
        super(_model);
    }

    @Override
    public String getDescription() {
        return "Selektion von einem oder mehreren " +
                "Clusteringalgorithmen durch das Angeben " +
                "unterschiedlicher Eigenschaften.";
    }

    @Override
    public String getIdentifier() {
        return "scenarioA";
    }
}
