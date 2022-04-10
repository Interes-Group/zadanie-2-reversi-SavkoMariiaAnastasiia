package sk.stuba.fei.uim.oop.pocitac;

import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.okno.Pole;

public class Pocitac extends Hrac {
    public Pocitac(int x, int y, int rozmer, int riadok, int currnt, Pole pole) {
        super(x, y, rozmer, riadok, currnt, pole);
    }
    @Override
    public int getIndexHraca() {
        return 1;
    }


    @Override
    protected void vykresliKamen() {
        i="/2.png";
        kamen();
    }

    @Override
    protected void zvysPocet() {
        this.pole.kolkoPocitac++;
    }
}
