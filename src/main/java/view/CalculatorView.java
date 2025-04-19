package view;

import controller.CalculatorController;

import javax.swing.*;

public class CalculatorView {
    private JTextField textPolinom1;
    private JTextField textPolinom2;
    private JTextField textRezultat;
    private JButton buttonAdunare;
    private JButton buttonScadere;
    private JButton buttonImpartire;
    private JButton buttonInmultire;
    private JButton buttonDeriveaza;
    private JButton buttonIntegreaza;
    private JPanel panel1;
    private JTextField textRest;

    public String getTextPolinom1() {
        return textPolinom1.getText();
    }
    public JTextField getTextRezultat() {
        return textRezultat;
    }

    public JTextField getTextRest() {
        return textRest;
    }

    public String getTextPolinom2() {
        return textPolinom2.getText();
    }

    public JButton getButtonAdunare() {
        return buttonAdunare;
    }

    public JButton getButtonScadere() {
        return buttonScadere;
    }

    public CalculatorView(){
        CalculatorController controller = new CalculatorController(this);
        buttonAdunare.addActionListener(e -> controller.aduna());
        buttonScadere.addActionListener(e -> controller.scade());
        buttonImpartire.addActionListener(e -> controller.imparte());

        buttonInmultire.addActionListener(e -> controller.inmulteste());
        buttonDeriveaza.addActionListener(e -> controller.deriveaza());
        buttonIntegreaza.addActionListener(e -> controller.integreaza());
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Tema 1");
        frame.setContentPane(new CalculatorView().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500, 300);
    }
}
