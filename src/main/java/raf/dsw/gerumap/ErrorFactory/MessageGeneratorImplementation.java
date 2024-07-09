package raf.dsw.gerumap.ErrorFactory;

import raf.dsw.gerumap.Observer.Subscriber;
import raf.dsw.gerumap.core.MessageGenerator;

import java.util.ArrayList;
import java.util.List;
public class MessageGeneratorImplementation implements MessageGenerator
{
    List<Subscriber> subscribers;


    public static MessageGeneratorImplementation instance = null;
    public MessageGeneratorImplementation() {
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
        if (notification == null || this.subscribers == null || this.subscribers.isEmpty())
            return;

        for (Subscriber listener : subscribers) {
            listener.update(notification);
        }
    }
    public static MessageGeneratorImplementation getInstance(){
        if(instance == null){
            instance = new MessageGeneratorImplementation();
        } return instance;

    }
    @Override
    public void generateError(Errors errorType) {
        Error error = null;
        if (errorType == Errors.nodeLeaf) {
            //error = new Error(Errors.nodeLeaf, "Ne možeš dodati dete elementu!");
            notify(new Error(Errors.nodeLeaf, "Ne možeš dodati dete elementu!"));
        } else if (errorType == Errors.nullSelected) {
            //error = new Error(Errors.nullSelected, "Moraš selektovati nešto");
            notify(new Error(Errors.nullSelected, "Moraš selektovati nešto"));
        } else if (errorType == Errors.nodeProjectExplorer) {
            error = new Error(Errors.nodeProjectExplorer, "Ne možeš izbrisati project explorer!");
            notify(new Error(Errors.nodeProjectExplorer, "Ne možeš izbrisati project explorer!"));
        } else if (errorType == Errors.nullProjectSelected) {
            //error = new Error(Errors.nullProjectSelected, "Moraš selektovati projekat");
            notify(new Error(Errors.nullProjectSelected, "Moraš selektovati projekat"));
        } else if (errorType == Errors.threeClickProjectExplorer) {
            //error = new Error(Errors.threeClickProjectExplorer, "Ne možeš preimenovati project explorer");
            notify(new Error(Errors.threeClickProjectExplorer, "Ne možeš preimenovati project explorer"));
        } else if (errorType == Errors.noExistingProject) {
           //error = new Error(Errors.noExistingProject, "Ne postoji ovaj projekat");
            notify(new Error(Errors.noExistingProject, "Ne postoji ovaj projekat"));
        } else if (errorType == Errors.nullUrl) {
            //error = new Error(Errors.nullUrl, "URL slike nije pronadjen");
            notify(new Error(Errors.nullUrl, "URL slike nije pronadjen"));
        } else if (errorType == Errors.noExistingMindMap) {
            //error = new Error(Errors.noExistingMindMap, "Ne postoji ova mapa uma");
            notify(new Error(Errors.noExistingMindMap, "Ne postoji ova mapa uma"));
        } else if (errorType == Errors.noExistingElement) {
            //error = new Error(Errors.noExistingElement, "Ne postoji ovaj element");
            notify(new Error(Errors.noExistingElement, "Ne postoji ovaj element"));
        } else if (errorType == Errors.noProjectExplorerSelected) {
            //error = new Error(Errors.noProjectExplorerSelected, "Morate selektovati project explorer");
            notify(new Error(Errors.noProjectExplorerSelected, "Morate selektovati project explorer"));
        } else if (errorType == Errors.noProjectSelected) {
            //error = new Error(Errors.noProjectSelected, "Morate selektovati projekat");
            notify(new Error(Errors.noProjectSelected, "Morate selektovati projekat"));
        }else if (errorType == Errors.noMindMapSelected) {
            //error = new Error(Errors.noMindMapSelected, "Morate selektovati mapu uma");
            notify(new Error(Errors.noMindMapSelected, "Morate selektovati mapu uma"));
        } else if(errorType == Errors.noTermClicked) {
            notify(new Error(Errors.noTermClicked, "Morate kliknuti na pojam"));
        }
    }

}
