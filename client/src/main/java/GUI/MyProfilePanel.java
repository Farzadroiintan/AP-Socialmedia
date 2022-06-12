package GUI;

import Data.ThisUser;
import GUI.GUI;
import connection.Connector;
import logger.MyLogger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//home
public class MyProfilePanel extends JPanel implements ActionListener {
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel label6;
    JLabel label7;
    JLabel label8;

    JTextField textField1;
    JTextField textField2;
    JTextField textField3;
    JTextField textField4;
    JTextField textField5;
    JTextField textField6;
    JTextField textField7;
    JTextField textField8;

    JButton button1;

    public MyProfilePanel() {
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.MyProfilePanel," + "constructor,");
        this.setLayout(null);
        this.setBounds(0,0,375,360);
//        setText();
//        this.setBackground(Color.BLACK);

        label1 = new JLabel("username:");
        label1.setBounds(25,5,90,25);
        textField1 = new JTextField();
        textField1.setBounds(115,5,90,25);

        label2 = new JLabel("firstname:");
        label2.setBounds(25,40,90,25);
        textField2 = new JTextField();
        textField2.setBounds(115,40,90,25);

        label3 = new JLabel("lastname:");
        label3.setBounds(25,75,90,25);
        textField3 = new JTextField();
        textField3.setBounds(115,75,90,25);

        label4 = new JLabel("email:");
        label4.setBounds(25,110,90,25);
        textField4 = new JTextField();
        textField4.setBounds(115,110,90,25);

        label5 = new JLabel("bio:");
        label5.setBounds(25,145,90,25);
        textField5 = new JTextField();
        textField5.setBounds(115,145,90,25);

        label6 = new JLabel("phone number:");
        label6.setBounds(25,180,90,25);
        textField6 = new JTextField();
        textField6.setBounds(115,180,90,25);

        label7 = new JLabel("privacy:");
        label7.setBounds(25,215,90,25);
        textField7 = new JTextField();
        textField7.setBounds(115,215,90,25);

        label8 = new JLabel("last seen:");
        label8.setBounds(25,250,90,25);
        textField8 = new JTextField();
        textField8.setBounds(115,250,90,25);

        button1 = new JButton("edit");
        button1.setBounds(215,250,90,25);
        button1.addActionListener(this);

        this.add(label1);
        this.add(label2);
        this.add(label3);
        this.add(label4);
        this.add(label5);
        this.add(label6);
        this.add(label7);
        this.add(label8);
        this.add(textField1);
        this.add(textField2);
        this.add(textField3);
        this.add(textField4);
        this.add(textField5);
        this.add(textField6);
        this.add(textField7);
        this.add(textField8);
        this.add(button1);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1){
            MyLogger.getLogger().log("Imp lvl:2," + "GUI.MyProfilePanel," + "button1,");
            Connector.profileEditRequest(textField1.getText(),textField2.getText(),textField3.getText(),textField4.getText(),textField5.getText(),textField6.getText(),textField7.getText(),textField8.getText());
            ThisUser.setUser(ThisUser.simpleUser.getUsername());
            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
            textField4.setText("");
            textField5.setText("");
            textField6.setText("");
            textField7.setText("");
            textField8.setText("");
            setText();
            repaint();
            revalidate();
            return;
        }

    }
    public void setText(){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.MyProfilePanel," + "setText,");
        if (ThisUser.simpleUser!=null){
            textField1.setText(ThisUser.simpleUser.getUsername());
            textField2.setText(ThisUser.simpleUser.getFirstname());
            textField3.setText(ThisUser.simpleUser.getLastname());
            textField4.setText(ThisUser.simpleUser.getEmail());
            textField5.setText(ThisUser.simpleUser.getBio());
            textField6.setText(ThisUser.simpleUser.getPhoneNumber());
            if(ThisUser.simpleUser.isPublicPage()){
                textField7.setText("public");
            }else {
                textField7.setText("private");
            }
            if (ThisUser.simpleUser.getLastSeenAccess()==0){
                textField8.setText("nobody");
            }
            if (ThisUser.simpleUser.getLastSeenAccess()==1){
                textField8.setText("just followers");
            }
            if (ThisUser.simpleUser.getLastSeenAccess()==2){
                textField8.setText("every one");
            }
        }

    }
}
