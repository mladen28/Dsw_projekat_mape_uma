package raf.dsw.gerumap.mapRepository.commands.implementation;

import raf.dsw.gerumap.mapRepository.commands.AbstractCommand;
import raf.dsw.gerumap.mapRepository.implementation.Link;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Term;

public class DeleteCommand extends AbstractCommand {

    private Link link = null;
    private Term term = null;
    private MindMap mindMap;
    private String type;

    public DeleteCommand(Link link, Term term, MindMap mindMap) {
        this.link = link;
        this.term = term;
        this.mindMap = mindMap;
    }
    public DeleteCommand(Link link, MindMap mindMap) {
        this.link = link;
        this.mindMap = mindMap;
        type = "DeleteCommand";

    }
    public DeleteCommand(Term term, MindMap mindMap) {
        this.term = term;
        this.mindMap = mindMap;
        type = "DeleteCommand";

    }
    @Override
    public void doCommand() {

        if(link == null) {
            ((MindMap) (term.getParent())).deleteTerm(term);
        }
        else if (term == null) {
            ((MindMap) (link.getParent())).deleteLink(link);

        }
        else if(term == link.getPocetak()) {

            ((MindMap) (link.getParent())).deleteLink(link);
            ((MindMap) (link.getParent())).deleteTerm(link.getPocetak());
        }
        else if (term == link.getKraj()) {
            ((MindMap) (link.getParent())).deleteLink(link);
            ((MindMap) (link.getParent())).deleteTerm(link.getKraj());
        }

        /*if(link instanceof Link) {
            ((MindMap) (link.getParent())).deleteLink(link);
        }
        if(term instanceof Term) {
            ((MindMap) (term.getParent())).deleteTerm(term);
        }

         */
    }

    @Override
    public void undoCommand() {
       /* if(link instanceof Link) {
            ((MindMap) (link.getParent())).addLink(link);
        }
        if(term instanceof Term) {
            ((MindMap) (term.getParent())).addTerm(term);
        }

        */

        if(link == null) {
            ((MindMap) (term.getParent())).addTerm(term);
        }
        else if (term == null) {
            ((MindMap) (link.getParent())).addLink(link);
        }
        else if(term == link.getPocetak()) {

            ((MindMap) (link.getParent())).addLink(link);
            ((MindMap) (link.getParent())).addTerm(link.getPocetak());
        }
        else if (term == link.getKraj()) {
            ((MindMap) (link.getParent())).addLink(link);
            ((MindMap) (link.getParent())).addTerm(link.getKraj());
        }
    }
}
