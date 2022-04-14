package sk.stuba.fei.uim.oop.okno;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Kamne extends JPanel {

    public String i;

    public int x, y;
    public boolean activpole=false;

    public Kamne zpolicka;
    public int pocetKamenov;

    public Kamne (int x, int y,Pole pole) {

        this.x = x;
        this.y = y;
        this.zpolicka = null;
        this.pocetKamenov = 0;
        this.addMouseListener(new Adapter(this,pole));
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
