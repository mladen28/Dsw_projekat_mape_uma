package raf.dsw.gerumap.state;

import raf.dsw.gerumap.gui.swing.view.rightView.MindMapView;
import raf.dsw.gerumap.gui.swing.view.rightView.TermPainter;

public abstract class State {

    public abstract void misKliknut(MindMapView mindMapView, int x, int y);

    public abstract void misPovucen(MindMapView mindMapView,int x, int y);

    public void misPusten(MindMapView mindMapView, int x, int y){
    }
}
