package raf.dsw.gerumap.mapRepository.implementation;

import raf.dsw.gerumap.Observer.Publisher;
import raf.dsw.gerumap.Observer.Subscriber;
import raf.dsw.gerumap.mapRepository.composite.MapNode;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;


public class Element extends MapNode implements Publisher{


    transient List<Subscriber> subscribers;

    public Element(String name, MapNode parent) {

        super(name, parent);
        type = "Element";
    }

   public Element() {

   }
    @Override
    public void addSubscriber(Subscriber sub) {
        if(sub == null)
            return;
        if(this.subscribers ==null)
            this.subscribers = new ArrayList<>();
        if(this.subscribers.contains(sub))
            return;
        this.subscribers.add(sub);
    }

    @Override
    public void removeSubscriber(Subscriber sub) {
        if(sub == null || this.subscribers == null || !this.subscribers.contains(sub))
            return;
        this.subscribers.remove(sub);
    }

    @Override
    public void notify(Object notification) {
        if(notification == null || this.subscribers == null || this.subscribers.isEmpty())
            return;

        for(Subscriber listener : subscribers){
            listener.update(notification);
        }
    }

}

