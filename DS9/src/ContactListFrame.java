import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactListFrame extends JFrame {
    public ContactListFrame() throws IOException {
        super("Rolodex");
        setSize(1000, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font large = new Font("Dialog", Font.BOLD, 36);
        Font medium = new Font("Dialog", Font.BOLD, 28);
        Font small = new Font("Dialog", Font.BOLD, 18);
        JLabel contacts = new JLabel("Contacts:");
        JList<Person> list = new JList<>();
        JScrollPane scroll = new JScrollPane(list);
        ArrayList<Person> array = new ArrayList<>();

        File save = new File("src/Rolodex.txt");
        if (!save.exists()) save.createNewFile();
        else {
            Scanner sc = new Scanner(save);
            while (sc.hasNextLine()) {
                Scanner scl = new Scanner(sc.nextLine());
                switch (Integer.parseInt(scl.next())) {
                    case 1 :
                        array.add(new Person(scl.next(), scl.next()));
                        break;
                    case 2 :
                        array.add(new Person(scl.next(), scl.next(), Long.parseLong(scl.next())));
                        break;
                    case 3 :
                        array.add(new Person(scl.next(), scl.next(), scl.next()));
                        break;
                    case 4 :
                        array.add(new Person(scl.next(), scl.next(), Long.parseLong(scl.next()), scl.next()));
                        break;
                }
            }
        }
        System.out.println(array);

        contacts.setFont(medium);
        contacts.setBounds(20, 20, 460, 30);
        add(contacts);

        scroll.setBounds(20, 60, 460, 460);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scroll);

        setVisible(true);
    }
}
