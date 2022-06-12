package GUI;

import config.Propertiees;
import config.ConfigStyles;
import logger.MyLogger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class ButtonPanel extends JPanel implements ActionListener {
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;

    public ButtonPanel() {
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.ButtonPanel," + "constructor,");
        this.setLayout(null);
        this.setBounds(0,360,600,20);
        this.setBackground(Color.BLACK);

        button1 = new JButton(ConfigStyles.text("button1", Propertiees.prop("ButtonPanel")));
        button1.setFont(ConfigStyles.font(Propertiees.prop("ButtonPanel")));
        button1.setBounds(ConfigStyles.rectangle("button1", Propertiees.prop("ButtonPanel")));
        button1.setBackground(ConfigStyles.color(Propertiees.prop("ButtonPanel")));
        button1.addActionListener(this);

        button2 = new JButton(ConfigStyles.text("button2", Propertiees.prop("ButtonPanel")));
        button2.setFont(ConfigStyles.font(Propertiees.prop("ButtonPanel")));
        button2.setBounds(ConfigStyles.rectangle("button2", Propertiees.prop("ButtonPanel")));
        button2.setBackground(ConfigStyles.color(Propertiees.prop("ButtonPanel")));
        button2.addActionListener(this);

        button3 = new JButton(ConfigStyles.text("button3", Propertiees.prop("ButtonPanel")));
        button3.setFont(ConfigStyles.font(Propertiees.prop("ButtonPanel")));
        button3.setBounds(ConfigStyles.rectangle("button3", Propertiees.prop("ButtonPanel")));
        button3.setBackground(ConfigStyles.color(Propertiees.prop("ButtonPanel")));
        button3.addActionListener(this);

        button4 = new JButton(ConfigStyles.text("button4", Propertiees.prop("ButtonPanel")));
        button4.setFont(ConfigStyles.font(Propertiees.prop("ButtonPanel")));
        button4.setBounds(ConfigStyles.rectangle("button4", Propertiees.prop("ButtonPanel")));
        button4.setBackground(ConfigStyles.color(Propertiees.prop("ButtonPanel")));
        button4.addActionListener(this);

        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1){
            MyLogger.getLogger().log("Imp lvl:2," + "GUI.ButtonPanel," + "button1,");
            GUI.showHome();
            return;
        }
        if (e.getSource()==button2){
            MyLogger.getLogger().log("Imp lvl:2," + "GUI.ButtonPanel," + "button2,");
            GUI.showExplore();
            return;
        }
        if (e.getSource()==button3){
            MyLogger.getLogger().log("Imp lvl:2," + "GUI.ButtonPanel," + "button3,");
            GUI.showTimeline();
            return;
        }
        if (e.getSource()==button4){
            MyLogger.getLogger().log("Imp lvl:2," + "GUI.ButtonPanel," + "button4,");
            GUI.showChat();
            return;
        }

    }
}
