import GUI.GUI;
import connection.Connector;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class main {
    public static void main(String[] args) throws IOException {

        try (OutputStream output = new FileOutputStream("./src/main/resources/HomePanelConfig.properties")) {

            Properties prop = new Properties();

            // set the properties value
            String name = "panel";
            prop.setProperty(name+"_x","0");
            prop.setProperty(name+"_y", "0");
            prop.setProperty(name+"_width", "600");
            prop.setProperty(name+"_height", "380");
//            prop.setProperty(name+"_text", "Artaram");
           name = "homeMainPanel";
            prop.setProperty(name+"_x","225");
            prop.setProperty(name+"_y", "0");
            prop.setProperty(name+"_width", "375");
            prop.setProperty(name+"_height", "380");

            // save properties to project root folder
            prop.store(output, null);

            System.out.println(prop);

        } catch (IOException io) {
            io.printStackTrace();

        }
//        Connector.autoConnect();
//        GUI.start();

    }
}
