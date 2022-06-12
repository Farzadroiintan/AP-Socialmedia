package action;

import Data.DataBaseConnection;
import loger.MyLogger;
import models.user.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ProfileInfo {
    public static String edit(int userId,String username,String firstname,String lastname,String email, String bio, String phoneNumber, String privacy, String lastSeen ){
        MyLogger.getLogger().log("Imp lvl:2," + "ProfileInfo," + "edit,");
        Session session = DataBaseConnection.getFactory().openSession();
        String hql = "From User u Where u.id=:userid";
        Query query = session.createQuery(hql);
        query.setInteger("userid", userId);
        List list = query.list();
        User user = (User) list.get(0);

        //username
        String hql1 = "From User u Where u.username=:userna";
        Query query1 = session.createQuery(hql1);
        query1.setString("userna", username);
        List list1 = query1.list();
        if (list1.size()>0){
            User user1 = (User) list1.get(0);
            if (user.getId()!=user1.getId()){
                System.out.println("username not available");
                return "username not available";

            }
        }else {
            user.setUsername(username);
        }
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setEmail(email);
        user.setBio(bio);
        user.setPhoneNumber(phoneNumber);
        if (privacy.equals("public")){
            user.setPublicPage(true);
        }
        if (privacy.equals("private")){
            user.setPublicPage(false);
        }
        if (lastSeen.equals("nobody")){
            user.setLastSeenAccess(0);
        }
        if (lastSeen.equals("just followers")){
            user.setLastSeenAccess(1);
        }
        if (lastSeen.equals("every one")){
            user.setLastSeenAccess(2);
        }
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        return "edit successful";


    }
}
