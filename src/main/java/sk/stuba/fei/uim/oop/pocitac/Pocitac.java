package sk.stuba.fei.uim.oop.pocitac;

import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.okno.Pole;

public class Pocitac extends Hrac {
    public Pocitac(int x, int y, Pole pole) {
        super(x, y, pole);
        this.pole = pole;
        this.vykresliKamen();
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
    public void zvysPocet() {
        this.pole.zmenPocetPocitac(1);
    }

    @Override
    protected void znizPocet() {
        this.pole.zmenPocetPocitac(-1);
    }

    @Override
    public void zvysPocetHrac() {
        return;
    }

    @Override
    public void zvysPocetPocitac() {
        this.zvysPocet();
    }

    @Override
    public void znizPocetHrac() {
        return;
    }

    @Override
    public void znizPocetPocitac() {
        this.znizPocet();
    }
}
