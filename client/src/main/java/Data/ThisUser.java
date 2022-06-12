package Data;

import connection.Connector;
import logger.MyLogger;
import models.SimpleUser;

public class ThisUser {
    public static SimpleUser simpleUser;


    public static void setUser(String username){
        MyLogger.getLogger().log("Imp lvl:2," + "ThisUser," + "setUser,");
        simpleUser = (SimpleUser) Connector.userRequest(username);
        return;
    }



}
