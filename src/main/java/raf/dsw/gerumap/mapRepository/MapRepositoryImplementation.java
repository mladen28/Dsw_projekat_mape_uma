package raf.dsw.gerumap.mapRepository;

import raf.dsw.gerumap.Observer.Subscriber;
import raf.dsw.gerumap.core.MapRepository;
import raf.dsw.gerumap.mapRepository.commands.CommandManager;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.composite.MapNodeComposite;
import raf.dsw.gerumap.mapRepository.implementation.Element;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;

public class MapRepositoryImplementation implements MapRepository {

    private ProjectExplorer projectexplorer;


    public MapRepositoryImplementation () {
        projectexplorer = new ProjectExplorer("My Project Explorer");

    }
    @Override
    public ProjectExplorer getProjectExplorer() {
        return projectexplorer;
    }

    @Override
    public void addChild(MapNodeComposite parent, MapNode child) {

    }

    @Override
    public void loadProject(Project project) {
        this.projectexplorer.addChild(project);
        project.setParent(this.projectexplorer);

        for(MapNode mindMap : project.getChildren()) {
            mindMap.setParent(project);
            ((MindMap) mindMap).setCommandManager(new CommandManager());
            MapNodeComposite mindMapComposite = (MapNodeComposite) mindMap;
            ((MindMap) mindMap).setUpLoadedMindMap();
            for(MapNode element : (mindMapComposite).getChildren()) {
                element.setParent(mindMap);
            }
        }
        project.setUpLoadedProject(project);
    }

}
