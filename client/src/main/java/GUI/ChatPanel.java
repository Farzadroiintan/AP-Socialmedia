package GUI;

import config.ConfigStyles;
import config.Propertiees;
import logger.MyLogger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatPanel extends JPanel implements ActionListener {
    JLabel jLabel;
    public ChatPanel() {
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.ChatPanel," + "constructor,");
        this.setLayout(null);
        this.setBounds(ConfigStyles.rectangle("panel", Propertiees.prop("ChatPanel")));

        jLabel = new JLabel(ConfigStyles.text("jlabel", Propertiees.prop("ChatPanel")));
        jLabel.setBounds(ConfigStyles.rectangle("jlabel", Propertiees.prop("ChatPanel")));
        this.add(jLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
