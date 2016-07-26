package functionalities;

import helpers.console;
import helpers.queries;
import org.apache.jena.rdf.model.Model;

/**
 * Created by Lars on 16.06.2016.
 */
public class C_Eigenschaften extends FunctionObject {
    /**
     * constructor
     *
     * @param _model current model
     */
    public C_Eigenschaften(Model _model) {
        super(_model);
    }

    @Override
    public void start() {

        queries.getAllProperties(model);
        System.out.println("Es gibt 2 Optionen:");
        System.out.println("1. Angeben von verschiedenen Eigenschaften, z.B. 'multi_dim,handle_noise,take_parameter'");
        System.out.println("2. Angeben von einer Eigenschaft mit Wert, z.B. 'speed=normal'");

        String properties = console.readLine();

        if(properties.contains("=")) {
            String propValue[] = properties.split("=");
            String queryString =
                    "PREFIX dc: <http://purl.org/dc/elements/1.1/>" +
                            "PREFIX : <http://cluster.info#>" +
                            "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
                            "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                            "PREFIX  list: <http://jena.hpl.hp.com/ARQ/list#>" +
                            "SELECT ?Algorithmus " +
                            "WHERE {" +
                            "?algo rdfs:label ?Algorithmus." +
                            "?algo :properties ?proplist." +
                            "?proplist list:member ?props." +
                            "FILTER (?props = :"+propValue[0]+")." +
                            "?props :has_values ?list." +
                            "filter not exists {" +
                            "values ?value { :"+propValue[1]+" }" +
                            "filter not exists {" +
                            "?list rdf:rest*/rdf:first ?value" +
                            "}" +
                            "}" +
                            "}";

            queries.createQuery(queryString, model);
        }

        else {
            String propList[] = properties.split(",");
            String filter = "";
            for(String prop : propList) {
                filter = filter + " :" + prop;
            }
                String queryString =
                    "PREFIX dc: <http://purl.org/dc/elements/1.1/>" +
                    "PREFIX : <http://cluster.info#>" +
                    "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
                    "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                    "SELECT ?Algorithmus " +
                    "WHERE {" +
                       "?algo rdfs:label ?Algorithmus." +
                       "?algo :properties ?list." +
                       "filter not exists {" +
                          "values ?value {"+filter+"}" +
                          "filter not exists {" +
                            "?list rdf:rest*/rdf:first ?value" +
                          "}" +
                       "}" +
                     "}";
            queries.createQuery(queryString, model);
        }
    }

    @Override
    public String getIdentifier() {
        return "properties";
    }

    @Override
    public String getDescription() {
        return "Ausgabe von Clustering-Algorithmen zu bestimmten Eigenschaften.";
    }
}
