import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TextEditorFrame extends JFrame {
    private static JTabbedPane tabs = new JTabbedPane();
    private static JMenuBar mb = new JMenuBar();
    private static JMenu file = new JMenu("File");
    private static JMenu edit = new JMenu("Edit");
    private static JMenuItem create = new JMenuItem("Create");
    private static JMenuItem open = new JMenuItem("Open");
    private static JMenuItem saveAs = new JMenuItem("Save As");
    private static JMenuItem save = new JMenuItem("Save");
    private static JMenuItem close = new JMenuItem("Close");
    private static JMenuItem exit = new JMenuItem("Exit");
    private static JMenuItem font = new JMenuItem("Font");
    private static JMenuItem replace = new JMenuItem("Replace");
    private static JMenuItem wordCount = new JMenuItem("Word Count");

    public TextEditorFrame() {
        super("Text Editor");
        setSize(new Dimension(600, 400));
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        create.addActionListener(e -> {
            JTextArea text = new JTextArea();
            JScrollPane textScroll = new JScrollPane(text);
            text.setLineWrap(true);
            textScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            boolean foundSpot = false;
            String title = "Untitled1";
            while (!foundSpot) {
                foundSpot = true;
                for (int i = 0; i < tabs.getTabCount(); i++) {
                    if (tabs.getTitleAt(i).equals(title)) {
                        foundSpot = false;
                        title = title.substring(0, title.length()-1)+(Integer.parseInt(title.substring(title.length()-1))+1);
                        break;
                    }
                }

            }
            File f = new File("C:\\Users\\k2420213\\OneDrive - Katy Independent School District\\Github\\DataStructures\\DS9\\src\\Saves\\"+title+".txt");
            if (!f.exists()) {
                try {
                    f.createNewFile();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

            tabs.add(title, textScroll);
        });
        file.add(create);
        open.addActionListener(e -> {
            JFileChooser fc = new JFileChooser("C:\\Users\\k2420213\\OneDrive - Katy Independent School District\\Github\\DataStructures\\DS9\\src\\Saves");
            FileNameExtensionFilter fnef = new FileNameExtensionFilter("(.txt)", "txt");
            fc.setFileFilter(fnef);
            int r = fc.showOpenDialog(this);
            if (r == JFileChooser.APPROVE_OPTION) {
                File f = fc.getSelectedFile();
                JTextArea text = new JTextArea();
                JScrollPane textScroll = new JScrollPane(text);
                text.setLineWrap(true);
                textScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                tabs.add(f.getName(), textScroll);
            }
        });
        file.add(open);
        saveAs.setEnabled(false);
        file.add(saveAs);
        save.setEnabled(false);
        file.add(save);
        close.setEnabled(false);
        file.add(close);
        exit.addActionListener(e -> {

        });
        file.add(exit);
        mb.add(file);

        font.setEnabled(false);
        edit.add(font);
        replace.setEnabled(false);
        edit.add(replace);
        wordCount.setEnabled(false);
        edit.add(wordCount);
        mb.add(edit);

        tabs.setBounds(0, 0, 585, 340);
        tabs.addChangeListener(e -> {
            if (tabs.getTabCount()>0) {
                saveAs.setEnabled(true);
                save.setEnabled(true);
                close.setEnabled(true);
                font.setEnabled(true);
                replace.setEnabled(true);
                wordCount.setEnabled(true);
            }
            else {
                saveAs.setEnabled(false);
                save.setEnabled(false);
                close.setEnabled(false);
                font.setEnabled(false);
                replace.setEnabled(false);
                wordCount.setEnabled(false);
            }
        });
        add(tabs);

        setJMenuBar(mb);
        setVisible(true);
    }
}
