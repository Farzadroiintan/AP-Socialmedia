package config;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static java.lang.Integer.parseInt;

public class Propertiees {
    public static java.util.Properties prop(String clas){
        java.util.Properties prop = new java.util.Properties();;
        try (InputStream input = new FileInputStream("./src/main/resources/"+clas+"Config.properties")) {

            // load a properties file
            prop.load(input);

            // get the property value and print it out
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }


}
