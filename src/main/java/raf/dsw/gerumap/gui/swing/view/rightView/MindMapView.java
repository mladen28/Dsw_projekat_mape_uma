package raf.dsw.gerumap.gui.swing.view.rightView;

import raf.dsw.gerumap.ErrorFactory.Errors;
import raf.dsw.gerumap.ErrorFactory.MessageGeneratorImplementation;
import raf.dsw.gerumap.Observer.Subscriber;
import raf.dsw.gerumap.gui.swing.controller.MouseController;
import raf.dsw.gerumap.gui.swing.view.ElementToolBar;
import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.implementation.Link;
import raf.dsw.gerumap.mapRepository.implementation.MindMap;
import raf.dsw.gerumap.mapRepository.implementation.Project;
import raf.dsw.gerumap.mapRepository.implementation.Term;
import raf.dsw.gerumap.state.StateManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class MindMapView extends JPanel implements Subscriber, MouseWheelListener{

    private MindMap mindMap;
    private String pozadina;
    private TermPainter termPainter;
    private LinkPainter linkPainter;
    private List<TermPainter> termPainterList = new ArrayList<>();
    private List<LinkPainter> linkPainterList= new ArrayList<>();
    private double zoomFactor = 1;
    private double prevZoomFactor = 1;
    private boolean zoomer;
    private boolean dragger;
    private boolean released;
    private double xOffset = 0;
    private double yOffset = 0;
    private int xDiff;
    private int yDiff;

    public MindMapView(MindMap mindMap) {

        this.mindMap = mindMap;
        this.mindMap.addSubscriber(this);

        this.addMouseListener(new MouseController());
        this.addMouseMotionListener(new MouseController());
        addMouseWheelListener(this);

        this.setBackground(Color.WHITE);
    }

    private void renameMindMapView(String ime) {
        Project p = (Project) this.mindMap.getParent();

        for(ProjectView projectView : ProjectView.projectViews){
            if(projectView.getProject().getName().equals(p.getName())){
                projectView.getTabbedPane().setTitleAt(projectView.getMindMapViews().indexOf(this), ime);
            }
        }
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if (zoomer) {
            AffineTransform at = new AffineTransform();

            double xRel = MouseInfo.getPointerInfo().getLocation().getX() - getLocationOnScreen().getX();
            double yRel = MouseInfo.getPointerInfo().getLocation().getY() - getLocationOnScreen().getY();

            double zoomDiv = zoomFactor / prevZoomFactor;

            xOffset = (zoomDiv) * (xOffset) + (1 - zoomDiv) * xRel;
            yOffset = (zoomDiv) * (yOffset) + (1 - zoomDiv) * yRel;

            at.translate(xOffset, yOffset);
            at.scale(zoomFactor, zoomFactor);
            prevZoomFactor = zoomFactor;
            g2.transform(at);
            zoomer = false;
        } if (dragger) {
            AffineTransform at = new AffineTransform();
            at.translate(xOffset + xDiff, yOffset + yDiff);
            at.scale(zoomFactor, zoomFactor);
            g2.transform(at);

            if (released) {
                xOffset += xDiff;
                yOffset += yDiff;
                dragger = false;
            }

        }

        for (TermPainter termPainter: termPainterList) {
             termPainter.paint(g2);
            }
        for(LinkPainter linkPainter: linkPainterList){
            linkPainter.paint(g2);
        }
    }

    @Override
    public void update(Object notification) {

        if (notification instanceof String) {
            String message = (String) notification;

            if (message.contains("rename")) {
                System.out.println("ime promenjeno u " + message.split(" ")[1]);

                String[] splitMessage = message.split(" ");
                String name = "";
                for (int i = 1; i < splitMessage.length; i++) {
                    name += splitMessage[i];
                    name += " ";
                    System.out.println(name);
                }
                renameMindMapView(name);
            }
        }

            if (notification instanceof Term) {

                Term term = (Term) notification;
                boolean add = true;
                for (TermPainter termPainter : termPainterList) {
                    if (termPainter.getTerm().equals(term)) {
                        termPainterList.remove(termPainter);
                        add = false;
                        break;
                    }
                }

                if (add) {
                    termPainterList.add(new TermPainter(term));
                    System.out.println(termPainterList.size());
                    System.out.println("DODAO SAM TERM");
                }

            }

            if (notification instanceof Link) {
                Link link = (Link) notification;
                boolean add = true;
                for (LinkPainter linkPainter : linkPainterList) {
                    if (linkPainter.getLink().equals(link)) {
                        linkPainterList.remove(linkPainter);
                        add = false;
                        break;
                    }
                }
                if (add) {
                    linkPainterList.add(new LinkPainter(link));
                    System.out.println(linkPainterList.size());
                    System.out.println("DODAO SAM VEZU");
                }
            }

            repaint();
            validate();
            updateUI();

    }

    public MindMap getMindMap() {
        return mindMap;
    }

    public void setMindMap(MindMap mindMap) {
        this.mindMap = mindMap;
    }

    public String getPozadina() {
        return pozadina;
    }

    public void setPozadina(String pozadina) {
        this.pozadina = pozadina;
    }

    public TermPainter getTermPainter() {
        return termPainter;
    }

    public void setTermPainter(TermPainter termPainter) {
        this.termPainter = termPainter;
    }

    public List<TermPainter> getTermPainterList() {
        return termPainterList;
    }

    public void setTermPainterList(List<TermPainter> termPainterList) {
        this.termPainterList = termPainterList;
    }

    public List<LinkPainter> getLinkPainterList() {
        return linkPainterList;
    }

    public void setLinkPainterList(List<LinkPainter> linkPainterList) {
        this.linkPainterList = linkPainterList;
    }

    public LinkPainter getLinkPainter() {
        return linkPainter;
    }

    public void setLinkPainter(LinkPainter linkPainter) {
        this.linkPainter = linkPainter;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        zoomer = true;
        if (e.getWheelRotation() < 0) {
            zoomFactor *= 1.1;
            repaint();
        }
        if (e.getWheelRotation() > 0) {
            zoomFactor /= 1.1;
            repaint();
        }
    }

    public double getZoomFactor() {
        return zoomFactor;
    }

    public void setZoomFactor(double zoomFactor) {
        this.zoomFactor = zoomFactor;
    }

    public double getPrevZoomFactor() {
        return prevZoomFactor;
    }

    public void setPrevZoomFactor(double prevZoomFactor) {
        this.prevZoomFactor = prevZoomFactor;
    }

    public boolean isZoomer() {
        return zoomer;
    }

    public void setZoomer(boolean zoomer) {
        this.zoomer = zoomer;
    }

    public boolean isDragger() {
        return dragger;
    }

    public void setDragger(boolean dragger) {
        this.dragger = dragger;
    }

    public boolean isReleased() {
        return released;
    }

    public void setReleased(boolean released) {
        this.released = released;
    }

    public double getxOffset() {
        return xOffset;
    }

    public void setxOffset(double xOffset) {
        this.xOffset = xOffset;
    }

    public double getyOffset() {
        return yOffset;
    }

    public void setyOffset(double yOffset) {
        this.yOffset = yOffset;
    }

    public int getxDiff() {
        return xDiff;
    }

    public void setxDiff(int xDiff) {
        this.xDiff = xDiff;
    }

    public int getyDiff() {
        return yDiff;
    }

    public void setyDiff(int yDiff) {
        this.yDiff = yDiff;
    }

}
