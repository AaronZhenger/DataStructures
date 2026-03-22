import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class TextEditorFontFrame extends JFrame {
    String[] arr = {Font.DIALOG, Font.DIALOG_INPUT, Font.MONOSPACED, Font.SANS_SERIF, Font.SERIF};
    JComboBox<String> fonts = new JComboBox<>(arr);
    JTextField size;
    JLabel lFont = new JLabel("Font:");
    JLabel lSize = new JLabel("Size:");
    JButton save = new JButton("Save");
    JButton cancel = new JButton("Cancel");

    public TextEditorFontFrame(JTextArea ta, ArrayList<Boolean> unsaved, int index) {
        super("Font");
        setSize(200, 300);
        setLayout(null);

        lFont.setBounds(20, 20, 140, 20);
        add(lFont);
        fonts.setSelectedIndex(List.of(arr).indexOf(ta.getFont().getName()));
        fonts.setBounds(20, 40, 140, 30);
        add(fonts);

        lSize.setBounds(20, 90, 140, 20);
        add(lSize);
        size = new JTextField(""+ta.getFont().getSize());
        size.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar()))
                    e.consume();
            }
        });
        size.setBounds(20, 110, 140, 30);
        add(size);

        save.addActionListener(e -> {
            ta.setFont(new Font(arr[fonts.getSelectedIndex()], Font.PLAIN, Integer.parseInt(size.getText())));
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
