package sk.stuba.fei.uim.oop.okno;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Kamne extends JPanel {

    private int x, y;

    public Kamne(int x, int y, int rozmer, int riadok, int currnt) {
        super();

        if((x==(rozmer/2)-1 && x==y)||(x==(rozmer/2) && x==y)){
            BufferedImage black = null;
            try {
                black = ImageIO.read(Objects.requireNonNull(Pole.class.getResourceAsStream("/imgo.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
            JLabel picLabel = new JLabel(new ImageIcon(black));
            this.add(picLabel);
        }
        if((x==(rozmer/2)-1 && y==x+1)||(x==(rozmer/2) && y==x-1)){
            BufferedImage black = null;
            try {
                black = ImageIO.read(Objects.requireNonNull(Pole.class.getResourceAsStream("/2.png")));
            } catch (IOException e) {
                e.printStackTrace();
            }
            JLabel picLabel = new JLabel(new ImageIcon(black));
            this.add(picLabel);
        }
        //this.setBounds(currnt,riadok,40,40);
        this.setBackground(new Color(236, 117, 46));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //poli.add(tpoli);

        // pole_prehru.add(poli);
    }
}
