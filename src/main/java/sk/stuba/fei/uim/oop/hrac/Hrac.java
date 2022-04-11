package sk.stuba.fei.uim.oop.hrac;

import sk.stuba.fei.uim.oop.okno.Adapter;
import sk.stuba.fei.uim.oop.okno.Kamne;
import sk.stuba.fei.uim.oop.okno.Pole;


public class Hrac extends Kamne {

    protected Pole pole;

    public Hrac(int x, int y, int rozmer, int riadok, int currnt, Pole pole) {
        super(x, y);
        this.pole = pole;
        this.vykresliKamen();
        this.zvysPocet();
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
}
