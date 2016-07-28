package functionalities;

import helpers.console;
import helpers.queries;
import org.apache.jena.rdf.model.Model;

/**
 * Created by Lars on 16.06.2016.
 */
public class D_Literatur extends FunctionObject {
    /**
     * constructor
     *
     * @param _model current model
     */
    public D_Literatur(Model _model) {
        super(_model);
    }

    @Override
    public void start() {

        String[] algorithms = queries.getAlgorithms(model);

        String filterOptions = "";
        if(algorithms.length > 0) {
            filterOptions = "?Algorithmus = '"+algorithms[0]+"'";
            for(int i=1; i<algorithms.length; i++) {
                filterOptions = filterOptions + " || ?Algorithmus = '"+algorithms[i]+"'";
            }
        }
        String queryString =
                "PREFIX dc: <http://purl.org/dc/elements/1.1/>" +
                "PREFIX : <http://cluster.info#>" +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
                     "SELECT ?Algorithmus ?Paper " +
                     "WHERE {" +
                        "?algo rdfs:label ?Algorithmus." +
                        "FILTER("+filterOptions+")." +
                        "?algo :described_in ?paper." +
                        "?paper dc:title ?Paper." +
                     "}  order by ?Algorithmus ?Paper";

        queries.createQuery(queryString, model);

        /**
         * TODO: Meldung falls kein Paper vorhanden ist
         * TODO: Wegfiltern von möglichen doppelten Einträgen
         */
        
    }



    @Override
    public String getIdentifier() {
        return "literature";
    }

    @Override
    public String getDescription() {
        return "Ausgabe der Literatur zu einem oder mehreren Clustering-Algorithmen.";
    }
}
