package GUI;

import logger.MyLogger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserPane extends JScrollPane implements ActionListener {
    JPanel panel = new JPanel();
    SingleUserPanel singleUserPanel;

    public UserPane(ArrayList<String> arrayList) {
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.UserPane," + "constructor,");
        panel.setLayout(null);

        this.setBounds(0,0,375,360);
        this.setOpaque(false);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        for(int i=0; i<arrayList.size();i++){
            singleUserPanel = new SingleUserPanel(arrayList.get(i));
            singleUserPanel.setBounds(0,30*i,375,30);
            panel.add(singleUserPanel);
        }
        if(arrayList.size()>0){
            panel.setPreferredSize(new Dimension(375,arrayList.size()*30));
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
