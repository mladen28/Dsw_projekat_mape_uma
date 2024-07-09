package raf.dsw.gerumap.gui.swing.tree;

import raf.dsw.gerumap.ErrorFactory.Errors;
import raf.dsw.gerumap.ErrorFactory.MessageGeneratorImplementation;
import raf.dsw.gerumap.factory.FactoryUtils;
import raf.dsw.gerumap.factory.NodeFactory;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.tree.model.MyModel;
import raf.dsw.gerumap.gui.swing.tree.view.MapTreeView;
import raf.dsw.gerumap.gui.swing.view.rightView.MindMapView;
import raf.dsw.gerumap.gui.swing.view.rightView.ProjectView;
import raf.dsw.gerumap.mapRepository.commands.CommandManager;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.composite.MapNodeComposite;
import raf.dsw.gerumap.mapRepository.implementation.*;

import javax.swing.*;
import javax.swing.tree.TreePath;

public class MapTreeImplementation implements MapTree{

    private MapTreeView treeView;
    private MyModel treeModel;
    private TreePath path;


    @Override
    public MapTreeView generateTree(ProjectExplorer projectExplorer) {
        MapTreeItem root = new MapTreeItem(projectExplorer);
        treeModel = new MyModel(root);
        treeView = new MapTreeView();
        treeView.setModel(treeModel);
        return treeView;
    }

    @Override
    public void addChild(MapTreeItem parent) {

        if(parent == null)
        {
            MessageGeneratorImplementation.getInstance().generateError(Errors.nullSelected);
            return;
        }
        if (!(parent.getMapNode() instanceof MapNodeComposite)) {
            MessageGeneratorImplementation.getInstance().generateError(Errors.nodeLeaf);
            return;
        }
        if(parent.getMapNode() instanceof Element)
        {
            //MessageGeneratorImplementation.getInstance().generateError(Errors.nodeLeaf);
        }
        /*
        MapTreeItem selectedNode = MainFrame.getInstance().getMapTree().getSelectedNode();
        MapNode mapNode = selectedNode.getMapNode();

        FactoryUtils factoryGenerator = new FactoryUtils();
        NodeFactory nodeFactory = factoryGenerator.returnNodeFactory(mapNode);
        MapNode newMapNode = nodeFactory.getNewNode(mapNode);
        MapTreeItem mapTreeItem = new MapTreeItem(newMapNode);
        parent.add(mapTreeItem);
       if(parent.getMapNode() instanceof ProjectExplorer){
            System.out.println(mapTreeItem.getMapNode().getName());
            ProjectView.projectViews.add(new ProjectView((Project) mapTreeItem.getMapNode()));
        }
       MainFrame.getInstance().getTree().expandPath(path);
       SwingUtilities.updateComponentTreeUI(treeView);

         */
        MapNode child = createChild(parent.getMapNode());
        MapTreeItem mapTreeItem = new MapTreeItem(child);
        parent.add(mapTreeItem);
        if(parent.getMapNode() instanceof ProjectExplorer){
            System.out.println(mapTreeItem.getMapNode().getName());
            ProjectView.projectViews.add(new ProjectView((Project) mapTreeItem.getMapNode()));
        }
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }


    @Override
    public void removeChild(MapTreeItem parent)
    {
        if(parent == null)
        {
            MessageGeneratorImplementation.getInstance().generateError(Errors.nullSelected);
            return;
        }
        if(parent.getMapNode() instanceof ProjectExplorer) {
            MessageGeneratorImplementation.getInstance().generateError(Errors.nodeProjectExplorer);
            return;
        }
        ((MapNodeComposite)parent.getMapNode().getParent()).deleteChild(parent.getMapNode());
        parent.removeAllChildren();
        parent.removeFromParent();


        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public MapTreeItem getSelectedNode() {
        return (MapTreeItem) treeView.getLastSelectedPathComponent();
    }

    @Override
    public void loadProject(Project project) {

        MapTreeItem loadedProject = new MapTreeItem(project);
        treeModel.getRoot().add(loadedProject);

        MapNodeComposite mapNode = (MapNodeComposite) treeModel.getRoot().getMapNode();
        mapNode.addChild(project);

        ProjectView projectView = new ProjectView(project);
        ProjectView.projectViews.add(projectView);


        if(project.getChildren().size() != 0){
            for (MapNode mindMap:  project.getChildren()) {
                mindMap.setParent(project);
                MapTreeItem mindMapNode = new MapTreeItem(mindMap);
                loadedProject.add(mindMapNode);
                MindMapView mindMapView = new MindMapView((MindMap) mindMap);
                projectView.getMindMapViews().add(mindMapView);
                projectView.getTabbedPane().add(mindMap.getName(), mindMapView);
                if(((MapNodeComposite) mindMap).getChildren().size() !=0){
                    for (MapNode element:((MapNodeComposite) mindMap).getChildren()) {
                        element.setParent(mindMap);
                        mindMapNode.add(new MapTreeItem(element));
                    }
                }
            }
        }
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);

        System.out.println("Dosao sam OVDE");
    }

    private MapNode createChild(MapNode parent) {
        NodeFactory node = FactoryUtils.returnNodeFactory(parent);
        return node.getNewNode(parent);
    }
}
