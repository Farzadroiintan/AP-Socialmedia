package connection;

import Data.GsonReader;
import action.*;
import loger.MyLogger;
import models.twitt.Twitt;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class ClientThread extends Thread{
    private Socket socket;
    private String clientString;
    private PrintWriter output;
    private Scanner input;

    private String username;
    private boolean userLoggedIn;
    public ClientThread(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run(){
        MyLogger.getLogger().log("Imp lvl:1," + "ClientThread," + "run,");
        try {
            output = new PrintWriter(socket.getOutputStream(), true);
//            String message ="you connected to server.";
//            output.println(message);

            input = new Scanner(socket.getInputStream());
            service(input);
        }
        catch (Exception e){
            e.getMessage();
        }
    }
    public void service(Scanner scanner){
        clientString = (String) scanner.nextLine();
        MyLogger.getLogger().log("Imp lvl:1," + "ClientThread," + "service,"+clientString);
        if (clientString.equals("signUpRequest")){
            signUpRequest(scanner);
        }
        if (clientString.equals("loginRequest")){
            loginRequest(scanner);
        }
        if (clientString.equals("userRequest")){
            userRequest(scanner);
        }
        if (clientString.equals("twittListRequest")){
            twittListRequest(scanner);
        }
        if (clientString.equals("userListRequest")){
            userListRequest(scanner);
        }
        if (clientString.equals("writeTwittRequest")){
            writeTwittRequest(scanner);
        }
        if (clientString.equals("lastSeenRequest")){
            lastSeenRequest(scanner);
        }
        if (clientString.equals("likeRequest")){
            likeRequest(scanner);
        }
        if (clientString.equals("saveRequest")){
            saveRequest(scanner);
        }
        if (clientString.equals("writeCommentRequest")){
            writeCommentRequest(scanner);
        }
        if (clientString.equals("followRequest")){
            followRequest(scanner);
        }
        if (clientString.equals("profileEditRequest")){
            profileEditRequest(scanner);
        }
        if (clientString.equals("acceptFollowRequest")){
            acceptFollowRequest(scanner);
        }
        if (clientString.equals("rejectFollowRequest")){
            rejectFollowRequest(scanner);
        }
        if (clientString.equals("reportRequest")){
            reportRequest(scanner);
        }
        service(scanner);

    }
    public void signUpRequest(Scanner scanner){
        MyLogger.getLogger().log("Imp lvl:1," + "ClientThread," + "signUpRequest,");
        String stat;
        String username;
        String password;
        output.println("username");
        username = (String) scanner.nextLine();
        output.println("password");
        password=(String) scanner.nextLine();
        stat = SignUp.Run(username,password);
        output.println(stat);
        return;
    }
    public void loginRequest(Scanner scanner){
        MyLogger.getLogger().log("Imp lvl:1," + "ClientThread," + "loginRequest,");
        String stat;
        String username;
        String password;
        output.println("username");
        username = (String) scanner.nextLine();
        output.println("password");
        password=(String) scanner.nextLine();
        stat = Login.Run(username,password);
        output.println(stat);
        if (stat.equals("2")){
            this.username = username;
            this.userLoggedIn = true;
        }
        return;
    }
    public void userRequest(Scanner scanner){
        MyLogger.getLogger().log("Imp lvl:1," + "ClientThread," + "userRequest,");
        String userGson;
        output.println("username");
        username = (String) scanner.nextLine();
        userGson = UserRequest.Run(username);
        output.println(userGson);
        return;
    }

    public void twittListRequest(Scanner scanner){
        MyLogger.getLogger().log("Imp lvl:1," + "ClientThread," + "twittListRequest,");
        ArrayList<Twitt> arrayList = new ArrayList<Twitt>();
        int Id;
        //2
        output.println("stat");
        //3
        String stat = (String) scanner.nextLine();
        if(stat.equals("0")){
            //4
            output.println("userId");
        }
        if(stat.equals("1")){
            //4
            output.println("twittId");
        }
        if(stat.equals("2")){
            //4
            output.println("userId");
        }
        //5
        Id = parseInt((String)scanner.nextLine());

        if(stat.equals("0")){
            arrayList = TwittListRequest.userTwitt(Id);
        }
        if(stat.equals("1")){
            arrayList = TwittListRequest.twittComment(Id);
        }
        if(stat.equals("2")){
            arrayList = TimelineRequest.timelineTwitt(Id);
        }

        //6 send size
        output.println(arrayList.size());
        System.out.println("ready to send");
        //7
        for (int i = 0;i<arrayList.size();i++){
            System.out.println("sent");
            output.println(GsonReader.translateTwitt(arrayList.get(i)));
            if ((String) scanner.nextLine() == "next"){
                continue;
            }
        }

        return;
    }

    public void userListRequest(Scanner scanner){
        MyLogger.getLogger().log("Imp lvl:1," + "ClientThread," + "userListRequest,");
        ArrayList<String> arrayList = new ArrayList<String>();
        int Id;
        //2
        output.println("stat");
        //3
        String stat = (String) scanner.nextLine();
        //4
        output.println("Id");
        //5
        Id=parseInt((String)scanner.nextLine());
        if(stat.equals("0")){
            arrayList = UserListRequest.follower(Id);
        }
        if (stat.equals("1")){
            arrayList = UserListRequest.following(Id);
        }
        if (stat.equals("2")){
            arrayList = UserListRequest.otherFollowReq(Id);
        }
        if (stat.equals("3")){
            arrayList = UserListRequest.yourFollowReq(Id);
        }
        //6 send size
        output.println(arrayList.size());

        for (int i = 0;i<arrayList.size();i++){
            System.out.println(arrayList.get(i));
            output.println(arrayList.get(i));
            if ((String) scanner.nextLine() == "next"){
                continue;
            }
        }
    }
    public  void writeTwittRequest(Scanner scanner){
        MyLogger.getLogger().log("Imp lvl:1," + "ClientThread," + "writeTwittRequest,");
        //2
        output.println("Id");
        //3
        int Id=parseInt((String)scanner.nextLine());
        //4
        output.println("context");
        //5
        String context = (String)scanner.nextLine();
        WriteTwittRequest.writeTwitt(Id,context);
    }
    public  void writeCommentRequest(Scanner scanner){
        MyLogger.getLogger().log("Imp lvl:1," + "ClientThread," + "writeCommentRequest,");
        //2
        output.println("userId");
        //3
        int userId=parseInt((String)scanner.nextLine());
        //4
        output.println("twittId");
        //5
        int twittId=parseInt((String)scanner.nextLine());
        //6
        output.println("context");
        //7
        String context = (String)scanner.nextLine();
        WriteTwittRequest.writeComment(userId,twittId,context);
    }
    public  void lastSeenRequest(Scanner scanner){
        MyLogger.getLogger().log("Imp lvl:1," + "ClientThread," + "lastSeenRequest,");
        //2
        output.println("thisId");
        //3
        int thisUserId=parseInt((String)scanner.nextLine());
        //4
        output.println("userId");
        //5
        int userId=parseInt((String)scanner.nextLine());
        //6
        output.println(LastSeenRequest.req(thisUserId,userId));

    }
    public void likeRequest(Scanner scanner){
        MyLogger.getLogger().log("Imp lvl:1," + "ClientThread," + "likeRequest,");
        //2
        output.println("userId");
        //3
        int userId = parseInt((String)scanner.nextLine());
        //4
        output.println("twittId");
        //5
        int twittId = parseInt((String)scanner.nextLine());
        Like.request(userId,twittId);
    }
    public void saveRequest(Scanner scanner){
        MyLogger.getLogger().log("Imp lvl:1," + "ClientThread," + "saveRequest,");
        //2
        output.println("userId");
        //3
        int userId = parseInt((String)scanner.nextLine());
        //4
        output.println("twittId");
        //5
        int twittId = parseInt((String)scanner.nextLine());
        SaveTwitt.request(userId,twittId);
    }
    public void followRequest(Scanner scanner){
        MyLogger.getLogger().log("Imp lvl:1," + "ClientThread," + "followRequest,");
        //2
        output.println("followerId");
        //3
        int followerId = parseInt((String)scanner.nextLine());
        //4
        output.println("followingId");
        //5
        int followingId = parseInt((String)scanner.nextLine());
        Follow.followFunc(followerId,followingId);
    }
    public void reportRequest(Scanner scanner){
        MyLogger.getLogger().log("Imp lvl:1," + "ClientThread," + "reportRequest,");
        //2
        output.println("userId");
        //3
        int userId = parseInt((String)scanner.nextLine());
        //4
        output.println("twittId");
        //5
        int twittId = parseInt((String)scanner.nextLine());
        Report.request(userId,twittId);
    }
    public void profileEditRequest(Scanner scanner){
        MyLogger.getLogger().log("Imp lvl:1," + "ClientThread," + "profileEditRequest,");
        //2
        output.println("userId");
        //3
        int userId = parseInt((String)scanner.nextLine());
        //4
        output.println("username");
        //5
        String username = (String)scanner.nextLine();
        //6
        output.println("firstname");
        //7
        String firstname = (String)scanner.nextLine();
        //8
        output.println("lastname");
        //9
        String lastname = (String)scanner.nextLine();
        //10
        output.println("email");
        //11
        String email = (String)scanner.nextLine();
        //12
        output.println("bio");
        //13
        String bio = (String)scanner.nextLine();
        //14
        output.println("phone number");
        //15
        String phoneNumber = (String)scanner.nextLine();
        //16
        output.println("privacy");
        //17
        String privacy = (String)scanner.nextLine();
        //18
        output.println("last seen");
        //19
        String lastSeen = (String)scanner.nextLine();
        //20
        output.println(ProfileInfo.edit(userId,username,firstname,lastname,email,bio,phoneNumber,privacy,lastSeen));
    }
    public void acceptFollowRequest(Scanner scanner){
        MyLogger.getLogger().log("Imp lvl:1," + "ClientThread," + "acceptFollowRequest,");
        //2
        output.println("userId");
        //3
        int userId = parseInt((String)scanner.nextLine());
        //4
        output.println("followerId");
        //5
        int followerId = parseInt((String)scanner.nextLine());
        Follow.acceptRequest(userId,followerId);
    }
    public void rejectFollowRequest(Scanner scanner){
        MyLogger.getLogger().log("Imp lvl:1," + "ClientThread," + "rejectFollowRequest,");
        //2
        output.println("userId");
        //3
        int userId = parseInt((String)scanner.nextLine());
        //4
        output.println("followerId");
        //5
        int followerId = parseInt((String)scanner.nextLine());
        Follow.rejectRequest(userId,followerId);
    }


}
