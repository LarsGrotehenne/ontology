package functionalities;

import helpers.console;
import org.apache.jena.rdf.model.Model;

import java.util.function.Function;

/**
 * Created by Lars on 14.06.2016.
 */
public class WriteModel extends FunctionObject {
    public WriteModel(Model _model) {
        super(_model);
    }

    @Override
    public void start() {

        // write it to standard out
         model.write(System.out, console.getCorrectOutputFormat());
        //model.write(System.out);
    }

    @Override
    public String getIdentifier() {
        return "writeModel";
    }

    @Override
    public String getDescription() {
        return "Gibt das gesammte Modell wieder.";
    }
}
