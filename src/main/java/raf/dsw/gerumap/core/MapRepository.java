package raf.dsw.gerumap.core;

import raf.dsw.gerumap.Observer.Publisher;
import raf.dsw.gerumap.mapRepository.commands.CommandManager;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.composite.MapNodeComposite;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.implementation.ProjectExplorer;

public interface MapRepository {

    ProjectExplorer getProjectExplorer();
    void addChild(MapNodeComposite parent, MapNode child);
    void loadProject(Project project);
}
