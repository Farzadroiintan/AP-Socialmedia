package config;

import java.awt.*;
import java.util.Properties;

import static java.lang.Integer.parseInt;

public class ConfigStyles {
    public static Rectangle rectangle(String name, Properties prop){
        Rectangle rectangle = new Rectangle(parseInt(prop.getProperty(name + "_x")),parseInt(prop.getProperty(name+"_y")),parseInt(prop.getProperty(name+"_width")),parseInt(prop.getProperty(name+"_height")));
        return  rectangle;
    }
    public static Font font(Properties prop){
        Font font = new Font(prop.getProperty( "fontName"), parseInt(prop.getProperty(("fontStyle"))),parseInt(prop.getProperty(("fontSize"))));
        return font;
    }
    public static Color color(Properties prop){
        Color color = new Color(parseInt(prop.getProperty("color_r")),parseInt(prop.getProperty("color_g")),parseInt(prop.getProperty("color_b")),parseInt(prop.getProperty("color_a")));
        return color;
    }
    public static String text(String name, Properties prop){
        String string = prop.getProperty(name+"_text");
        return string;
    }
    public static int width(String name, Properties prop){
        String string = prop.getProperty(name+"_width");
        return parseInt(string);
    }
    public static int height(String name, Properties prop){
        String string = prop.getProperty(name+"_height");
        return parseInt(string);
    }

}
