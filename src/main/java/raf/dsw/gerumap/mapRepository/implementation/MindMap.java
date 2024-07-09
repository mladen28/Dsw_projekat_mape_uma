package raf.dsw.gerumap.mapRepository.implementation;

import raf.dsw.gerumap.Observer.Publisher;
import raf.dsw.gerumap.Observer.Subscriber;
import raf.dsw.gerumap.mapRepository.commands.CommandManager;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.composite.MapNodeComposite;

import java.io.File;
import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;

public class MindMap extends MapNodeComposite{


    transient List<Subscriber> subscribers;
    private transient CommandManager commandManager;

    private ArrayList<Term> terms = new ArrayList<>();
    private ArrayList<Link> links = new ArrayList<>();


    public MindMap(String name, MapNode parent) {
        super(name, parent);
        commandManager = new CommandManager();
        type = "MindMap";
    }

    public void addTerm(Term term){
        terms.add(term);
        notify(term);
    }

    public void deleteTerm(Term term)
    {
        terms.remove(term);
        notify(term);

    }
    public void addLink(Link link){
        links.add(link);
        notify(link);
    }

    public void deleteLink(Link link) {
        links.remove(link);
        notify(link);
    }

    public void setUpLoadedMindMap () {
        for(Term term : terms){
            notify(term);
        }
        for (Link link: links) {
            notify(link);
        }

        this.subscribers = new ArrayList<>();
    }
    @Override
    public void setName(String name) {
        super.setName(name);
        notify("rename " + this.getName());
    }


    @Override
    public void rename(String ime) {
        this.setName(ime);
        notify("rename " + this.getName());
    }

    @Override
    public void addChild(MapNode child) {
        if (child instanceof Element) {
                this.getChildren().add(child);
                child.setParent(this);
            notify("add " + child.getName());
        }
        else return;
    }

    @Override
    public void deleteChild(MapNode child) {
        if (child instanceof Element) {
            this.getChildren().remove(child);
            notify("delete " + child.getName());
        }
    }

    @Override
    public String toString() {
        return "MindMap";
    }

    @Override
    public void addSubscriber(Subscriber sub) {
        if(sub == null)
            return;
        if(this.subscribers ==null)
            this.subscribers = new ArrayList<>();
        if(this.subscribers.contains(sub))
            return;
        this.subscribers.add(sub);
    }

    @Override
    public void removeSubscriber(Subscriber sub) {
        if(sub == null || this.subscribers == null || !this.subscribers.contains(sub))
            return;
        this.subscribers.remove(sub);
    }

    @Override
    public void notify(Object notification) {
        if(notification == null || this.subscribers == null || this.subscribers.isEmpty())
            return;

        for(Subscriber listener : subscribers){
            listener.update(notification);
        }
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public void setCommandManager(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

}
