import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ContactListFrame extends JFrame {
    public ContactListFrame() throws IOException {
        super("Rolodex");
        setSize(900, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JList<Person> list = new JList<>();
        JScrollPane scroll = new ScrollPane(list);

        File save = new File("src/Rolodex.txt");
        if (!save.exists()) save.createNewFile();

        setVisible(true);
    }
}
