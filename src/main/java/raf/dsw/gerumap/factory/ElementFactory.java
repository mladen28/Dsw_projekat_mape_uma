package raf.dsw.gerumap.factory;

import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;

public class ElementFactory extends NodeFactory
{
    @Override
    public MapNode createNode(MapNode node)
    {
        if(node instanceof MindMap)
            return new Element("Element", node.getParent());
        return node;
    }
}
