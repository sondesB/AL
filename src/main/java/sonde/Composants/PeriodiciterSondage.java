package sonde.Composants;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Jaafar on 03/02/2017.
 */
public class PeriodiciterSondage extends JFrame {

    private JFrame frame;
    private JPanel panel;
    private JLabel labelPeriodicite;
    private JTextField fieldPeriodicite;
    private JButton btnOK;
    private int periodicite = 20; // 20ms par default
    private sonde.Services.Configuration configuration;

    public void createForm() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();

        labelPeriodicite = new JLabel("Periodicite (ms)");
        fieldPeriodicite = new JTextField(10);

        btnOK = new JButton("OK");

        btnOK.addActionListener(e -> {
            getPeriodiciteValue();
        });

        panel.add(labelPeriodicite);
        panel.add(fieldPeriodicite);
        panel.add(btnOK);

        Dimension dimension = panel.getPreferredSize();
        dimension.width = 300;
        dimension.height = 150;
        panel.setPreferredSize(dimension);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private void getPeriodiciteValue() {
        boolean parsable = true;
        int value = 0;
        try {
            value = Integer.parseInt(fieldPeriodicite.getText());
        } catch (NumberFormatException e) {
            parsable = false;
        }
        if (!parsable || value <= 0) {
            JOptionPane.showMessageDialog(frame, "Invalid input!");
        } else {
            frame.dispose();
            setPeriodicite(value);
        }
        configuration.definirPeriodicite(periodicite);
    }

    private void setPeriodicite(int periodicite) {
        this.periodicite = periodicite;
    }

}
