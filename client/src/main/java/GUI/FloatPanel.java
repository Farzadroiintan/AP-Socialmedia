package GUI;

import config.ConfigStyles;
import config.Propertiees;
import connection.Connector;
import logger.MyLogger;
import models.SimpleUser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FloatPanel extends JPanel implements ActionListener {
    JPanel exploreMainPanel;
    ProfilePanel profilePanel;

    public FloatPanel() {
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.FloatPanel," + "constructor,");
        this.setLayout(null);
        this.setBounds(ConfigStyles.rectangle("panel", Propertiees.prop("FloatPanel")));

        exploreMainPanel = new JPanel();
        exploreMainPanel.setLayout(null);
        exploreMainPanel.setBounds(ConfigStyles.rectangle("exploreMainPanel", Propertiees.prop("FloatPanel")));

        this.add(exploreMainPanel);
    }

    public void showUserProfile(SimpleUser simpleUser){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.FloatPanel," + "showUserProfile,");
        exploreMainPanel.removeAll();
        profilePanel = new ProfilePanel(simpleUser);
        exploreMainPanel.add(profilePanel);
        GUI.frame.repaint();
        repaint();
        revalidate();
    }

    public void showUserTwitts(SimpleUser simpleUser){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.FloatPanel," + "showUserTwitts,");
        profilePanel.profileMainPanel.removeAll();
        TwittPane twittPane = new TwittPane(Connector.twittListRequest("0",simpleUser.getId()));
        profilePanel.profileMainPanel.add(twittPane);
        GUI.frame.repaint();
        repaint();
        revalidate();
    }
    public void showUserList(ArrayList<String> arrayList){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.FloatPanel," + "showUserList,");
        profilePanel.profileMainPanel.removeAll();
        UserPane userPane = new UserPane(arrayList);
        profilePanel.profileMainPanel.add(userPane);
        GUI.frame.repaint();
        repaint();
        revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
