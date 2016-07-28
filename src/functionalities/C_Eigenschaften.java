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
        System.out.println("Bitte Eigenschaften und Werte angeben, z.B.: 'speed=normal,has_property=handle_noise'");

        String properties = console.readLine();
        String propertyArray[] = properties.split(",");

        String queryString =
                "PREFIX dc: <http://purl.org/dc/elements/1.1/>" +
                        "PREFIX : <http://cluster.info#>" +
                        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>" +
                        "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>" +
                        "PREFIX  list: <http://jena.hpl.hp.com/ARQ/list#>" +
                        "SELECT ?Algorithmus " +
                        "WHERE {" +
                        "?algo rdfs:label ?Algorithmus." +
                        "?algo :properties ?props.";



        for(int i=0; i<propertyArray.length; i++) {
            String propValue[] = propertyArray[i].split("=");

            queryString=queryString +
                    "{?props :"+propValue[0]+" ?list"+i+"." +
                    "filter not exists {" +
                    "values ?value { :"+propValue[1]+ " }" +
                    "filter not exists {" +
                    "?list"+i+" rdf:rest*/rdf:first ?value" +
                    "}" +
                    "}}";
        }
        queryString=queryString+"} order by ?Algorithmus";
        queries.createQuery(queryString, model);
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
