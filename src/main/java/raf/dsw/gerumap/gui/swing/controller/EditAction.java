package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.ErrorFactory.Errors;
import raf.dsw.gerumap.ErrorFactory.MessageGeneratorImplementation;
import raf.dsw.gerumap.gui.swing.tree.model.MapTreeItem;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.dialog.EditDialog;
import raf.dsw.gerumap.mapRepository.implementation.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class EditAction extends AbstractGerumapAction {

    private EditDialog editDialog;

    public EditAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/edit1.png"));
        putValue(NAME, "Edit");
        putValue(SHORT_DESCRIPTION, "Edit");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object o = MainFrame.getInstance().getMapTree().getSelectedNode();


        MapTreeItem mapTreeItem = null;

        if(o instanceof MapTreeItem)
            mapTreeItem = (MapTreeItem) o;

        if(mapTreeItem.getMapNode() instanceof Project){
            editDialog = new EditDialog((Project) mapTreeItem.getMapNode());
            editDialog.setVisible(true);
        }
        else {
            MessageGeneratorImplementation.getInstance().generateError(Errors.nullProjectSelected);
        }

    }
}
