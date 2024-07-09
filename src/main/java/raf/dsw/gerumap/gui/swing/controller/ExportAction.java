package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.rightView.MindMapView;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class ExportAction extends AbstractGerumapAction {

    public ExportAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        //putValue(SMALL_ICON, loadIcon("images/fileopen.png"));
        putValue(NAME, "Export");
        putValue(SHORT_DESCRIPTION, "Export");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Dimension d =  MainFrame.getInstance().getProjectView().getCurrMindMap().getSize();
        BufferedImage image2 = new BufferedImage((int) d.getWidth(), (int) d.getHeight(), BufferedImage.TYPE_INT_RGB);
        JFileChooser jFile = new JFileChooser();
        jFile.showSaveDialog(null);

        Path pth = jFile.getSelectedFile().toPath();
        JOptionPane.showMessageDialog(null, pth.toString());
        Graphics2D g = image2.createGraphics();
        MainFrame.getInstance().getProjectView().getCurrMindMap().paintComponent(g);
        MainFrame.getInstance().getProjectView().getCurrMindMap().print(g);
        g.dispose();

        try {
            ImageIO.write(image2, "png", new File(pth.toString()));
        } catch (IOException ox) {
            // TODO: handle exception
            ox.printStackTrace();

        }
    }
}
