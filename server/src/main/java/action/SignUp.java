package action;

import Data.DataBaseConnection;
import loger.MyLogger;
import models.user.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class SignUp {
    public static String Run(String username, String password){
        MyLogger.getLogger().log("Imp lvl:2," + "SignUp," + "Run,");
        String stat="0";//0=username taken 1=everything ok
        Session session = DataBaseConnection.getFactory().openSession();
        System.out.println(username);
        String hql = "From User u Where u.username=:usernames";
        Query query = session.createQuery(hql);
        query.setString("usernames",username);
        List list = query.list();
        if (list.size()!=0){

            return stat;
        }
        Transaction transaction = session.beginTransaction();
        User user = new User(username,password);
        session.save(user);
        transaction.commit();

        stat = "1";

        return stat;
    }
}
