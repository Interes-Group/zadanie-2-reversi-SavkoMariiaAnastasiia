package sk.stuba.fei.uim.oop.okno;
import sk.stuba.fei.uim.oop.hra.Hra;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Okno extends Hra {
    public int rozmer = 6;
    private int stlbec = 250;
    private int riadok = 50;
    public Okno(){
        JFrame frame=new JFrame("Reverse");
        final JTextField tf=new JTextField();
        tf.setBounds(50,50, 200,30);


        for (int i=0;i<rozmer;i++){
            stlbec=stlbec+37;
            riadok = 50;
            for (int j=0;j<rozmer;j++){
                JPanel poli=new JPanel();
                poli.setBounds(stlbec,riadok,35,35);
                poli.setBackground(new Color(236, 117, 46));
                riadok=riadok+37;
                frame.add(poli);

            }

        }

        JPanel panel=new JPanel();
        panel.setBounds(40,30,200,500);
        panel.setBackground(new Color(47, 40, 39));

        JButton button=new JButton("Reset");
        button.setBounds(50,50,95,30);
        button.setBackground(new Color(236, 117, 46));

        JLabel l1=new JLabel("Chodi :");
        l1.setForeground(new Color(236, 117, 46));
        l1.setBounds(50,100, 100,30);

        JLabel hracma=new JLabel("Hrac ma :");
        hracma.setForeground(new Color(236, 117, 46));
        hracma.setBounds(50,135, 100,30);

        JLabel pocitacma=new JLabel("Pocitac ma :");
        pocitacma.setForeground(new Color(236, 117, 46));
        pocitacma.setBounds(50,160, 100,30);

        JLabel l2=new JLabel("Rozmer:  6");
        l2.setForeground(new Color(236, 117, 46));
        l2.setBounds(50,220, 100,30);

        JRadioButton r1=new JRadioButton("rozmer 6");
        JRadioButton r2=new JRadioButton("rozmer 8");
        JRadioButton r3=new JRadioButton("rozmer 10");
        JRadioButton r4=new JRadioButton("rozmer 12");
        r1.setBounds(50,250,100,20);
        r2.setBounds(50,270,100,20);
        r3.setBounds(50,290,100,20);
        r4.setBounds(50,310,100,20);
        r1.setForeground(new Color(236, 117, 46));
        r2.setForeground(new Color(236, 117, 46));
        r3.setForeground(new Color(236, 117, 46));
        r4.setForeground(new Color(236, 117, 46));
        r1.setBackground(new Color(47, 40, 39));
        r2.setBackground(new Color(47, 40, 39));
        r3.setBackground(new Color(47, 40, 39));
        r4.setBackground(new Color(47, 40, 39));
        ButtonGroup bg=new ButtonGroup();
        bg.add(r1);bg.add(r2);bg.add(r3);bg.add(r4);
        r1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rozmer = 6;
                l2.setText("Rozmer:  6");
            }
        });
        r2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rozmer = 8;
                l2.setText("Rozmer:  8");
            }
        });
        r3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rozmer = 10;
                l2.setText("Rozmer:  10");
            }
        });
        r4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rozmer = 12;
                l2.setText("Rozmer:  12");
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
        frame.add(r1);
        frame.add(r2);
        frame.add(r3);
        frame.add(r4);
        frame.add(button);
        frame.add(vin);
        frame.add(panel);
        frame.setBounds(400,50,800,600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}

