package functionalities;


import helpers.console;
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


        System.out.println("Zurzeit keine Functionalitaeten.");
    }

    private String getCategory() {
        String category = null;

        String queryString =
                "PREFIX dc: <http://purl.org/dc/elements/1.1/>" +
                        "PREFIX : <http://cluster.info#>" +
                        "SELECT ?category " +
                        "WHERE {" +
                        "      ?a a :category." +
                        "?a dc:title ?category. " +
                        "      }";

        console.createQuery(queryString, model);

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
        return "Ausgabe von Clustering-Algorithmen zu einer Eigenschaft";
    }
}
