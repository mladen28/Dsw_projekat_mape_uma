package raf.dsw.gerumap.gui.swing.controller;

import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.rightView.MindMapView;
import raf.dsw.gerumap.gui.swing.view.rightView.ProjectView;
import raf.dsw.gerumap.mapRepository.implementation.Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ChooseCollorAction extends AbstractGerumapAction{

    private JColorChooser colorChooser;
    private JDialog dialog;
    private JButton save;

    public ChooseCollorAction() {
        putValue(NAME, "COLOR");
        putValue(SHORT_DESCRIPTION, "Choose color");

        colorChooser = new JColorChooser(Color.BLACK);
        dialog = new JDialog();
        dialog.setMinimumSize(new Dimension(600,400));
        dialog.setLocationRelativeTo(null);
        dialog.add(colorChooser, BorderLayout.CENTER);
        save = new JButton("Save color");
        dialog.add(save, BorderLayout.PAGE_END);
        save.addActionListener(e -> {

            MindMapView mm = (MindMapView) MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedComponent();
            Project project = (Project) mm.getMindMap().getParent();
            if(project instanceof Project){
                for(ProjectView projectView : ProjectView.projectViews){
                    if(projectView.getProject().getName().equals(project.getName())){
                        //projectView.setColor(colorChooser.getColor());
                        dialog.setVisible(false);
                    }
                }
            }
        });

    }

    public Color getCurrent() {
        return colorChooser.getColor();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dialog.setVisible(true);
    }
}
