package raf.dsw.gerumap.factory;

import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.composite.MapNodeComposite;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;

public abstract class NodeFactory {

    public MapNode getNewNode(MapNode node){

        MapNode n = createNode(node);
        n.setParent(node);
        if(node instanceof MapNodeComposite) {
            n.setName(n.getName() + " " + (((MapNodeComposite) node).getChildren().size()+1));
            ((MapNodeComposite) node).addChild(n);
            System.out.println(((MapNodeComposite) node).getChildren());
        }
        return n;
    }

    public abstract MapNode createNode(MapNode node);
}
