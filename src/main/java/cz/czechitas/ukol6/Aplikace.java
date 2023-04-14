package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

public class Aplikace extends JFrame {
    private JTextField husyField;
    private JLabel husyLabel;

    private JTextField kraliciField;

    private JLabel kraliciLabel;

    private JButton vypocitatButton;

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
        husyField.setHorizontalAlignment(JTextField.TRAILING);

        add(husyField);
        add(husyLabel);
        add(husyField, "left, span");

        kraliciField = new JTextField();
        kraliciLabel = new JLabel("Králíci");
        kraliciLabel.setDisplayedMnemonic('K');
        kraliciLabel.setLabelFor(kraliciField);
        kraliciField.setHorizontalAlignment(JTextField.TRAILING);


        add(kraliciField);
        add(kraliciLabel);
        add(kraliciField,"left, span");

        add(createButtonBar(), "span");

        hlavyField = new JTextField();
        hlavyLabel = new JLabel("Počet hlav");
        hlavyLabel.setDisplayedMnemonic('L');
        hlavyLabel.setLabelFor(hlavyField);
        hlavyField.setEditable(false);
        hlavyField.setHorizontalAlignment(JTextField.TRAILING);

        add(hlavyLabel);
        add(hlavyField);

        nohyField = new JTextField();
        nohyLabel = new JLabel("Počet nohou");
        nohyLabel.setDisplayedMnemonic('N');
        nohyLabel.setLabelFor(nohyField);
        nohyField.setEditable(false);
        nohyField.setHorizontalAlignment(JTextField.TRAILING);

        add(nohyLabel);
        add(nohyField);






        pack();

        vypocitatButton.addActionListener(this::handleVypocitat);
    }

    private JPanel createButtonBar() {
        vypocitatButton = new JButton("Vypočítat");
        vypocitatButton.setMnemonic('U');


        JPanel buttonBar = new JPanel(new MigLayout(null, "[right, grow]"));
        buttonBar.add(vypocitatButton);
        return buttonBar;
    }

    public void handleVypocitat(ActionEvent actionEvent) {

        int pocetHlav = Integer.parseInt(husyField.getText());
        pocetHlav = pocetHlav + Integer.parseInt(kraliciField.getText());

        hlavyField.setText(Integer.toString(pocetHlav));

        int pocetNohou = Integer.parseInt(husyField.getText())*2;
        int pocetNohouK = Integer.parseInt(kraliciField.getText())*4;

        nohyField.setText((Integer.toString(pocetNohou + pocetNohouK)));
    }

//    private JPanel createButtonBar () {
//        vypocitatButton = new JButton("Vypočítat");
//        vypocitatButton.setMnemotic('V');
//
//
//    }
}
