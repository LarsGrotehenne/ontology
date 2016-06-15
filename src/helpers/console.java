package helpers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Lars on 15.06.2016.
 */
public class console {

    public static String readLine()
    {
        String s = "";
        try {
            InputStreamReader converter = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(converter);
            s = in.readLine();
        } catch (Exception e) {
            System.out.println("Error! Exception: "+e);
        }
        return s;
    }

}
