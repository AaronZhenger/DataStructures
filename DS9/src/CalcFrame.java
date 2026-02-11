import javax.swing.*;
import java.awt.*;

public class CalcFrame extends JFrame {
    private JLabel operand1 = new JLabel();
    private JLabel operator = new JLabel();
    private JTextField input = new JTextField();

    private JButton zero = new JButton();
    private JButton one = new JButton();
    private JButton two = new JButton();
    private JButton three = new JButton();
    private JButton four = new JButton();
    private JButton five = new JButton();
    private JButton six = new JButton();
    private JButton seven = new JButton();
    private JButton eight = new JButton();
    private JButton nine = new JButton();
    private JButton add = new JButton();
    private JButton subtract = new JButton();
    private JButton multiply = new JButton();
    private JButton divide = new JButton();
    private JButton equals = new JButton();
    private JButton clear = new JButton();
    private JButton decimal = new JButton();
    private JButton radical = new JButton();

    public CalcFrame() {
        super("Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        operand1.setBounds(20, 20, 340, 20);
        operand1.setHorizontalAlignment(JTextField.RIGHT);
        operand1.setFont(new Font("Serif", Font.PLAIN, 20));
        add(operand1);

        operator.setBounds(20, 40, 340, 20);
        operator.setHorizontalAlignment(JTextField.RIGHT);
        operator.setFont(new Font("Serif", Font.PLAIN, 20));
        add(operator);

        input.setBounds(20, 60, 340, 30);
        input.setEditable(false);
        input.setHorizontalAlignment(JTextField.CENTER);
        input.setFont(new Font("Serif", Font.PLAIN, 28));
        add(input);

        one.setBounds(20, 155, 45, 45);
        one.setText("1");
        one.addActionListener(e -> {
            input.setText(input.getText()+"1");
        });
        add(one);

        two.setBounds(75, 155, 45, 45);
        two.setText("2");
        two.addActionListener(e -> {
            input.setText(input.getText()+"2");
        });
        add(two);

        three.setBounds(130, 155, 45, 45);
        three.setText("3");
        three.addActionListener(e -> {
            input.setText(input.getText()+"3");
        });
        add(three);

        four.setBounds(20, 210, 45, 45);
        four.setText("4");
        four.addActionListener(e -> {
            input.setText(input.getText()+"4");
        });
        add(four);

        five.setBounds(75, 210, 45, 45);
        five.setText("5");
        five.addActionListener(e -> {
            input.setText(input.getText()+"5");
        });
        add(five);

        six.setBounds(130, 210, 45, 45);
        six.setText("6");
        six.addActionListener(e -> {
            input.setText(input.getText()+"6");
        });
        add(six);

        seven.setBounds(20, 265, 45, 45);
        seven.setText("7");
        seven.addActionListener(e -> {
            input.setText(input.getText()+"7");
        });
        add(seven);

        eight.setBounds(75, 265, 45, 45);
        eight.setText("8");
        eight.addActionListener(e -> {
            input.setText(input.getText()+"8");
        });
        add(eight);

        nine.setBounds(130, 265, 45, 45);
        nine.setText("9");
        nine.addActionListener(e -> {
            input.setText(input.getText()+"9");
        });
        add(nine);

        zero.setBounds(185, 155, 45, 155);
        zero.setText("0");
        zero.addActionListener(e -> {
            input.setText(input.getText()+"0");
        });
        add(zero);

        decimal.setBounds(75, 100, 45, 45);
        decimal.setText(".");
        decimal.addActionListener(e -> {
            input.setText(input.getText()+".");
        });
        add(decimal);

        radical.setBounds(130, 100, 45, 45);
        radical.setText("√+");
        radical.setFont(new Font("Serif", Font.PLAIN, 7));
        radical.addActionListener(e -> {
            if (input.getText().charAt(0)=='-')
                input.setText(input.getText().substring(1));
            else input.setText("-" + input.getText());
        });
        add(radical);

        clear.setBounds(185, 100, 45, 45);
        clear.setText("C");
        clear.addActionListener(e -> {
            input.setText("");
        });
        add(clear);

        add.setBounds(240, 100, 45, 45);
        add.setText("+");
        add.addActionListener(e -> {
            if (operator.getText()=="") {
                operand1.setText(input.getText());
                input.setText("");
            }
            operator.setText("+");
        });
        add(add);

        subtract.setBounds(240, 155, 45, 45);
        subtract.setText("-");
        subtract.addActionListener(e -> {
            if (operator.getText()=="") {
                operand1.setText(input.getText());
                input.setText("");
            }
            operator.setText("-");
        });
        add(subtract);

        multiply.setBounds(240, 210, 45, 45);
        multiply.setText("*");
        multiply.addActionListener(e -> {
            if (operator.getText()=="") {
                operand1.setText(input.getText());
                input.setText("");
            }
            operator.setText("*");
        });
        add(multiply);

        divide.setBounds(240, 265, 45, 45);
        divide.setText("/");
        divide.addActionListener(e -> {
            if (operator.getText()=="") {
                operand1.setText(input.getText());
                input.setText("");
            }
            operator.setText("/");
        });
        add(divide);

        setVisible(true);
    }
}
