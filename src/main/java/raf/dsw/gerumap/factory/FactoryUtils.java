package raf.dsw.gerumap.factory;

import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;

public class FactoryUtils
{
    private static ProjectFactory projF = new ProjectFactory();
    private static MindMapFactory mindmapF = new MindMapFactory();
    private static ElementFactory elementF = new ElementFactory();


    public static NodeFactory returnNodeFactory(MapNode node) {
        if (node instanceof ProjectExplorer) {
            return projF;
        }else if (node instanceof Project){
            return mindmapF;
        }else if(node instanceof MindMap) {
            return elementF;
        }else
            return null;
    }
}
