import javax.swing.*;
import java.awt.*;

public class CalcFrame extends JFrame {

    public CalcFrame() {
        super("Calculator");

        JLabel operand1 = new JLabel();
        JLabel operator = new JLabel();
        JTextField input = new JTextField();
        JButton zero = new JButton();
        JButton one = new JButton();
        JButton two = new JButton();
        JButton three = new JButton();
        JButton four = new JButton();
        JButton five = new JButton();
        JButton six = new JButton();
        JButton seven = new JButton();
        JButton eight = new JButton();
        JButton nine = new JButton();
        JButton add = new JButton();
        JButton subtract = new JButton();
        JButton multiply = new JButton();
        JButton divide = new JButton();
        JButton equals = new JButton();
        JButton clear = new JButton();
        JButton decimal = new JButton();
        JButton sign = new JButton();

        setSize(325, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        operand1.setBounds(20, 20, 265, 20);
        operand1.setHorizontalAlignment(JTextField.RIGHT);
        operand1.setFont(new Font("Serif", Font.PLAIN, 20));
        add(operand1);

        operator.setBounds(20, 40, 265, 20);
        operator.setHorizontalAlignment(JTextField.RIGHT);
        operator.setFont(new Font("Serif", Font.PLAIN, 20));
        add(operator);

        input.setBounds(20, 60, 265, 30);
        input.setEditable(false);
        input.setHorizontalAlignment(JTextField.RIGHT);
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
            if (!input.getText().contains("."))
                if (input.getText().isBlank())
                    input.setText(input.getText()+"0.");
                else
                    input.setText(input.getText()+".");
        });
        add(decimal);

        sign.setBounds(130, 100, 45, 45);
        sign.setText("-/+");
        sign.setFont(new Font("Serif", Font.PLAIN, 9));
        sign.addActionListener(e -> {
            if (!input.getText().isBlank())
                if (input.getText().charAt(0)=='-')
                    input.setText(input.getText().substring(1));
                else input.setText("-" + input.getText());
        });
        add(sign);

        clear.setBounds(185, 100, 45, 45);
        clear.setText("C");
        clear.addActionListener(e -> {
            input.setText("");
            operand1.setText("");
            operator.setText("");
        });
        add(clear);

        add.setBounds(240, 100, 45, 45);
        add.setText("+");
        add.addActionListener(e -> {
            if (!operand1.getText().isBlank() && !operator.getText().isBlank() && !input.getText().isBlank()) {
                double first = Double.parseDouble(operand1.getText());
                double second = Double.parseDouble(input.getText());

                switch (operator.getText()) {
                    case "+" -> {
                        operand1.setText(""+(first+second));
                        input.setText("");
                        operator.setText("+");
                    }
                    case "-" -> {
                        operand1.setText(""+(first-second));
                        input.setText("");
                        operator.setText("+");
                    }
                    case "*" -> {
                        operand1.setText(""+(first*second));
                        input.setText("");
                        operator.setText("+");
                    }
                    case "/" -> {
                        operand1.setText(""+(first/second));
                        input.setText("");
                        operator.setText("+");
                    }
                }
            }
            if (operator.getText()=="") {
                operand1.setText(input.getText());
                input.setText("");
            }
            if (!operand1.getText().isBlank())
                operator.setText("+");
        });
        add(add);

        subtract.setBounds(240, 155, 45, 45);
        subtract.setText("-");
        subtract.addActionListener(e -> {
            if (!operand1.getText().isBlank() && !operator.getText().isBlank() && !input.getText().isBlank()) {
                double first = Double.parseDouble(operand1.getText());
                double second = Double.parseDouble(input.getText());

                switch (operator.getText()) {
                    case "+" -> {
                        operand1.setText(""+(first+second));
                        input.setText("");
                        operator.setText("-");
                    }
                    case "-" -> {
                        operand1.setText(""+(first-second));
                        input.setText("");
                        operator.setText("-");
                    }
                    case "*" -> {
                        operand1.setText(""+(first*second));
                        input.setText("");
                        operator.setText("-");
                    }
                    case "/" -> {
                        operand1.setText(""+(first/second));
                        input.setText("");
                        operator.setText("-");
                    }
                }
            }
            if (operator.getText()=="") {
                operand1.setText(input.getText());
                input.setText("");
            }
            if (!operand1.getText().isBlank()) operator.setText("-");
        });
        add(subtract);

        multiply.setBounds(240, 210, 45, 45);
        multiply.setText("*");
        multiply.addActionListener(e -> {
            if (!operand1.getText().isBlank() && !operator.getText().isBlank() && !input.getText().isBlank()) {
                double first = Double.parseDouble(operand1.getText());
                double second = Double.parseDouble(input.getText());

                switch (operator.getText()) {
                    case "+" -> {
                        operand1.setText(""+(first+second));
                        input.setText("");
                        operator.setText("*");
                    }
                    case "-" -> {
                        operand1.setText(""+(first-second));
                        input.setText("");
                        operator.setText("*");
                    }
                    case "*" -> {
                        operand1.setText(""+(first*second));
                        input.setText("");
                        operator.setText("*");
                    }
                    case "/" -> {
                        operand1.setText(""+(first/second));
                        input.setText("");
                        operator.setText("*");
                    }
                }
            }
            if (operator.getText()=="") {
                operand1.setText(input.getText());
                input.setText("");
                System.out.println("d1");
            }
            if (!operand1.getText().isBlank()) operator.setText("*");
        });
        add(multiply);

        divide.setBounds(240, 265, 45, 45);
        divide.setText("/");
        divide.addActionListener(e -> {
            if (!operand1.getText().isBlank() && !operator.getText().isBlank() && !input.getText().isBlank()) {
                double first = Double.parseDouble(operand1.getText());
                double second = Double.parseDouble(input.getText());

                switch (operator.getText()) {
                    case "+" -> {
                        operand1.setText(""+(first+second));
                        input.setText("");
                        operator.setText("/");
                    }
                    case "-" -> {
                        operand1.setText(""+(first-second));
                        input.setText("");
                        operator.setText("/");
                    }
                    case "*" -> {
                        operand1.setText(""+(first*second));
                        input.setText("");
                        operator.setText("/");
                    }
                    case "/" -> {
                        operand1.setText(""+(first/second));
                        input.setText("");
                        operator.setText("/");
                    }
                }
            }
            if (operator.getText()=="") {
                operand1.setText(input.getText());
                input.setText("");
            }
            if (!operand1.getText().isBlank()) operator.setText("/");
        });
        add(divide);

        equals.setBounds(20, 320, 265, 45);
        equals.setText("=");
        equals.addActionListener(e -> {
            if (!operand1.getText().isBlank() && !operator.getText().isBlank() && !input.getText().isBlank()) {
                double first = Double.parseDouble(operand1.getText());
                double second = Double.parseDouble(input.getText());

                switch (operator.getText()) {
                    case "+" -> {
                        input.setText(""+(first+second));
                        operand1.setText("");
                        operator.setText("");
                    }
                    case "-" -> {
                        input.setText(""+(first-second));
                        operand1.setText("");
                        operator.setText("");
                    }
                    case "*" -> {
                        input.setText(""+(first*second));
                        operand1.setText("");
                        operator.setText("");
                    }
                    case "/" -> {
                        input.setText(""+(first/second));
                        operand1.setText("");
                        operator.setText("");
                    }
                }
            }
        });
        add(equals);

        setVisible(true);
    }
}
