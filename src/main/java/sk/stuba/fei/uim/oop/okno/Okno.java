package sk.stuba.fei.uim.oop.okno;
import sk.stuba.fei.uim.oop.hrac.Hrac;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Okno extends Pole {

    public Okno(){
        final JTextField tf=new JTextField();
        tf.setBounds(50,50, 200,30);
        this.GenPole();

        JPanel panel=new JPanel();
        panel.setBounds(40,30,200,550);
        panel.setBackground(new Color(47, 40, 39));

        JButton button=new JButton("Reset");
        button.setBounds(50,50,95,30);
        button.setBackground(new Color(236, 117, 46));

        JLabel l1=new JLabel("Chodi :");
        l1.setForeground(new Color(236, 117, 46));
        l1.setBounds(50,100, 100,30);

        JLabel hracma=new JLabel("Hrac ma : "+kolkoHrac);
        hracma.setForeground(new Color(236, 117, 46));
        hracma.setBounds(50,135, 100,30);

        JLabel pocitacma=new JLabel("Pocitac ma : "+kolkoPocitac);
        pocitacma.setForeground(new Color(236, 117, 46));
        pocitacma.setBounds(50,160, 100,30);

        JLabel l2=new JLabel("Rozmer:  6");
        l2.setForeground(new Color(236, 117, 46));
        l2.setBounds(50,220, 100,30);

        ButtonGroup bg=new ButtonGroup();
        int y=250;
        for (int i=0;i<4;i++){
            int k = (6+(2*i));
            JRadioButton r1=new JRadioButton("rozmer "+k);
            r1.setBounds(50,y,100,20);
            r1.setForeground(new Color(236, 117, 46));
            r1.setBackground(new Color(47, 40, 39));
            frame.add(r1);
            y+=20;
            bg.add(r1);
            r1.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) {
                rozmer = k;
                setRozmer(rozmer);
            }
        });
        }

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                l2.setText("Rozmer:  " + rozmer);
                Okno.this.GenPole();
            }
        });

        JLabel vin=new JLabel("Vyhral :");
        vin.setForeground(new Color(236, 117, 46));
        vin.setBounds(50,400, 100,30);


        frame.getContentPane().setBackground(new Color(30, 30, 30));
        frame.add(l1);
        frame.add(hracma);
        frame.add(pocitacma);
        frame.add(l2);
        frame.add(button);
        frame.add(vin);
        frame.add(panel);
        frame.setBounds(400,50,850,650);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}

