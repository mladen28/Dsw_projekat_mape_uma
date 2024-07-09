package raf.dsw.gerumap.gui.swing.tree.model;

import raf.dsw.gerumap.mapRepository.composite.MapNode;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

public class MapTreeItem extends DefaultMutableTreeNode {

    private MapNode mapNode;

    public MapTreeItem (MapNode nodeModel)  {
        this.mapNode = nodeModel;
    }

     @Override
     public String toString() {
        return mapNode.getName();
     }

     public void setName(String name) {

        this.mapNode.setName(name);
     }

    public MapNode getMapNode() {
        return mapNode;
    }

    public void setMapNode(MapNode mapNode) {
        this.mapNode = mapNode;
    }
}
