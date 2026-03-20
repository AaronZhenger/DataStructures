import javax.swing.*;
import java.awt.*;

public class TextEditorFontFrame extends JFrame {
    String[] arr = {Font.DIALOG, Font.DIALOG_INPUT, Font.MONOSPACED, Font.SANS_SERIF, Font.SERIF};
    JComboBox<String> fonts = new JComboBox<>(arr);
    JTextField size;

    public TextEditorFontFrame(int Siz) {
        super("Font");
        setSize(200, 300);
        setLayout(null);

        fonts.setBounds(20, 40, 140, 40);
        add(fonts);

        size = new JTextField()



        setVisible(true);
    }
}
