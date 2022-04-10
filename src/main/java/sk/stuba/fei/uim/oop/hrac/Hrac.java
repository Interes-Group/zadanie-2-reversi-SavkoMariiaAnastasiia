package sk.stuba.fei.uim.oop.hrac;

import sk.stuba.fei.uim.oop.okno.Kamne;
import sk.stuba.fei.uim.oop.okno.Pole;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Hrac extends Kamne implements ActionListener, MouseListener {
    public int x, y;

    protected Pole pole;

    public Hrac(int x, int y, int rozmer, int riadok, int currnt, Pole pole) {
        super();
        this.x =x;
        this.y =y;
        this.pole = pole;
        this.vykresliKamen();
        this.zvysPocet();
        this.addMouseListener(this);
    }

    @Override
    public int getIndexHraca() {
        return 0;
    }

    protected void vykresliKamen() {
        i="/imgo.png";
        kamen();
    }

    protected void zvysPocet() {
        this.pole.kolkoHrac++;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getLocationOnScreen()+""+x+"."+y);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
