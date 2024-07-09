package raf.dsw.gerumap.factory;

import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;

public class ProjectFactory extends NodeFactory
{
    @Override
    public MapNode createNode(MapNode node) {
       if(node instanceof ProjectExplorer)
            return new Project("Project", node.getParent());
        return node;
    }
}
