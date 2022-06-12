package action;

import Data.DataBaseConnection;
import Data.GsonReader;
import loger.MyLogger;
import models.user.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class UserRequest {
    public static String Run(String username){
        MyLogger.getLogger().log("Imp lvl:2," + "UserRequest," + "Run,");
        String userToGson = "";
        Session session = DataBaseConnection.getFactory().openSession();
        System.out.println(username);
        String hql = "From User u Where u.username=:usernames";
        Query query = session.createQuery(hql);
        query.setString("usernames", username);
        List list = query.list();
        if (list.size() == 0) { //check username
            return "-1";
        }
        if (list.size() != 0) {
            User user = (User) list.get(0);
            userToGson = GsonReader.translateUser(user);
            return userToGson;
        }
        return userToGson;
    }
}
