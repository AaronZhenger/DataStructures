import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ContactListFrame extends JFrame {
    public ContactListFrame() throws IOException {
        super("Rolodex");
        setSize(1000, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font large = new Font("Dialog", Font.BOLD, 36);
        Font medium = new Font("Dialog", Font.BOLD, 28);
        Font small = new Font("Dialog", Font.PLAIN, 18);
        JLabel contacts = new JLabel("Contacts:");
        JLabel firstName = new JLabel("First Name:");
        JLabel lastName = new JLabel("Last Name:");
        JLabel phoneNumber = new JLabel("Phone Number:");
        JLabel address = new JLabel("Address:");
        JTextField textFirstName = new JTextField();
        JTextField textLastName = new JTextField();
        JTextField textPhoneNumber = new JTextField();
        JTextField textAddress = new JTextField();
        JButton kSave = new JButton("Save");
        JButton kNew = new JButton("New");
        JButton kSaveContact = new JButton("Save Contact");
        JButton kDeleteContact = new JButton("Delete Contact");
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
                        array.add(new Person(scl.next(), scl.next(), scl.nextLine().substring(1)));
                        break;
                    case 4 :
                        array.add(new Person(scl.next(), scl.next(), Long.parseLong(scl.next()), scl.nextLine().substring(1)));
                        break;
                }
            }
        }
        System.out.println(array);

        contacts.setFont(medium);
        contacts.setBounds(20, 20, 300, 30);
        add(contacts);

        scroll.setBounds(20, 60, 300, 400);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        list.addListSelectionListener(e -> {
            if (list.getSelectedIndex()==-1) {
                kSave.setVisible(true);
                kNew.setVisible(true);
                textFirstName.setText("");
                textLastName.setText("");
                textPhoneNumber.setText("");
                textAddress.setText("");
            } else {
                kSave.setVisible(false);
                kNew.setVisible(false);
                textFirstName.setText(array.get(list.getSelectedIndex()).getF());
                textLastName.setText(array.get(list.getSelectedIndex()).getL());
                textPhoneNumber.setText(""+array.get(list.getSelectedIndex()).getN());
                textAddress.setText(array.get(list.getSelectedIndex()).getA());
            }
        });
        Collections.sort(array);
        list.setListData(array.toArray(new Person[0]));
        add(scroll);

        firstName.setBounds(340, 90, 300, 30);
        firstName.setFont(medium);
        add(firstName);

        lastName.setBounds(340, 150, 300, 30);
        lastName.setFont(medium);
        add(lastName);

        phoneNumber.setBounds(340, 210, 300, 30);
        phoneNumber.setFont(medium);
        add(phoneNumber);

        address.setBounds(340, 270, 300, 30);
        address.setFont(medium);
        add(address);

        textFirstName.setBounds(640, 90, 300, 30);
        textFirstName.setFont(small);
        add(textFirstName);

        textLastName.setBounds(640, 150, 300, 30);
        textLastName.setFont(small);
        add(textLastName);

        textPhoneNumber.setBounds(640, 210, 300, 30);
        textPhoneNumber.setFont(small);
        add(textPhoneNumber);

        textAddress.setBounds(640, 270, 300, 30);
        textAddress.setFont(small);
        add(textAddress);

        kSave.setFont(medium);
        kSave.setBounds(540, 360, 120, 40);
        kSave.addActionListener(e -> {
            if (textFirstName.getText().isBlank()||textLastName.getText().isBlank()) {
                JOptionPane.showMessageDialog(this, "You must enter a first and last name", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (textPhoneNumber.getText().isBlank())
                    if (textAddress.getText().isBlank())
                        array.add(new Person(textFirstName.getText(), textLastName.getText()));
                    else array.add(new Person(textFirstName.getText(), textLastName.getText(), textAddress.getText()));
                else if (textAddress.getText().isBlank())
                    array.add(new Person(textFirstName.getText(), textLastName.getText(), Long.parseLong(textPhoneNumber.getText())));
                else array.add(new Person(textFirstName.getText(), textLastName.getText(), Long.parseLong(textPhoneNumber.getText()), textAddress.getText()));

                textFirstName.setText("");
                textLastName.setText("");
                textPhoneNumber.setText("");
                textAddress.setText("");
                Collections.sort(array);
                list.setListData(array.toArray(new Person[0]));
                try {
                    printTxt(array);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        add(kSave);

        kNew.setFont(medium);
        kNew.setBounds(680, 360, 120, 40);
        kNew.addActionListener(e -> {
            array.clear();
            list.setListData(array.toArray(new Person[0]));
            try {
                printTxt(array);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        add(kNew);

        setVisible(true);
    }

    private void printTxt(ArrayList<Person> array) throws IOException {
        FileWriter fw = new FileWriter("src/Rolodex.txt");
        PrintWriter pw = new PrintWriter(fw);

        for (Person person : array) {
            if (person.getN()==Long.MAX_VALUE)
                if (person.getA()==null)
                    pw.println("1 "+person.getF()+" "+person.getL());
                else
                    pw.println("3 "+person.getF()+" "+person.getL()+" "+person.getA());
            else if (person.getA()==null)
                pw.println("2 "+person.getF()+" "+person.getL()+" "+person.getN());
            else
                pw.println("4 "+person.getF()+" "+person.getL()+" "+person.getN()+" "+person.getA());
        }

        fw.close();
        pw.close();
    }
}
