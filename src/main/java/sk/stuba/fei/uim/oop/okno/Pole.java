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
    public int x1;
    public int y1;
    JPanel poli=new JPanel();
    public Pole(){
    }
    public void GenPole(){
        int currnt=stlbec;
        JPanel pole_prehru = new JPanel();
        pole_prehru.setLayout(new GridLayout(rozmer,rozmer));
        for ( x=0;x<rozmer;x++){
            currnt=currnt+42 ;
            riadok = 50;
            for (y=0;y<rozmer;y++){
                poli=new JPanel();
                //JLabel tpoli =new JLabel(x+"."+y);
                if((x==(rozmer/2)-1 && x==y)||(x==(rozmer/2) && x==y)){
                    BufferedImage black = null;
                    try {
                        black = ImageIO.read(Objects.requireNonNull(Pole.class.getResourceAsStream("/imgo.png")));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    JLabel picLabel = new JLabel(new ImageIcon(black));
                    poli.add(picLabel);
                }
                poli.setBounds(currnt,riadok,40,40);
                poli.setBackground(new Color(236, 117, 46));
                riadok=riadok+42;
                //poli.add(tpoli);
                poli.addMouseListener(this);
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

    public void setX(int x) {
        this.x1 = x;
    }

    public void setY(int y) {
        this.y1 = y;
    }
}
