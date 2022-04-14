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

        if(policko.isActivpole()) {
            pole.hrajHrac(policko);
            pole.oznacNieaktivPole();
            this.pole.tah = false;
            //pole.oznacAktivnePoli(1);
            policko = pole.najdiNajlepsiePoli(1);
            this.pole.l1.setText("Chodi : Pocitac biely");

            pole.hrajPocitac(policko);
            pole.oznacNieaktivPole();
            this.pole.tah = true;
            pole.oznacAktivnePoli(0);
            if (pole.najlepsie==null){
                if (pole.kolkoPocitac>pole.kolkoHrac||pole.kolkoPocitac+pole.kolkoHrac>= (pole.rozmer* pole.rozmer)-1){
                    this.pole.vin.setText("Vyhral : Pocitac");
                } else {
                    this.pole.vin.setText("Vyhral : Hrac");
                }
            }
            this.pole.l1.setText("Chodi : Hrac cierny");

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
