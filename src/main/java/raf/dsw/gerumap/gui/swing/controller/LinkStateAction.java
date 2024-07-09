package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.rightView.MindMapView;
import raf.dsw.gerumap.gui.swing.view.rightView.ProjectView;
import raf.dsw.gerumap.mapRepository.implementation.Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class LinkStateAction extends AbstractGerumapAction {

    public LinkStateAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_A, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/veza.png"));
        putValue(NAME, "Dodaj vezu");
        putValue(SHORT_DESCRIPTION, "DodajVezu");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int i = MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedIndex();
        Component c = MainFrame.getInstance().getProjectView().getTabbedPane().getComponentAt(i);
        if (c instanceof MindMapView) {
            MindMapView mm = (MindMapView) MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedComponent();
            Project project = (Project) mm.getMindMap().getParent();
            if (project instanceof Project) {
                for (ProjectView projectView : ProjectView.projectViews) {
                    if (projectView.getProject().getName().equals(project.getName())) {
                        projectView.addLinkState();
                    }
                }
            }
        }
    }
}