package sk.stuba.fei.uim.oop.pocitac;

import sk.stuba.fei.uim.oop.hrac.Hrac;

public class Pocitac extends Hrac {
    public Pocitac(int x, int y, int rozmer, int riadok, int currnt) {
        super(x, y, rozmer, riadok, currnt);
        if((x==(rozmer/2)-1 && y==x+1)||(x==(rozmer/2) && y==x-1)){
            i="/2.png";
            kamen();
        }
    }
}
