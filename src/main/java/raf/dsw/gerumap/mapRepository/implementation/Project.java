package raf.dsw.gerumap.mapRepository.implementation;

import raf.dsw.gerumap.Observer.Publisher;
import raf.dsw.gerumap.Observer.Subscriber;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.composite.MapNodeComposite;

import java.io.File;
import java.util.List;
import java.util.ArrayList;

public class Project extends MapNodeComposite{

    private String imeAutora;
    private String fileName;

    transient List<Subscriber> subscribers;

    private boolean changed = true;


    public Project(String name, MapNode parent) {
        super(name, parent);
        type = "Project";
    }

    public void setUpLoadedProject(Project project) {
        for(MapNode child : project.getChildren()) {
            if(child instanceof MindMap){
                notify(child);
            }
        }
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
        changed =true;
        notify("rename " + this.getName());
    }

    @Override
    public void addChild(MapNode child) {
        if(child instanceof MindMap) {
            this.getChildren().add(child);
            child.setParent(this);
            notify("add " + child.getName());
        }
        else return;
    }

    @Override
    public void deleteChild(MapNode child) {
        if (child instanceof MindMap) {
            this.getChildren().remove(child);
        }
        notify("delete " + child.getName());
    }

    @Override
    public void rename(String ime) {
        this.setName(ime);
        notify("rename " + this.getName());
    }

    public void setChanged(boolean changed){
        if(this.changed != changed){
            this.changed = changed;
        }
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getImeAutora() {
        return imeAutora;
    }

    public void setImeAutora(String imeAutora) {
        this.imeAutora = imeAutora;
        notify( "autor");
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
}
