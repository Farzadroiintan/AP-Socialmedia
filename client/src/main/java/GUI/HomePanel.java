package GUI;
//home
import Data.ThisUser;
import config.ConfigStyles;
import config.Propertiees;
import connection.Connector;
import logger.MyLogger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HomePanel extends JPanel implements ActionListener {
    HomeButtonPanel homeButtonPanel;
    JPanel homeMainPanel;
    MyProfilePanel myProfilePanel = new MyProfilePanel();


    public HomePanel() {
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.HomePanel," + "constructor,");
        this.setLayout(null);
        this.setBounds(ConfigStyles.rectangle("panel", Propertiees.prop("HomePanel")));

        homeButtonPanel = new HomeButtonPanel();
        homeMainPanel = new JPanel();
        homeMainPanel.setLayout(null);
        homeMainPanel.setBounds(ConfigStyles.rectangle("homeMainPanel", Propertiees.prop("HomePanel")));

        this.add(homeButtonPanel);
        this.add(homeMainPanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }

    public void showMyProfile(){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.HomePanel," + "showMyProfile,");
        homeMainPanel.removeAll();
        myProfilePanel.setText();
        myProfilePanel.revalidate();
        homeMainPanel.add(myProfilePanel);
        GUI.frame.repaint();
        repaint();
        revalidate();
    }

    public void showUserTwitts(){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.HomePanel," + "showUserTwitts,");
        homeMainPanel.removeAll();
        TwittPane twittPane = new TwittPane(Connector.twittListRequest("0",ThisUser.simpleUser.getId()));
        homeMainPanel.add(twittPane);
        GUI.frame.repaint();
        repaint();
        revalidate();
    }
    public void showTwittComment(int twittId){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.HomePanel," + "showTwittComment,");
        homeMainPanel.removeAll();
        TwittPane twittPane = new TwittPane(Connector.twittListRequest("1",twittId));
        homeMainPanel.add(twittPane);
        GUI.frame.repaint();
        repaint();
        revalidate();
    }
    public void showUserList(ArrayList<String> arrayList){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.HomePanel," + "showUserList,");
        homeMainPanel.removeAll();
        UserPane userPane = new UserPane(arrayList);

        homeMainPanel.add(userPane);
        GUI.frame.repaint();
        repaint();
        revalidate();
    }
    public void writeTwitt(){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.HomePanel," + "writeTwitt,");
        homeMainPanel.removeAll();
        WriteTwittPanel writeTwittPanel = new WriteTwittPanel();
        homeMainPanel.add(writeTwittPanel);
        GUI.frame.repaint();
        repaint();
        revalidate();
    }
    public void showNotification(){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.HomePanel," + "showNotification,");
        homeMainPanel.removeAll();
        NotificationPanel notificationPanel = new NotificationPanel(ThisUser.simpleUser);
        homeMainPanel.add(notificationPanel);
        GUI.frame.repaint();
        repaint();
        revalidate();
    }
}
