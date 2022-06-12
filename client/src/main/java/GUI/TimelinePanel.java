package GUI;

import Data.ThisUser;
import connection.Connector;
import logger.MyLogger;
import models.SimpleUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimelinePanel extends JPanel implements ActionListener {
    JPanel context;
    JPanel jPanel;

    public TimelinePanel() {
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.TimelinePanel," + "constructor,");
        this.setLayout(null);
        this.setBounds(0,0,600,360);

        jPanel = new JPanel();
        jPanel.setBackground(Color.LIGHT_GRAY);
        jPanel.setBounds(0,0,225,360);

        context = new JPanel();
        context.setLayout(null);
        context.setBounds(225,0,375,360);

        this.add(context);
        this.add(jPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public void setContext(SimpleUser simpleuser){
        context.removeAll();
        TwittPane twittPane = new TwittPane(Connector.twittListRequest("2",simpleuser.getId()));
        context.add(twittPane);
        context.repaint();
        revalidate();
    }
}
