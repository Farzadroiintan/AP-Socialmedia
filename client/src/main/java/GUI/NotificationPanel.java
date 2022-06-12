package GUI;

import Data.ThisUser;
import connection.Connector;
import logger.MyLogger;
import models.SimpleUser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NotificationPanel extends JPanel implements ActionListener {
    JButton button1;
    JButton button2;
    JButton button3;

    JPanel context;

    public NotificationPanel(SimpleUser simpleUser) {
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.NotificationPanel," + "constructor,");
        this.setLayout(null);
        this.setBounds(0,0,375,360);

        button1 = new JButton("follow requests");
        button1.setBounds(5,5,120,20);
        button1.addActionListener(this);

        button2 = new JButton("my request");
        button2.setBounds(130,5,120,20);
        button2.addActionListener(this);

        button3 = new JButton("system notif");
        button3.setBounds(255,5,120,20);
        button3.addActionListener(this);

        context = new JPanel();
        context.setLayout(null);
        context.setBounds(0,25,375,350);

        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(context);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1){
            MyLogger.getLogger().log("Imp lvl:2," + "GUI.NotificationPanel," + "button1,");
            showFollowRequest(Connector.userListRequest("2", ThisUser.simpleUser.getId()));
            return;
        }
        if(e.getSource()==button2){
            MyLogger.getLogger().log("Imp lvl:2," + "GUI.NotificationPanel," + "button2,");
            showMyRequest(Connector.userListRequest("3", ThisUser.simpleUser.getId()));
            return;
        }

    }
    public void showFollowRequest(ArrayList<String> arrayList){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.NotificationPanel," + "showFollowRequest,");
        context.removeAll();
        FollowRequestPanel followRequestPanel;
        for (int i = 0;i<arrayList.size();i++){
            System.out.println(arrayList.get(i));
            followRequestPanel = new FollowRequestPanel(arrayList.get(i));
            followRequestPanel.setBounds(0,5,375,30);
            context.add(followRequestPanel);
        }
        context.repaint();
        revalidate();
    }
    public void showMyRequest(ArrayList<String> arrayList){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.NotificationPanel," + "showMyRequest,");
        context.removeAll();
        UserPane userPane = new UserPane(arrayList);
        System.out.println(arrayList);
        context.add(userPane);
        context.repaint();
        revalidate();
    }


}
