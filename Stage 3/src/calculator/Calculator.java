package calculator;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class Calculator extends JFrame {
    private JLabel equationLabel;
    private JLabel resultLabel;


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
        resultLabel = new JLabel("0");
        resultLabel.setName("ResultLabel");
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 40));
        resultLabel.setBounds(250, 30, 300, 50);
        add(resultLabel);

        equationLabel = new JLabel();
        equationLabel.setName("EquationLabel");
        equationLabel.setBounds(250, 100, 280, 25);
        equationLabel.setForeground(Color.green);
        add(equationLabel);

        JButton clear = new JButton("C");
        clear.setName("Clear");
        clear.setBounds(170, 170, 70, 40);
        add(clear);
        clear.addActionListener(e -> equationLabel.setText(""));

        JButton delete = new JButton("Del");
        delete.setName("Delete");
        delete.setBounds(250, 170, 70, 40);
        add(delete);
        delete.addActionListener(e -> {
            var text = equationLabel.getText();
            if (text.length() > 0) {
                equationLabel.setText(text.substring(0, text.length() - 1));
            }
        });


        JButton seven = new JButton("7");
        seven.setName("Seven");
        seven.setBounds(10, 220, 70, 40);
        add(seven);
        seven.addActionListener(e -> equationLabel.setText(equationLabel.getText() + "7"));


        JButton eight = new JButton("8");
        eight.setName("Eight");
        eight.setBounds(90, 220, 70, 40);
        add(eight);
        eight.addActionListener(e -> equationLabel.setText(equationLabel.getText() + "8"));

        JButton nine = new JButton("9");
        nine.setName("Nine");
        nine.setBounds(170, 220, 70, 40);
        add(nine);
        nine.addActionListener(e -> equationLabel.setText(equationLabel.getText() + "9"));

        JButton divide = new JButton("\u00F7");
        divide.setName("Divide");
        divide.setBounds(250, 220, 70, 40);
        add(divide);
        divide.addActionListener(e -> equationLabel.setText(equationLabel.getText() + "\u00F7"));

        JButton four = new JButton("4");
        four.setName("Four");
        four.setBounds(10, 270, 70, 40);
        add(four);
        four.addActionListener(e -> equationLabel.setText(equationLabel.getText() + "4"));

        JButton five = new JButton("5");
        five.setName("Five");
        five.setBounds(90, 270, 70, 40);
        add(five);
        five.addActionListener(e -> equationLabel.setText(equationLabel.getText() + "5"));

        JButton six = new JButton("6");
        six.setName("Six");
        six.setBounds(170, 270, 70, 40);
        add(six);
        six.addActionListener(e -> equationLabel.setText(equationLabel.getText() + "6"));


        JButton multiply = new JButton("\u00D7");
        multiply.setName("Multiply");
        multiply.setBounds(250, 270, 70, 40);
        add(multiply);
        multiply.addActionListener(e -> equationLabel.setText(equationLabel.getText() + "\u00D7"));

        JButton one = new JButton("1");
        one.setName("One");
        one.setBounds(10, 320, 70, 40);
        add(one);
        one.addActionListener(e -> equationLabel.setText(equationLabel.getText() + "1"));

        JButton two = new JButton("2");
        two.setName("Two");
        two.setBounds(90, 320, 70, 40);
        add(two);
        two.addActionListener(e -> equationLabel.setText(equationLabel.getText() + "2"));

        JButton three = new JButton("3");
        three.setName("Three");
        three.setBounds(170, 320, 70, 40);
        add(three);
        three.addActionListener(e -> equationLabel.setText(equationLabel.getText() + "3"));

        JButton add = new JButton("\u002B");
        add.setName("Add");
        add.setBounds(250, 320, 70, 40);
        add(add);
        add.addActionListener(e -> equationLabel.setText(equationLabel.getText() + "\u002B"));

        JButton dot = new JButton(".");
        dot.setName("Dot");
        dot.setBounds(10, 370, 70, 40);
        add(dot);
        dot.addActionListener(e -> equationLabel.setText(equationLabel.getText() + "."));

        JButton zero = new JButton("0");
        zero.setName("Zero");
        zero.setBounds(90, 370, 70, 40);
        add(zero);
        zero.addActionListener(e -> equationLabel.setText(equationLabel.getText() + "0"));

        JButton equals = new JButton("=");
        equals.setName("Equals");
        equals.setBounds(170, 370, 70, 40);
        add(equals);

        JButton subtract = new JButton("-");
        subtract.setName("Subtract");
        subtract.setBounds(250, 370, 70, 40);
        add(subtract);
        subtract.addActionListener(e -> equationLabel.setText(equationLabel.getText() + "-"));

        equals.addActionListener(e -> {

            String usrInput = equationLabel.getText();

            double result = Calculator.evaluate(usrInput);

            if (result % 1 == 0) {
                resultLabel.setText(String.valueOf((long) result));
            } else {
                resultLabel.setText(String.valueOf(result));
            }
            equationLabel.setText(usrInput);
        });

    }

    public static double evaluate(String input) {
        Stack<Integer> op = new Stack<>();
        Stack<Double> val = new Stack<>();
        /* Create temporary stacks for operators and operands */
        Stack<Integer> optmp = new Stack<>();
        Stack<Double> valtmp = new Stack<>();
        /* Accept expression */
        input = "0" + input;
        input = input.replaceAll("-", "+-");
        /* Store operands and operators in respective stacks */
        String temp = "";
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '-')
                temp = "-" + temp;
            else if (ch != '+' && ch != '\u00D7' && ch != '\u00F7')
                temp = temp + ch;
            else {
                val.push(Double.parseDouble(temp));
                op.push((int) ch);
                temp = "";
            }
        }
        val.push(Double.parseDouble(temp));
        /* Create char array of operators as per precedence */
        /* -ve sign is already taken care of while storing */
        char[] operators = {'\u00F7', '\u00D7', '+'};
        /* Evaluation of expression */
        for (int i = 0; i < 3; i++) {
            boolean it = false;
            while (!op.isEmpty()) {
                int optr = op.pop();
                double v1 = val.pop();
                double v2 = val.pop();
                if (optr == operators[i]) {
                    /* if operator matches evaluate and store in temporary stack */
                    if (i == 0) {
                        valtmp.push(v2 / v1);
                        it = true;
                        break;
                    } else if (i == 1) {
                        valtmp.push(v2 * v1);
                        it = true;
                        break;
                    } else if (i == 2) {
                        valtmp.push(v2 + v1);
                        it = true;
                        break;
                    }
                } else {
                    valtmp.push(v1);
                    val.push(v2);
                    optmp.push(optr);
                }
            }
            /* Push back all elements from temporary stacks to main stacks */
            while (!valtmp.isEmpty())
                val.push(valtmp.pop());
            while (!optmp.isEmpty())
                op.push(optmp.pop());
            /* Iterate again for same operator */
            if (it)
                i--;
        }
        return val.pop();
    }
}
