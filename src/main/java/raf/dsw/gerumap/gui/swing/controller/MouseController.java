package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.rightView.MindMapView;
import raf.dsw.gerumap.gui.swing.view.rightView.ProjectView;
import raf.dsw.gerumap.mapRepository.implementation.Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;

public class MouseController extends MouseAdapter {
    @Override
    public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
           MindMapView mindMapView = (MindMapView) MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedComponent();
            if (mindMapView instanceof MindMapView) {
                Project project = (Project) mindMapView.getMindMap().getParent();
                if (project instanceof Project) {
                    for (ProjectView projectView : ProjectView.projectViews) {
                        if (projectView.getProject().getName().equals(project.getName())) {
                            projectView.setCurrMindMap((MindMapView) e.getSource());
                            projectView.setPoint(e.getPoint());
                            projectView.misKliknut();
                        }
                    }
                }
            }
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
            MindMapView mindMapView = (MindMapView) MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedComponent();
            if (mindMapView instanceof MindMapView) {
                Project project = (Project) mindMapView.getMindMap().getParent();
                if (project instanceof Project) {
                    for (ProjectView projectView : ProjectView.projectViews) {
                        if (projectView.getProject().getName().equals(project.getName())) {
                            projectView.setCurrMindMap((MindMapView) e.getSource());
                            projectView.setPoint(e.getPoint());
                            projectView.misPovucen((MindMapView) e.getSource(), e.getPoint());
                        }
                    }
                }
            }
        }
    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        MindMapView mindMapView = (MindMapView) MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedComponent();
        if (mindMapView instanceof MindMapView) {
            Project project = (Project) mindMapView.getMindMap().getParent();
            if (project instanceof Project) {
                for (ProjectView projectView : ProjectView.projectViews) {
                    if (projectView.getProject().getName().equals(project.getName())) {
                        projectView.setCurrMindMap((MindMapView) e.getSource());
                        System.out.println(e.getSource());
                        projectView.setPoint(e.getPoint());
                        System.out.println(e.getPoint());
                        projectView.misPusten();
                    }
                }
            }
        }
    }
}
