package action;

import Data.DataBaseConnection;
import loger.MyLogger;
import models.twitt.Twitt;
import models.user.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class Follow {
    public static void follow(int followerId,int followingId){
        MyLogger.getLogger().log("Imp lvl:2," + "Follow," + "follow,");
        Session session = DataBaseConnection.getFactory().openSession();
        String hql = "From User u Where u.id=:userid";
        Query query = session.createQuery(hql);
        query.setInteger("userid", followerId);
        List list = query.list();
        User user = (User) list.get(0);

        String hql1 = "From User u Where u.id=:userid";
        Query query1 = session.createQuery(hql1);
        query1.setInteger("userid", followingId);
        List list1 = query1.list();
        User user1 = (User) list1.get(0);
        Transaction transaction = session.beginTransaction();
        user.following.add(user1);
        user1.followers.add(user);
        session.save(user);
        session.save(user1);
        transaction.commit();
        return;
    }
    public static void request(int followerId,int followingId){
        MyLogger.getLogger().log("Imp lvl:2," + "Follow," + "request,");
        Session session = DataBaseConnection.getFactory().openSession();
        String hql = "From User u Where u.id=:userid";
        Query query = session.createQuery(hql);
        query.setInteger("userid", followerId);
        List list = query.list();
        User user = (User) list.get(0);

        String hql1 = "From User u Where u.id=:userid";
        Query query1 = session.createQuery(hql1);
        query1.setInteger("userid", followingId);
        List list1 = query1.list();
        User user1 = (User) list1.get(0);

        Transaction transaction = session.beginTransaction();
        user.yourFollowReq.add(user1);
        user1.otherFollowReq.add(user);
        session.save(user);
        session.save(user1);
        transaction.commit();
        return;
    }
    public static void acceptRequest(int followerId,int followingId){
        MyLogger.getLogger().log("Imp lvl:2," + "Follow," + "acceptRequest,");
        Session session = DataBaseConnection.getFactory().openSession();
        String hql = "From User u Where u.id=:userid";
        Query query = session.createQuery(hql);
        query.setInteger("userid", followerId);
        List list = query.list();
        User user = (User) list.get(0);

        String hql1 = "From User u Where u.id=:userid";
        Query query1 = session.createQuery(hql1);
        query1.setInteger("userid", followingId);
        List list1 = query1.list();
        User user1 = (User) list1.get(0);

        Transaction transaction = session.beginTransaction();
        user.otherFollowReq.remove(user1);
        user1.yourFollowReq.remove(user);
        user1.systemNotification.add(user.getUsername()+"accept your request.");
        user.followers.add(user1);
        user1.following.add(user);
        session.save(user);
        session.save(user1);
        transaction.commit();
        return;
    }
    public static void rejectRequest(int followerId,int followingId){
        MyLogger.getLogger().log("Imp lvl:2," + "Follow," + "rejectRequest,");
        Session session = DataBaseConnection.getFactory().openSession();
        String hql = "From User u Where u.id=:userid";
        Query query = session.createQuery(hql);
        query.setInteger("userid", followerId);
        List list = query.list();
        User user = (User) list.get(0);

        String hql1 = "From User u Where u.id=:userid";
        Query query1 = session.createQuery(hql1);
        query1.setInteger("userid", followingId);
        List list1 = query1.list();
        User user1 = (User) list1.get(0);

        Transaction transaction = session.beginTransaction();
        user.otherFollowReq.remove(user1);
        user1.yourFollowReq.remove(user);
        user1.systemNotification.add(user.getUsername()+"reject your request.");
        session.save(user);
        session.save(user1);
        transaction.commit();
        return;
    }

    public static void followFunc(int followerId,int followingId){
        MyLogger.getLogger().log("Imp lvl:2," + "Follow," + "followFunc,");
        Session session = DataBaseConnection.getFactory().openSession();
        String hql = "From User u Where u.id=:userid";
        Query query = session.createQuery(hql);
        query.setInteger("userid", followerId);
        List list = query.list();
        User user = (User) list.get(0);

        String hql1 = "From User u Where u.id=:userid";
        Query query1 = session.createQuery(hql1);
        query1.setInteger("userid", followingId);
        List list1 = query1.list();
        User user1 = (User) list1.get(0);
        if(user.following.contains(user1)){
            return;
        }
        if (user1.isPublicPage()){
            follow(followerId,followingId);
            return;
        }
        request(followerId,followingId);
        return;
    }


}
