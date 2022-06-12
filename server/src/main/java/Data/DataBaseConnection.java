package Data;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DataBaseConnection {
    static Configuration configuration;
    static SessionFactory factory;
    public static void connect(){
        setConfiguration(new Configuration().configure());
        setFactory(configuration.buildSessionFactory());
        return;
    }

    public static Configuration getConfiguration() {
        return configuration;
    }

    public static void setConfiguration(Configuration configuration) {
        DataBaseConnection.configuration = configuration;
    }

    public static SessionFactory getFactory() {
        return factory;
    }

    public static void setFactory(SessionFactory factory) {
        DataBaseConnection.factory = factory;
    }
}
