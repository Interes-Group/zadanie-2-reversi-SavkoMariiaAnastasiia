package sk.stuba.fei.uim.oop.hrac;

import sk.stuba.fei.uim.oop.okno.Kamne;

public class Hrac extends Kamne {
    int kolkoHrac=0;

    public Hrac(int x, int y, int rozmer, int riadok, int currnt) {
        super();
        if((x==(rozmer/2)-1 && x==y)||(x==(rozmer/2) && x==y)){
            i="/imgo.png";
            kamen();
            this.kolkoHrac=kolkoHrac++;
        }
    }
}
