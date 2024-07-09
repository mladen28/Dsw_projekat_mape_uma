package raf.dsw.gerumap.mapRepository.implementation;

import raf.dsw.gerumap.mapRepository.composite.MapNode;


public class Term extends Element{

    private int OGX;
    private int OGY;
    private int MoveX;
    private int MoveY;
    private int x;
    private int y;
    private int w;
    private int h;
    private int color;
    private int unSelectedColor;
    private int stroke;


    public Term(int x, int y, int w, int h,int boja, int stroke, String name, MapNode parent) {
        super(name,parent);
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        unSelectedColor = color;
        this.color = boja;
        this.stroke = stroke;
    }

    public Term(String name, MapNode parent) {
        super(name, parent);
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

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getUnSelectedColor() {
        return unSelectedColor;
    }

    public void setUnSelectedColor(int unSelectedColor) {
        this.unSelectedColor = unSelectedColor;
    }

    public int getStroke() {
        return stroke;
    }

    public void setStroke(int stroke) {
        this.stroke = stroke;
    }

    public int getOGX() {
        return OGX;
    }

    public void setOGX(int OGX) {
        this.OGX = OGX;
    }

    public int getOGY() {
        return OGY;
    }

    public void setOGY(int OGY) {
        this.OGY = OGY;
    }

    public int getMoveX() {
        return MoveX;
    }

    public void setMoveX(int moveX) {
        MoveX = moveX;
    }

    public int getMoveY() {
        return MoveY;
    }

    public void setMoveY(int moveY) {
        MoveY = moveY;
    }
}
