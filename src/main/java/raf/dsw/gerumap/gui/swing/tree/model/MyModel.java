package raf.dsw.gerumap.gui.swing.tree.model;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

public class MyModel extends DefaultTreeModel {

    public MyModel(TreeNode root) {
        super(root);
    }

    @Override
    public MapTreeItem getRoot() {
        MapTreeItem root = (MapTreeItem) super.getRoot();
        return root;
    }
}
