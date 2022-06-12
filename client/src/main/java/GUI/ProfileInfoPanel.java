package GUI;

import Data.ThisUser;
import connection.Connector;
import logger.MyLogger;
import models.SimpleUser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileInfoPanel extends JPanel implements ActionListener {
    SimpleUser simpleUser;

    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel label6;

    JButton button1;
    JButton button2;
    JButton button3;


    public ProfileInfoPanel(SimpleUser simpleUser) {
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.ProfileInfoPanel," + "constructor,");
        this.setLayout(null);
        this.setBounds(0,0,375,380);
        this.simpleUser=simpleUser;
        label1 = new JLabel();
        label1.setBounds(5,5,160,20);

        label2 = new JLabel("Firstname");
        label2.setBounds(5,30,160,20);

        label3 = new JLabel();
        label3.setBounds(170,30,160,20);

        label4 = new JLabel("Lastname");
        label4.setBounds(5,55,160,20);

        label5 = new JLabel();
        label5.setBounds(270,55,160,20);

        label6 = new JLabel();
        label6.setBounds(5,80,160,20);

        button1 = new JButton("Follow");
        if(simpleUser.isPublicPage()){
            button1.setText("Follow");
        }else {
            button1.setText("Follow req");
        }
        button1.setBounds(5,105,120,20);
        button1.addActionListener(this);

        button2 = new JButton("Chat");
        button2.setBounds(130,105,120,20);
        button2.addActionListener(this);

        this.add(label1);
        this.add(label2);
        this.add(label3);
        this.add(label4);
        this.add(label5);
        this.add(label6);

        this.add(button1);
        this.add(button2);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1){
            MyLogger.getLogger().log("Imp lvl:2," + "GUI.ProfileInfoPanel," + "button1,");
            Connector.followRequest(this.simpleUser.getId());
            return;
        }

    }
    public void setText(){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.ProfileInfoPanel," + "setText,");
        if (this.simpleUser!=null){
            label1.setText(this.simpleUser.getUsername());
            label3.setText(this.simpleUser.getFirstname());
            label5.setText(this.simpleUser.getLastname());
            label6.setText(Connector.lastSeenRequest(ThisUser.simpleUser.getId(),this.simpleUser.getId()));
        }
    }

}
