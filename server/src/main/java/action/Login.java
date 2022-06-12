package action;

import Data.DataBaseConnection;
import loger.MyLogger;
import models.user.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Login {
    public static String Run(String username, String password) {
        MyLogger.getLogger().log("Imp lvl:2," + "Login," + "Run,");
        String stat = "0";//0=username not fount 1=wrong pass 2=ok
        Session session = DataBaseConnection.getFactory().openSession();
        System.out.println(username);
        String hql = "From User u Where u.username=:usernames";
        Query query = session.createQuery(hql);
        query.setString("usernames", username);
        List list = query.list();
        if (list.size() == 0) { //check username
            return stat;
        }
        if (list.size() != 0) {
            User user = (User) list.get(0);
            if (!user.getPassword().equals(password) ) {//check password
                stat = "1";
                return stat;
            }
            if (user.getPassword().equals(password)) {
                stat = "2";
                return stat;
            }
        }

        return stat;
    }
}
