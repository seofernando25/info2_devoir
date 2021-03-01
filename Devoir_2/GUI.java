package Devoir_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JTextField calcText;
    private JButton decimalPlaceButton;

    // Calculator input helper variables
    private String intInput = "";
    private String decimalInput = "";
    private String numberSign = "+";
    private boolean isFractInput = false;

    private Calculator calculator;

    // Updates the calculator number on
    // both screen and Calculator class
    public void updateNumber() {
        String numStr = numberSign;
        if (intInput.isEmpty()) {
            numStr += "0.";
        } else {
            numStr += intInput + ".";
        }

        if (decimalInput.isEmpty()) {
            numStr += "0";
        } else {
            numStr += decimalInput;
        }
        double numToPush = Double.parseDouble(numStr);
        this.calculator.pushNumber(numToPush);
        this.calcText.setText(this.calculator.toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        var command = e.getActionCommand();

        // Handle number related input
        switch (command) {
            case ".":
                isFractInput = true;
                decimalPlaceButton.setEnabled(false);
                return;
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
                    this.decimalInput += command;
                } else {
                    this.intInput += command;
                }
                this.updateNumber();
                return;
            case "-":
                // Special case for when we add a negative sign
                // or call the subtract() operation
                if (this.intInput.isEmpty() && this.decimalInput.isEmpty() && this.calculator.op.isEmpty()
                        && this.calculator.acc == 0.0) {
                    if (numberSign == "-") {
                        numberSign = "";
                    } else {
                        numberSign = "-";
                    }
                    updateNumber();
                    return;
                }
        }

        // If the event is going to be other
        // than adding a digit, we reset it
        intInput = "";
        decimalInput = "";
        numberSign = "";
        decimalPlaceButton.setEnabled(true);
        isFractInput = false;

        // Handle operations calling
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
        decimalPlaceButton = new JButton(".");
        lowerPanel.add(decimalPlaceButton);
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
