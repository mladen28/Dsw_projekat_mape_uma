package raf.dsw.gerumap.mapRepository.commands.implementation;

import raf.dsw.gerumap.mapRepository.commands.AbstractCommand;
import raf.dsw.gerumap.mapRepository.implementation.Link;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;

public class AddLinkCommand extends AbstractCommand {

    private Link link;
    private String type;
    public AddLinkCommand (Link link) {
        this.link = link;
        type = "AddLinkCommand";

    }
    @Override
    public void doCommand() {
        ((MindMap) (link.getParent())).addLink(link);
    }

    @Override
    public void undoCommand() {

        ((MindMap) (link.getParent())).deleteLink(link);
    }
}
