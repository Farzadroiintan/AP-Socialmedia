package Data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import logger.MyLogger;
import models.SimpleTwitt.SimpleTwitt;
import models.SimpleUser;

import java.util.ArrayList;

public class GsonReader {
    static Gson gson = new GsonBuilder().create();

    public static SimpleUser readUser(String string){
        MyLogger.getLogger().log("Imp lvl:2," + "GsonReader," + "readUser,");
        SimpleUser simpleUser;
        simpleUser = gson.fromJson(string, SimpleUser.class);
        return simpleUser;
    }

    public static SimpleTwitt readTwitt(String string){
        MyLogger.getLogger().log("Imp lvl:2," + "GsonReader," + "readTwitt,");
        SimpleTwitt simpleTwitt;
        simpleTwitt = gson.fromJson(string, SimpleTwitt.class);
        return simpleTwitt;
    }
}
