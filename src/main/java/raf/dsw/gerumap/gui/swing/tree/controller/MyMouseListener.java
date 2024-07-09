package raf.dsw.gerumap.gui.swing.tree.controller;

import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.rightView.MindMapView;
import raf.dsw.gerumap.gui.swing.view.rightView.ProjectView;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;

import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;

public class MyMouseListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getClickCount() == 2) {
            MapTreeItem selectedNode = MainFrame.getInstance().getMapTree().getSelectedNode();
            MapNode mapNode = selectedNode.getMapNode();
            System.out.println(mapNode);

            if (mapNode instanceof Project) {
                Project project = (Project) mapNode;
                for (ProjectView projectView : ProjectView.projectViews) {
                    if (projectView.getProject().getName().equals(project.getName())) {

                        MainFrame.getInstance().setRightView(projectView);
                    }
                }
            }
            else {
                if (mapNode instanceof MindMap) {
                    MindMap mindMap = (MindMap) mapNode;
                    Project parent = (Project) mindMap.getParent();
                    for (ProjectView projectView : ProjectView.projectViews) {
                        if (parent.equals(projectView.getProject())) {
                            for (MindMapView mindMapView : projectView.getMindMapViews()) {
                                if (mindMapView.getMindMap().getName().equals(mindMap.getName())) {
                                    MainFrame.getInstance().setRightView(projectView);
                                    projectView.setMindMapView(parent.getChildren().indexOf(mindMap));
                                }
                            }
                        }
                    }
                }
            }

            //SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getTree());
        }
    }




    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
