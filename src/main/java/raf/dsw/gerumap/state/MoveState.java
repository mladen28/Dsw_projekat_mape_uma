package raf.dsw.gerumap.state;

import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.rightView.LinkPainter;
import raf.dsw.gerumap.gui.swing.view.rightView.MindMapView;
import raf.dsw.gerumap.gui.swing.view.rightView.TermPainter;
import raf.dsw.gerumap.mapRepository.commands.implementation.MoveCommand;
import raf.dsw.gerumap.mapRepository.implementation.Link;

import java.awt.*;

public class MoveState extends State{

    public boolean jeste = false;
    @Override
    public void misKliknut(MindMapView mindMapView, int x, int y) {
        if (mindMapView.getTermPainter() != null) {
            mindMapView.getTermPainter().getTerm().setOGX(x);
            mindMapView.getTermPainter().getTerm().setOGY(y);

            if (mindMapView.getTermPainter() != null) {
                if (mindMapView.getTermPainter().elementAt(x, y)) {
                    jeste = true;
                    MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedComponent().repaint();
                }
            }
        }
    }

    @Override
    public void misPovucen(MindMapView mindMapView, int x, int y) {
        if (jeste) {
            if (mindMapView.getTermPainter() != null) {
                mindMapView.getTermPainter().getTerm().setX(x);
                mindMapView.getTermPainter().getTerm().setY(y);
                MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedComponent().repaint();
            }
        }
    }

    @Override
    public void misPusten(MindMapView mindMapView, int x, int y) {
        super.misPusten(mindMapView,x,y);
        if(mindMapView.getTermPainter() != null) {
            mindMapView.getTermPainter().getTerm().setMoveX(x);
            mindMapView.getTermPainter().getTerm().setMoveY(y);
            jeste = false;
            MainFrame.getInstance().getProjectView().getMindMapCurrent().getCommandManager().addCommand(new MoveCommand(mindMapView.getMindMap(), mindMapView.getTermPainter().getTerm()));
        }
    }
}
