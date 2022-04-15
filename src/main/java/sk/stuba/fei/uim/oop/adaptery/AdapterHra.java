package sk.stuba.fei.uim.oop.adaptery;

import sk.stuba.fei.uim.oop.okno.Kamne;
import sk.stuba.fei.uim.oop.okno.Okno;
import sk.stuba.fei.uim.oop.okno.Pole;

import java.awt.event.*;

public class AdapterHra implements ActionListener, MouseListener, KeyListener {

    private Kamne policko;
    private Pole pole;

    public AdapterHra(Kamne poli, Pole pole) {
        this.policko = poli;
        this.pole = pole;
    }
    public AdapterHra() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        pole.l2.setText("Rozmer:  " + pole.rozmer);
        pole.kolkoHrac=0;
        pole.kolkoPocitac=0;
        pole.vin.setText("Vyhral : ");
        pole.GenPole();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getLocationOnScreen()+""+policko.x+"."+policko.y);

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
            //TODO: restart
            System.out.println("R");
            pole.l2.setText("Rozmer:  " + pole.rozmer);
            pole.kolkoHrac=0;
            pole.kolkoPocitac=0;
            pole.vin.setText("Vyhral : ");
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
