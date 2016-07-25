package functionalities;


import helpers.console;
import helpers.queries;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;

/**
 * Created by Lars on 16.06.2016.
 */
public class B_Browsing extends FunctionObject {
    /**
     * constructor
     *
     * @param _model current model
     */
    public B_Browsing(Model _model) {
        super(_model);
    }

    @Override
    public void start() {
        String category = getCategory();

        String queryString =
                "PREFIX dc: <http://purl.org/dc/elements/1.1/>" +
                "PREFIX : <http://cluster.info#>" +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
                "SELECT ?algoname " +
                        "WHERE {" +
                        "?algo :has_category ?category." +
                        "?category dc:title ?categoryname." +
                        "FILTER(?categoryname = '"+category+"')." +
                        "?algo rdfs:label ?algoname." +
                        "}";

        queries.createQuery(queryString, model);

        /**
         * TODO: Meldung falls kein Algorithmus zur genannten Kategorie vorhanden ist!
         */
    }

    private String getCategory() {
        String category = null;

        queries.getAllCategories(model);

        System.out.println("Select one of these Categories!");
        category = console.readLine();

        /**
         * TODO: Sicherstellen, dass die eingegebene Kategorie überhaupt vorhanden ist!
         */
        return category;
    }

    @Override
    public String getIdentifier() {
        return "browsing";
    }

    @Override
    public String getDescription() {
        return "Ausgabe von Clustering-Algorithmen zu einer Kategorie.";
    }
}
