package raf.dsw.gerumap.mapRepository.implementation;

import raf.dsw.gerumap.Observer.Publisher;
import raf.dsw.gerumap.Observer.Subscriber;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.composite.MapNode;
import raf.dsw.gerumap.mapRepository.composite.MapNodeComposite;

import javax.swing.*;

public class ProjectExplorer extends MapNodeComposite {


    public ProjectExplorer(String name) {
        super(name, null);
        type = "ProjectExplorer";
    }

    @Override
    public void addChild(MapNode child) {
        if(child instanceof Project) {
            this.getChildren().add(child);
            //child.setParent(this);
        }
        else {
            return;
        }
    }

    @Override
    public void deleteChild(MapNode child) {
        if (child instanceof Project) {
            this.getChildren().remove(child);
        }
    }

    @Override
    public void addSubscriber(Subscriber sub) {

    }

    @Override
    public void removeSubscriber(Subscriber sub) {

    }

    @Override
    public void notify(Object notification) {

    }
}
