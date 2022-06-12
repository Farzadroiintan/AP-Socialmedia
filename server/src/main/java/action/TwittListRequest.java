package action;

import Data.DataBaseConnection;
import Data.GsonReader;
import loger.MyLogger;
import models.twitt.SimpleTwitt;
import models.twitt.Twitt;
import models.user.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class TwittListRequest {
    public static ArrayList<Twitt> userTwitt(int Id){
        MyLogger.getLogger().log("Imp lvl:2," + "TwittListRequest," + "userTwitt,");
        ArrayList<Twitt> arrayList = new ArrayList<Twitt>();
        Session session = DataBaseConnection.getFactory().openSession();
        String hql = "From User u Where u.id=:userid";
        Query query = session.createQuery(hql);
        query.setInteger("userid", Id);
        List list = query.list();

            User user = (User) list.get(0);
            for (int i = 0;i<user.getTwitts().size();i++){

                arrayList.add(user.getTwitts().get(i));
            }

        return arrayList;
    }
    public static ArrayList<Twitt> twittComment(int Id){
        MyLogger.getLogger().log("Imp lvl:2," + "TwittListRequest," + "twittComment,");
        ArrayList<Twitt> arrayList = new ArrayList<Twitt>();
        Session session = DataBaseConnection.getFactory().openSession();
        String hql = "From Twitt u Where u.id=:twittId";
        Query query = session.createQuery(hql);
        query.setInteger("twittId", Id);
        List list = query.list();
        Twitt twitt = (Twitt) list.get(0);
        for (int i = 0;i<twitt.getComments().size();i++){
            arrayList.add(twitt.getComments().get(i));
        }
        return arrayList;
    }
}
