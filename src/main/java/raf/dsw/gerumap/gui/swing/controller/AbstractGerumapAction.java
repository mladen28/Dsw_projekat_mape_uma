package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.ErrorFactory.Errors;
import raf.dsw.gerumap.ErrorFactory.MessageGeneratorImplementation;

import javax.swing.*;
import java.net.URL;

public abstract class AbstractGerumapAction extends AbstractAction {

    public Icon loadIcon(String fileName){

        URL imageURL = getClass().getResource(fileName);
        Icon icon = null;

        if (imageURL != null) {
            icon = new ImageIcon(imageURL);
        }
        else {
            MessageGeneratorImplementation.getInstance().generateError(Errors.nullUrl);
        }
        return icon;
    }

}
