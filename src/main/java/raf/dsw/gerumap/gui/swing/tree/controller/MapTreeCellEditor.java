package raf.dsw.gerumap.gui.swing.tree.controller;

import raf.dsw.gerumap.ErrorFactory.Errors;
import raf.dsw.gerumap.ErrorFactory.MessageGeneratorImplementation;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class MapTreeCellEditor extends DefaultTreeCellEditor implements ActionListener {

    private Object clickedOn =null;
    private JTextField edit=null;

    public MapTreeCellEditor(JTree arg0, DefaultTreeCellRenderer arg1) {

        super(arg0, arg1);
    }

    public Component getTreeCellEditorComponent(JTree arg0, Object arg1, boolean arg2, boolean arg3, boolean arg4, int arg5) {
        clickedOn =arg1;
        edit=new JTextField(arg1.toString());
        edit.addActionListener(this);
        return edit;
    }

    public boolean isCellEditable(EventObject arg0) {
        if (arg0 instanceof MouseEvent)
            if (((MouseEvent)arg0).getClickCount()==3){
                    return true;

            }
        return false;
    }


    public void actionPerformed(ActionEvent e){

        if(clickedOn instanceof MapTreeItem)
            if (((MapTreeItem)clickedOn).getMapNode() instanceof MindMap){
                ((MapTreeItem)clickedOn).getMapNode().setName(e.getActionCommand());
            }else if(((MapTreeItem)clickedOn).getMapNode() instanceof Project){
                ((MapTreeItem)clickedOn).getMapNode().setName(e.getActionCommand());
            }else if(((MapTreeItem)clickedOn).getMapNode() instanceof Element){
                ((MapTreeItem)clickedOn).getMapNode().setName(e.getActionCommand());
            }else{
                MessageGeneratorImplementation.getInstance().generateError(Errors.threeClickProjectExplorer);

            }
        //SwingUtilities.updateComponentTreeUI( MainFrame.getInstance().getTree());
    }
}
