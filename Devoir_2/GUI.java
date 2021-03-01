package Devoir_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JTextField calcText;

    private String intInput = "";
    private String fractionalInput = "";
    private boolean isFractInput = false;

    private Calculator calculator;

    @Override
    public void actionPerformed(ActionEvent e) {
        var command = e.getActionCommand();

        if (command.equals(".")) {
            isFractInput = true;
            return;
        }

        switch (command) {
            case ".":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "0":
                if (isFractInput) {
                    this.fractionalInput += command;
                } else {
                    this.intInput += command;
                }

                String numStr = "";
                if (intInput.isEmpty()) {
                    numStr += "0.";
                } else {
                    numStr += intInput + ".";
                }

                if (fractionalInput.isEmpty()) {
                    numStr += "0";
                } else {
                    numStr += fractionalInput;
                }
                double numToPush = Double.parseDouble(numStr);
                this.calculator.pushNumber(numToPush);
                this.calcText.setText(this.calculator.toString());
                return;
        }

        // Reset for next digit
        intInput = "";
        fractionalInput = "";
        isFractInput = false;
        switch (command) {
            case "C":
                this.calculator.clear();
                break;
            case "sqrt":
                this.calculator.rootSquare();
                break;
            case "!":
                this.calculator.factorial();
                break;
            case "=":
                this.calculator.compute();
                break;
            case "^":
                this.calculator.pow();
                break;
            case "+":
                calculator.add();
                break;
            case "-":
                this.calculator.subtract();
                break;
            case "ln":
                this.calculator.nepLog();
                break;
            case "*":
                this.calculator.multiply();
                break;
            case "/":
                this.calculator.divide();
                break;
            case "Ans":
                this.calculator.pushNumber(this.calculator.acc);
            default:
                intInput = "";
                fractionalInput = "";
                break;
        }
        this.calcText.setText(this.calculator.toString());
    }

    public GUI() {
        super("Calculator");
        this.calculator = new Calculator();
        // this.setLayout(new BorderLayout());

        var upperPanel = new JPanel();
        this.calcText = new JTextField(25);
        upperPanel.add(this.calcText);
        this.calcText.setText(this.calculator.toString());

        var lowerPanel = new JPanel();

        this.add(upperPanel, BorderLayout.PAGE_START);
        this.add(lowerPanel);

        lowerPanel.add(new JButton("7"));
        lowerPanel.add(new JButton("8"));
        lowerPanel.add(new JButton("9"));
        lowerPanel.add(new JButton("C"));
        lowerPanel.add(new JButton(""));
        lowerPanel.add(new JButton("^"));

        lowerPanel.add(new JButton("4"));
        lowerPanel.add(new JButton("5"));
        lowerPanel.add(new JButton("6"));
        lowerPanel.add(new JButton("*"));
        lowerPanel.add(new JButton("/"));
        lowerPanel.add(new JButton("!"));

        lowerPanel.add(new JButton("1"));
        lowerPanel.add(new JButton("2"));
        lowerPanel.add(new JButton("3"));
        lowerPanel.add(new JButton("+"));
        lowerPanel.add(new JButton("-"));
        lowerPanel.add(new JButton("sqrt"));

        lowerPanel.add(new JButton("0"));
        lowerPanel.add(new JButton("."));
        lowerPanel.add(new JButton("="));
        lowerPanel.add(new JButton("Ans"));
        lowerPanel.add(new JButton(""));
        lowerPanel.add(new JButton("ln"));

        lowerPanel.setLayout(new GridLayout(4, 4));
        // upperPanel.add(quit_button);
        synchronized (lowerPanel.getTreeLock()) {
            for (var element : lowerPanel.getComponents()) {
                JButton b = (JButton) element;
                b.addActionListener(this);
            }
        }

        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new GUI();
    }
}
