package GUI;

import logger.MyLogger;
import models.SimpleUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfilePanel extends JPanel implements ActionListener {
    ProfileButtonPanel profileButtonPanel;
    JPanel profileMainPanel;
    ProfileInfoPanel profileInfoPanel;

    public ProfilePanel(SimpleUser simpleUser) {
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.ProfilePanel," + "constructor,");
        this.setLayout(null);
        this.setBounds(0,0,600,380);

        profileButtonPanel = new ProfileButtonPanel(simpleUser);
        profileMainPanel = new JPanel();
        profileMainPanel.setBackground(Color.red);

        profileInfoPanel = new ProfileInfoPanel(simpleUser);

        profileMainPanel.setLayout(null);
        profileMainPanel.setBounds(225,0,375,380);
        profileMainPanel.add(profileInfoPanel);
        profileInfoPanel.repaint();
        profileInfoPanel.revalidate();

        profileMainPanel.repaint();
        profileMainPanel.revalidate();

        this.add(profileButtonPanel);
        this.add(profileMainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
