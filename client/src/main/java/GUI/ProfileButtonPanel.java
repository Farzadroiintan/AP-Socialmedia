package GUI;

import connection.Connector;
import logger.MyLogger;
import models.SimpleUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileButtonPanel extends JPanel implements ActionListener {
    SimpleUser simpleUser;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;

    public ProfileButtonPanel(SimpleUser simpleUser) {
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.ProfileButtonPanel," + "constructor,");
        this.simpleUser = simpleUser;
        this.setLayout(null);
        this.setBounds(0,0,225,380);
        this.setBackground(Color.LIGHT_GRAY);

        button1 = new JButton("Twitts");
        button1.setFont(new Font("Serif", Font.PLAIN, 12));
        button1.setBounds(25,5,175,40);
        button1.setBackground(new Color(94, 94, 170, 233));
        button1.addActionListener(this);

        button2 = new JButton("Followers");
        button2.setFont(new Font("Serif", Font.PLAIN, 12));
        button2.setBounds(25,65,175,40);
        button2.setBackground(new Color(94, 94, 170, 233));
        button2.addActionListener(this);

        button3 = new JButton("Following");
        button3.setFont(new Font("Serif", Font.PLAIN, 12));
        button3.setBounds(25,125,175,40);
        button3.setBackground(new Color(94, 94, 170, 233));
        button3.addActionListener(this);

        button4 = new JButton("Profile");
        button4.setFont(new Font("Serif", Font.PLAIN, 12));
        button4.setBounds(25,185,175,40);
        button4.setBackground(new Color(94, 94, 170, 233));
        button4.addActionListener(this);

        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1){
            MyLogger.getLogger().log("Imp lvl:2," + "GUI.ProfileButtonPanel," + "button1,");
            GUI.floatShowTwitt(this.simpleUser);
            return;
        }
        if (e.getSource()==button2){
            MyLogger.getLogger().log("Imp lvl:2," + "GUI.ProfileButtonPanel," + "button2,");
            GUI.floatShowUserList(Connector.userListRequest("0",this.simpleUser.getId()));
            return;
        }
        if (e.getSource()==button3){
            MyLogger.getLogger().log("Imp lvl:2," + "GUI.ProfileButtonPanel," + "button3,");
            GUI.floatShowUserList(Connector.userListRequest("1",this.simpleUser.getId()));
            return;
        }
        if (e.getSource()==button4){
            MyLogger.getLogger().log("Imp lvl:2," + "GUI.ProfileButtonPanel," + "button4,");
            GUI.floatShowProfile(this.simpleUser);
            return;
        }
    }
}
