package raf.dsw.gerumap.gui.swing.view.rightView;

import raf.dsw.gerumap.mapRepository.implementation.Term;

import java.awt.*;

public class TermPainter extends ElementPainter{

    private Term term;

    TermPainter(Term term){
        this.term = term;
    }


    @Override
    public void paint(Graphics2D g) {
        g.setColor(new Color(term.getColor()));
        g.setStroke(new BasicStroke(term.getStroke()));
        g.drawRect(term.getX(), term.getY(), term.getW(), term.getH());
        if (term instanceof Term){
            g.setPaint(Color.BLACK);
            Term t=(Term) term;

            g.drawString(term.getName(), t.getX()+5,
                    t.getY()+25);
        }
    }

    @Override
    public boolean elementAt(int X, int Y) {

        int termX = term.getX();
        int termY = term.getY();

        if((X < termX + term.getW() && X > termX) && Y < termY + term.getH() && Y > termY) return true;
        return false;
    }


    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }



}
