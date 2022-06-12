package GUI;

import GUI.GUI;
import config.ConfigStyles;
import config.Propertiees;
import connection.Connector;
import logger.MyLogger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FollowRequestPanel extends JPanel implements ActionListener {
    String username;
    JTextArea textArea;
    JButton button1;
    JButton button2;

    public FollowRequestPanel(String username) {
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.FollowRequestPanel," + "constructor,");
        this.setLayout(null);
        this.username = username;

        textArea = new JTextArea(username + ConfigStyles.text("textArea", Propertiees.prop("FollowRequestPanel")));
        textArea.setBounds(ConfigStyles.rectangle("textArea", Propertiees.prop("FollowRequestPanel")));

        button1 = new JButton(ConfigStyles.text("button1", Propertiees.prop("FollowRequestPanel")));
        button1.setBounds(ConfigStyles.rectangle("button1", Propertiees.prop("FollowRequestPanel")));
        button1.addActionListener(this);

        button2 = new JButton(ConfigStyles.text("button2", Propertiees.prop("FollowRequestPanel")));
        button2.setBounds(ConfigStyles.rectangle("button2", Propertiees.prop("FollowRequestPanel")));
        button2.addActionListener(this);

        this.add(textArea);
        this.add(button1);
        this.add(button2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1){
            MyLogger.getLogger().log("Imp lvl:2," + "GUI.FollowRequestPanel," + "button1,");
            Connector.acceptFollowRequest(Connector.userRequest(this.username).getId());
            return;
        }
        if(e.getSource()==button2){
            MyLogger.getLogger().log("Imp lvl:2," + "GUI.FollowRequestPanel," + "button2,");
            Connector.rejectFollowRequest(Connector.userRequest(this.username).getId());
            return;
        }
    }
}
