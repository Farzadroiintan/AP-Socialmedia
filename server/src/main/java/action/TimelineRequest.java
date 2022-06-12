package action;

import Data.DataBaseConnection;
import loger.MyLogger;
import models.twitt.Twitt;
import models.user.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class TimelineRequest {
    public static ArrayList<Twitt> timelineTwitt(int Id){
        MyLogger.getLogger().log("Imp lvl:2," + "TimelineRequest," + "timelineTwitt,");
        ArrayList<Twitt> arrayList = new ArrayList<Twitt>();
        Session session = DataBaseConnection.getFactory().openSession();
        String hql = "From User u Where u.id=:userid";
        Query query = session.createQuery(hql);
        query.setInteger("userid", Id);
        List list = query.list();

        User user = (User) list.get(0);

        for (int i = 0;i<user.getFollowing().size();i++){
            for (int j=0;j<user.getFollowing().get(i).getTwitts().size();j++){
                if (!user.getFollowing().get(i).getTwitts().get(j).isReport()){
                    arrayList.add(user.getFollowing().get(i).getTwitts().get(j));
                }
            }
            for (int j=0;j<user.getFollowing().get(i).getLikedTwitt().size();j++){
                if (!user.getFollowing().get(i).getLikedTwitt().get(j).isReport()){
                    if (!arrayList.contains(user.getFollowing().get(i).getLikedTwitt().get(j))){
                        arrayList.add(user.getFollowing().get(i).getLikedTwitt().get(j));
                    }
                }
            }
        }

        return arrayList;
    }
}
