package helpers;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;

/**
 * Created by Lars on 25.07.2016.
 */
public class queries {
    public static void createQuery(String queryString, Model model) {

        Query query = QueryFactory.create(queryString);

        // Execute the query and obtain results
        QueryExecution qe = QueryExecutionFactory.create(query, model);
        ResultSet results = qe.execSelect();

        // Output query results
        ResultSetFormatter.out(System.out, results, query);

        // Important � free up resources used running the query
        qe.close();
    }

    public static void getAllAlgorithms(Model model) {
        String queryString =
                "PREFIX dc: <http://purl.org/dc/elements/1.1/>" +
                        "PREFIX : <http://cluster.info#>" +
                        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
                        "SELECT ?Algorithmus " +
                        "WHERE {" +
                        "?algo rdfs:label ?Algorithmus." +
                        "}";

        queries.createQuery(queryString, model);
    }

    public static void getAllCategories(Model model) {
        String queryString =
                "PREFIX dc: <http://purl.org/dc/elements/1.1/>" +
                        "PREFIX : <http://cluster.info#>" +
                        "SELECT ?Kategorie " +
                        "WHERE {" +
                        "      ?a a :category." +
                        "?a dc:title ?Kategorie. " +
                        "      }";

        queries.createQuery(queryString, model);
    }

    public static void getAllProperties(Model model) {
        String queryString =
                "PREFIX dc: <http://purl.org/dc/elements/1.1/>" +
                "PREFIX : <http://cluster.info#>" +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                     "SELECT ?Eigenschaft ?Wert " +
                     "WHERE {" +
                        "?property a :algo-property." +
                        "?property dc:title ?Eigenschaft." +
                        "OPTIONAL { ?property :has_values/rdf:rest*/rdf:first ?Wert.}" +
                     "}";

        queries.createQuery(queryString, model);
    }
}
