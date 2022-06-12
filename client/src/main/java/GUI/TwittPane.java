package GUI;

import logger.MyLogger;
import models.SimpleTwitt.SimpleTwitt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TwittPane extends JScrollPane implements ActionListener {
    JPanel panel = new JPanel();
    SingleTwittPanel singleTwittPanel;
    public TwittPane(ArrayList<SimpleTwitt> arrayList) {
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.TwittPane," + "constructor,");
        panel.setLayout(null);

        this.setBounds(0,0,375,360);
        this.setOpaque(false);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

//        this.setBounds();
        for(int i=0; i<arrayList.size();i++){
            singleTwittPanel = new SingleTwittPanel(arrayList.get(i));
            singleTwittPanel.setBounds(0,250*(i),375,245);
            panel.add(singleTwittPanel);
        }
        if(arrayList.size()>0){
            panel.setPreferredSize(new Dimension(375,arrayList.size()*250));
        }else {
            panel.setPreferredSize(new Dimension(375,360));
        }
        this.setViewportView(panel);
        panel.repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
