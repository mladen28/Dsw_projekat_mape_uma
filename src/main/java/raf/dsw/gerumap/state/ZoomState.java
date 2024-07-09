package raf.dsw.gerumap.state;

import raf.dsw.gerumap.gui.swing.view.rightView.MindMapView;

import java.awt.*;
import java.awt.event.*;

public class ZoomState extends State{

    Point startPoint;

    @Override
    public void misKliknut(MindMapView mindMapView, int x, int y) {
        mindMapView.setReleased(false);
        startPoint = MouseInfo.getPointerInfo().getLocation();
    }

    @Override
    public void misPovucen(MindMapView mindMapView, int x, int y) {
        Point curPoint = new Point(x,y);
        mindMapView.setxDiff(curPoint.x - startPoint.x);
        mindMapView.setyDiff(curPoint.y - startPoint.y);

        mindMapView.setDragger(true);
        mindMapView.repaint();

    }
    public void misPusten(MindMapView mindMapView, int x, int y){
        mindMapView.setReleased(true);
        mindMapView.repaint();
    }
}
