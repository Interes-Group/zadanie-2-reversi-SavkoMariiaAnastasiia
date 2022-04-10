package sk.stuba.fei.uim.oop.okno;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Kamne extends JPanel {

    public String i;

    public Kamne () {

        this.setBackground(new Color(236, 117, 46));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
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

    public int getIndexHraca() {
        return -1;
    }
}
