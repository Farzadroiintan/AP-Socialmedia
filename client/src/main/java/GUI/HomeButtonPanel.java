package GUI;
//home
import Data.ThisUser;
import config.ConfigStyles;
import config.Propertiees;
import connection.Connector;
import logger.MyLogger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeButtonPanel extends JPanel implements ActionListener {
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button6;
    JButton button7;
    JButton button8;



    public HomeButtonPanel() {
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.HomeButtonPanel," + "constructor,");
        this.setLayout(null);
        this.setBounds(ConfigStyles.rectangle("panel", Propertiees.prop("HomeButtonPanel")));
        this.setBackground(Color.LIGHT_GRAY);

        button1 = new JButton(ConfigStyles.text("button1", Propertiees.prop("HomeButtonPanel")));
        button1.setFont(ConfigStyles.font(Propertiees.prop("ButtonPanel")));
        button1.setBounds(ConfigStyles.rectangle("button1", Propertiees.prop("HomeButtonPanel")));
        button1.setBackground(ConfigStyles.color(Propertiees.prop("ButtonPanel")));
        button1.addActionListener(this);

        button2 = new JButton(ConfigStyles.text("button2", Propertiees.prop("HomeButtonPanel")));
        button2.setFont(ConfigStyles.font(Propertiees.prop("ButtonPanel")));
        button2.setBounds(ConfigStyles.rectangle("button2", Propertiees.prop("HomeButtonPanel")));
        button2.setBackground(ConfigStyles.color(Propertiees.prop("ButtonPanel")));
        button2.addActionListener(this);

        button3 = new JButton(ConfigStyles.text("button3", Propertiees.prop("HomeButtonPanel")));
        button3.setFont(ConfigStyles.font(Propertiees.prop("ButtonPanel")));
        button3.setBounds(ConfigStyles.rectangle("button3", Propertiees.prop("HomeButtonPanel")));
        button3.setBackground(ConfigStyles.color(Propertiees.prop("ButtonPanel")));
        button3.addActionListener(this);

        button4 = new JButton(ConfigStyles.text("button4", Propertiees.prop("HomeButtonPanel")));
        button4.setFont(ConfigStyles.font(Propertiees.prop("ButtonPanel")));
        button4.setBounds(ConfigStyles.rectangle("button4", Propertiees.prop("HomeButtonPanel")));
        button4.setBackground(ConfigStyles.color(Propertiees.prop("ButtonPanel")));
        button4.addActionListener(this);

        button6 = new JButton(ConfigStyles.text("button6", Propertiees.prop("HomeButtonPanel")));
        button6.setFont(ConfigStyles.font(Propertiees.prop("ButtonPanel")));
        button6.setBounds(ConfigStyles.rectangle("button6", Propertiees.prop("HomeButtonPanel")));
        button6.setBackground(ConfigStyles.color(Propertiees.prop("ButtonPanel")));
        button6.addActionListener(this);

        button7 = new JButton(ConfigStyles.text("button7", Propertiees.prop("HomeButtonPanel")));
        button7.setFont(ConfigStyles.font(Propertiees.prop("ButtonPanel")));
        button7.setBounds(ConfigStyles.rectangle("button7", Propertiees.prop("HomeButtonPanel")));
        button7.setBackground(ConfigStyles.color(Propertiees.prop("ButtonPanel")));
        button7.addActionListener(this);

        button8 = new JButton(ConfigStyles.text("button8", Propertiees.prop("HomeButtonPanel")));
        button8.setFont(ConfigStyles.font(Propertiees.prop("ButtonPanel")));
        button8.setBounds(ConfigStyles.rectangle("button8", Propertiees.prop("HomeButtonPanel")));
        button8.setBackground(ConfigStyles.color(Propertiees.prop("ButtonPanel")));
        button8.addActionListener(this);


        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(button6);
        this.add(button7);
        this.add(button8);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1){
            MyLogger.getLogger().log("Imp lvl:2," + "GUI.HomeButtonPanel," + "button1,");
            GUI.homeShowMyTwitts();
            return;
        }
        if (e.getSource()==button2){
            MyLogger.getLogger().log("Imp lvl:2," + "GUI.HomeButtonPanel," + "button2,");
            return;
        }
        if (e.getSource()==button3){
            MyLogger.getLogger().log("Imp lvl:2," + "GUI.HomeButtonPanel," + "button3,");
            GUI.homeShowUserList(Connector.userListRequest("0", ThisUser.simpleUser.getId()));
            return;
        }
        if (e.getSource()==button4){
            MyLogger.getLogger().log("Imp lvl:2," + "GUI.HomeButtonPanel," + "button4,");
            GUI.homeShowUserList(Connector.userListRequest("1", ThisUser.simpleUser.getId()));
            return;
        }
        if (e.getSource()==button6){
            MyLogger.getLogger().log("Imp lvl:2," + "GUI.HomeButtonPanel," + "button6,");
            GUI.homeWriteTwitt();
            return;
        }
        if (e.getSource()==button7){
            MyLogger.getLogger().log("Imp lvl:2," + "GUI.HomeButtonPanel," + "button7,");
            GUI.homeShowMyProfile();
            return;
        }

        if (e.getSource()== button8){
            MyLogger.getLogger().log("Imp lvl:2," + "GUI.HomeButtonPanel," + "button8,");
            GUI.homeShowMyNotification();
            return;
        }

    }
}
