package action;

import Data.DataBaseConnection;
import loger.MyLogger;
import models.twitt.Twitt;
import models.user.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Report {
    public static void request(int userId, int twittId){
        MyLogger.getLogger().log("Imp lvl:2," + "Report," + "request,");
        Session session = DataBaseConnection.getFactory().openSession();
        String hql = "From User u Where u.id=:userid";
        Query query = session.createQuery(hql);
        query.setInteger("userid", userId);
        List list = query.list();
        User user = (User) list.get(0);

        String hql1 = "From Twitt u Where u.id=:twittId";
        Query query1 = session.createQuery(hql1);
        query1.setInteger("twittId", twittId);
        List list1 = query1.list();
        Twitt twitt = (Twitt) list1.get(0);
        Transaction transaction = session.beginTransaction();

        if (!twitt.reports.contains(user)){
            twitt.reports.add(user);
            if (twitt.reports.size()>4){
                twitt.setReport(true);
            }
        }
        session.save(user);
        session.save(twitt);
        transaction.commit();

    }
}
