package action;

import Data.DataBaseConnection;
import loger.MyLogger;
import models.twitt.Twitt;
import models.user.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UserListRequest {
    public static ArrayList<String> follower(int Id){
        MyLogger.getLogger().log("Imp lvl:2," + "UserListRequest," + "follower,");
        ArrayList<String> arrayList = new ArrayList<String>();
        Session session = DataBaseConnection.getFactory().openSession();

        String hql = "From User u Where u.id=:userid";
        Query query = session.createQuery(hql);
        query.setInteger("userid", Id);
        List list = query.list();

        if (list.size() != 0) {
            User user = (User) list.get(0);
            for (int i = 0;i<user.getFollowers().size();i++){
                System.out.println(user.getFollowers().size());
                arrayList.add(user.getFollowers().get(i).getUsername());
            }
        }

        return arrayList;
    }
    public static ArrayList<String> following(int Id){
        MyLogger.getLogger().log("Imp lvl:2," + "UserListRequest," + "following,");
        ArrayList<String> arrayList = new ArrayList<String>();
        Session session = DataBaseConnection.getFactory().openSession();

        String hql = "From User u Where u.id=:userid";
        Query query = session.createQuery(hql);
        query.setInteger("userid", Id);
        List list = query.list();

        if (list.size() != 0) {
            User user = (User) list.get(0);
            for (int i = 0;i<user.getFollowing().size();i++){
                System.out.println(user.getFollowing().size());
                arrayList.add(user.getFollowing().get(i).getUsername());
            }
        }

        return arrayList;
    }
    public static ArrayList<String> otherFollowReq(int Id){
        MyLogger.getLogger().log("Imp lvl:2," + "UserListRequest," + "otherFollowReq,");
        ArrayList<String> arrayList = new ArrayList<String>();
        Session session = DataBaseConnection.getFactory().openSession();

        String hql = "From User u Where u.id=:userid";
        Query query = session.createQuery(hql);
        query.setInteger("userid", Id);
        List list = query.list();

        if (list.size() != 0) {
            User user = (User) list.get(0);
            for (int i = 0;i<user.getOtherFollowReq().size();i++){
                System.out.println(user.getOtherFollowReq().size());
                arrayList.add(user.getOtherFollowReq().get(i).getUsername());
            }
        }
        return arrayList;
    }
    public static ArrayList<String> yourFollowReq(int Id){
        MyLogger.getLogger().log("Imp lvl:2," + "UserListRequest," + "yourFollowReq,");
        ArrayList<String> arrayList = new ArrayList<String>();
        Session session = DataBaseConnection.getFactory().openSession();

        String hql = "From User u Where u.id=:userid";
        Query query = session.createQuery(hql);
        query.setInteger("userid", Id);
        List list = query.list();

        if (list.size() != 0) {
            User user = (User) list.get(0);
            for (int i = 0;i<user.getYourFollowReq().size();i++){
                System.out.println(user.getYourFollowReq().size());
                arrayList.add(user.getYourFollowReq().get(i).getUsername());
            }
        }
        return arrayList;
    }

}
