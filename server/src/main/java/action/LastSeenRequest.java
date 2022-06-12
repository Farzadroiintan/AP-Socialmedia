package action;

import Data.DataBaseConnection;
import loger.MyLogger;
import models.user.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LastSeenRequest {
    public static String req(int thisUserId, int userId){
        MyLogger.getLogger().log("Imp lvl:2," + "LastSeenRequest," + "req,");
        String lastSeen = "Last seen recently.";
        Session session = DataBaseConnection.getFactory().openSession();
        String hql = "From User u Where u.id=:userid";
        Query query = session.createQuery(hql);
        query.setInteger("userid", thisUserId);
        List list = query.list();
        User user = (User) list.get(0);

        String hql1 = "From User u Where u.id=:userid";
        Query query1 = session.createQuery(hql1);
        query1.setInteger("userid", userId);
        List list1 = query1.list();
        User user1 = (User) list1.get(0);
        if (user1.getLastSeenAccess()==0){
            return lastSeen;
        }
        if (user1.getLastSeenAccess()==1 && user1.followers.contains(user)){
            lastSeen = user1.getLastSeen().toString();
            return lastSeen;
        }
        if(user1.getLastSeenAccess()==2){
            lastSeen = user1.getLastSeen().toString();
            return lastSeen;
        }
        return lastSeen;
    }
}
