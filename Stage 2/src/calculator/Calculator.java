package calculator;

import javax.swing.*;

public class Calculator extends JFrame {

    public Calculator() {
        super("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(340, 500);
        setLocationRelativeTo(null);

        initComponents();

        setLayout(null);
        setVisible(true);
    }

    private void initComponents() {
        JTextField equationTextField = new JTextField();
        equationTextField.setName("EquationTextField");
        equationTextField.setBounds(20, 40, 280, 25);
        add(equationTextField);

        JButton seven = new JButton("7");
        seven.setName("Seven");
        seven.setBounds(30, 100, 50, 40);
        add(seven);
        seven.addActionListener(e -> equationTextField.setText(equationTextField.getText() + "7"));


        JButton eight = new JButton("8");
        eight.setName("Eight");
        eight.setBounds(100, 100, 50, 40);
        add(eight);
        eight.addActionListener(e -> equationTextField.setText(equationTextField.getText() + "8"));

        JButton nine = new JButton("9");
        nine.setName("Nine");
        nine.setBounds(170, 100, 50, 40);
        add(nine);
        nine.addActionListener(e -> equationTextField.setText(equationTextField.getText() + "9"));

        JButton divide = new JButton("/");
        divide.setName("Divide");
        divide.setBounds(240, 100, 50, 40);
        add(divide);
        divide.addActionListener(e -> equationTextField.setText(equationTextField.getText() + "/"));

        JButton four = new JButton("4");
        four.setName("Four");
        four.setBounds(30, 170, 50, 40);
        add(four);
        four.addActionListener(e -> equationTextField.setText(equationTextField.getText() + "4"));

        JButton five = new JButton("5");
        five.setName("Five");
        five.setBounds(100, 170, 50, 40);
        add(five);
        five.addActionListener(e -> equationTextField.setText(equationTextField.getText() + "5"));

        JButton six = new JButton("6");
        six.setName("Six");
        six.setBounds(170, 170, 50, 40);
        add(six);
        six.addActionListener(e -> equationTextField.setText(equationTextField.getText() + "6"));


        JButton multiply = new JButton("x");
        multiply.setName("Multiply");
        multiply.setBounds(240, 170, 50, 40);
        add(multiply);
        multiply.addActionListener(e -> equationTextField.setText(equationTextField.getText() + "x"));

        JButton one = new JButton("1");
        one.setName("One");
        one.setBounds(30, 240, 50, 40);
        add(one);
        one.addActionListener(e -> equationTextField.setText(equationTextField.getText() + "1"));

        JButton two = new JButton("2");
        two.setName("Two");
        two.setBounds(100, 240, 50, 40);
        add(two);
        two.addActionListener(e -> equationTextField.setText(equationTextField.getText() + "2"));

        JButton three = new JButton("3");
        three.setName("Three");
        three.setBounds(170, 240, 50, 40);
        add(three);
        three.addActionListener(e -> equationTextField.setText(equationTextField.getText() + "3"));

        JButton add = new JButton("+");
        add.setName("Add");
        add.setBounds(240, 240, 50, 40);
        add(add);
        add.addActionListener(e -> equationTextField.setText(equationTextField.getText() + "+"));

        JButton zero = new JButton("0");
        zero.setName("Zero");
        zero.setBounds(100, 310, 50, 40);
        add(zero);
        zero.addActionListener(e -> equationTextField.setText(equationTextField.getText() + "0"));
        
        JButton equals = new JButton("=");
        equals.setName("Equals");
        equals.setBounds(170, 310, 50, 40);
        add(equals);

        JButton subtract = new JButton("-");
        subtract.setName("Subtract");
        subtract.setBounds(240, 310, 50, 40);
        add(subtract);
        subtract.addActionListener(e -> equationTextField.setText(equationTextField.getText() + "-"));

        equals.addActionListener(e -> {

            String input = equationTextField.getText();

            String[] array = input.split("(?=\\d)(?<=[-+x/])|(?<=\\d)(?=[-+x/])");
            int a = Integer.parseInt(array[0]);
            int b = Integer.parseInt(array[2]);
            String operator = array[1];

            if("/".equals(operator) && b == 0) {
                equationTextField.setText(input + "=" + "error");
            }

            long result = "+".equals(operator) ? (long) a + b :
                    "-".equals(operator) ? a - b :
                            "x".equals(operator) ? (long) a * b : a / b;

            equationTextField.setText(input + "=" + result);
        });

    }
}
