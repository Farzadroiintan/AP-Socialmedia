package GUI;

import Data.ThisUser;
import config.ConfigStyles;
import config.Propertiees;
import connection.ConnectionResource;
import logger.MyLogger;
import models.SimpleUser;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI {
    static JFrame frame;
    static LoginPanel loginPanel = new LoginPanel();
    static SignUpPanel signUpPanel = new SignUpPanel();
    static MainPanel mainPanel = new MainPanel();

    public static void start(){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI," + "start,");
        frame = new JFrame(ConfigStyles.text("frame", Propertiees.prop("GUI")));
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(ConfigStyles.width("frame", Propertiees.prop("GUI")), ConfigStyles.height("frame", Propertiees.prop("GUI")));
        frame.setFocusable(false);
        frame.setContentPane(loginPanel);
        frame.setVisible(true);
    }

    public static void showLogin(){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI," + "showLogin,");
        frame.setContentPane(loginPanel);
        frame.validate();
    }
    public static void loginUsernameNotFound(){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI," + "loginUsernameNotFound,");
        loginPanel.jLabel5.setText(ConfigStyles.text("usernf", Propertiees.prop("GUI")));
        loginPanel.validate();
        frame.setContentPane(loginPanel);
    }
    public static void loginWrongPassword(){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI," + "loginWrongPassword,");
        loginPanel.jLabel5.setText(ConfigStyles.text("userwp", Propertiees.prop("GUI")));
        loginPanel.validate();
        frame.setContentPane(loginPanel);
    }
    public static void loginSuccessful(){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI," + "loginSuccessful,");
        loginPanel.jLabel5.setForeground(Color.GREEN);
        loginPanel.jLabel5.setText(ConfigStyles.text("userls", Propertiees.prop("GUI")));
        loginPanel.validate();
        frame.setContentPane(loginPanel);
        ThisUser.setUser(ConnectionResource.getUsername());
        frame.setContentPane(mainPanel);
        frame.revalidate();
        showHome();
    }
    public static void showSignUp(){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI," + "showSignUp,");
        frame.setContentPane(signUpPanel);
        frame.validate();
    }
    public static void signUpUsernameTaken(){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI," + "signUpUsernameTaken,");
        signUpPanel.jLabel4.setText(ConfigStyles.text("userht", Propertiees.prop("GUI")));
        signUpPanel.validate();
        frame.setContentPane(signUpPanel);
    }
    public static void signUpSuccessful(){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI," + "signUpSuccessful,");
        signUpPanel.jLabel4.setForeground(Color.GREEN);
        signUpPanel.jLabel4.setText(ConfigStyles.text("userss", Propertiees.prop("GUI")));
        signUpPanel.validate();
        frame.setContentPane(signUpPanel);
    }

    public static void showHome(){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI," + "showHome,");
        mainPanel.setHomePanel();
        frame.setContentPane(mainPanel);
        frame.revalidate();
    }
    public static void showExplore(){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI," + "showExplore,");
        mainPanel.setExplorePanel();
        frame.setContentPane(mainPanel);
        frame.revalidate();
    }
    public static void showFloat(){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI," + "showFloat,");
        mainPanel.setFloatPanel();
        frame.setContentPane(mainPanel);
        frame.revalidate();
    }
    public static void showTimeline(){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI," + "showTimeline,");
        mainPanel.setTimelinePanel();
        frame.setContentPane(mainPanel);
        frame.revalidate();
    }
    public static void showChat(){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI," + "showChat,");
        mainPanel.setChatPanel();
        frame.setContentPane(mainPanel);
        frame.revalidate();
    }
    public static void homeShowMyNotification(){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI," + "homeShowMyNotification,");
        mainPanel.homePanel.showNotification();
    }
    public static void homeShowMyProfile(){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI," + "homeShowMyProfile,");
        mainPanel.homePanel.showMyProfile();
    }
    public static void homeShowMyTwitts(){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI," + "homeShowMyTwitts,");
        mainPanel.homePanel.showUserTwitts();
    }
    public static void homeShowTwittComment(int twittId){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI," + "homeShowTwittComment,");
        mainPanel.homePanel.showTwittComment(twittId);
    }
    public static void homeShowUserList(ArrayList<String> arrayList){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI," + "homeShowUserList,");
        mainPanel.homePanel.showUserList(arrayList);
    }
    public static void homeWriteTwitt(){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI," + "homeWriteTwitt,");
        mainPanel.homePanel.writeTwitt();
    }
    public static void floatShowProfile(SimpleUser simpleUser){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI," + "floatShowProfile,");
        showFloat();
        mainPanel.floatPanel.showUserProfile(simpleUser);
        mainPanel.floatPanel.profilePanel.profileInfoPanel.setText();
    }
    public static void floatShowTwitt(SimpleUser simpleUser){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI," + "floatShowTwitt,");
        mainPanel.floatPanel.showUserTwitts(simpleUser);
    }
    public static void floatShowUserList(ArrayList<String> arrayList){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI," + "floatShowUserList,");
        mainPanel.floatPanel.showUserList(arrayList);
    }

}
