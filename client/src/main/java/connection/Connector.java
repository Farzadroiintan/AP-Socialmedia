package connection;

import Data.GsonReader;
import Data.ThisUser;
import logger.MyLogger;
import models.SimpleTwitt.SimpleTwitt;
import models.SimpleUser;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Connector {
    static Socket socket;
    static Scanner input;
    static PrintWriter output;
    static String serverString;



    public static void autoConnect() throws IOException {
        MyLogger.getLogger().log("Imp lvl:1," + "Connector," + "autoConnect,");
        socket = new Socket("localhost", 9000);

        input = new Scanner(socket.getInputStream());
//        System.out.println(input.nextLine());

        output = new PrintWriter(socket.getOutputStream(),true);
//        String message = new Scanner(System.in).nextLine();
//        output.println(message);
    }

    public static String signUpRequest(){
        MyLogger.getLogger().log("Imp lvl:1," + "Connector," + "signUpRequest,");
        String stat="2";//0
        output.println("signUpRequest");
        serverString=(String) input.nextLine();
        if (serverString.equals("username")){
            output.println(ConnectionResource.getUsername());
            serverString=(String) input.nextLine();
        }
        if(serverString.equals("password")){
            output.println(ConnectionResource.getPassword());
            serverString=(String) input.nextLine();
            stat=serverString;
        }
        return stat;
    }

    public static String loginRequest(){
        MyLogger.getLogger().log("Imp lvl:1," + "Connector," + "loginRequest,");
        String stat="3";
        output.println("loginRequest");
        serverString=(String) input.nextLine();
        if (serverString.equals("username")){
            output.println(ConnectionResource.getUsername());
            serverString=(String) input.nextLine();
        }
        if(serverString.equals("password")){
            output.println(ConnectionResource.getPassword());
            serverString=(String) input.nextLine();
            stat=serverString;
        }
        return stat;
    }

    public static SimpleUser userRequest(String username){
        MyLogger.getLogger().log("Imp lvl:1," + "Connector," + "userRequest,");
        String gsonString="";

        output.println("userRequest");
        serverString=(String) input.nextLine();
        if (serverString.equals("username")){
            output.println(username);
            gsonString=(String) input.nextLine();
        }
        if (gsonString.equals("-1")){
            SimpleUser simpleUser = new SimpleUser();
            simpleUser.setId(-1);
            return simpleUser;
        }
        return GsonReader.readUser(gsonString);
    }

    public static ArrayList<SimpleTwitt> twittListRequest(String stat, int Id){//stat0 user twitt,1 twitt comments, 2 user timeline
        MyLogger.getLogger().log("Imp lvl:1," + "Connector," + "twittListRequest,");
        ArrayList<SimpleTwitt> arrayList = new ArrayList<SimpleTwitt>();
        String gsonString="";
        //1
        output.println("twittListRequest");
        //2
        serverString=(String) input.nextLine();
        if (serverString.equals("stat")){
            //3
            output.println(stat);
        }
        //4
        serverString=(String) input.nextLine();
        if (serverString.equals("userId") & stat.equals("0")){
            //5
            output.println(Id);
        }
        if (serverString.equals("twittId") & stat.equals("1")){
            //5
            output.println(Id);
        }
        if (serverString.equals("userId") & stat.equals("2")){
            //5
            output.println(Id);
        }
        //6
        int size = parseInt((String) input.nextLine());

        //7
        for (int i = 0; i<size;i++){

            arrayList.add(GsonReader.readTwitt((String) input.nextLine()));
            output.println("next");
        }

        return arrayList;

    }

    public static ArrayList<String> userListRequest(String stat,int Id){//stat0 follower, 1 following 2other follow req 3your follow req
        MyLogger.getLogger().log("Imp lvl:1," + "Connector," + "userListRequest,");
        ArrayList<String> arrayList = new ArrayList<String>();
        //1
        output.println("userListRequest");

        //2
        serverString=(String) input.nextLine();
        if (serverString.equals("stat")){
            //3
            output.println(stat);
        }
        //4
        serverString=(String) input.nextLine();
        if(serverString.equals("Id")){
            //5
            output.println(Id);
        }
        //6
        int size = parseInt((String) input.nextLine());
        //7
        for (int i = 0; i<size;i++){
            arrayList.add((String) input.nextLine());
            output.println("next");
        }
        return arrayList;
    }
    public static void writeTwittRequest(String context){
        MyLogger.getLogger().log("Imp lvl:1," + "Connector," + "writeTwittRequest,");
        //1
        output.println("writeTwittRequest");
        //2
        serverString=(String) input.nextLine();
        if (serverString.equals("Id")){
            //3
            output.println(ThisUser.simpleUser.getId());
        }
        //4
        serverString=(String) input.nextLine();
        if (serverString.equals("context")){
            //5
            output.println(context);
        }
    }

    public static void writeCommentRequest(int twittId, String context){
        MyLogger.getLogger().log("Imp lvl:1," + "Connector," + "writeCommentRequest,");
        //1
        output.println("writeCommentRequest");
        //2
        serverString=(String) input.nextLine();
        if (serverString.equals("userId")){
            //3
            output.println(ThisUser.simpleUser.getId());
        }
        //4
        serverString=(String) input.nextLine();
        if (serverString.equals("twittId")){
            //5
            output.println(twittId);
        }
        //6
        serverString=(String) input.nextLine();
        if (serverString.equals("context")){
            //7
            output.println(context);
        }
    }


    public static String lastSeenRequest(int thisUserId,int userId){
        MyLogger.getLogger().log("Imp lvl:1," + "Connector," + "lastSeenRequest,");
        //1
        output.println("lastSeenRequest");
        //2
        serverString=(String) input.nextLine();
        if (serverString.equals("thisId")){
            //3
            output.println(thisUserId);
        }
        //4
        serverString=(String) input.nextLine();
        if (serverString.equals("userId")){
            //5
            output.println(userId);
        }
        //6
        return (String) input.nextLine();
    }



    public static void likeRequest(int twittId){
        MyLogger.getLogger().log("Imp lvl:1," + "Connector," + "likeRequest,");
        //1
        output.println("likeRequest");
        //2
        serverString=(String) input.nextLine();
        if (serverString.equals("userId")){
            //3
            output.println(ThisUser.simpleUser.getId());
        }
        //4
        serverString=(String) input.nextLine();
        if (serverString.equals("twittId")){
            //5
            output.println(twittId);
        }
        return;
    }

    public static void saveRequest(int twittId){
        MyLogger.getLogger().log("Imp lvl:1," + "Connector," + "saveRequest,");
        //1
        output.println("saveRequest");
        //2
        serverString=(String) input.nextLine();
        if (serverString.equals("userId")){
            //3
            output.println(ThisUser.simpleUser.getId());
        }
        //4
        serverString=(String) input.nextLine();
        if (serverString.equals("twittId")){
            //5
            output.println(twittId);
        }
        return;
    }
    public static void reportRequest(int twittId){
        MyLogger.getLogger().log("Imp lvl:1," + "Connector," + "reportRequest,");
        //1
        output.println("reportRequest");
        //2
        serverString=(String) input.nextLine();
        if (serverString.equals("userId")){
            //3
            output.println(ThisUser.simpleUser.getId());
        }
        //4
        serverString=(String) input.nextLine();
        if (serverString.equals("twittId")){
            //5
            output.println(twittId);
        }
        return;
    }
    public static void followRequest(int followingId){
        MyLogger.getLogger().log("Imp lvl:1," + "Connector," + "followRequest,");
        //1
        output.println("followRequest");
        //2
        serverString=(String) input.nextLine();
        if (serverString.equals("followerId")){
            //3
            output.println(ThisUser.simpleUser.getId());
        }
        //4
        serverString=(String) input.nextLine();
        if (serverString.equals("followingId")){
            //5
            output.println(followingId);
        }
        return;
    }
    public static String profileEditRequest(String username,String firstname,String lastname,String email, String bio, String phoneNumber, String privacy, String lastSeen){
        MyLogger.getLogger().log("Imp lvl:1," + "Connector," + "profileEditRequest,");
        //1
        output.println("profileEditRequest");
        //2
        serverString=(String) input.nextLine();
        if (serverString.equals("userId")){
            //3
            output.println(ThisUser.simpleUser.getId());
        }
        //4
        serverString=(String) input.nextLine();
        if (serverString.equals("username")){
            //5
            output.println(username);
        }
        //6
        serverString=(String) input.nextLine();
        if (serverString.equals("firstname")){
            //7
            output.println(firstname);
        }
        //8
        serverString=(String) input.nextLine();
        if (serverString.equals("lastname")){
            //9
            output.println(lastname);
        }
        //10
        serverString=(String) input.nextLine();
        if (serverString.equals("email")){
            //11
            output.println(email);
        }
        //12
        serverString=(String) input.nextLine();
        if (serverString.equals("bio")){
            //13
            output.println(bio);
        }
        //14
        serverString=(String) input.nextLine();
        if (serverString.equals("phone number")){
            //15
            output.println(phoneNumber);
        }
        //16
        serverString=(String) input.nextLine();
        if (serverString.equals("privacy")){
            //17
            output.println(privacy);
        }
        //18
        serverString=(String) input.nextLine();
        if (serverString.equals("last seen")){
            //19
            output.println(lastSeen);
        }
        //20
        return (String) input.nextLine();
    }
    public static void acceptFollowRequest(int followerId){
        MyLogger.getLogger().log("Imp lvl:1," + "Connector," + "acceptFollowRequest,");
        //1
        output.println("acceptFollowRequest");
        //2
        serverString=(String) input.nextLine();
        if (serverString.equals("userId")){
            //3
            output.println(ThisUser.simpleUser.getId());
        }
        //4
        serverString=(String) input.nextLine();
        if (serverString.equals("followerId")){
            //5
            output.println(followerId);
        }
        return;
    }
    public static void rejectFollowRequest(int followerId){
        MyLogger.getLogger().log("Imp lvl:1," + "Connector," + "rejectFollowRequest,");
        //1
        output.println("rejectFollowRequest");
        //2
        serverString=(String) input.nextLine();
        if (serverString.equals("userId")){
            //3
            output.println(ThisUser.simpleUser.getId());
        }
        //4
        serverString=(String) input.nextLine();
        if (serverString.equals("followerId")){
            //5
            output.println(followerId);
        }
        return;
    }

}
