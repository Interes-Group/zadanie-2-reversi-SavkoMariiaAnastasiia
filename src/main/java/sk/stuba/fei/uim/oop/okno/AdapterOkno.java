package sk.stuba.fei.uim.oop.okno;

import java.awt.event.*;

public class AdapterOkno implements ActionListener {
    private Okno okno;
    public AdapterOkno() {

    }
    public AdapterOkno(Okno okno)
    {
        this.okno = okno;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
     okno.setRozmer(Integer.parseInt(e.getActionCommand()));
    }

}
