package raf.dsw.gerumap.state;

import raf.dsw.gerumap.core.ApplicationFramework;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.gui.swing.view.rightView.LinkPainter;
import raf.dsw.gerumap.gui.swing.view.rightView.MindMapView;
import raf.dsw.gerumap.gui.swing.view.rightView.TermPainter;
import raf.dsw.gerumap.mapRepository.commands.implementation.AddTermCommand;
import raf.dsw.gerumap.mapRepository.commands.implementation.DeleteCommand;


public class DeleteState extends State {

    @Override
    public void misKliknut(MindMapView mindMapView, int x, int y) {
        for (TermPainter termPainter : mindMapView.getTermPainterList()) {
            for (LinkPainter linkPainter : mindMapView.getLinkPainterList()) {
                if (termPainter.elementAt(x, y)) {
                    if (termPainter.getTerm().equals(linkPainter.getLink().getPocetak())
                            || termPainter.getTerm().equals(linkPainter.getLink().getKraj())) {
                        mindMapView.getLinkPainterList().remove(linkPainter);
                    }
                }
                break;
            }
            if (termPainter.elementAt(x, y)) {
                MainFrame.getInstance().getProjectView().getMindMapCurrent().getCommandManager().addCommand(new DeleteCommand(termPainter.getTerm(), mindMapView.getMindMap()));
                break;
            }
        }

        for (LinkPainter linkPainter: mindMapView.getLinkPainterList()){
            if(linkPainter.elementAt(x,y)){
                    MainFrame.getInstance().getProjectView().getMindMapCurrent().getCommandManager().addCommand(new DeleteCommand(linkPainter.getLink(), mindMapView.getMindMap()));
                    break;
            }
        }

    }

    @Override
    public void misPovucen(MindMapView mindMapView,int x, int y) {

    }
}
