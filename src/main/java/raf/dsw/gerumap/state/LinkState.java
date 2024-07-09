package raf.dsw.gerumap.state;

import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.rightView.MindMapView;
import raf.dsw.gerumap.gui.swing.view.rightView.TermPainter;
import raf.dsw.gerumap.mapRepository.commands.implementation.AddLinkCommand;
import raf.dsw.gerumap.mapRepository.commands.implementation.AddTermCommand;
import raf.dsw.gerumap.mapRepository.implementation.Link;
import java.awt.*;


public class LinkState extends State {


    Link link;

    @Override
    public void misKliknut(MindMapView mindMapView, int x, int y) {

        link = new Link("", mindMapView.getMindMap());

        for (TermPainter termPainter : mindMapView.getTermPainterList()) {
            if (termPainter.elementAt(x, y)) {
                link.setStart(new Point(x, y));
                link.setPocetak(termPainter.getTerm());
                link.setEnd(new Point(x, y));
                MainFrame.getInstance().getProjectView().getMindMapCurrent().getCommandManager().addCommand(new AddLinkCommand(link));
            }
         }
    }


    @Override
    public void misPovucen(MindMapView mindMapView, int x, int y) {
        link.setEnd(new Point(x,y));
        mindMapView.repaint();
    }

    public void misPusten (MindMapView mindMapView,int x, int y) {
        boolean b = false;
        for (TermPainter termPainter : mindMapView.getTermPainterList()) {
            if (termPainter.elementAt(x, y)) {
                link.setEnd(new Point(x, y));
                link.setKraj(termPainter.getTerm());
                b = true;
            }
        }
        if (b == false){
            MainFrame.getInstance().getProjectView().getMindMapCurrent().getCommandManager().addCommand(new AddLinkCommand(link));
        }
    }
}


