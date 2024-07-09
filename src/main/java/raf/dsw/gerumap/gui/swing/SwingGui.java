package raf.dsw.gerumap.gui.swing;

import raf.dsw.gerumap.ErrorFactory.Error;
import raf.dsw.gerumap.ErrorFactory.MessageGeneratorImplementation;
import raf.dsw.gerumap.core.Gui;
import raf.dsw.gerumap.gui.swing.view.MainFrame;

import javax.swing.*;


public class SwingGui implements Gui {

    private MainFrame instance;

    public SwingGui () {

    }
    @Override
    public void start() {

        instance = MainFrame.getInstance();
        instance.setVisible(true);
        MessageGeneratorImplementation.getInstance().addSubscriber(this);
    }

    @Override
    public void update(Object errObject) {
        Error err = (Error) errObject;
        JOptionPane.showMessageDialog(null,err.getPoruka(),"Error",JOptionPane.ERROR_MESSAGE);
    }
}
