package raf.dsw.gerumap.gui.swing.tree.controller;

import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.net.URL;

public class MapTreeCellRenderer extends DefaultTreeCellRenderer {

    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {

        super.getTreeCellRendererComponent(tree, value, sel,expanded, leaf, row, hasFocus);
        URL imageURL = null;

        if(value instanceof MapTreeItem) {

            if (((MapTreeItem) value).getMapNode() instanceof ProjectExplorer) {
                imageURL = getClass().getResource("/images/projectExplorer.png");
            } else if (((MapTreeItem) value).getMapNode() instanceof Project) {
                imageURL = getClass().getResource("/images/project1.png");
            } else if (((MapTreeItem) value).getMapNode() instanceof MindMap) {
                imageURL = getClass().getResource("/images/mindmap.png");
            }
        }

        Icon icon = null;
        if (imageURL != null)
            icon = new ImageIcon(imageURL);
        setIcon(icon);

        return this;
    }
}
