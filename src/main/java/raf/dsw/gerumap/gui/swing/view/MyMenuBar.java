package raf.dsw.gerumap.gui.swing.view;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MyMenuBar extends JMenuBar {

    public MyMenuBar(){
        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);
        file.add(MainFrame.getInstance().getActionManager().getNewAction());
        file.add(MainFrame.getInstance().getActionManager().getDeleteAction());


        JMenu help = new JMenu("Help");
        help.add(MainFrame.getInstance().getActionManager().getEditAction());

        this.add(file);
        this.add(help);

    }
}
