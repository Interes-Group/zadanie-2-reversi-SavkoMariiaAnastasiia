package sk.stuba.fei.uim.oop.okno;
import sk.stuba.fei.uim.oop.hra.Hra;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;

public class Pole extends Hra {
    public void setRozmer(int rozmer) {
        this.rozmer = rozmer;
    }
    JFrame frame=new JFrame("Reverse");
    public int rozmer = 6;
    public int stlbec = 250;
    public int riadok = 50;
    public Pole(){
    }
    public void GenPole(){
        int currnt=stlbec;
        JPanel pole_prehru = new JPanel();
        pole_prehru.setLayout(new GridLayout(rozmer,rozmer));
        for (int i=0;i<rozmer;i++){
            currnt=currnt+37;
            riadok = 50;
            for (int j=0;j<rozmer;j++){
                JPanel poli=new JPanel();
                poli.setBounds(currnt,riadok,35,35);
                poli.setBackground(new Color(236, 117, 46));
                riadok=riadok+37;
                pole_prehru.add(poli);
                frame.add(poli);
            }
            frame.repaint();
        }
//        for ( int i=0;i<pole.toArray().length;i++){
//            System.out.println(pole);
//        }
    }
}
