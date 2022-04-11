package sk.stuba.fei.uim.oop.okno;
import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.pocitac.Pocitac;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Pole {
    public void setRozmer(int rozmer) {
        this.rozmer = rozmer;
    }
    JFrame frame=new JFrame("Reverse");
    public int rozmer = 6;
    private int stlbec = 250;
    private int riadok = 50;
    public int y, x;
    public int kolkoHrac=0;
    public int kolkoPocitac=0;

    Kamne poli;
    JPanel pole_prehru = new JPanel();
    public Pole(){
    }
    public void GenPole(){
        int currnt=stlbec;
        this.vymazPoli();
        System.out.println(currnt + " + " + riadok );
        frame.remove(pole_prehru);
        pole_prehru.setLayout(new GridLayout(rozmer,rozmer));
        pole_prehru.setBounds(currnt, 50, 42 * rozmer, 42 * rozmer);
        for (y =0; y <rozmer; y++){
            currnt=currnt+42;
            riadok = 50;
            for (x =0; x <rozmer; x++){

                if((y ==(rozmer/2)-1 && y == x)||(y ==(rozmer/2) && y == x)) {
                    poli=new Hrac(x, y, rozmer, riadok, currnt, this);
                }  else if((y ==(rozmer/2)-1 && x == y +1)||(y ==(rozmer/2) && x == y -1)) {
                    poli=new Pocitac(x, y, rozmer, riadok, currnt, this);
                } else {
                    poli=new Kamne(x, y,this);
                }
                JLabel tpoli =new JLabel(x +"."+ y);
                poli.add(tpoli);
                pole_prehru.add(poli);
            }
            frame.repaint();
        }

        frame.add(pole_prehru);
        this.oznacAktivnePoli(0);
    }

    public void vymazPoli(){
        for(Component c : pole_prehru.getComponents()){
            pole_prehru.remove(c);
        }

    }

    private ArrayList<Hrac> najdiPoliHraca(int hrac) {

        ArrayList<Hrac> kamene = new ArrayList<>();

        for (int x = 0; x < this.rozmer; x++) {

            for (int y = 0; y < rozmer; y++) {

                Kamne poli = (Kamne) pole_prehru.getComponent(x + y * rozmer);

                if(poli.getIndexHraca() == hrac) {

                   kamene.add((Hrac) poli);

                }

            }

        }

        return kamene;

    }

    private ArrayList<Kamne> najdiAktivnePoli(ArrayList<Hrac> kamene, int protivnik) {

        ArrayList<Kamne> aktivneKamene = new ArrayList<>();

        for(Hrac kamen : kamene) {

            int x = kamen.x;
            int y = kamen.y;

            int xmin = x - 1;
            int xmax = x + 2;
            int ymin = y - 1;
            int ymax = y + 2;

            for (int x1 = xmin; x1 < xmax; x1++) {
                for (int y1 = ymin; y1 < ymax; y1++) {

                    if(x1 == x && y1 == y) {
                        continue;
                    }

                    Kamne pkamen = (Kamne) pole_prehru.getComponent(x1 + y1 * rozmer);

                    if(pkamen.getIndexHraca() == protivnik) {

                        pkamen = this.najdiDalsiePoli(pkamen, x1 - x, y1 - y);

                        if(pkamen != null) {
                            aktivneKamene.add(pkamen);
                        }

                    }

                }
            }

        }

        return aktivneKamene;

    }

    public Kamne najdiDalsiePoli(Kamne zaciatok, int x1, int y1) {

        Hrac hkamen = (Hrac) zaciatok;

        int x = hkamen.x;
        int y = hkamen.y;

        int x2 = x + x1;
        int y2 = y + y1;

        Kamne kamen = (Kamne) pole_prehru.getComponent(x2 + y2 * rozmer);

        if(kamen.getIndexHraca() == -1) {
            return kamen;
        }

        if(kamen.getIndexHraca() != zaciatok.getIndexHraca()) {
            return null;
        }

        return this.najdiDalsiePoli(kamen, x2 - x, y2 - y);

    }

    public void oznacAktivnePoli(int hrac) {

        ArrayList<Hrac> kamene = najdiPoliHraca(hrac);

        ArrayList<Kamne> poli = this.najdiAktivnePoli(kamene, 1 - hrac);

        for(Kamne kamen : poli) {//vsetke pohibove policka
            kamen.setActivpole(true);
        }
    }
    public void oznacNieaktivPole(){
        for (int x = 0; x < this.rozmer; x++) {
            for (int y = 0; y < rozmer; y++) {
                Kamne poli = (Kamne) pole_prehru.getComponent(x + y * rozmer);
                poli.setActivpole(false);

            }

        }
    }
}

