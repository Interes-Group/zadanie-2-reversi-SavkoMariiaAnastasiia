package sk.stuba.fei.uim.oop.okno;
import sk.stuba.fei.uim.oop.hra.Hra;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Pole extends Hra implements ActionListener, MouseListener {
    public void setRozmer(int rozmer) {
        this.rozmer = rozmer;
    }
    JFrame frame=new JFrame("Reverse");
    public int rozmer = 6;
    public int stlbec = 250;
    public int riadok = 50;
    public int x;
    public int y;
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
        for ( x=0;x<rozmer;x++){
            currnt=currnt+42;
            riadok = 50;
            for (y=0;y<rozmer;y++){
                poli=new Kamne(x, y, rozmer, riadok, currnt);
                //JLabel tpoli =new JLabel(x+"."+y);
                poli.addMouseListener(this);

                pole_prehru.add(poli);
            }
            frame.repaint();
        }

        frame.add(pole_prehru);
//        for ( int i=0;i<pole.toArray().length;i++){
//            System.out.println(pole);
//        }
    }

    public void vymazPoli(){
        for(Component c : pole_prehru.getComponents()){
            pole_prehru.remove(c);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getLocationOnScreen()+""+x+"."+y);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
