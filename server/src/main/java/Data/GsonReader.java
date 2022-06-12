package Data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import models.twitt.SimpleTwitt;
import models.twitt.Twitt;
import models.user.SimpleUser;
import models.user.User;

import java.util.ArrayList;

public class GsonReader {
    static Gson gson = new GsonBuilder().create();

    public static String translateUser(User user){
        String string;
        string = gson.toJson(simpleUser(user));
        return string;
    }
    public static SimpleUser simpleUser(User user){
        SimpleUser simpleUser = new SimpleUser();

        simpleUser.setId(user.getId());
        simpleUser.setUsername(user.getUsername());
        simpleUser.setPassword(user.getPassword());
        simpleUser.setFirstname(user.getFirstname());
        simpleUser.setLastname(user.getLastname());
        simpleUser.setEmail(user.getEmail());
        simpleUser.setBio(user.getBio());
        simpleUser.setPhoneNumber(user.getPhoneNumber());
        simpleUser.setPublicPage(user.isPublicPage());
        simpleUser.setLastSeenAccess(user.getLastSeenAccess());
        simpleUser.setLastSeen(user.getLastSeen());

        return simpleUser;
    }

    public static String translateTwitt(Twitt twitt){
        String string;
        string = gson.toJson(simpleTwitt(twitt));
        return string;
    }
    public static SimpleTwitt simpleTwitt(Twitt twitt){
        SimpleTwitt simpleTwitt = new SimpleTwitt();

        simpleTwitt.setId(twitt.getId());
        simpleTwitt.setContext(twitt.getContext());
        simpleTwitt.setWriterId(twitt.getWriter().getId());
        simpleTwitt.setWriterUsername(twitt.getWriter().getUsername());
        simpleTwitt.setWriteDateTime(twitt.getWriteDateTime());
        simpleTwitt.setLikes(twitt.Likes.size());
        simpleTwitt.setComments(twitt.Comments.size());

        return simpleTwitt;
    }

}
