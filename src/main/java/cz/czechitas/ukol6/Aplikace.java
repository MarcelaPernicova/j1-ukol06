package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class Aplikace extends JFrame {
    private JTextField husyField;
    private JLabel husyLabel;

    private JTextField kraliciField;

    private JLabel kraliciLabel;

    private Button vypocitatButton;

    private JTextField hlavyField;

    private JLabel hlavyLabel;

    private JTextField nohyField;

    private JLabel nohyLabel;



    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    public Aplikace() throws HeadlessException {
        super("Farmářka 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(250, 200));

        //TODO implementovat formulář podle zadání


        husyField = new JTextField();
        husyLabel = new JLabel("Husy");
        husyLabel.setDisplayedMnemonic('H');
        husyLabel.setLabelFor(husyField);
        add(husyField);
        add(husyLabel);
        add(husyField, "left, span");

        kraliciField = new JTextField();
        kraliciLabel = new JLabel("Králíci");
        kraliciLabel.setDisplayedMnemonic('K');
        kraliciLabel.setLabelFor(kraliciField);

        add(kraliciField);
        add(kraliciLabel);
        add(kraliciField,"left, span");

        getRootPane().setDefaultButton(vypocitatButton);

        vypocitatButton.addActionListener(this::handleVypocitat);

n
        pack();
    }

    private JPanel createButtonBar () {
        vypocitatButton = new JButton("Vypočítat");
        vypocitatButton.setMnemotic('V');


    }
}
