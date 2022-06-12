package GUI;

import connection.Connector;
import logger.MyLogger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SingleUserPanel extends JPanel implements ActionListener {
    JTextArea textArea1;
    JButton button1;
    String username;

    public SingleUserPanel(String username) {
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.SingleUserPanel," + "constructor,");
        this.setLayout(null);
        this.username = username;
        textArea1 = new JTextArea(username);
        textArea1.setBounds(5,5,180,20);

        button1 = new JButton("profile");
        button1.setBounds(270,5,80,20);
        button1.addActionListener(this);

        this.add(textArea1);
        this.add(button1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1){
            MyLogger.getLogger().log("Imp lvl:2," + "GUI.SingleUserPanel," + "button1,");
            GUI.floatShowProfile(Connector.userRequest(username));
            return;
        }
    }
}
