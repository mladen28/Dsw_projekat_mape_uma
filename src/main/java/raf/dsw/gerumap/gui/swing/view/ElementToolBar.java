package raf.dsw.gerumap.gui.swing.view;

import javax.swing.*;
import java.awt.*;

public class ElementToolBar extends JToolBar {

    private JTextField strokeSize;

    public ElementToolBar() {
        super(VERTICAL);

        setFloatable(false);
        setBackground(new Color(132, 118, 164));

        strokeSize = new JTextField();
        strokeSize.setText("1");
        strokeSize.setEditable(true);


        add(MainFrame.getInstance().getActionManager().getTermStateAction());
        add(MainFrame.getInstance().getActionManager().getLinkStateAction());
        add(MainFrame.getInstance().getActionManager().getSelectedStateAction());
        add(MainFrame.getInstance().getActionManager().getDeleteStateAction());
        add(MainFrame.getInstance().getActionManager().getMoveStateAction());
        add(MainFrame.getInstance().getActionManager().getZoomStateAction());
        addSeparator();
        addSeparator();
        add(strokeSize);
        addSeparator();
        add(MainFrame.getInstance().getActionManager().getChooseCollorAction());

    }

    public JTextField getStrokeSize() {
        return strokeSize;
    }


    public void setStrokeSize(JTextField strokeSize) {
        this.strokeSize = strokeSize;
    }
}
