package raf.dsw.gerumap.mapRepository.composite;

import raf.dsw.gerumap.Observer.Publisher;
import raf.dsw.gerumap.Observer.Subscriber;

import java.util.ArrayList;
import java.util.List;

public abstract class MapNode implements Publisher{

    private String name;
    private transient MapNode parent;
    protected String type;

    public MapNode(String name, MapNode parent) {
        this.name = name;
        this.parent = parent;
    }

    protected MapNode() {

    }

    public void rename(String ime){}

    public void setName(String name) {
        this.name = name;
        notify("rename " + this.getName());
    }

    public String getName() {
        return name;
    }

    public MapNode getParent() {
        return parent;
    }

    public void setParent(MapNode parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return name ;
    }

}
