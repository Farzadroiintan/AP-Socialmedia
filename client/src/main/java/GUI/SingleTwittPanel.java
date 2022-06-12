package GUI;

import connection.Connector;
import logger.MyLogger;
import models.SimpleTwitt.SimpleTwitt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SingleTwittPanel extends JPanel implements ActionListener {
    SimpleTwitt simpleTwitt;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton button8;

    JTextArea area1;
    JTextArea area2;
    JTextArea area3;
    JTextArea area4;

    JTextArea textArea1;

    public SingleTwittPanel(SimpleTwitt simpleTwitt) {
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.SingleTwittPanel," + "constructor,");
        this.setLayout(null);
        this.simpleTwitt = simpleTwitt;

        area1 = new JTextArea(String.valueOf(simpleTwitt.getWriterUsername()));
        area1.setBounds(5,0,375,20);

        area2 = new JTextArea(simpleTwitt.getContext());
        area2.setBounds(5,20,375,60);

        area3 = new JTextArea(simpleTwitt.getWriteDateTime().toString());
        area3.setBounds(5,80,375,20);

        area4 = new JTextArea("Likes:"+simpleTwitt.getLikes()+"  "+"Comments:"+simpleTwitt.getComments());
        area4.setBounds(5,100,375,20);

        button1 = new JButton("like");
        button1.setBounds(5,120,80,25);
        button1.setFont(new Font("Serif", Font.PLAIN, 12));
        button1.addActionListener(this);

        button2 = new JButton("retwitt");
        button2.setBounds(95,120,80,25);
        button2.setFont(new Font("Serif", Font.PLAIN, 12));
        button2.addActionListener(this);

        button3 = new JButton("save");
        button3.setBounds(185,120,80,25);
        button3.setFont(new Font("Serif", Font.PLAIN, 12));
        button3.addActionListener(this);

        button4 = new JButton("forward");
        button4.setBounds(275,120,80,25);
        button4.setFont(new Font("Serif", Font.PLAIN, 12));
        button4.addActionListener(this);

        button5 = new JButton("comments");
        button5.setBounds(05,150,80,25);
        button5.setFont(new Font("Serif", Font.PLAIN, 10));
        button5.addActionListener(this);

        button6 = new JButton("profile");
        button6.setBounds(95,150,80,25);
        button6.setFont(new Font("Serif", Font.PLAIN, 11));
        button6.addActionListener(this);

        button7 = new JButton("report");
        button7.setBounds(185,150,80,25);
        button7.setFont(new Font("Serif", Font.PLAIN, 12));
        button7.addActionListener(this);

        button8 = new JButton("put cm");
        button8.setBounds(275,150,80,25);
        button8.setFont(new Font("Serif", Font.PLAIN, 11));
        button8.addActionListener(this);

        textArea1 = new JTextArea();
        textArea1.setBounds(5,180,375,60);

        this.add(area1);
        this.add(area2);
        this.add(area3);
        this.add(area4);

        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(button5);
        this.add(button6);
        this.add(button7);
        this.add(button8);

        this.add(textArea1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==button1) {
            MyLogger.getLogger().log("Imp lvl:2," + "GUI.SingleTwittPanel," + "button1,");
            Connector.likeRequest(this.simpleTwitt.getId());
            return;
        }
        if (e.getSource()==button2) {
            MyLogger.getLogger().log("Imp lvl:2," + "GUI.SingleTwittPanel," + "button2,");

            return;
        }
        if (e.getSource()==button3) {
            MyLogger.getLogger().log("Imp lvl:2," + "GUI.SingleTwittPanel," + "button3,");
            Connector.saveRequest(this.simpleTwitt.getId());
            return;
        }
        if (e.getSource()==button4) {
            MyLogger.getLogger().log("Imp lvl:2," + "GUI.SingleTwittPanel," + "button4,");
            return;
        }
        if (e.getSource()==button5) {
            MyLogger.getLogger().log("Imp lvl:2," + "GUI.SingleTwittPanel," + "button5,");
            GUI.homeShowTwittComment(this.simpleTwitt.getId());
            return;
        }
        if (e.getSource()==button6) {
            MyLogger.getLogger().log("Imp lvl:2," + "GUI.SingleTwittPanel," + "button6,");
            GUI.floatShowProfile(Connector.userRequest(this.simpleTwitt.getWriterUsername()));
            return;
        }
        if (e.getSource()==button7) {
            MyLogger.getLogger().log("Imp lvl:2," + "GUI.SingleTwittPanel," + "button7,");
            Connector.reportRequest(this.simpleTwitt.getId());
            return;
        }
        if (e.getSource()==button8) {
            MyLogger.getLogger().log("Imp lvl:2," + "GUI.SingleTwittPanel," + "button8,");
            Connector.writeCommentRequest(this.simpleTwitt.getId(),textArea1.getText());
            return;
        }


    }
}
