import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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
    private static ArrayList<JTextArea> arr = new ArrayList<>();
    private static ArrayList<String> paths = new ArrayList<>();
    private static ArrayList<Boolean> unsaved = new ArrayList<>();

    public TextEditorFrame() {
        super("Text Editor");
        setSize(new Dimension(600, 400));
//        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        create.addActionListener(e -> {
            JTextArea text = new JTextArea();
            text.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    unsaved.set(tabs.getSelectedIndex(), true);
                    updateTabTitle(tabs.getSelectedIndex());
                }
            });
            JScrollPane textScroll = new JScrollPane(text);
            text.setLineWrap(true);
            text.setWrapStyleWord(true);
            textScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            boolean foundSpot = false;
            String title = "Untitled1";
            while (!foundSpot) {
                foundSpot = true;
                if (new File("src\\Saves\\"+title+".txt").exists()) {
                    foundSpot = false;
                    title = title.substring(0, title.length()-1)+(Integer.parseInt(title.substring(title.length()-1))+1);
                }
                for (int i = 0; i < tabs.getTabCount(); i++) {
                    if (tabs.getTitleAt(i).equals(title)) {
                        foundSpot = false;
                        title = title.substring(0, title.length()-1)+(Integer.parseInt(title.substring(title.length()-1))+1);
                        break;
                    }
                }
            }
            File f = new File("src\\Saves\\"+title+".txt");
            if (!f.exists()) {
                try {
                    f.createNewFile();
                    paths.add(f.getAbsolutePath());
                    FileWriter fw = new FileWriter(f);
                    PrintWriter pw = new PrintWriter(fw);
                    pw.println("Dialog 12");
                    fw.close();
                    pw.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

            arr.add(text);
            unsaved.add(false);

            tabs.add(title, textScroll);
            tabs.setSelectedIndex(tabs.getTabCount()-1);
        });
        file.add(create);
        open.addActionListener(e -> {
            JFileChooser fc = new JFileChooser("src\\Saves");
            FileNameExtensionFilter fnef = new FileNameExtensionFilter("(.txt)", "txt");
            fc.setFileFilter(fnef);
            int r = fc.showOpenDialog(this);
            if (r == JFileChooser.APPROVE_OPTION) {
                File f = fc.getSelectedFile();
                boolean foundSpot = true;
                for (int i = 0; i < tabs.getTabCount(); i++) {
                    if ((tabs.getTitleAt(i)+".txt").equals(f.getName())) {
                        foundSpot = false;
                        break;
                    }
                }
                if (foundSpot) {
                    JTextArea text = new JTextArea();
                    text.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyTyped(KeyEvent e) {
                            unsaved.set(tabs.getSelectedIndex(), true);
                            updateTabTitle(tabs.getSelectedIndex());
                        }
                    });
                    JScrollPane textScroll = new JScrollPane(text);
                    text.setLineWrap(true);
                    text.setWrapStyleWord(true);
                    textScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                    Font font;
                    try {
                        Scanner fs = new Scanner(f);
                        String[] d = fs.nextLine().split(" ");
                        font = new Font(d[0], Font.PLAIN, Integer.parseInt(d[1]));
                        while (fs.hasNextLine()) {
                            text.append(fs.nextLine());
                            if (fs.hasNextLine()) text.append("\n");
                        }
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }

                    tabs.add(f.getName().substring(0, f.getName().length()-4), textScroll);
                    tabs.setSelectedIndex(tabs.getTabCount()-1);
                    text.setFont(font);

                    paths.add(f.getAbsolutePath());
                    arr.add(text);
                    unsaved.add(false);
                }
            }
        });
        file.add(open);
        saveAs.addActionListener(e -> {
            JFileChooser fc = new JFileChooser("src\\Saves");
            FileNameExtensionFilter fnef = new FileNameExtensionFilter("(.txt)", "txt");
            fc.setFileFilter(fnef);
            int r = fc.showSaveDialog(this);
            if (r == JFileChooser.APPROVE_OPTION) {
                File f = fc.getSelectedFile();
                try {
                    FileWriter fw = new FileWriter(f);
                    PrintWriter pw = new PrintWriter(fw);
                    pw.println(arr.get(tabs.getSelectedIndex()).getFont().getName()+" "+arr.get(tabs.getSelectedIndex()).getFont().getSize());
                    pw.print(arr.get(tabs.getSelectedIndex()).getText());
                    fw.close();
                    pw.close();
                    String adjName = f.getName().substring(0, f.getName().length() - 4);
                    if (!adjName.equals(tabs.getTitleAt(tabs.getSelectedIndex()))) {
                        if (tabs.indexOfTab(adjName) != -1) {
                            arr.remove(tabs.indexOfTab(adjName));
                            paths.remove(f.getAbsolutePath());
                            unsaved.remove(tabs.indexOfTab(adjName));
                            tabs.remove(tabs.indexOfTab(adjName));
                        }
                        File d = new File(paths.get(tabs.getSelectedIndex()));
                        System.out.println(d.getAbsolutePath());
                        d.delete();
                        tabs.setTitleAt(tabs.getSelectedIndex(), adjName);
                        paths.set(tabs.getSelectedIndex(), f.getAbsolutePath());
                    }
                    unsaved.set(tabs.indexOfTab(adjName), false);
                    updateTabTitle(tabs.getSelectedIndex());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        saveAs.setEnabled(false);
        file.add(saveAs);
        save.addActionListener(e -> {
                File f = new File(paths.get(tabs.getSelectedIndex()));
                try {
                    FileWriter fw = new FileWriter(f);
                    PrintWriter pw = new PrintWriter(fw);
                    pw.println(arr.get(tabs.getSelectedIndex()).getFont().getName()+" "+arr.get(tabs.getSelectedIndex()).getFont().getSize());
                    pw.print(arr.get(tabs.getSelectedIndex()).getText());
                    unsaved.set(tabs.getSelectedIndex(), false);
                    updateTabTitle(tabs.getSelectedIndex());
                    fw.close();
                    pw.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
        });
        save.setEnabled(false);
        file.add(save);
        close.addActionListener(e -> {
            try {
                Scanner fs = new Scanner(new File(paths.get(tabs.getSelectedIndex())));
                StringBuilder sb = new StringBuilder();
                if (!unsaved.get(tabs.getSelectedIndex())) {
                    tabs.remove(tabs.getSelectedIndex());
                } else {
                    int selection = JOptionPane.showConfirmDialog(this, "Unsaved data will be lost. Are you sure you want to close this file?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (selection==0) {
                        arr.remove(tabs.getSelectedIndex());
                        paths.remove(tabs.getSelectedIndex());
                        tabs.remove(tabs.getSelectedIndex());
                    }
                }
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
        close.setEnabled(false);
        file.add(close);
        exit.addActionListener(e -> {
                if (!unsaved.contains(true)) {
                    System.exit(0);
                } else {
                    int selection = JOptionPane.showConfirmDialog(this, "There are files that have not been saved, unsaved data will be lost. Are you sure you want to exit?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (selection==0) {
                        System.exit(0);
                    }
                }
        });
        file.add(exit);
        mb.add(file);

        font.addActionListener(e -> {
            new TextEditorFontFrame(arr.get(tabs.getSelectedIndex()), unsaved, tabs.getSelectedIndex());
            updateTabTitle(tabs.getSelectedIndex());
        });
        font.setEnabled(false);
        edit.add(font);
        replace.addActionListener(e -> {
            new TextEditorReplaceFrame(arr.get(tabs.getSelectedIndex()), unsaved, tabs.getSelectedIndex());
            updateTabTitle(tabs.getSelectedIndex());
        });
        replace.setEnabled(false);
        edit.add(replace);
        wordCount.addActionListener(e -> {
            String text = arr.get(tabs.getSelectedIndex()).getText();
            JOptionPane.showMessageDialog(this, "Word Count: "+ (text.isBlank() ? 0 : text.split("[\n ]+").length));
        });
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

    private void updateTabTitle(int index) {
        String title = tabs.getTitleAt(index);

        if (title.endsWith("*")) {
            title = title.substring(0, title.length() - 1);
        }

        if (unsaved.get(index)) {
            title += "*";
        }

        tabs.setTitleAt(index, title);
    }
}
