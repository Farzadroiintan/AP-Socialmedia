package GUI;

import connection.ConnectionResource;
import connection.Connector;
import logger.MyLogger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel implements ActionListener {
    JButton button1;
    JButton button2;

    JLabel jLabel1;
    JLabel jLabel2;
    JLabel jLabel3;
    JLabel jLabel4;
    JLabel jLabel5;

    JTextField textField1;
    JTextField textField2;
    JCheckBox checkBox;

    public LoginPanel() {
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.LoginPanel," + "constructor,");
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

        jLabel1 = new JLabel("Login");
        jLabel1.setBounds(280,70,80,30);
        jLabel1.setFont(new Font("Serif", Font.PLAIN, 17));

        jLabel2 = new JLabel("Username");
        jLabel2.setBounds(140,120,80,30);

        jLabel3 = new JLabel("Password");
        jLabel3.setBounds(140,150,80,30);

        jLabel4 = new JLabel("Don't have an account yet? Click on sign up.");
        jLabel4.setBounds(220,240,200,30);
        jLabel4.setFont(new Font("Serif", Font.PLAIN, 10));

        jLabel5 = new JLabel();
        jLabel5.setBounds(400,180,200,30);
        jLabel5.setFont(new Font("Serif", Font.PLAIN, 17));
        jLabel5.setForeground(Color.RED);

        checkBox = new JCheckBox();
        checkBox.setText("Remember me!");
        checkBox.setBounds(220,210,165,30);

        this.add(button1);
        this.add(button2);
        this.add(textField1);
        this.add(textField2);
        this.add(jLabel1);
        this.add(jLabel2);
        this.add(jLabel3);
        this.add(jLabel4);
        this.add(jLabel5);
        this.add(checkBox);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1){
            MyLogger.getLogger().log("Imp lvl:2," + "GUI.LoginPanel," + "button1,");
            ConnectionResource.setUsername(textField1.getText());
            ConnectionResource.setPassword(textField2.getText());
            String stat =Connector.loginRequest();
            if(stat.equals("0")){
                GUI.loginUsernameNotFound();
                return;
            }
            if (stat.equals("1")){
                GUI.loginWrongPassword();
                return;
            }
            if(stat.equals("2")){
                GUI.loginSuccessful();
//                GUI.showHome();
//                GUI.showButton();

                return;
            }

        }else {
            MyLogger.getLogger().log("Imp lvl:2," + "GUI.LoginPanel," + "button2,");
            GUI.showSignUp();
        }
    }
}
