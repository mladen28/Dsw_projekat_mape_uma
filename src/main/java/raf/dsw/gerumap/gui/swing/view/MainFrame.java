package raf.dsw.gerumap.gui.swing.view;

import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.gui.swing.controller.ActionManager;
import raf.dsw.gerumap.gui.swing.tree.MapTree;
import raf.dsw.gerumap.gui.swing.tree.MapTreeImplementation;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.tree.view.MapTreeView;
import raf.dsw.gerumap.gui.swing.view.rightView.MindMapView;
import raf.dsw.gerumap.gui.swing.view.rightView.ProjectView;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;


import javax.swing.*;
import java.awt.*;
import java.awt.MenuBar;

public class MainFrame extends JFrame {

    private JMenuBar menu;
    private JToolBar toolbar;
    private ActionManager actionManager;
    private MapTree mapTree;
    private JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

    private JScrollPane paneLeft;

    private void initialise () {
        actionManager = new ActionManager();
        mapTree = new MapTreeImplementation();
        initialiseGui();
    }
    private void initialiseGui(){
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();

        setSize(1300,580);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("GeRuMap");

        menu=new MyMenuBar();
        setJMenuBar(menu);


        toolbar=new Toolbar();
        add(toolbar, BorderLayout.NORTH);


        JTree projectExplorer = mapTree.generateTree(ApplicationFramework.getInstance().getMapRepository().getProjectExplorer());

        sp.setOneTouchExpandable(true);
        sp.setDividerLocation(150);

        paneLeft = new JScrollPane(projectExplorer);

        paneLeft.setMinimumSize(new Dimension(250,250));
        sp.setLeftComponent(paneLeft);

        add(sp, BorderLayout.CENTER);


    }

    private static MainFrame instance = null;

    private MainFrame() {

    }

    public static MainFrame getInstance(){
        if (instance == null){
            instance  = new MainFrame();
            instance.initialise();

        }
        return instance;
    }

    public JMenuBar getMenu() {
        return menu;
    }

    public void setMenu(JMenuBar menu) {
        this.menu = menu;
    }

    public JToolBar getToolbar() {
        return toolbar;
    }

    public void setToolbar(JToolBar toolbar) {
        this.toolbar = toolbar;
    }

    public ActionManager getActionManager() {
        return actionManager;
    }

    public void setActionManager(ActionManager actionManager) {
        this.actionManager = actionManager;
    }

    public MapTree getMapTree() {
        return mapTree;
    }

    public void setMapTree(MapTree mapTree) {
        this.mapTree = mapTree;
    }

    public JSplitPane getSp() {
        return sp;
    }

    public void setSp(JSplitPane sp) {
        this.sp = sp;
    }

    public void setRightView(ProjectView projectView){

        this.sp.setRightComponent(projectView);
    }


    public ProjectView getProjectView(){
        return (ProjectView) sp.getRightComponent();
    }

}
