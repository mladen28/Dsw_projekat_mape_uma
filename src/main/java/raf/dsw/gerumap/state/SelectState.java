package raf.dsw.gerumap.state;

import raf.dsw.gerumap.gui.swing.view.rightView.MindMapView;
import raf.dsw.gerumap.gui.swing.view.rightView.TermPainter;

import java.awt.*;

public class SelectState extends State{
    @Override
    public void misKliknut(MindMapView mindMapView, int x, int y) {
        for(TermPainter termPainter : mindMapView.getTermPainterList()){
            if(termPainter.elementAt(x,y)) {
                if (mindMapView.getTermPainter() == null) {
                    mindMapView.setTermPainter(termPainter);
                    termPainter.getTerm().setColor(Color.RED.getRGB());

                } else if(mindMapView.getTermPainter().equals(termPainter)){
                    TermPainter termPainter1 = mindMapView.getTermPainter();
                    termPainter1.getTerm().setColor(termPainter.getTerm().getUnSelectedColor());
                    mindMapView.setTermPainter(null);

                }else{
                    TermPainter termPainter1 = mindMapView.getTermPainter();
                    termPainter1.getTerm().setColor(termPainter1.getTerm().getUnSelectedColor());
                    mindMapView.setTermPainter(termPainter);
                    termPainter.getTerm().setColor(Color.RED.getRGB());

                }
                mindMapView.repaint();
            }
        }

    }

    @Override
    public void misPovucen(MindMapView mindMapView,int x, int y) {

    }
}
