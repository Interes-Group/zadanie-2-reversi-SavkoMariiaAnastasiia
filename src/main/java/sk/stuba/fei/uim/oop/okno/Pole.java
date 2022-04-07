package sk.stuba.fei.uim.oop.okno;
import sk.stuba.fei.uim.oop.hra.Hra;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;

public class Pole extends Hra implements ActionListener, MouseListener {
    public void setRozmer(int rozmer) {
        this.rozmer = rozmer;
    }
    JFrame frame=new JFrame("Reverse");
    public int rozmer = 6;
    public int stlbec = 250;
    public int riadok = 50;
    private int x;
    private int y;
    public Pole(){
    }
    public void GenPole(){
        int currnt=stlbec;
        JPanel pole_prehru = new JPanel();
        pole_prehru.setLayout(new GridLayout(rozmer,rozmer));
        for ( x=0;x<rozmer;x++){
            currnt=currnt+37;
            riadok = 50;
            for (y=0;y<rozmer;y++){
                JPanel poli=new JPanel();
                JLabel tpoli =new JLabel(x+"."+y);
                poli.setBounds(currnt,riadok,35,35);
                poli.setBackground(new Color(236, 117, 46));
                riadok=riadok+37;
                poli.add(tpoli);
                tpoli.addMouseListener(this);
                pole_prehru.add(poli);
                frame.add(poli);
            }
            frame.repaint();
        }
//        for ( int i=0;i<pole.toArray().length;i++){
//            System.out.println(pole);
//        }
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
