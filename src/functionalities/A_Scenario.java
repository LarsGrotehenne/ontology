package functionalities;

import helpers.console;
import helpers.queries;
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

        queries.getAllClustertypes(model);
        System.out.println("Einen oder mehrere Clustertypen eingeben, getrennt" +
                " mit Komma, ohne Leerzeichen, z.B. 'encircled,not_convex'");
        String input = console.readLine();
        String types[] = input.split(",");
        String filter = "";
        for(String type : types) {
            filter = filter + " :" + type;
        }
            String queryString =
                    "PREFIX dc: <http://purl.org/dc/elements/1.1/>" +
                    "PREFIX : <http://cluster.info#>" +
                    "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
                    "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                    "PREFIX  list: <http://jena.hpl.hp.com/ARQ/list#>" +
                    "SELECT ?Algorithmus " +
                    "WHERE {" +
                        "?algo rdfs:label ?Algorithmus." +
                        "?algo :properties ?props." +
                        "?props :can_cluster ?list." +
                         "filter not exists {" +
                            "values ?value { "+filter+" }" +
                            "filter not exists {" +
                                "?list rdf:rest*/rdf:first ?value" +
                            "}" +
                        "}" +
                    "}";

            queries.createQuery(queryString, model);


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
