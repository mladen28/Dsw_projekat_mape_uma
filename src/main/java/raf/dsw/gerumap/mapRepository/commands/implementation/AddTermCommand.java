package raf.dsw.gerumap.mapRepository.commands.implementation;

import raf.dsw.gerumap.mapRepository.commands.AbstractCommand;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Term;

import javax.swing.*;

public class AddTermCommand extends AbstractCommand {

    private Term term;
    private String type;

    public AddTermCommand(Term term){
        this.term = term;
        type = "AddTermCommand";


    }
    @Override
    public void doCommand() {

        ((MindMap) (term.getParent())).addTerm(term);
    }

    @Override
    public void undoCommand() {

        ((MindMap) (term.getParent())).deleteTerm(term);
    }
}
