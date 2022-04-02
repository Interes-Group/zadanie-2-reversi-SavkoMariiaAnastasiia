package sk.stuba.fei.uim.oop.okno;
import sk.stuba.fei.uim.oop.hra.Hra;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Okno extends Hra {
    public Okno(){
        JFrame frame=new JFrame("Reverse");
        final JTextField tf=new JTextField();
        tf.setBounds(50,50, 200,30);

        JButton button=new JButton("Reset");
        button.setBounds(50,100,95,30);
        button.setBackground(new Color(236, 117, 46));

        JLabel l1=new JLabel("Rozmer:");
        l1.setForeground(new Color(236, 117, 46));
        l1.setBounds(50,50, 100,30);

        frame.getContentPane().setBackground(new Color(30, 30, 30));
        frame.add(l1);
        frame.add(button);
        frame.setBounds(400,50,800,600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
