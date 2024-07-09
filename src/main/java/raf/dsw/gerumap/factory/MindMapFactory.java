package raf.dsw.gerumap.factory;

import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;

public class MindMapFactory extends NodeFactory
{

    @Override
    public MapNode createNode(MapNode node)
    {
       if(node instanceof Project)
            return new MindMap("MindMap", node.getParent());
       return node;
    }
}
