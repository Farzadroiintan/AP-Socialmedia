package GUI;

import Data.ThisUser;
import logger.MyLogger;

import javax.swing.*;

public class MainPanel extends JPanel {
    ButtonPanel buttonPanel;
    JPanel context;
    HomePanel homePanel = new HomePanel();
    ExplorePanel explorePanel = new ExplorePanel();
    ChatPanel chatPanel = new ChatPanel();
    TimelinePanel timelinePanel = new TimelinePanel();
    FloatPanel floatPanel = new FloatPanel();

    public MainPanel() {
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.MainPanel," + "constructor,");
        this.setLayout(null);
        this.setBounds(0,0,600,420);

        buttonPanel = new ButtonPanel();
        buttonPanel.setBounds(0,360,600,20);

        context = new JPanel();
        context.setLayout(null);
        context.setBounds(0,0,600,420);

        this.add(buttonPanel);
        this.add(context);
    }

    public  void setHomePanel(){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.MainPanel," + "setHomePanel,");
        context.removeAll();
        context.add(homePanel);
        context.repaint();
        revalidate();
    }
    public  void setExplorePanel(){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.MainPanel," + "setExplorePanel,");
        context.removeAll();
        context.add(explorePanel);
        context.repaint();
        revalidate();
    }
    public  void setChatPanel(){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.MainPanel," + "setChatPanel,");
        context.removeAll();
        context.add(chatPanel);
        context.repaint();
        revalidate();
    }
    public  void setTimelinePanel(){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.MainPanel," + "setTimelinePanel,");
        context.removeAll();
        context.add(timelinePanel);
        timelinePanel.setContext(ThisUser.simpleUser);
        context.repaint();
        revalidate();
    }
    public  void setFloatPanel(){
        MyLogger.getLogger().log("Imp lvl:2," + "GUI.MainPanel," + "setFloatPanel,");
        context.removeAll();
        context.add(floatPanel);
        context.repaint();
        revalidate();
    }


}
