package raf.dsw.gerumap.mapRepository.composite;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class MapNodeComposite extends MapNode {

    List<MapNode> children ;

    public MapNodeComposite(String name, MapNode parent)
    {
        super(name, parent);
        this.children = new ArrayList<>();
    }


    public MapNodeComposite(String name, MapNode parent, List<MapNode> children) {
        super(name, parent);
        this.children = children;
    }


    public abstract void addChild(MapNode child);

    public abstract void deleteChild(MapNode child);

    public List<MapNode> getChildren() {
        return children;
    }

    public void setChildren(List<MapNode> children) {
        this.children = children;
    }
}
