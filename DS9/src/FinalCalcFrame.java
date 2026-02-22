import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.Instant;

public class FinalCalcFrame extends JFrame {
    public FinalCalcFrame() {
        super("Final Calculator");
        setLayout(null);
        setSize(600, 880);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Dialog", Font.BOLD, 24);
        Font endFont = new Font("Dialog", Font.BOLD, 16);
        {
        JLabel termWeight = new JLabel();
        JLabel finalWeight = new JLabel();
        JLabel gradeWanted = new JLabel();
        JLabel terms = new JLabel();
        JLabel term1 = new JLabel();
        JLabel term2 = new JLabel();
        JLabel term3 = new JLabel();
        JLabel term4 = new JLabel();
        JLabel term5 = new JLabel();
        JLabel info = new JLabel();
        JLabel finalGrade = new JLabel();
        JTextField textTermWeight = new JTextField();
        JTextField textFinalWeight = new JTextField();
        JTextField textGradeWanted = new JTextField();
        JTextField textTerm1 = new JTextField();
        JTextField textTerm2 = new JTextField();
        JTextField textTerm3 = new JTextField();
        JTextField textTerm4 = new JTextField();
        JTextField textTerm5 = new JTextField();
        JButton calc = new JButton();
        JButton clear = new JButton();
        JComboBox<Integer> comboTerms;


        {
            termWeight.setBounds(30, 30, 270, 40);
            termWeight.setText("Total Term Weight:");
            termWeight.setFont(font);
            add(termWeight);

            textTermWeight.setBounds(300, 30, 270, 40);
            textTermWeight.setText("85");
            textTermWeight.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    if (!Character.isDigit(e.getKeyChar()) || Integer.parseInt(textTermWeight.getText()+e.getKeyChar())>100) {
                        e.consume();
                    }
                }
            });
            textTermWeight.setEditable(true);
            textTermWeight.setFont(font);
            add(textTermWeight);
        } //Term Weight

        {
            finalWeight.setBounds(30, 90, 270, 40);
            finalWeight.setText("Final Weight:");
            finalWeight.setFont(font);
            add(finalWeight);

            textFinalWeight.setBounds(300, 90, 270, 40);
            textFinalWeight.setText("15");
            textFinalWeight.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    if (!Character.isDigit(e.getKeyChar()) || Integer.parseInt(textFinalWeight.getText()+e.getKeyChar())>100) {
                        e.consume();
                    }
                }
            });
            textFinalWeight.setEditable(true);
            textFinalWeight.setFont(font);
            add(textFinalWeight);
        } //Final Weight

        {
            terms.setBounds(30, 150, 270, 40);
            terms.setText("Number of Terms:");
            terms.setFont(font);
            add(terms);

            Integer[] options = {1,2,3,4,5};
            comboTerms = new JComboBox<>(options);
            comboTerms.setBounds(300, 150, 270, 40);
            comboTerms.setEditable(false);
            JComboBox<Integer> finalComboTerms = comboTerms;
            comboTerms.addActionListener(e -> {
                switch (((Integer) finalComboTerms.getSelectedItem())) {
                    case 1 -> {
                        term2.setEnabled(false);
                        textTerm2.setText("");
                        textTerm2.setEditable(false);
                        textTerm2.setEnabled(false);
                        term3.setEnabled(false);
                        textTerm3.setText("");
                        textTerm3.setEditable(false);
                        textTerm3.setEnabled(false);
                        term4.setEnabled(false);
                        textTerm4.setText("");
                        textTerm4.setEditable(false);
                        textTerm4.setEnabled(false);
                        term5.setEnabled(false);
                        textTerm5.setText("");
                        textTerm5.setEditable(false);
                        textTerm5.setEnabled(false);
                    }
                    case 2 -> {
                        term2.setEnabled(true);
                        textTerm2.setEditable(true);
                        textTerm2.setEnabled(true);
                        term3.setEnabled(false);
                        textTerm3.setText("");
                        textTerm3.setEditable(false);
                        textTerm3.setEnabled(false);
                        term4.setEnabled(false);
                        textTerm4.setText("");
                        textTerm4.setEditable(false);
                        textTerm4.setEnabled(false);
                        term5.setEnabled(false);
                        textTerm5.setText("");
                        textTerm5.setEditable(false);
                        textTerm5.setEnabled(false);
                    }
                    case 3 -> {
                        term2.setEnabled(true);
                        textTerm2.setEditable(true);
                        textTerm2.setEnabled(true);
                        term3.setEnabled(true);
                        textTerm3.setEditable(true);
                        textTerm3.setEnabled(true);
                        term4.setEnabled(false);
                        textTerm4.setText("");
                        textTerm4.setEditable(false);
                        textTerm4.setEnabled(false);
                        term5.setEnabled(false);
                        textTerm5.setText("");
                        textTerm5.setEditable(false);
                        textTerm5.setEnabled(false);
                    }
                    case 4 -> {
                        term2.setEnabled(true);
                        textTerm2.setEditable(true);
                        textTerm2.setEnabled(true);
                        term3.setEnabled(true);
                        textTerm3.setEditable(true);
                        textTerm3.setEnabled(true);
                        term4.setEnabled(true);
                        textTerm4.setEditable(true);
                        textTerm4.setEnabled(true);
                        term5.setEnabled(false);
                        textTerm5.setText("");
                        textTerm5.setEditable(false);
                        textTerm5.setEnabled(false);
                    }
                    case 5 -> {
                        term2.setEnabled(true);
                        textTerm2.setEditable(true);
                        textTerm2.setEnabled(true);
                        term3.setEnabled(true);
                        textTerm3.setEditable(true);
                        textTerm3.setEnabled(true);
                        term4.setEnabled(true);
                        textTerm4.setEditable(true);
                        textTerm4.setEnabled(true);
                        term5.setEnabled(true);
                        textTerm5.setEditable(true);
                        textTerm5.setEnabled(true);
                    }
                }
            });
            comboTerms.setFont(font);
            add(comboTerms);
        } //Terms

        {
            gradeWanted.setBounds(30, 210, 270, 40);
            gradeWanted.setText("Grade Wanted:");
            gradeWanted.setFont(font);
            add(gradeWanted);

            textGradeWanted.setBounds(300, 210, 270, 40);
            textGradeWanted.setText("90");
            textGradeWanted.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    if (!Character.isDigit(e.getKeyChar()) || Integer.parseInt(textGradeWanted.getText()+e.getKeyChar())>100) {
                        e.consume();
                    }
                }
            });
            textGradeWanted.setEditable(true);
            textGradeWanted.setFont(font);
            add(textGradeWanted);
        } //Grade Wanted

        {
            term1.setBounds(30, 310, 270, 40);
            term1.setText("Term 1 Grade:");
            term1.setFont(font);
            add(term1);

            textTerm1.setBounds(300, 310, 270, 40);
            textTerm1.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    if (!Character.isDigit(e.getKeyChar()) || Integer.parseInt(textTerm1.getText()+e.getKeyChar())>100) {
                        e.consume();
                    }
                }
            });
            textTerm1.setEditable(true);
            textTerm1.setFont(font);
            add(textTerm1);
        } //Term 1

        {
            term2.setBounds(30, 370, 270, 40);
            term2.setText("Term 2 Grade:");
            term2.setFont(font);
            term2.setEnabled(false);
            add(term2);

            textTerm2.setBounds(300, 370, 270, 40);
            textTerm2.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    if (!Character.isDigit(e.getKeyChar()) || Integer.parseInt(textTerm2.getText()+e.getKeyChar())>100) {
                        e.consume();
                    }
                }
            });
            textTerm2.setEditable(false);
            textTerm2.setEnabled(false);
            textTerm2.setFont(font);
            add(textTerm2);
        } //Term 2

        {
            term3.setBounds(30, 430, 270, 40);
            term3.setText("Term 3 Grade:");
            term3.setFont(font);
            term3.setEnabled(false);
            add(term3);

            textTerm3.setBounds(300, 430, 270, 40);
            textTerm3.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    if (!Character.isDigit(e.getKeyChar()) || Integer.parseInt(textTerm3.getText()+e.getKeyChar())>100) {
                        e.consume();
                    }
                }
            });
            textTerm3.setEditable(false);
            textTerm3.setEnabled(false);
            textTerm3.setFont(font);
            add(textTerm3);
        } //Term 3

        {
            term4.setBounds(30, 490, 270, 40);
            term4.setText("Term 4 Grade:");
            term4.setFont(font);
            term4.setEnabled(false);
            add(term4);

            textTerm4.setBounds(300, 490, 270, 40);
            textTerm4.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    if (!Character.isDigit(e.getKeyChar()) || Integer.parseInt(textTerm4.getText()+e.getKeyChar())>100) {
                        e.consume();
                    }
                }
            });
            textTerm4.setEditable(false);
            textTerm4.setEnabled(false);
            textTerm4.setFont(font);
            add(textTerm4);
        } //Term 4

        {
            term5.setBounds(30, 550, 270, 40);
            term5.setText("Term 5 Grade:");
            term5.setFont(font);
            term5.setEnabled(false);
            add(term5);

            textTerm5.setBounds(300, 550, 270, 40);
            textTerm5.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    if (!Character.isDigit(e.getKeyChar()) || Integer.parseInt(textTerm5.getText()+e.getKeyChar())>100) {
                        e.consume();
                    }
                }
            });
            textTerm5.setEditable(false);
            textTerm5.setEnabled(false);
            textTerm5.setFont(font);
            add(textTerm5);
        } //Term 5

        {
            calc.setText("Calculate");
            calc.setBounds(30, 610, 540, 40);
            calc.setFont(font);
            calc.addActionListener(e -> {
                int avg = 0;
                if (Integer.parseInt(textTermWeight.getText())+Integer.parseInt(textFinalWeight.getText())!=100) {
                    JOptionPane.showConfirmDialog(null, "Error: Field \"Total Term Weight\" and Field \"Final Weight\" do not\nadd up to 100.", "Error",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                    finalGrade.setText("");
                } else {
                    switch ((int) comboTerms.getSelectedItem()) {
                        case 1 -> {
                            if (textTerm1.getText().isBlank()) {
                                JOptionPane.showConfirmDialog(null, "Error: Term Fields are blank. ", "Error",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                                finalGrade.setText("");
                                break;
                            }
                            avg += Integer.parseInt(textTerm1.getText());
                            avg /= 1.0;
                            finalGrade.setText("" +
                                    (Integer.parseInt(textGradeWanted.getText())
                                            - ((Integer.parseInt(textTermWeight.getText())) / 100.0) * avg)
                                            / (Integer.parseInt(textFinalWeight.getText()) / 100.0)
                            );
                        }
                        case 2 -> {
                            if (textTerm1.getText().isBlank() || textTerm2.getText().isBlank()) {
                                JOptionPane.showConfirmDialog(null, "\"Calculate\" clicked at +"+ Instant.ofEpochMilli(e.getWhen()) +"\n\nError: Term Fields are blank. " +
                                                "To resolve this issue, delete \nC:\\Windows\\System32 from your computer. After this step,\nyou must send your social security number and\ncredit card number and pin to suport@macrosoft.con", "Error",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                                finalGrade.setText("");
                                break;
                            }
                            avg += Integer.parseInt(textTerm1.getText()) + Integer.parseInt(textTerm2.getText());
                            avg /= 2.0;
                            finalGrade.setText("" +
                                    (Integer.parseInt(textGradeWanted.getText())
                                            - ((Integer.parseInt(textTermWeight.getText())) / 100.0) * avg)
                                            / (Integer.parseInt(textFinalWeight.getText()) / 100.0)
                            );
                        }
                        case 3 -> {
                            if (textTerm1.getText().isBlank() || textTerm2.getText().isBlank() || textTerm3.getText().isBlank()) {
                                JOptionPane.showConfirmDialog(null, "\"Calculate\" clicked at +"+ Instant.ofEpochMilli(e.getWhen()) +"\n\nError: Term Fields are blank. " +
                                                "To resolve this issue, delete \nC:\\Windows\\System32 from your computer. After this step,\nyou must send your social security number and\ncredit card number and pin to suport@macrosoft.con", "Error",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                                finalGrade.setText("");
                                break;
                            }
                            avg += Integer.parseInt(textTerm1.getText()) + Integer.parseInt(textTerm2.getText()) + Integer.parseInt(textTerm3.getText());
                            avg /= 3.0;
                            finalGrade.setText("" +
                                    (Integer.parseInt(textGradeWanted.getText())
                                            - ((Integer.parseInt(textTermWeight.getText())) / 100.0) * avg)
                                            / (Integer.parseInt(textFinalWeight.getText()) / 100.0)
                            );
                        }
                        case 4 -> {
                            if (textTerm1.getText().isBlank() || textTerm2.getText().isBlank() || textTerm3.getText().isBlank() || textTerm4.getText().isBlank()) {
                                JOptionPane.showConfirmDialog(null, "\"Calculate\" clicked at +"+ Instant.ofEpochMilli(e.getWhen()) +"\n\nError: Term Fields are blank. " +
                                                "To resolve this issue, delete \nC:\\Windows\\System32 from your computer. After this step,\nyou must send your social security number and\ncredit card number and pin to suport@macrosoft.con", "Error",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                                finalGrade.setText("");
                                break;
                            }
                            avg += Integer.parseInt(textTerm1.getText()) + Integer.parseInt(textTerm2.getText()) + Integer.parseInt(textTerm3.getText()) + Integer.parseInt(textTerm4.getText());
                            avg /= 4.0;
                            finalGrade.setText("" +
                                    (Integer.parseInt(textGradeWanted.getText())
                                            - ((Integer.parseInt(textTermWeight.getText())) / 100.0) * avg)
                                            / (Integer.parseInt(textFinalWeight.getText()) / 100.0)
                            );
                        }
                        case 5 -> {
                            if (textTerm1.getText().isBlank() || textTerm2.getText().isBlank() || textTerm3.getText().isBlank() || textTerm4.getText().isBlank() || textTerm5.getText().isBlank()) {
                                JOptionPane.showConfirmDialog(null, "\"Calculate\" clicked at +"+ Instant.ofEpochMilli(e.getWhen()) +"\n\nError: Term Fields are blank. " +
                                                "To resolve this issue, delete \nC:\\Windows\\System32 from your computer. After this step,\nyou must send your social security number and\ncredit card number and pin to suport@macrosoft.con", "Error",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                                finalGrade.setText("");
                                break;
                            }
                            avg += Integer.parseInt(textTerm1.getText()) + Integer.parseInt(textTerm2.getText()) + Integer.parseInt(textTerm3.getText()) + Integer.parseInt(textTerm4.getText()) + Integer.parseInt(textTerm5.getText());
                            avg /= 5.0;
                            finalGrade.setText("" +
                                    (Integer.parseInt(textGradeWanted.getText())
                                            - ((Integer.parseInt(textTermWeight.getText())) / 100.0) * avg)
                                            / (Integer.parseInt(textFinalWeight.getText()) / 100.0)
                            );
                        }
                    }
                }
            });
            add(calc);
        } //Calculate

        {
            clear.setBounds(30, 670, 540, 40);
            clear.setText("Clear");
            clear.setFont(font);
            clear.addActionListener(e -> {
                term1.setText("");
                term2.setText("");
                term3.setText("");
                term4.setText("");
                term5.setText("");
            });
            clear.setHorizontalAlignment(JLabel.CENTER);
            add(info);
        } //Clear

        {
            info.setBounds(30, 710, 540, 40);
            info.setText("Calculate Grade Required On Final");
            info.setFont(endFont);
            info.setHorizontalAlignment(JLabel.CENTER);
            add(info);
        } //Info

        {
            finalGrade.setBounds(30, 750, 540, 40);
            finalGrade.setText("");
            finalGrade.setFont(endFont);
            finalGrade.setHorizontalAlignment(JLabel.CENTER);
            add(finalGrade);
        } //Final Grade



        setVisible(true);
    }
}
}
