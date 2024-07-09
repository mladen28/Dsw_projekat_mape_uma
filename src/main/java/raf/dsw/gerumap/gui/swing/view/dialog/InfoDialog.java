package raf.dsw.gerumap.gui.swing.view.dialog;

import javax.swing.*;
import java.awt.*;

public class InfoDialog extends JDialog {

    public InfoDialog(String filename1, String filename2) {
        setSize(500, 250);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        setUndecorated(false);
        setTitle("Info");
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        JPanel slikaPanel = new JPanel();

       Image slika1 = getToolkit().getImage(getClass().getResource(filename1));
       JLabel lbSlika1 = new JLabel(new ImageIcon(slika1));

        Image slika2 = getToolkit().getImage(getClass().getResource(filename2));
        JLabel lbSlika2 = new JLabel(new ImageIcon(slika2));

       slikaPanel.add(lbSlika1, BorderLayout.WEST);
        slikaPanel.add(lbSlika2, BorderLayout.EAST);

       panel.add(slikaPanel, BorderLayout.WEST);

        JPanel rightPanel = new JPanel(new FlowLayout());

        JLabel lbImePrezime = new JLabel("Ime i Prezime: Mladen Matic , Veljko Zivanovic");
        rightPanel.add(lbImePrezime);

        JLabel lbIndeks = new JLabel("Indeks: RN 110/2021, RN 122/2020       ");
        rightPanel.add(lbIndeks);

        JButton btnZatvori = new JButton("Zatvori");
        btnZatvori.addActionListener(e -> InfoDialog.this.setVisible(false));
        rightPanel.add(btnZatvori);

        panel.add(rightPanel, BorderLayout.CENTER);

        getContentPane().add(panel);
    }
}

