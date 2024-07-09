package raf.dsw.gerumap.gui.swing.view.rightView;

import raf.dsw.gerumap.mapRepository.implementation.Link;
import raf.dsw.gerumap.mapRepository.implementation.Term;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import static java.lang.Math.abs;

public class LinkPainter extends ElementPainter{


    private Link link;
    private Line2D line;
    private Rectangle2D rect;
    public LinkPainter(Link link){
        this.link = link;
    }

    @Override
    public void paint(Graphics2D g) {


        if(link.getPocetak() == null || link.getKraj() == null) {
            line = new Line2D.Double(link.getStart().x, link.getStart().y, link.getEnd().x, link.getEnd().y);
        }else {
            line = new Line2D.Double(link.getPocetak().getX() + 50, link.getPocetak().getY() + 25, link.getKraj().getX() + 50, link.getKraj().getY() + 25);
        }

        if (link.getStart() != null) {
            g.setColor(Color.blue);
            g.setStroke(new BasicStroke(5));
            g.draw(line);

            //g.drawLine(link.getStart().x, link.getStart().y, link.getEnd().x, link.getEnd().y);
        }
    }
    @Override
    public boolean elementAt(int X, int Y) {
        //line = new Line2D.Double(link.getStart().x, link.getStart().y, link.getEnd().x, link.getEnd().y);
       rect = new Rectangle2D.Double(X,Y,50,25);
       return line.intersects(rect);

    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public Line2D getLine() {
        return line;
    }

    public void setLine(Line2D line) {
        this.line = line;
    }
}
