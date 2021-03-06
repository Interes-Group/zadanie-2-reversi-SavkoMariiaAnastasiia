package sk.stuba.fei.uim.oop.hrac;

import sk.stuba.fei.uim.oop.okno.Kamne;
import sk.stuba.fei.uim.oop.okno.Pole;


public class Hrac extends Kamne {
    protected Pole pole;
    public Hrac(int x, int y, Pole pole) {
        super(x, y,pole);
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
        this.pole.zmenPocetHrac(1);
    }

    protected void znizPocet() {
        this.pole.zmenPocetHrac(-1);
    }

    public void zvysPocetHrac() {
        this.zvysPocet();
    }

    public void zvysPocetPocitac() {
        return;
    }

    public void znizPocetHrac() {
        this.znizPocet();
    }

    public void znizPocetPocitac() {
        return;
    }
}
