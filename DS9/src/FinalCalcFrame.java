import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.NumberFormat;

public class FinalCalcFrame extends JFrame {
    public FinalCalcFrame() {
        super("Final Calculator");
        setLayout(null);
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("Dialog", Font.BOLD, 24);
        NumberFormatter formatter = new NumberFormatter(NumberFormat.getIntegerInstance());
        formatter.setValueClass(Integer.class);
        formatter.setAllowsInvalid(false);
        formatter.setCommitsOnValidEdit(true);
        formatter.setMinimum(0);
        formatter.setMaximum(100);

        JLabel termWeight = new JLabel();
        JLabel finalWeight = new JLabel();
        JLabel gradeWanted = new JLabel();
        JLabel terms = new JLabel();
        JFormattedTextField textTermWeight = new JFormattedTextField(formatter);
        JFormattedTextField textFinalWeight = new JFormattedTextField(formatter);
        JFormattedTextField textGradeWanted = new JFormattedTextField(formatter);
        JComboBox<Integer> comboTerms = new JComboBox<>();

        {
            termWeight.setBounds(30, 30, 269, 40);
            termWeight.setText("Total Term Weight:");
            termWeight.setFont(font);
            add(termWeight);

            textTermWeight.setBounds(300, 30, 270, 40);
            textTermWeight.setEditable(true);
            textTermWeight.setFont(font);
            add(textTermWeight);
        } //Term Weight

        {
            finalWeight.setBounds(30, 90, 269, 40);
            finalWeight.setText("Final Weight:");
            finalWeight.setFont(font);
            add(finalWeight);

            textFinalWeight.setBounds(300, 90, 270, 40);
            textFinalWeight.setEditable(true);
            textFinalWeight.setFont(font);
            add(textFinalWeight);
        } //Final Weight

        {
            terms.setBounds(30, 150, 269, 40);
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
                        System.out.println("Hi people");
                    }
                }
            });
            comboTerms.setFont(font);
            add(comboTerms);
        } //Terms

        {
            gradeWanted.setBounds(30, 210, 269, 40);
            gradeWanted.setText("Grade Wanted:");
            gradeWanted.setFont(font);
            add(gradeWanted);

            textGradeWanted.setBounds(300, 210, 270, 40);
            textGradeWanted.setEditable(true);
            textGradeWanted.setFont(font);
            add(textGradeWanted);
        } //Grade Wanted

        setVisible(true);
    }
}
