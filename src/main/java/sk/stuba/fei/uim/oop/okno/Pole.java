package sk.stuba.fei.uim.oop.okno;
import sk.stuba.fei.uim.oop.hra.Hra;

import java.awt.*;
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
    ArrayList<JPanel> pole = new ArrayList<>();
    public Pole(){
    }
    public void GenPole(){
        int currnt=stlbec;
        for (int i=0;i<rozmer;i++){
            currnt=currnt+37;
            riadok = 50;
            for (int j=0;j<rozmer;j++){
                JPanel poli=new JPanel();
                poli.setBounds(currnt,riadok,35,35);
                poli.setBackground(new Color(236, 117, 46));
                riadok=riadok+37;
                frame.add(poli);
                pole.add(poli);
            }
            frame.repaint();
        }
//        for ( int i=0;i<pole.toArray().length;i++){
//            System.out.println(pole);
//        }
    }
}
