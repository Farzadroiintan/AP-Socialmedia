import Data.DataBaseConnection;
import connection.Server;
import models.twitt.Comment;
import models.twitt.Twitt;
import models.user.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void  main(String[] args) throws IOException {
//        Configuration configuration = new Configuration().configure();
//        SessionFactory factory = configuration.buildSessionFactory();
//        Session session = factory.openSession();
//
//        Transaction transaction = session.beginTransaction();
//        User user = new User("elo","farshad");
//
//        Twitt twitt = new Twitt(user,"man elo hastam");
//        Comment comment = new Comment(user,"eliii",twitt);
//        twitt.Likes.add(user);
//        session.save(user);
//        session.save(twitt);
//        session.save(comment);
//        transaction.commit();

//        User user1 = new User("dosteferi", "12345");
//        User user2 = new User(2,"erfan", "ahmadi", "efi");
//        User user3 = new User(3,"erfaaaan", "mmm", "eaafi");
//        User user4 = new User(4,"efarazad", "rtn", "ardi");
//        User user5 = new User(5,"erfaaaan", "mmm", "username");
//        User user6 = new User(6,"erfaaaan", "mmm", "username2");
//        User user7 = new User(7,"erfaaaan", "mmm", "username3");
//        user.friends.add(user2);
//        user2.friends.add(user);

//        user.friends.add(user2);
//        user.friends.add(user3);
//        user.friends.add(user4);
//
//        session.save(user);
//        session.save(user2);
//        session.save(user3);
//        session.save(user4);
//        session.save(user5);
//        session.save(user7);
//
//        transaction.commit();
//        String hql = "From User u Where u.username='feri'";
//        Query query = session.createQuery(hql);
//        List list = query.list();
//        System.out.println(list.size());
//        User user = (User) list.get(0);
//
//        String hql1 = "From User u Where u.username='dada'";
//        Query query1 = session.createQuery(hql1);
//        List list1 = query1.list();
//        System.out.println(list.size());
//        User user1 = (User) list1.get(0);
//
//        user1.followers.add(user);
//        user.following.add(user1);
//        session.update(user);
//        session.update(user1);
//        transaction.commit();
//        session.close();

//        ArrayList<Twitt> arrayList = new ArrayList<Twitt>();
//        Session session = DataBaseConnection.getFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//        User user;
//        int Id = 52;
//        String hql = "From User u Where u.id=:userid";
//        Query query = session.createQuery(hql);
//        query.setInteger("userid", Id);
//        List list = query.list();
//        if (list.size() == 0) { //check username
//            session.close();
//        }
//             user = (User) list.get(0);
//            System.out.println(user.getTwitts());
////            for (int i = 0;i<user.getTwitts().size();i++){
////                arrayList.add(user.getTwitts().get(i));
////            }
////        Twitt twitt = new Twitt(user,"salam man feri hastam");
////              session.save(user);
////              session.save(twitt);
////              transaction.commit();
        DataBaseConnection.connect();
        Server.Run();
    }
}
