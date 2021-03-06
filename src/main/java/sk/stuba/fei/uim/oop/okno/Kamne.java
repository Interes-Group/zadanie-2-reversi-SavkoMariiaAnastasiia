package sk.stuba.fei.uim.oop.okno;

import sk.stuba.fei.uim.oop.adaptery.AdapterHra;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Kamne extends JPanel {

    protected String i;
    protected int x, y;
    private boolean activpole=false;
    private Kamne zpolicka;
    protected int pocetKamenov;

    public Kamne getZpolicka() {
        return zpolicka;
    }

    public void setZpolicka(Kamne zpolicka) {
        this.zpolicka = zpolicka;
    }

    public Kamne (int x, int y, Pole pole) {

        this.x = x;
        this.y = y;
        this.zpolicka = null;
        this.pocetKamenov = 0;
        this.addMouseListener(new AdapterHra(this,pole));
        this.setBackground(new Color(236, 117, 46));
        this.setBorder(BorderFactory.createLineBorder(new Color(30, 30, 30)));
    }
    public void kamen(){
        BufferedImage kamne = null;
        try {
            kamne = ImageIO.read(Objects.requireNonNull(Pole.class.getResourceAsStream(i)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel picLabel = new JLabel(new ImageIcon(kamne));
        this.add(picLabel);

    }

    public void setActivpole (boolean activpole){
        this.activpole = activpole;
        if(isActivpole()){
            this.setBackground(new Color(246, 175, 128));
        }else {
            this.zpolicka = null;
            this.pocetKamenov = 0;
            this.setBackground(new Color(236, 117, 46));
        }
        this.repaint();
    }

    public boolean isActivpole() {
        return this.activpole;
    }

    public int getIndexHraca() {
        return -1;
    }
}
