import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class TextEditorReplaceFrame extends JFrame {
    public static JLabel replace = new JLabel("Replace:");
    public static JLabel replacement = new JLabel("Replacement Text:");
    public static JTextField tReplace = new JTextField();
    public static JTextField tReplacement = new JTextField();
    JButton save = new JButton("Replace");
    JButton cancel = new JButton("Cancel");

    public TextEditorReplaceFrame(JTextArea ta, ArrayList<Boolean> unsaved, int index) {
        super("Replace");
        setSize(200, 300);
        setLayout(null);

        replace.setBounds(20, 20, 140, 20);
        add(replace);
        tReplace.setBounds(20, 40, 140, 30);
        add(tReplace);

        replacement.setBounds(20, 90, 140, 20);
        add(replacement);
        tReplacement = new JTextField();
        tReplacement.setBounds(20, 110, 140, 30);
        add(tReplacement);

        save.addActionListener(e -> {
            ta.setText(ta.getText().replace(tReplace.getText(), tReplacement.getText()));
            unsaved.set(index, true);
            dispose();
        });
        save.setBounds(20, 160, 140, 30);
        add(save);

        cancel.addActionListener(e -> {
            dispose();
        });
        cancel.setBounds(20, 210, 140, 30);
        add(cancel);

        setVisible(true);
    }
}
