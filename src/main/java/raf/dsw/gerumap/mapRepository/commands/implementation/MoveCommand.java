package raf.dsw.gerumap.mapRepository.commands.implementation;

import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.commands.AbstractCommand;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Term;

public class MoveCommand extends AbstractCommand {

    private MindMap mindMap;
    private Term term;
    private String type;

    public MoveCommand (MindMap mindMap, Term term) {
        this.mindMap = mindMap;
        this.term = term;
        type = "MoveCommand";
    }
    @Override
    public void doCommand() {
        term.setX(term.getMoveX());
        term.setY(term.getMoveY());

        MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedComponent().repaint();
    }

    @Override
    public void undoCommand() {

        term.setX(term.getOGX());
        term.setY(term.getOGY());

        MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedComponent().repaint();


    }
}
