package raf.dsw.gerumap.state;

import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.rightView.MindMapView;
import raf.dsw.gerumap.gui.swing.view.rightView.ProjectView;
import raf.dsw.gerumap.mapRepository.commands.implementation.AddTermCommand;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.implementation.Term;

import javax.swing.*;

public class TermState extends State{
    @Override
    public void misKliknut(MindMapView mindMapView,int x, int y) {

        ProjectView p = null;
        Project project = (Project) mindMapView.getMindMap().getParent();
        if (project instanceof Project) {
            for (ProjectView projectView : ProjectView.projectViews) {
                if (projectView.getProject().getName().equals(project.getName())) {
                    p = projectView;
                }
            }

            JOptionPane edit = new JOptionPane();
            String content = edit.showInputDialog(MainFrame.getInstance(), "Unesite ime pojma");

            Term term;
            term = new Term(x, y, 100, 50, MainFrame.getInstance().getActionManager().getChooseCollorAction().getCurrent().getRGB(),p.getStroke(), content,mindMapView.getMindMap());

            MainFrame.getInstance().getProjectView().getMindMapCurrent().getCommandManager().addCommand(new AddTermCommand(term));
        }
    }

    @Override
    public void misPovucen(MindMapView mindMapView, int x, int y) {

    }
}
