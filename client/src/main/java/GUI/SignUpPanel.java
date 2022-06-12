package GUI;

import connection.ConnectionResource;
import connection.Connector;
import logger.MyLogger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpPanel extends JPanel implements ActionListener {
    JButton button1;
    JButton button2;

    JLabel jLabel1;
    JLabel jLabel2;
    JLabel jLabel3;
    JLabel jLabel4;

    JTextField textField1;
    JTextField textField2;

    public SignUpPanel() {
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.SignUpPanel," + "constructor,");
        this.setLayout(null);

        button1 = new JButton("log in");
        button1.setFont(new Font("Serif", Font.PLAIN, 12));
        button1.setBounds(220,180,80,25);
        button1.setBackground(new Color(94, 94, 170, 233));
        button1.addActionListener(this);

        button2 = new JButton("sign up");
        button2.setFont(new Font("Serif", Font.PLAIN, 12));
        button2.setBounds(305,180,80,25);
        button2.setBackground(new Color(94, 94, 170, 233));
        button2.addActionListener(this);

        textField1 = new JTextField();
        textField1.setBounds(220,120,165,25);

        textField2 = new JTextField(20);
        textField2.setBounds(220,150,165,25);

        jLabel1 = new JLabel("Sign up");
        jLabel1.setBounds(280,70,80,30);
        jLabel1.setFont(new Font("Serif", Font.PLAIN, 17));

        jLabel2 = new JLabel("Username");
        jLabel2.setBounds(140,120,80,30);

        jLabel3 = new JLabel("Password");
        jLabel3.setBounds(140,150,80,30);

        jLabel4 = new JLabel();
        jLabel4.setBounds(400,180,200,30);
        jLabel4.setFont(new Font("Serif", Font.PLAIN, 17));
        jLabel4.setForeground(Color.RED);

        this.add(button1);
        this.add(button2);
        this.add(textField1);
        this.add(textField2);
        this.add(jLabel1);
        this.add(jLabel2);
        this.add(jLabel3);
        this.add(jLabel4);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button2){
            MyLogger.getLogger().log("Imp lvl:2," + "GUI.SignUpPanel," + "button2,");
            ConnectionResource.setUsername(textField1.getText());
            ConnectionResource.setPassword(textField2.getText());
            String stat =Connector.signUpRequest();
            if(stat.equals("0")){
                GUI.signUpUsernameTaken();
                return;
            }
            if (stat.equals("1")){
                GUI.signUpSuccessful();
                return;
            }

        }else {
            MyLogger.getLogger().log("Imp lvl:2," + "GUI.SignUpPanel," + "button1,");
            GUI.showLogin();
        }
    }
}
