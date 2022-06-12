package GUI;

import Data.ThisUser;
import config.ConfigStyles;
import config.Propertiees;
import connection.Connector;
import logger.MyLogger;
import models.SimpleUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

public class ExplorePanel extends JPanel implements ActionListener {
    JPanel exploreMainPanel;
    JButton button1;
    JTextField textField1;
    JLabel label1;
    SingleUserPanel singleUserPanel;


    public ExplorePanel() {
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.ExplorePanel," + "constructor,");
        this.setLayout(null);
        this.setBounds(ConfigStyles.rectangle("panel", Propertiees.prop("ExplorePanel")));

        exploreMainPanel = new JPanel();
        exploreMainPanel.setLayout(null);
        exploreMainPanel.setBounds(ConfigStyles.rectangle("exploreMainPanel", Propertiees.prop("ExplorePanel")));

        textField1=new JTextField();
        textField1.setBounds(ConfigStyles.rectangle("textField1", Propertiees.prop("ExplorePanel")));

        button1 = new JButton(ConfigStyles.text("button1", Propertiees.prop("ExplorePanel")));
        button1.setBounds(ConfigStyles.rectangle("button1", Propertiees.prop("ExplorePanel")));
        button1.addActionListener(this);

        label1 = new JLabel();
        label1.setBounds(ConfigStyles.rectangle("label1", Propertiees.prop("ExplorePanel")));

        exploreMainPanel.add(textField1);
        exploreMainPanel.add(button1);
        exploreMainPanel.add(label1);

        this.add(exploreMainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1){
            MyLogger.getLogger().log("Imp lvl:2," + "GUI.ExplorePanel," + "button1,");
            if (Connector.userRequest(textField1.getText()).getId()==-1){
                label1.setText(ConfigStyles.text("label1b1", Propertiees.prop("ExplorePanel")));
                return;
            }
            singleUserPanel = new SingleUserPanel(textField1.getText());
            singleUserPanel.setBounds(ConfigStyles.rectangle("singleUserPanel", Propertiees.prop("ExplorePanel")));
            exploreMainPanel.add(singleUserPanel);
            exploreMainPanel.revalidate();
            exploreMainPanel.repaint();
//            GUI.floatShowProfile(Connector.userRequest(textField1.getText()));
            return;
        }
    }
}
