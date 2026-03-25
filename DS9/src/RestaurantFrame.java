import javax.swing.*;
import java.awt.*;

public class RestaurantFrame extends JFrame {
    public static final Font large = new Font(Font.DIALOG, Font.BOLD, 36);
    public static final Font medium = new Font(Font.DIALOG, Font.BOLD, 24);
    public static final Font small = new Font(Font.DIALOG, Font.PLAIN, 18);

    public static final JMenuBar mb = new JMenuBar();
    public static final JMenu m_menu = new JMenu("Menu");
    public static final JMenuItem mi_appetizers = new JMenuItem("Appetizers");
    public static final JMenuItem mi_entrees = new JMenuItem("Entrees");
    public static final JMenuItem mi_desserts = new JMenuItem("Desserts");
    public static final JMenu m_checkOut = new JMenu("Check Out");
    public static final JMenuItem mi_viewCart = new JMenuItem("View Cart");

    public static final JPanel p_appetizers = new JPanel();
    public static final JPanel p_entrees = new JPanel();
    public static final JPanel p_desserts = new JPanel();

    public static final JScrollPane s_appetizers = new JScrollPane(p_appetizers);
    public static final JScrollPane s_entrees = new JScrollPane(p_entrees);
    public static final JScrollPane s_desserts = new JScrollPane(p_desserts);

    public static final JLabel l_appetizers = new JLabel("Appetizers");
    public static final JLabel l_entrees = new JLabel("Entrees");
    public static final JLabel l_desserts = new JLabel("Desserts");

    public static final JPanel p_wildBread = new JPanel();
    public static final JLabel l_wildBread = new JLabel("Wild Bread® ($3.98)");
    public static final JLabel d_wildBread = new JLabel("<html>Eight margarine garlic flavored bread sticks, sprinkled with cheddar cheese and served with Wild Sauce®</html>");
    public static final ImageIcon ic_wildBread = new ImageIcon(new ImageIcon("src\\Images\\wildBread.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    public static final JLabel i_wildBread = new JLabel(ic_wildBread);
    public static final JTextField n_wildBread = new JTextField("0");
    public static final JButton a_wildBread = new JButton("+");
    public static final JButton r_wildBread = new JButton("-");

    public static final JPanel p_spanishQB = new JPanel();
    public static final JLabel l_spanishQB = new JLabel("Spanish Queso Bread ($3.98)");
    public static final JLabel d_spanishQB = new JLabel("<html>Eight margarine garlic flavored bread sticks, sprinkled with cheddar cheese and served with Wild Sauce®</html>");
    public static final ImageIcon ic_spanishQB = new ImageIcon(new ImageIcon("src\\Images\\wildBread.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    public static final JLabel i_spanishQB = new JLabel(ic_spanishQB);
    public static final JTextField n_spanishQB = new JTextField("0");
    public static final JButton a_spanishQB = new JButton("+");
    public static final JButton r_spanishQB = new JButton("-");

    public RestaurantFrame() {
        super("Big Julius'");
        setSize(620, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        {
            m_menu.add(mi_appetizers);
            m_menu.add(mi_entrees);
            m_menu.add(mi_desserts);
            mb.add(m_menu);
            m_checkOut.add(mi_viewCart);
            mb.add(m_checkOut);
            setJMenuBar(mb);
        } // Menu

        {
            p_appetizers.setLayout(null);
            {
                l_appetizers.setFont(large);
                l_appetizers.setHorizontalAlignment(JLabel.CENTER);
                l_appetizers.setBounds(0, 0, 600, 40);

                p_wildBread.setBackground(Color.WHITE);
                p_wildBread.setLayout(null);
                p_wildBread.setBounds(20, 50, 560, 180);
                l_wildBread.setBounds(20, 20, 520, 30);
                l_wildBread.setFont(medium);
                p_wildBread.add(l_wildBread);
                i_wildBread.setBounds(20, 60, 100, 100);
                p_wildBread.add(i_wildBread);
                d_wildBread.setBounds(140, 60, 320, 100);
                p_wildBread.add(d_wildBread);
                n_wildBread.setBounds(438, 20, 46, 46);
                n_wildBread.setEnabled(false);
                n_wildBread.setHorizontalAlignment(JTextField.CENTER);
                p_wildBread.add(n_wildBread);
                a_wildBread.setBounds(494, 20, 46, 46);
                a_wildBread.addActionListener(e -> {
                    n_wildBread.setText("" + (Integer.parseInt(n_wildBread.getText()) + 1));
                    if (Integer.parseInt(n_wildBread.getText()) > 0) r_wildBread.setEnabled(true);
                });
                p_wildBread.add(a_wildBread);
                r_wildBread.setBounds(382, 20, 46, 46);
                r_wildBread.setEnabled(false);
                r_wildBread.addActionListener(e -> {
                    n_wildBread.setText("" + (Integer.parseInt(n_wildBread.getText()) - 1));
                    if (Integer.parseInt(n_wildBread.getText()) <= 0) r_wildBread.setEnabled(false);
                });


                p_wildBread.add(r_wildBread);
                p_wildBread.add(i_wildBread);
                p_appetizers.add(p_wildBread);
            } // Wild Bread

            p_appetizers.add(l_appetizers);

            s_appetizers.setVisible(true);
            add(s_appetizers);
        } // Appetizers

        setVisible(true);
    }
}
