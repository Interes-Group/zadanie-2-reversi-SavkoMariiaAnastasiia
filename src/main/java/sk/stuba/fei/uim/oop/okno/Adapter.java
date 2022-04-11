package sk.stuba.fei.uim.oop.okno;

import sk.stuba.fei.uim.oop.hrac.Hrac;

import java.awt.event.*;

public class Adapter implements ActionListener, MouseListener {

    private Kamne policko;
    private Pole pole;

    public Adapter(Kamne poli, Pole pole) {
        this.policko = poli;
        this.pole = pole;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getLocationOnScreen()+""+policko.x+"."+policko.y);
        if(policko.isActivpole()){
            pole.oznacNieaktivPole();
            pole.hrajHrac(policko);
        }
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
