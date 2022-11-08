package calculator;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

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
        JLabel resultLabel = new JLabel();
        resultLabel.setName("ResultLabel");
        resultLabel.setBounds(50, 0, 270, 50);
        resultLabel.setText("0");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 40));
        resultLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        add(resultLabel);

        JLabel equationLabel = new JLabel();
        equationLabel.setName("EquationLabel");
        equationLabel.setBounds(50, 60, 260, 25);
        equationLabel.setFont(new Font("Arial", Font.BOLD, 20));
        equationLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        equationLabel.setForeground(Color.GREEN);
        add(equationLabel);

        JButton Parentheses = new JButton("()");
        Parentheses.setName("Parentheses");
        Parentheses.setBounds(10, 120, 70, 40);
        Parentheses.addActionListener(e -> checkAndInsert(equationLabel));
        add(Parentheses);

        JButton ce = new JButton("CE");
        ce.setName("CE");
        ce.setBounds(90, 120, 70, 40);
        ce.addActionListener(e -> equationLabel.setText(""));
        add(ce);

        JButton clear = new JButton("C");
        clear.setName("Clear");
        clear.setBounds(170, 120, 70, 40);
        add(clear);
        clear.addActionListener(e -> {
            resultLabel.setText("");
            equationLabel.setText("");
        });

        JButton delete = new JButton("Del");
        delete.setName("Delete");
        delete.setBounds(250, 120, 70, 40);
        add(delete);
        delete.addActionListener(e -> {
            var text = equationLabel.getText();
            if (text.length() > 0) {
                equationLabel.setText(text.substring(0, text.length() - 1));
            }
        });

        JButton powerTwo = new JButton("X\u00B2");
        powerTwo.setName("PowerTwo");
        powerTwo.setBounds(10, 170, 70, 40);
        add(powerTwo);
        powerTwo.addActionListener(e -> equationLabel.setText(equationLabel.getText() + "^(2)"));

        JButton powerY = new JButton("X\u02B8");
        powerY.setName("PowerY");
        powerY.setBounds(90, 170, 70, 40);
        add(powerY);
        powerY.addActionListener(e -> equationLabel.setText(equationLabel.getText() + "^("));

        JButton squareRoot = new JButton("\u221A");
        squareRoot.setName("SquareRoot");
        squareRoot.setBounds(170, 170, 70, 40);
        add(squareRoot);
        squareRoot.addActionListener(e -> {
            String str = equationLabel.getText();
            if (checkCurrentEquation(str) == 1 || str.length() == 0) {
                equationLabel.setText(str + "\u221A(");
            } else if (checkCurrentEquation(str) == 2) {
                equationLabel.setText(str.substring(0, str.length() - 1) + "\u221A(");
            } else if (checkCurrentEquation(str) == 3) {
                equationLabel.setText(str + "0" + "\u221A(");
            }
        });

        JButton divide = new JButton("\u00F7");
        divide.setName("Divide");
        divide.setBounds(250, 170, 70, 40);
        add(divide);
        divide.addActionListener(e -> insertOperator(equationLabel, "\u00F7"));

        JButton seven = new JButton("7");
        seven.setName("Seven");
        seven.setBounds(10, 220, 70, 40);
        add(seven);
        seven.addActionListener(e -> {
            String str = equationLabel.getText();
            if (str.equals(".")) {
                equationLabel.setText("0" + str + "7");
            } else {
                equationLabel.setText(str + "7");
            }
        });

        JButton eight = new JButton("8");
        eight.setName("Eight");
        eight.setBounds(90, 220, 70, 40);
        add(eight);
        eight.addActionListener(e -> {
            String str = equationLabel.getText();
            if (str.equals(".")) {
                equationLabel.setText("0" + str + "8");
            } else {
                equationLabel.setText(str + "8");
            }
        });

        JButton nine = new JButton("9");
        nine.setName("Nine");
        nine.setBounds(170, 220, 70, 40);
        add(nine);
        nine.addActionListener(e -> {
            String str = equationLabel.getText();
            if (str.equals(".")) {
                equationLabel.setText("0" + str + "9");
            } else {
                equationLabel.setText(str + "9");
            }
        });

        JButton multiply = new JButton("\u00D7");
        multiply.setName("Multiply");
        multiply.setBounds(250, 220, 70, 40);
        add(multiply);
        multiply.addActionListener(e -> insertOperator(equationLabel, "\u00D7"));

        JButton four = new JButton("4");
        four.setName("Four");
        four.setBounds(10, 270, 70, 40);
        add(four);
        four.addActionListener(e -> {
            String str = equationLabel.getText();
            if (str.equals(".")) {
                equationLabel.setText("0" + str + "4");
            } else {
                equationLabel.setText(str + "4");
            }
        });

        JButton five = new JButton("5");
        five.setName("Five");
        five.setBounds(90, 270, 70, 40);
        add(five);
        five.addActionListener(e -> {
            String str = equationLabel.getText();
            if (str.equals(".")) {
                equationLabel.setText("0" + str + "5");
            } else {
                equationLabel.setText(str + "5");
            }
        });

        JButton six = new JButton("6");
        six.setName("Six");
        six.setBounds(170, 270, 70, 40);
        add(six);
        six.addActionListener(e -> {
            String str = equationLabel.getText();
            if (str.equals(".")) {
                equationLabel.setText("0" + str + "6");
            } else {
                equationLabel.setText(str + "6");
            }
        });


        JButton subtract = new JButton("-");
        subtract.setName("Subtract");
        subtract.setBounds(250, 270, 70, 40);
        add(subtract);
        subtract.addActionListener(e -> insertOperator(equationLabel, "-"));

        JButton one = new JButton("1");
        one.setName("One");
        one.setBounds(10, 320, 70, 40);
        add(one);
        one.addActionListener(e -> equationLabel.setText(equationLabel.getText() + "1"));

        JButton two = new JButton("2");
        two.setName("Two");
        two.setBounds(90, 320, 70, 40);
        add(two);
        two.addActionListener(e -> {
            String str = equationLabel.getText();
            if (str.equals(".")) {
                equationLabel.setText("0" + str + "2");
            } else {
                equationLabel.setText(str + "2");
            }
        });

        JButton three = new JButton("3");
        three.setName("Three");
        three.setBounds(170, 320, 70, 40);
        add(three);
        three.addActionListener(e -> {
            String str = equationLabel.getText();
            if (str.equals(".")) {
                equationLabel.setText("0" + str + "3");
            } else {
                equationLabel.setText(str + "3");
            }
        });

        JButton add = new JButton("\u002B");
        add.setName("Add");
        add.setBounds(250, 320, 70, 40);
        add(add);
        add.addActionListener(e -> insertOperator(equationLabel, "\u002B"));

        JButton plusMinus = new JButton("\u00B1");
        plusMinus.setName("PlusMinus");
        plusMinus.setBounds(10, 370, 70, 40);
        add(plusMinus);
        plusMinus.addActionListener(e -> {
            String str = equationLabel.getText();
            if (str.length() == 0) {
                equationLabel.setText("(\u002D");
                return;
            }
            if (str.startsWith("(\u002D") && !notContainsOperator(str)) {
                equationLabel.setText(str.substring(2));
                return;
            }
            if (notContainsOperator(str)) {
                equationLabel.setText("(\u002D" + str);
                return;
            }
            if (str.equals("(\u002D")) {
                equationLabel.setText("");
                return;
            }
            if (!str.startsWith("(\u002D")) {
                equationLabel.setText("(\u002D(" + str + "))");
            } else {
                equationLabel.setText(str.substring(3, str.length()-2));
            }
        });

        JButton zero = new JButton("0");
        zero.setName("Zero");
        zero.setBounds(90, 370, 70, 40);
        add(zero);
        zero.addActionListener(e -> equationLabel.setText(equationLabel.getText() + "0"));

        JButton dot = new JButton(".");
        dot.setName("Dot");
        dot.setBounds(170, 370, 70, 40);
        add(dot);
        dot.addActionListener(e -> equationLabel.setText(equationLabel.getText() + "."));

        JButton equals = new JButton("=");
        equals.setName("Equals");
        equals.setBounds(250, 370, 70, 40);
        add(equals);

        equals.addActionListener(e -> {

            String usrInput = equationLabel.getText();

            if (checkEquation(usrInput)) {
                String str = infixToPostfix(usrInput);
                double result = evaluatePostfix(str);
                if (result % 1 == 0) {
                    resultLabel.setText(String.valueOf((long) result));
                } else {
                    resultLabel.setText(String.valueOf(result));
                }
            } else {
                    equationLabel.setForeground(Color.RED.darker());
                }
            equationLabel.setText(usrInput);
        });

    }

    private double evaluatePostfix(String str) {
        String[] strArray = str.split("\\s+");
        Stack<String> st = new Stack<>();
        for (String s : strArray) {
            if (s.length() == 0) {
                continue;
            }
            if (s.length() > 1 || !isOperator(s.charAt(0))) {
                st.push(s);
            } else {
                String operator = getOperator(s.charAt(0));
                double ans = 0;
                if ("add".equals(operator)) {
                    double num1 = Double.parseDouble(st.peek());
                    st.pop();
                    double num2 = Double.parseDouble(st.peek());
                    st.pop();
                    ans = num2 + num1;
                } else if ("subtract".equals(operator)) {
                    double num1 = Double.parseDouble(st.peek());
                    st.pop();
                    double num2 = Double.parseDouble(st.peek());
                    st.pop();
                    ans = num2 - num1;
                } else if ("multiply".equals(operator)) {
                    double num1 = Double.parseDouble(st.peek());
                    st.pop();
                    double num2 = Double.parseDouble(st.peek());
                    st.pop();
                    ans = num2 * num1;
                } else if ("divide".equals(operator)) {
                    double num1 = Double.parseDouble(st.peek());
                    st.pop();
                    double num2 = Double.parseDouble(st.peek());
                    st.pop();
                    ans = num2 / num1;
                } else if ("sqrt".equals(operator)) {
                    double num1 = Double.parseDouble(st.peek());
                    st.pop();
                    ans = Math.sqrt(num1);
                } else if ("power".equals(operator)) {
                    double num1 = Double.parseDouble(st.peek());
                    st.pop();
                    double num2 = Double.parseDouble(st.peek());
                    st.pop();
                    ans = Math.pow(num2, num1);
                }
                st.push(String.valueOf(ans));
            }
        }
        return Double.parseDouble(st.peek());
    }

    private String infixToPostfix(String str) {
        Stack<Character> stack =new Stack<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (!isOperator(str.charAt(i)) && !isParenthesis(str.charAt(i)) || str.charAt(i) == '\u002D' && str.charAt(i - 1) == '(') {
                ans.append(str.charAt(i));
            } else {
                char currentCh = str.charAt(i);
                if (i!= 0 && currentCh == '\u221A' && !isOperator(str.charAt(i-1))) {
                    char ch = '\u00D7';
                    if (stack.empty() || getPrecedence(stack.peek()) < getPrecedence(ch)) {
                        ans.append(" ");
                        stack.push(ch);
                    } else {
                        while (!stack.empty() && getPrecedence(stack.peek()) >= getPrecedence(ch)) {
                            ans.append(" ").append(stack.peek()).append(" ");
                            stack.pop();
                        }
                        stack.push(ch);
                    }
                }
                if (currentCh == '(') {
                    stack.push('(');
                } else if (currentCh == ')') {
                    while (stack.peek() != '(') {
                        ans.append(" ").append(stack.peek()).append(" ");
                        stack.pop();
                    }
                    stack.pop();
                } else if (stack.empty() || getPrecedence(stack.peek()) < getPrecedence(currentCh)) {
                    ans.append(" ");
                    stack.push(str.charAt(i));
                } else {
                    while (!stack.empty() && getPrecedence(stack.peek()) >= getPrecedence(currentCh)) {
                        ans.append(" ").append(stack.peek()).append(" ");
                        stack.pop();
                    }
                    stack.push(currentCh);
                }
            }
        }
        while (!stack.empty()) {
            ans.append(" ").append(stack.peek());
            stack.pop();
        }
        return ans.toString();
    }

    private boolean isParenthesis(char ch) {
        return ch == '(' || ch == ')';
    }

    private int checkCurrentEquation(String str) {
        if (str.length() == 0) return -1;
        if (str.charAt(str.length()-1) == '.') {
            return 3;
        } else if (getPrecedence(str.charAt(0)) == -1 && getPrecedence(str.charAt(str.length()-1)) == -1) {
            return 1;
        } else if (getPrecedence(str.charAt(str.length()-1)) != -1) {
            return 2;
        }
        return -1;
    }

    private boolean checkEquation(String str) {
        if (getPrecedence(str.charAt(str.length()-1)) != -1) return false;
        for (int i = 0; i < str.length(); i++) {
            if ("divide".equals(getOperator(str.charAt(i))) && str.charAt(i+1) == '0') return false;
        }
        return true;
    }

    private int getPrecedence(char ch) {
        if (ch == '^' || ch == '\u221A') {
            return 3;
        } else if (ch == '\u00F7' || ch == '\u00D7') {
            return 2;
        } else if (ch == '\u002B' || ch == '-') {
            return 1;
        }
        return -1;
    }

    private String getOperator(char ch) {
        if (ch == '^') {
            return "power";
        } else if (ch == '\u00F7') {
            return "divide";
        } else if (ch == '\u00D7') {
            return "multiply";
        } else if (ch == '\u002B') {
            return "add";
        } else if (ch == '-') {
            return "subtract";
        } else if (ch == '\u221A') {
            return "sqrt";
        }
        return null;
    }
    boolean isOperator(char ch) {
        return ch == '\u00F7' || ch == '^' || ch == '\u221A' || ch == '\u00D7' || ch == '\u002B' || ch == '-';
    }

    private boolean notContainsOperator(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (isOperator(str.charAt(i))) return false;
        }
        return true;
    }

    private void insertOperator(JLabel equationLabel, String operator) {
        String str = equationLabel.getText();
        if (str.charAt(str.length()-1) == ')') {
            equationLabel.setText(str + operator);
            return;
        }
        if (checkCurrentEquation(str) == 1) {
            equationLabel.setText(str + operator);
        } else if (checkCurrentEquation(str) == 2) {
            equationLabel.setText(str.substring(0, str.length() - 1) + operator);
        } else if (checkCurrentEquation(str) == 3) {
            equationLabel.setText(str + "0" + operator);
        }
    }

    private void checkAndInsert(JLabel equationLabel) {
        String str = equationLabel.getText();
        if (str.length() == 0 || str.charAt(str.length()-1) == '(' || isOperator(str.charAt(str.length()-1))) {
            equationLabel.setText(str+"(");
            return;
        }
        int cntStart = 0;
        int cntEnd = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' /*&& !str.substring(i).startsWith("(\u002D")*/) {
                cntStart++;
            }
            else if (str.charAt(i) == ')'){
                cntEnd++;
            }
        }
        if (cntStart == cntEnd) {
            equationLabel.setText(str + "(");
        } else {
            equationLabel.setText(str + ")");
        }
    }
}
