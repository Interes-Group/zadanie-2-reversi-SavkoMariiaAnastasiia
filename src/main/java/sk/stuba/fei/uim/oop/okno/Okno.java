package sk.stuba.fei.uim.oop.okno;
import sk.stuba.fei.uim.oop.adaptery.AdapterHra;
import sk.stuba.fei.uim.oop.adaptery.AdapterOkno;

import java.awt.*;
import javax.swing.*;

public class Okno extends Pole {

    private JLabel hracma;
    private JLabel pocitacma;


    public Okno(){
        final JTextField tf=new JTextField();
        tf.setBounds(50,50, 200,30);

        hracma=new JLabel("Hrac cierny ma : "+kolkoHrac);
        hracma.setForeground(new Color(236, 117, 46));
        hracma.setBounds(50,135, 120,30);

        pocitacma=new JLabel("Pocitac biely ma : "+kolkoPocitac);
        pocitacma.setForeground(new Color(236, 117, 46));
        pocitacma.setBounds(50,160, 120,30);


        l1=new JLabel("Chodi : Hrac cierny");
        l1.setForeground(new Color(236, 117, 46));
        l1.setBounds(50,100, 120,30);

        vin=new JLabel("Vyhral :");
        vin.setForeground(new Color(236, 117, 46));
        vin.setBounds(50,470, 100,30);

        this.GenPole();

        JPanel panel=new JPanel();
        panel.setBounds(40,30,200,550);
        panel.setBackground(new Color(47, 40, 39));

        JButton button=new JButton("Reset");
        button.setBounds(50,50,95,30);
        button.setBackground(new Color(236, 117, 46));

        l2=new JLabel("Rozmer:  6");
        l2.setForeground(new Color(236, 117, 46));
        l2.setBounds(50,220, 100,30);

        JLabel l3=new JLabel("2.Aby zatvorit okno stlac - esc");
        l3.setForeground(new Color(236, 117, 46));
        l3.setBounds(50,400, 170,30);

        JLabel l4=new JLabel("3.Aby restartovat hru stlac - r");
        l4.setForeground(new Color(236, 117, 46));
        l4.setBounds(50,430, 170,30);

        JLabel l5=new JLabel("1.Aby zmenit rozmer, vyber");
        l5.setForeground(new Color(236, 117, 46));
        l5.setBounds(50,350, 170,30);

        JLabel l6=new JLabel("  aky rozmer a stlac Reset");
        l6.setForeground(new Color(236, 117, 46));
        l6.setBounds(50,370, 170,30);

        JLabel l7=new JLabel("//////////////////////////////"+
                "/////////////////////////");
        l7.setForeground(new Color(236, 117, 46));
        l7.setBounds(50,530, 200,30);

        ButtonGroup bg=new ButtonGroup();
        int y=250;
        for (int i=0;i<4;i++){
            int k = (6+(2*i));
            JRadioButton r1=new JRadioButton("rozmer "+k);
            r1.setBounds(50,y,100,20);
            r1.setForeground(new Color(236, 117, 46));
            r1.setBackground(new Color(47, 40, 39));
            r1.setActionCommand(k + "");
            frame.add(r1);
            y+=20;
            bg.add(r1);
            r1.addActionListener(new AdapterOkno(this));
        }

        button.addActionListener(new AdapterHra(getPoli(),this));

        frame.getContentPane().setBackground(new Color(30, 30, 30));
        frame.add(l1);
        frame.add(hracma);
        frame.add(pocitacma);
        frame.add(l2);
        frame.add(l3);
        frame.add(l4);
        frame.add(l5);
        frame.add(l6);
        frame.add(l7);
        frame.add(button);
        frame.add(vin);
        frame.add(panel);
        frame.setBounds(400,50,850,650);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void zmenPocetHrac(int pocet) {
        super.zmenPocetHrac(pocet);
        this.hracma.setText("Hrac cierny ma : "+kolkoHrac);
    }
    @Override
    public void zmenPocetPocitac(int pocet1) {
        super.zmenPocetPocitac(pocet1);
        this.pocitacma.setText("Pocitac biely ma : "+kolkoPocitac);
    }

}

