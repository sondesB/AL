package sonde.Composants;

import javax.security.auth.login.Configuration;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Jaafar on 03/02/2017.
 */
public class PeriodiciterSondage extends JFrame {

    private JFrame frame;
    private JPanel panel;
    private JLabel labelPeriodicite;
    private JTextField fieldPeriodicite;
    private JButton btnOK;
    private int periodicite = 0;

    sonde.Services.Configuration conf;

    public void createForm() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();

        labelPeriodicite = new JLabel("Periodicite (ms)");
        fieldPeriodicite = new JTextField(10);

        btnOK = new JButton("OK");
        btnOK.addActionListener(e -> { getPeriodiciteValue(); });

        panel.add(labelPeriodicite);
        panel.add(fieldPeriodicite);
        panel.add(btnOK);

        Dimension dimension = panel.getPreferredSize();
        dimension.width = 200;
        dimension.height = 100;
        panel.setPreferredSize(dimension);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private void getPeriodiciteValue() {
        String value = fieldPeriodicite.getText();
        boolean parsable = true;
        try {
            periodicite = Integer.parseInt(fieldPeriodicite.getText());
        } catch (NumberFormatException e) {
            parsable = false;
        }
        if (!parsable) {
            JOptionPane.showMessageDialog(frame, "Invalid input!");
        } else {
            frame.dispose();
        }
        conf.definirPeriodicite(periodicite);
    }
}
