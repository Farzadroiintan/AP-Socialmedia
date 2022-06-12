package GUI;

import Data.ThisUser;
import GUI.GUI;
import connection.Connector;
import logger.MyLogger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WriteTwittPanel extends JPanel implements ActionListener {
    JTextArea textArea1;
    JButton button1;
    JLabel label1;

    public WriteTwittPanel() {
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.WriteTwittPanel," + "constructor,");
        this.setLayout(null);
        this.setBounds(0,0,375,380);

        textArea1 = new JTextArea();
        textArea1.setBounds(5,5,365,200);
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);

        button1 = new JButton("Send");
        button1.setBounds(5,210,80,20);
        button1.addActionListener(this);

        label1 = new JLabel();
        label1.setBounds(105,210,160,20);

        this.add(textArea1);
        this.add(button1);
        this.add(label1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1){
            MyLogger.getLogger().log("Imp lvl:2," + "GUI.WriteTwittPanel," + "button1,");
            Connector.writeTwittRequest(textArea1.getText());
            textArea1.setText("");
            this.revalidate();
            this.repaint();
            return;
        }
    }
}
