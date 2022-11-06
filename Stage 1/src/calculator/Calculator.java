package calculator;

import javax.swing.*;

public class Calculator extends JFrame {

    public Calculator() {
        super("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);

        initComponents();

        setLayout(null);
        setVisible(true);
    }

    private void initComponents() {
        JTextField equationTextField = new JTextField();
        equationTextField.setBounds(80, 20, 130, 20);
        add(equationTextField);

        JButton solveButton = new JButton("Solve");
        solveButton.setName("Solve");
        solveButton.setBounds(100, 150, 80, 20);
        add(solveButton);

        equationTextField.setName("EquationTextField");

        solveButton.addActionListener(e -> {
            
            String input= equationTextField.getText();

            String[] s = input.split("\\+");
            int[] a = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                a[i] = Integer.parseInt(s[i]);
            }

            int sum = 0;
            for (int value : a) {
                sum += value;
            }

            equationTextField.setText(input + "=" + sum);

        });

    }
}
