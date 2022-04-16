package sk.stuba.fei.uim.oop.okno;
import sk.stuba.fei.uim.oop.adaptery.AdapterHra;
import sk.stuba.fei.uim.oop.hrac.Hrac;
import sk.stuba.fei.uim.oop.pocitac.Pocitac;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Pole {
    protected JFrame frame=new JFrame("Reverse");
    protected int rozmer = 6;
    private int stlbec = 250,riadok = 50;
    private int y, x;
    protected int kolkoHrac=0,kolkoPocitac=0;
    private boolean tah_hrac = true,tah_pocitac = true;
    private Kamne najlepsie = null;
    private Kamne pkamen,poli;
    protected JLabel l1, l2,vin;
    private JPanel pole_prehru = new JPanel();
    private AdapterHra hra;

    public Pole(){
        frame.setFocusable(true);
    }

    public void setKolkoHrac(int kolkoHrac) {
        this.kolkoHrac = kolkoHrac;
    }

    public void setKolkoPocitac(int kolkoPocitac) {
        this.kolkoPocitac = kolkoPocitac;
    }

    public JLabel getL2() {
        return l2;
    }

    public JLabel getVin() {
        return vin;
    }

    public int getRozmer() {
        return rozmer;
    }

    public Kamne getPoli() {
        return poli;
    }

    public void setRozmer(int rozmer) {
        this.rozmer = rozmer;
        frame.setFocusable(true);
        this.frame.requestFocusInWindow();
    }
    public void GenPole(){
        int currnt=stlbec;
        this.vymazPoli();
        frame.remove(pole_prehru);
        frame.setFocusable(true);
        this.frame.requestFocusInWindow();
        pole_prehru.setLayout(new GridLayout(rozmer,rozmer));
        pole_prehru.setBounds(currnt, 50, 42 * rozmer, 42 * rozmer);
        for (y =0; y <rozmer; y++){
            currnt=currnt+42;
            riadok = 50;
            for (x =0; x <rozmer; x++){

                if((y ==(rozmer/2)-1 && y == x)||(y ==(rozmer/2) && y == x)) {
                    poli=new Hrac(x, y, this);
                }  else if((y ==(rozmer/2)-1 && x == y +1)||(y ==(rozmer/2) && x == y -1)) {
                    poli=new Pocitac(x, y, this);
                } else {
                    poli=new Kamne(x, y,this);
                }
                pole_prehru.add(poli);
            }
            frame.repaint();
        }
        hra = new AdapterHra(poli,this);
        frame.addKeyListener(hra);
        frame.add(pole_prehru);
        this.oznacAktivnePoli(0);
    }

    public void vymazPoli(){
        for(Component c : pole_prehru.getComponents()){
            pole_prehru.remove(c);
        }

    }

    public void hrajHrac(Kamne policko) {
        int x = policko.x;
        int y = policko.y;
        int n = x + y * this.rozmer;

        int x1 = policko.getZpolicka().x;
        int y1 = policko.getZpolicka().y;
        int index = x1 + y1 * this.rozmer;

        int x2 = x - x1;
        int y2 = y - y1;

        if(x2 != 0) {
            x2 = x2 / Math.abs(x2);
        }

        if(y2 != 0) {
            y2 = y2 / Math.abs(y2);
        }

        Kamne kamen = (Kamne) this.pole_prehru.getComponent(index);

        this.hracZoberPoli(kamen, x2, y2);

    }

    public void hrajPocitac(Kamne policko) {

        int x = policko.x;
        int y = policko.y;

        int x1 = policko.getZpolicka().x;
        int y1 = policko.getZpolicka().y;
        int index = x1 + y1 * this.rozmer;

        int x2 = x - x1;
        int y2 = y - y1;

        if(x2 != 0) {
            x2 = x2 / Math.abs(x2);
        }

        if(y2 != 0) {
            y2 = y2 / Math.abs(y2);
        }

        Kamne kamen = (Kamne) this.pole_prehru.getComponent(index);

        this.pocitacZoberPoli(kamen, x2, y2);


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

                    if(x1<0||x1>=rozmer||y1<0||y1>=rozmer) {
                        continue;
                    }

                    pkamen = (Kamne) pole_prehru.getComponent(x1 + y1 * rozmer);

                    if(pkamen.getIndexHraca() == protivnik) {

                        pkamen = this.najdiDalsiePoli(pkamen, x1 - x, y1 - y);

                        if(pkamen != null) {

                            int pocetKamenov = 0;

                            int x2 = pkamen.x;
                            int y2 = pkamen.y;

                            if(x2 == x) {
                                pocetKamenov = Math.abs(y - y2);
                            } else {
                                pocetKamenov = Math.abs(x - x2);
                            }

                            pocetKamenov--;

                            aktivneKamene.add(pkamen);

                            if(pkamen.getZpolicka() == null) {
                                this.pkamen.setZpolicka(kamen);
                                this.pkamen.pocetKamenov = pocetKamenov;
                                continue;
                            }

                            if(pocetKamenov <= pkamen.pocetKamenov) {
                                continue;
                            }

                            this.pkamen.setZpolicka(kamen);
                            this.pkamen.pocetKamenov = pocetKamenov;


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
        if (x2<0||x2>=rozmer||y2<0||y2>=rozmer){
            return null;
        }

        int index = x2 + y2 * rozmer;

        Kamne kamen = (Kamne) pole_prehru.getComponent(index);

        if(kamen.getIndexHraca() == -1) {
            return kamen;
        }

        if(kamen.getIndexHraca() != zaciatok.getIndexHraca()) {
            return null;
        }

        return this.najdiDalsiePoli(kamen, x2 - x, y2 - y);

    }

    public void hracZoberPoli(Kamne zaciatok, int x1, int y1) {

        int x = zaciatok.x;
        int y = zaciatok.y;

        int x2 = x + x1;
        int y2 = y + y1;

        int index = x2 + y2 * rozmer;

        Kamne kamen = (Kamne) pole_prehru.getComponent(index);

        if(kamen instanceof  Hrac) {
            Hrac p = (Hrac) kamen;
            p.znizPocetPocitac();
        }

        this.pole_prehru.remove(index);
        this.pole_prehru.add(new Hrac(x2, y2, this), index);
        this.pole_prehru.revalidate();
        this.pole_prehru.repaint();

        if(kamen.getIndexHraca() == -1) {
            return;
        }

        this.hracZoberPoli(kamen, x2 - x, y2 - y);

    }
    public void pocitacZoberPoli(Kamne zaciatok, int x1, int y1) {

        int x = zaciatok.x;
        int y = zaciatok.y;

        int x2 = x + x1;
        int y2 = y + y1;

        int n = x2 + y2 * rozmer;

        Kamne kamen = (Kamne) pole_prehru.getComponent(n);

        if(kamen instanceof Hrac) {
            Hrac h = (Hrac) kamen;
            h.znizPocetHrac();
        }

        this.pole_prehru.remove(n);
        this.pole_prehru.add(new Pocitac(x2, y2, this), n);
        this.pole_prehru.revalidate();
        this.pole_prehru.repaint();

        if(kamen.getIndexHraca() == -1) {
            return;
        }

        this.pocitacZoberPoli(kamen, x2 - x, y2 - y);

    }

    public void oznacAktivnePoli(int hrac) {

        ArrayList<Hrac> kamene = najdiPoliHraca(hrac);

        ArrayList<Kamne> poli = this.najdiAktivnePoli(kamene, 1 - hrac);

        for(Kamne kamen : poli) {
            kamen.setActivpole(true);
        }

        this.tah_hrac = poli.size() > 0;

        if(!this.tah_hrac) {

            if(!this.tah_pocitac) {
                if (kolkoPocitac>kolkoHrac){
                    this.vin.setText("Vyhral : Pocitac");
                } else {
                    this.vin.setText("Vyhral : Hrac");
                }
                return;
            }

            this.koloPocitac();
        }
    }

    public Kamne najdiNajlepsiePoli(int hrac) {

        ArrayList<Hrac> kamene = najdiPoliHraca(hrac);

        ArrayList<Kamne> poli = this.najdiAktivnePoli(kamene, 1 - hrac);

        najlepsie = null;
        int pocet = 0;

        for (int x = 0; x < rozmer; x++) {
            for (int y = 0; y < rozmer; y++) {
                int n = x + y * rozmer;
                Kamne policko = (Kamne) this.pole_prehru.getComponent(n);

                if(policko.pocetKamenov > pocet) {
                    najlepsie = policko;
                    pocet = policko.pocetKamenov;
                }
            }
        }

        this.tah_pocitac = najlepsie != null;

        return najlepsie;

    }

    public void oznacNieaktivPole(){
        for (int x = 0; x < this.rozmer; x++) {
            for (int y = 0; y < rozmer; y++) {
                Kamne poli = (Kamne) pole_prehru.getComponent(x + y * rozmer);
                poli.setActivpole(false);

            }

        }
    }

    public void koloPocitac() {

        this.l1.setText("Chodi : Pocitac biely");
        Kamne policko = this.najdiNajlepsiePoli(1);

        if(!this.tah_pocitac) {

            if(!this.tah_hrac) {
                if (kolkoPocitac>kolkoHrac){
                    this.vin.setText("Vyhral : Pocitac");
                } else {
                    this.vin.setText("Vyhral : Hrac");
                }
                return;
            }

            oznacNieaktivPole();
            this.oznacAktivnePoli(0);
            this.l1.setText("Chodi : Hrac cierny");
            return;
        }


       hrajPocitac(policko);
        oznacNieaktivPole();
        this.oznacAktivnePoli(0);
        this.l1.setText("Chodi : Hrac cierny");

    }

    public void zmenPocetHrac(int pocet) {
        this.kolkoHrac += pocet;
    }

    public void zmenPocetPocitac(int pocet) {
        this.kolkoPocitac += pocet;
    }
}

