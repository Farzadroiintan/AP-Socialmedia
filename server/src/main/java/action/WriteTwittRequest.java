package action;

import Data.DataBaseConnection;
import loger.MyLogger;
import models.twitt.Comment;
import models.twitt.Twitt;
import models.user.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class WriteTwittRequest {
    public static void writeTwitt(int Id,String context){
        MyLogger.getLogger().log("Imp lvl:2," + "WriteTwittRequest," + "writeTwitt,");
        ArrayList<String> arrayList = new ArrayList<String>();
        Session session = DataBaseConnection.getFactory().openSession();
        System.out.println(Id);
        String hql = "From User u Where u.id=:userid";
        Query query = session.createQuery(hql);
        query.setInteger("userid", Id);
        List list = query.list();
        if (list.size() == 0) { //check userId
            session.close();
        }
        if (list.size() != 0) {
            Transaction transaction = session.beginTransaction();
            User user = (User) list.get(0);
            Twitt twitt = new Twitt(user,context);
            session.save(user);
            session.save(twitt);
            transaction.commit();
        }

    }
    public static void writeComment(int userId,int twittId,String context){
        MyLogger.getLogger().log("Imp lvl:2," + "WriteTwittRequest," + "writeComment,");
        ArrayList<String> arrayList = new ArrayList<String>();
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
        Comment comment = new Comment(user,context,twitt);
        Transaction transaction = session.beginTransaction();
        session.save(user);
        session.save(twitt);
        session.save(comment);
        transaction.commit();
    }
}
