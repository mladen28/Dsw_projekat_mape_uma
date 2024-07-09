package raf.dsw.gerumap.gui.swing.view.dialog;

import raf.dsw.gerumap.gui.swing.view.MainFrame;
import raf.dsw.gerumap.mapRepository.implementation.Project;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;

public class EditDialog extends JDialog {

    JLabel lblAutor;
    JTextField tfAutor;
    JLabel lblUrl;
    JTextField tfUrl;
    JButton btnSacuvaj;

    public EditDialog(Project project){
        setSize(250, 130);
        setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        setTitle("Edit");
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new FlowLayout());

        lblAutor = new JLabel("Unesi autora:     ");
        tfAutor = new JTextField();
        tfAutor.setText("");
        tfAutor.setColumns(10);


        btnSacuvaj = new JButton("Sacuvaj");
        btnSacuvaj.addActionListener(e -> {
            if(!tfAutor.getText().equals(""))
                project.setImeAutora(tfAutor.getText());
            this.setVisible(false);
        });


        panel.add(lblAutor);
        panel.add(tfAutor);
        panel.add(btnSacuvaj);


        this.add(panel);
    }

    public JLabel getLblAutor() {
        return lblAutor;
    }

    public void setLblAutor(JLabel lblAutor) {
        this.lblAutor = lblAutor;
    }

    public JTextField getTfAutor() {
        return tfAutor;
    }

    public void setTfAutor(JTextField tfAutor) {
        this.tfAutor = tfAutor;
    }

    public JLabel getLblUrl() {
        return lblUrl;
    }

    public void setLblUrl(JLabel lblUrl) {
        this.lblUrl = lblUrl;
    }

    public JTextField getTfUrl() {
        return tfUrl;
    }

    public void setTfUrl(JTextField tfUrl) {
        this.tfUrl = tfUrl;
    }
}
