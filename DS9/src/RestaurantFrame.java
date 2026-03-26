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
    public static final JLabel l_spanishQB = new JLabel("Spanish Queso Bread ($6.48)");
    public static final JLabel d_spanishQB = new JLabel("<html>Ten pieces of freshly baked bread with a crispy edge, topped with buttery-garlic flavored drizzle, covered with queso, and finished with Spanish spices.</html>");
    public static final ImageIcon ic_spanishQB = new ImageIcon(new ImageIcon("src\\Images\\sqb.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    public static final JLabel i_spanishQB = new JLabel(ic_spanishQB);
    public static final JTextField n_spanishQB = new JTextField("0");
    public static final JButton a_spanishQB = new JButton("+");
    public static final JButton r_spanishQB = new JButton("-");

    public static final JPanel p_juliusWings = new JPanel();
    public static final JLabel l_juliusWings = new JLabel("Julius Wings® ($8.98)");
    public static final JLabel d_juliusWings = new JLabel("<html>Untraditionally seasoned oven roasted wings</html>");
    public static final ImageIcon ic_juliusWings = new ImageIcon(new ImageIcon("src\\Images\\jw.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    public static final JLabel i_juliusWings = new JLabel(ic_juliusWings);
    public static final JTextField n_juliusWings = new JTextField("0");
    public static final JButton a_juliusWings = new JButton("+");
    public static final JButton r_juliusWings = new JButton("-");

    public static final JPanel p_wildSauce = new JPanel();
    public static final JLabel l_wildSauce = new JLabel("Wild Sauce® ($0.99)");
    public static final JLabel d_wildSauce = new JLabel("<html>Tomato dipping dip with a special blend of tasty herbs and spices</html>");
    public static final ImageIcon ic_wildSauce = new ImageIcon(new ImageIcon("src\\Images\\ws.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    public static final JLabel i_wildSauce = new JLabel(ic_wildSauce);
    public static final JTextField n_wildSauce = new JTextField("0");
    public static final JButton a_wildSauce = new JButton("+");
    public static final JButton r_wildSauce = new JButton("-");

    public static final JPanel p_juliusDips = new JPanel();
    public static final JLabel l_juliusDips = new JLabel("Julius Dips® ($0.98)");
    public static final JLabel d_juliusDips = new JLabel("<html>Butter and garlic flavored dipping dip</html>");
    public static final ImageIcon ic_juliusDips = new ImageIcon(new ImageIcon("src\\Images\\jd.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    public static final JLabel i_juliusDips = new JLabel(ic_juliusDips);
    public static final JTextField n_juliusDips = new JTextField("0");
    public static final JButton a_juliusDips = new JButton("+");
    public static final JButton r_juliusDips = new JButton("-");

    public static final JPanel p_sqb = new JPanel();
    public static final JLabel l_sqb = new JLabel("Salami Queso Bread ($6.48)");
    public static final JLabel d_sqb = new JLabel("<html>Ten pieces of freshly baked bread with crispy edge, covered with queso, salami and sprinkled with cheddar cheese</html>");
    public static final ImageIcon ic_sqb = new ImageIcon(new ImageIcon("src\\Images\\sqbs.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    public static final JLabel i_sqb = new JLabel(ic_sqb);
    public static final JTextField n_sqb = new JTextField("0");
    public static final JButton a_sqb = new JButton("+");
    public static final JButton r_sqb = new JButton("-");

    public RestaurantFrame() {
        super("Big Julius'");
        setSize(620, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        {
            mi_appetizers.addActionListener(e -> {
                System.out.println("WHAT");
                s_appetizers.setVisible(true);
                revalidate();
                repaint();
                System.out.println("HUH");
            });
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
            p_appetizers.setPreferredSize(new Dimension(600, 1300));
            l_appetizers.setFont(large);
            l_appetizers.setBounds(0, 0, 600, 40);
            l_appetizers.setHorizontalAlignment(JLabel.CENTER);
            s_appetizers.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            s_appetizers.getVerticalScrollBar().setUnitIncrement(200);

            {
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
                p_appetizers.add(p_wildBread);
            } // Wild Bread

            {
                p_spanishQB.setBackground(new Color(230, 230, 230));
                p_spanishQB.setLayout(null);
                p_spanishQB.setBounds(20, 250, 560, 180);
                l_spanishQB.setBounds(20, 20, 520, 30);
                l_spanishQB.setFont(medium);
                p_spanishQB.add(l_spanishQB);
                i_spanishQB.setBounds(20, 60, 100, 100);
                p_spanishQB.add(i_spanishQB);
                d_spanishQB.setBounds(140, 60, 320, 100);
                p_spanishQB.add(d_spanishQB);
                n_spanishQB.setBounds(438, 20, 46, 46);
                n_spanishQB.setEnabled(false);
                n_spanishQB.setHorizontalAlignment(JTextField.CENTER);
                p_spanishQB.add(n_spanishQB);
                a_spanishQB.setBounds(494, 20, 46, 46);
                a_spanishQB.addActionListener(e -> {
                    n_spanishQB.setText("" + (Integer.parseInt(n_spanishQB.getText()) + 1));
                    if (Integer.parseInt(n_spanishQB.getText()) > 0) r_spanishQB.setEnabled(true);
                });
                p_spanishQB.add(a_spanishQB);
                r_spanishQB.setBounds(382, 20, 46, 46);
                r_spanishQB.setEnabled(false);
                r_spanishQB.addActionListener(e -> {
                    n_spanishQB.setText("" + (Integer.parseInt(n_spanishQB.getText()) - 1));
                    if (Integer.parseInt(n_spanishQB.getText()) <= 0) r_spanishQB.setEnabled(false);
                });
                p_spanishQB.add(r_spanishQB);
                p_appetizers.add(p_spanishQB);
            } // Spanish Queso Bread

            {
                p_juliusWings.setBackground(Color.WHITE);
                p_juliusWings.setLayout(null);
                p_juliusWings.setBounds(20, 450, 560, 180);
                l_juliusWings.setBounds(20, 20, 520, 30);
                l_juliusWings.setFont(medium);
                p_juliusWings.add(l_juliusWings);
                i_juliusWings.setBounds(20, 60, 100, 100);
                p_juliusWings.add(i_juliusWings);
                d_juliusWings.setBounds(140, 60, 320, 100);
                p_juliusWings.add(d_juliusWings);
                n_juliusWings.setBounds(438, 20, 46, 46);
                n_juliusWings.setEnabled(false);
                n_juliusWings.setHorizontalAlignment(JTextField.CENTER);
                p_juliusWings.add(n_juliusWings);
                a_juliusWings.setBounds(494, 20, 46, 46);
                a_juliusWings.addActionListener(e -> {
                    n_juliusWings.setText("" + (Integer.parseInt(n_juliusWings.getText()) + 1));
                    if (Integer.parseInt(n_juliusWings.getText()) > 0) r_juliusWings.setEnabled(true);
                });
                p_juliusWings.add(a_juliusWings);
                r_juliusWings.setBounds(382, 20, 46, 46);
                r_juliusWings.setEnabled(false);
                r_juliusWings.addActionListener(e -> {
                    n_juliusWings.setText("" + (Integer.parseInt(n_juliusWings.getText()) - 1));
                    if (Integer.parseInt(n_juliusWings.getText()) <= 0) r_juliusWings.setEnabled(false);
                });
                p_juliusWings.add(r_juliusWings);
                p_appetizers.add(p_juliusWings);
            } // Julius Wings

            {
                p_wildSauce.setBackground(new Color(230, 230, 230));
                p_wildSauce.setLayout(null);
                p_wildSauce.setBounds(20, 650, 560, 180);
                l_wildSauce.setBounds(20, 20, 520, 30);
                l_wildSauce.setFont(medium);
                p_wildSauce.add(l_wildSauce);
                i_wildSauce.setBounds(20, 60, 100, 100);
                p_wildSauce.add(i_wildSauce);
                d_wildSauce.setBounds(140, 60, 320, 100);
                p_wildSauce.add(d_wildSauce);
                n_wildSauce.setBounds(438, 20, 46, 46);
                n_wildSauce.setEnabled(false);
                n_wildSauce.setHorizontalAlignment(JTextField.CENTER);
                p_wildSauce.add(n_wildSauce);
                a_wildSauce.setBounds(494, 20, 46, 46);
                a_wildSauce.addActionListener(e -> {
                    n_wildSauce.setText("" + (Integer.parseInt(n_wildSauce.getText()) + 1));
                    if (Integer.parseInt(n_wildSauce.getText()) > 0) r_wildSauce.setEnabled(true);
                });
                p_wildSauce.add(a_wildSauce);
                r_wildSauce.setBounds(382, 20, 46, 46);
                r_wildSauce.setEnabled(false);
                r_wildSauce.addActionListener(e -> {
                    n_wildSauce.setText("" + (Integer.parseInt(n_wildSauce.getText()) - 1));
                    if (Integer.parseInt(n_wildSauce.getText()) <= 0) r_wildSauce.setEnabled(false);
                });
                p_wildSauce.add(r_wildSauce);
                p_appetizers.add(p_wildSauce);
            } // Wild Sauce

            {
                p_juliusDips.setBackground(Color.WHITE);
                p_juliusDips.setLayout(null);
                p_juliusDips.setBounds(20, 850, 560, 180);
                l_juliusDips.setBounds(20, 20, 520, 30);
                l_juliusDips.setFont(medium);
                p_juliusDips.add(l_juliusDips);
                i_juliusDips.setBounds(20, 60, 100, 100);
                p_juliusDips.add(i_juliusDips);
                d_juliusDips.setBounds(140, 60, 320, 100);
                p_juliusDips.add(d_juliusDips);
                n_juliusDips.setBounds(438, 20, 46, 46);
                n_juliusDips.setEnabled(false);
                n_juliusDips.setHorizontalAlignment(JTextField.CENTER);
                p_juliusDips.add(n_juliusDips);
                a_juliusDips.setBounds(494, 20, 46, 46);
                a_juliusDips.addActionListener(e -> {
                    n_juliusDips.setText("" + (Integer.parseInt(n_juliusDips.getText()) + 1));
                    if (Integer.parseInt(n_juliusDips.getText()) > 0) r_juliusDips.setEnabled(true);
                });
                p_juliusDips.add(a_juliusDips);
                r_juliusDips.setBounds(382, 20, 46, 46);
                r_juliusDips.setEnabled(false);
                r_juliusDips.addActionListener(e -> {
                    n_juliusDips.setText("" + (Integer.parseInt(n_juliusDips.getText()) - 1));
                    if (Integer.parseInt(n_juliusDips.getText()) <= 0) r_juliusDips.setEnabled(false);
                });
                p_juliusDips.add(r_juliusDips);
                p_appetizers.add(p_juliusDips);
            } // Julius Dips

            {
                p_sqb.setBackground(new Color(230, 230, 230));
                p_sqb.setLayout(null);
                p_sqb.setBounds(20, 1050, 560, 180);
                l_sqb.setBounds(20, 20, 520, 30);
                l_sqb.setFont(medium);
                p_sqb.add(l_sqb);
                i_sqb.setBounds(20, 60, 100, 100);
                p_sqb.add(i_sqb);
                d_sqb.setBounds(140, 60, 320, 100);
                p_sqb.add(d_sqb);
                n_sqb.setBounds(438, 20, 46, 46);
                n_sqb.setEnabled(false);
                n_sqb.setHorizontalAlignment(JTextField.CENTER);
                p_sqb.add(n_sqb);
                a_sqb.setBounds(494, 20, 46, 46);
                a_sqb.addActionListener(e -> {
                    n_sqb.setText("" + (Integer.parseInt(n_sqb.getText()) + 1));
                    if (Integer.parseInt(n_sqb.getText()) > 0) r_sqb.setEnabled(true);
                });
                p_sqb.add(a_sqb);
                r_sqb.setBounds(382, 20, 46, 46);
                r_sqb.setEnabled(false);
                r_sqb.addActionListener(e -> {
                    n_sqb.setText("" + (Integer.parseInt(n_sqb.getText()) - 1));
                    if (Integer.parseInt(n_sqb.getText()) <= 0) r_sqb.setEnabled(false);
                });
                p_sqb.add(r_sqb);
                p_appetizers.add(p_sqb);
            } // Salami Queso Bread

            p_appetizers.add(l_appetizers);

            s_appetizers.setVisible(false);
            add(s_appetizers);
        } // Appetizers

        setVisible(true);
    }
}
