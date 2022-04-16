package sk.stuba.fei.uim.oop.adaptery;

import sk.stuba.fei.uim.oop.okno.Kamne;
import sk.stuba.fei.uim.oop.okno.Pole;

import java.awt.event.*;

public class AdapterHra implements ActionListener, MouseListener, KeyListener {

    private Kamne policko;
    private Pole pole;

    public AdapterHra(Kamne poli, Pole pole) {
        this.policko = poli;
        this.pole = pole;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        pole.getL2().setText("Rozmer:  " + pole.getRozmer());
        pole.setKolkoHrac(0);
        pole.setKolkoPocitac(0);
        pole.getVin().setText("Vyhral : ");
        pole.GenPole();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(policko.isActivpole()) {
            pole.hrajHrac(policko);
            pole.oznacNieaktivPole();
            pole.koloPocitac();

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
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'r') {
            pole.getL2().setText("Rozmer:  " + pole.getRozmer());
            pole.setKolkoHrac(0);
            pole.setKolkoPocitac(0);
            pole.getVin().setText("Vyhral : ");
            pole.GenPole();

        }
        if(e.getKeyCode() == 27)
        {
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
