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

        String[] algorithms = getAlgorithms();

        String filterOptions = "";
        if(algorithms.length > 0) {
            filterOptions = "?algoname = '"+algorithms[0]+"'";
            for(int i=1; i<algorithms.length; i++) {
                filterOptions = filterOptions + " || ?algoname = '"+algorithms[i]+"'";
            }
        }
        String queryString =
                "PREFIX dc: <http://purl.org/dc/elements/1.1/>" +
                "PREFIX : <http://cluster.info#>" +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
                     "SELECT ?algoname ?papername " +
                     "WHERE {" +
                        "?algo rdfs:label ?algoname." +
                        "FILTER("+filterOptions+")." +
                        "?algo :described_in ?paper." +
                        "?paper dc:title ?papername." +
                     "}";

        queries.createQuery(queryString, model);

        /**
         * TODO: Meldung falls kein Paper vorhanden ist
         * TODO: Wegfiltern von möglichen doppelten Einträgen
         */
        
    }

    private String[] getAlgorithms() {
        String algorithms[] = null;

        queries.getAllAlgorithms(model);

        System.out.println("Select Algorithms, seperated with comma and no space!");
        algorithms = console.readLine().split(",");

        /**
         * TODO: Sicherstellen, dass der eingegebene Algorithmus überhaupt vorhanden ist!
         */

        return algorithms;
    }

    @Override
    public String getIdentifier() {
        return "literatur";
    }

    @Override
    public String getDescription() {
        return "Ausgabe der Literatur zu einem oder mehreren Clustering-Algorithmen.";
    }
}
