package functionalities;

import org.apache.jena.rdf.model.Model;

/**
 * Selektion von einem oder mehreren Clusteringalgorithmen durch das Angeben
 * unterschiedlicher Eigenschaften.
 */
public class A_Scenario extends FunctionObject {
    public A_Scenario(Model _model) {
        super(_model);
    }

    @Override
    public void start() {
        System.out.println("Zurzeit keine Functionalitaeten.");
    }

    @Override
    public String getDescription() {
        return "Selektion von einem oder mehreren " +
                "Clusteringalgorithmen durch das Angeben " +
                "unterschiedlicher Eigenschaften der Daten.";
    }

    @Override
    public String getIdentifier() {
        return "scenario";
    }
}
