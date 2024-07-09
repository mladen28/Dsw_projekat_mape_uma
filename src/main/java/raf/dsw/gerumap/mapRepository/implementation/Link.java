package raf.dsw.gerumap.mapRepository.implementation;

import raf.dsw.gerumap.mapRepository.composite.MapNode;

import java.awt.*;


public class Link extends Element{

    private Term pocetak;
    private Term kraj;
    private int x;
    private int y;
    private Point start;
    private Point end;



    public Link(String name, MapNode parent) {

        super(name, parent);
    }

    public Term getPocetak() {
        return pocetak;
    }

    public void setPocetak(Term pocetak) {
        this.pocetak = pocetak;
    }

    public Term getKraj() {
        return kraj;
    }

    public void setKraj(Term kraj) {
        this.kraj = kraj;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }


}
