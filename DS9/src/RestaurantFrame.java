import javax.swing.*;
import java.awt.*;

public class RestaurantFrame extends JFrame {
    public static final Font large = new Font(Font.DIALOG, Font.BOLD, 36);
    public static final Font medium = new Font(Font.DIALOG, Font.BOLD, 24);
    public static final Font small = new Font(Font.DIALOG, Font.PLAIN, 18);
    public static final Font small_bold = new Font(Font.DIALOG, Font.BOLD, 18);

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

    public static final JPanel p_nwfs = new JPanel();
    public static final JLabel l_nwfs = new JLabel("New World Fancerami Salami™ ($10.98)");
    public static final JLabel d_nwfs = new JLabel("<html>A large Salami pizza topped with over 101 crispy new world Salamis all the way to the edge and a crispy, caramelized crust.</html>");
    public static final ImageIcon ic_nwfs = new ImageIcon(new ImageIcon("src\\Images\\nwfs.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    public static final JLabel i_nwfs = new JLabel(ic_nwfs);
    public static final JTextField n_nwfs = new JTextField("0");
    public static final JButton a_nwfs = new JButton("+");
    public static final JButton r_nwfs = new JButton("-");

    public static final JPanel p_cnt = new JPanel();
    public static final JLabel l_cnt = new JLabel("Cuts-N-Twigs® ($8.98)");
    public static final JLabel d_cnt = new JLabel("<html>Four slices of Salami pizza combined with eight Spanish Queso Twigs, plus Wild Dip®</html>");
    public static final ImageIcon ic_cnt = new ImageIcon(new ImageIcon("src\\Images\\cnt.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    public static final JLabel i_cnt = new JLabel(ic_cnt);
    public static final JTextField n_cnt = new JTextField("0");
    public static final JButton a_cnt = new JButton("+");
    public static final JButton r_cnt = new JButton("-");

    public static final JPanel p_acs = new JPanel();
    public static final JLabel l_acs = new JLabel("Attenuate Crust Salami ($8.48)");
    public static final JLabel d_acs = new JLabel("<html>Large attenuate crust pizza topped right to the edge with Salami and Queso.</html>");
    public static final ImageIcon ic_acs = new ImageIcon(new ImageIcon("src\\Images\\acs.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    public static final JLabel i_acs = new JLabel(ic_acs);
    public static final JTextField n_acs = new JTextField("0");
    public static final JButton a_acs = new JButton("+");
    public static final JButton r_acs = new JButton("-");

    public static final JPanel p_acq = new JPanel();
    public static final JLabel l_acq = new JLabel("Attenuate Crust Queso ($8.48)");
    public static final JLabel d_acq = new JLabel("<html>Large attenuate crust pizza topped right to the edge with Queso.</html>");
    public static final ImageIcon ic_acq = new ImageIcon(new ImageIcon("src\\Images\\acq.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    public static final JLabel i_acq = new JLabel(ic_acq);
    public static final JTextField n_acq = new JTextField("0");
    public static final JButton a_acq = new JButton("+");
    public static final JButton r_acq = new JButton("-");

    public static final JPanel p_ps = new JPanel();
    public static final JLabel l_ps = new JLabel("Paramount Superior ($13.99)");
    public static final JLabel d_ps = new JLabel("<html>Large round pizza with Salami, German Wurst, Fungi, Onions, and Red Peppers</html>");
    public static final ImageIcon ic_ps = new ImageIcon(new ImageIcon("src\\Images\\ps.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    public static final JLabel i_ps = new JLabel(ic_ps);
    public static final JTextField n_ps = new JTextField("0");
    public static final JButton a_ps = new JButton("+");
    public static final JButton r_ps = new JButton("-");

    public static final JPanel p_fmd = new JPanel();
    public static final JLabel l_fmd = new JLabel("4 Meat Delicacy® ($13.99)");
    public static final JLabel d_fmd = new JLabel("<html>Large round <strong>pizza</strong> topped with Pepperoni, Italian Sausage and Bacon</html>");
    public static final ImageIcon ic_fmd = new ImageIcon(new ImageIcon("src\\Images\\fmd.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    public static final JLabel i_fmd = new JLabel(ic_fmd);
    public static final JTextField n_fmd = new JTextField("0");
    public static final JButton a_fmd = new JButton("+");
    public static final JButton r_fmd = new JButton("-");

    public static final JPanel p_hs = new JPanel();
    public static final JLabel l_hs = new JLabel("Hoop Samoa® ($11.99)");
    public static final JLabel d_hs = new JLabel("<html>WILD!WILD!™ AMOUNTS OF TOPPINGS AT THE COUNTRY'S BEST PRICE** Large round pizza with Smoky Turkey and Pineapple Pens</html>");
    public static final ImageIcon ic_hs = new ImageIcon(new ImageIcon("src\\Images\\hs.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    public static final JLabel i_hs = new JLabel(ic_hs);
    public static final JTextField n_hs = new JTextField("0");
    public static final JButton a_hs = new JButton("+");
    public static final JButton r_hs = new JButton("-");

    public RestaurantFrame() {
        super("Big Julius'");
        setSize(620, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        {
            mi_appetizers.addActionListener(e -> {
                s_appetizers.setVisible(true);
                s_entrees.setVisible(false);
                s_desserts.setVisible(false);
                revalidate();
                repaint();
            });
            m_menu.add(mi_appetizers);
            mi_entrees.addActionListener(e -> {
                s_entrees.setVisible(true);
                s_appetizers.setVisible(false);
                s_desserts.setVisible(false);
                revalidate();
                repaint();
            });
            m_menu.add(mi_entrees);
            mi_desserts.addActionListener(e -> {
                s_desserts.setVisible(true);
                s_entrees.setVisible(false);
                s_appetizers.setVisible(false);
                revalidate();
                repaint();
            });
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

            s_appetizers.setVisible(true);
            add(s_appetizers);
        } // Appetizers

        {
            p_entrees.setLayout(null);
            p_entrees.setPreferredSize(new Dimension(600, 1500));
            l_entrees.setFont(large);
            l_entrees.setBounds(0, 0, 600, 40);
            l_entrees.setHorizontalAlignment(JLabel.CENTER);
            s_entrees.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            s_entrees.getVerticalScrollBar().setUnitIncrement(200);

            {
                p_nwfs.setBackground(Color.WHITE);
                p_nwfs.setLayout(null);
                p_nwfs.setBounds(20, 50, 560, 180);
                l_nwfs.setBounds(20, 20, 520, 30);
                l_nwfs.setFont(small_bold);
                p_nwfs.add(l_nwfs);
                i_nwfs.setBounds(20, 60, 100, 100);
                p_nwfs.add(i_nwfs);
                d_nwfs.setBounds(140, 60, 320, 100);
                p_nwfs.add(d_nwfs);
                n_nwfs.setBounds(438, 20, 46, 46);
                n_nwfs.setEnabled(false);
                n_nwfs.setHorizontalAlignment(JTextField.CENTER);
                p_nwfs.add(n_nwfs);
                a_nwfs.setBounds(494, 20, 46, 46);
                a_nwfs.addActionListener(e -> {
                    n_nwfs.setText("" + (Integer.parseInt(n_nwfs.getText()) + 1));
                    if (Integer.parseInt(n_nwfs.getText()) > 0) r_nwfs.setEnabled(true);
                });
                p_nwfs.add(a_nwfs);
                r_nwfs.setBounds(382, 20, 46, 46);
                r_nwfs.setEnabled(false);
                r_nwfs.addActionListener(e -> {
                    n_nwfs.setText("" + (Integer.parseInt(n_nwfs.getText()) - 1));
                    if (Integer.parseInt(n_nwfs.getText()) <= 0) r_nwfs.setEnabled(false);
                });
                p_nwfs.add(r_nwfs);
                p_entrees.add(p_nwfs);
            } // New World Fancerami Salami

            {
                p_cnt.setBackground(new Color(230, 230, 230));
                p_cnt.setLayout(null);
                p_cnt.setBounds(20, 250, 560, 180);
                l_cnt.setBounds(20, 20, 520, 30);
                l_cnt.setFont(medium);
                p_cnt.add(l_cnt);
                i_cnt.setBounds(20, 60, 100, 100);
                p_cnt.add(i_cnt);
                d_cnt.setBounds(140, 60, 320, 100);
                p_cnt.add(d_cnt);
                n_cnt.setBounds(438, 20, 46, 46);
                n_cnt.setEnabled(false);
                n_cnt.setHorizontalAlignment(JTextField.CENTER);
                p_cnt.add(n_cnt);
                a_cnt.setBounds(494, 20, 46, 46);
                a_cnt.addActionListener(e -> {
                    n_cnt.setText("" + (Integer.parseInt(n_cnt.getText()) + 1));
                    if (Integer.parseInt(n_cnt.getText()) > 0) r_cnt.setEnabled(true);
                });
                p_cnt.add(a_cnt);
                r_cnt.setBounds(382, 20, 46, 46);
                r_cnt.setEnabled(false);
                r_cnt.addActionListener(e -> {
                    n_cnt.setText("" + (Integer.parseInt(n_cnt.getText()) - 1));
                    if (Integer.parseInt(n_cnt.getText()) <= 0) r_cnt.setEnabled(false);
                });
                p_cnt.add(r_cnt);
                p_entrees.add(p_cnt);
            } // Cuts-N-Twigs

            {
                p_acs.setBackground(Color.WHITE);
                p_acs.setLayout(null);
                p_acs.setBounds(20, 450, 560, 180);
                l_acs.setBounds(20, 20, 520, 30);
                l_acs.setFont(medium);
                p_acs.add(l_acs);
                i_acs.setBounds(20, 60, 100, 100);
                p_acs.add(i_acs);
                d_acs.setBounds(140, 60, 320, 100);
                p_acs.add(d_acs);
                n_acs.setBounds(438, 20, 46, 46);
                n_acs.setEnabled(false);
                n_acs.setHorizontalAlignment(JTextField.CENTER);
                p_acs.add(n_acs);
                a_acs.setBounds(494, 20, 46, 46);
                a_acs.addActionListener(e -> {
                    n_acs.setText("" + (Integer.parseInt(n_acs.getText()) + 1));
                    if (Integer.parseInt(n_acs.getText()) > 0) r_acs.setEnabled(true);
                });
                p_acs.add(a_acs);
                r_acs.setBounds(382, 20, 46, 46);
                r_acs.setEnabled(false);
                r_acs.addActionListener(e -> {
                    n_acs.setText("" + (Integer.parseInt(n_acs.getText()) - 1));
                    if (Integer.parseInt(n_acs.getText()) <= 0) r_acs.setEnabled(false);
                });
                p_acs.add(r_acs);
                p_entrees.add(p_acs);
            } // Attenuate Crust Salami

            {
                p_acq.setBackground(Color.WHITE);
                p_acq.setLayout(null);
                p_acq.setBounds(20, 650, 560, 180);
                l_acq.setBounds(20, 20, 520, 30);
                l_acq.setFont(medium);
                p_acq.add(l_acq);
                i_acq.setBounds(20, 60, 100, 100);
                p_acq.add(i_acq);
                d_acq.setBounds(140, 60, 320, 100);
                p_acq.add(d_acq);
                n_acq.setBounds(438, 20, 46, 46);
                n_acq.setEnabled(false);
                n_acq.setHorizontalAlignment(JTextField.CENTER);
                p_acq.add(n_acq);
                a_acq.setBounds(494, 20, 46, 46);
                a_acq.addActionListener(e -> {
                    n_acq.setText("" + (Integer.parseInt(n_acq.getText()) + 1));
                    if (Integer.parseInt(n_acq.getText()) > 0) r_acq.setEnabled(true);
                });
                p_acq.add(a_acq);
                r_acq.setBounds(382, 20, 46, 46);
                r_acq.setEnabled(false);
                r_acq.addActionListener(e -> {
                    n_acq.setText("" + (Integer.parseInt(n_acq.getText()) - 1));
                    if (Integer.parseInt(n_acq.getText()) <= 0) r_acq.setEnabled(false);
                });
                p_acq.add(r_acq);
                p_entrees.add(p_acq);
            } // Attenuate Crust Queso

            {
                p_ps.setBackground(Color.WHITE);
                p_ps.setLayout(null);
                p_ps.setBounds(20, 850, 560, 180);
                l_ps.setBounds(20, 20, 520, 30);
                l_ps.setFont(medium);
                p_ps.add(l_ps);
                i_ps.setBounds(20, 60, 100, 100);
                p_ps.add(i_ps);
                d_ps.setBounds(140, 60, 320, 100);
                p_ps.add(d_ps);
                n_ps.setBounds(438, 20, 46, 46);
                n_ps.setEnabled(false);
                n_ps.setHorizontalAlignment(JTextField.CENTER);
                p_ps.add(n_ps);
                a_ps.setBounds(494, 20, 46, 46);
                a_ps.addActionListener(e -> {
                    n_ps.setText("" + (Integer.parseInt(n_ps.getText()) + 1));
                    if (Integer.parseInt(n_ps.getText()) > 0) r_ps.setEnabled(true);
                });
                p_ps.add(a_ps);
                r_ps.setBounds(382, 20, 46, 46);
                r_ps.setEnabled(false);
                r_ps.addActionListener(e -> {
                    n_ps.setText("" + (Integer.parseInt(n_ps.getText()) - 1));
                    if (Integer.parseInt(n_ps.getText()) <= 0) r_ps.setEnabled(false);
                });
                p_ps.add(r_ps);
                p_entrees.add(p_ps);
            } // Paramount Superior

            {
                p_fmd.setBackground(Color.WHITE);
                p_fmd.setLayout(null);
                p_fmd.setBounds(20, 1050, 560, 180);
                l_fmd.setBounds(20, 20, 520, 30);
                l_fmd.setFont(medium);
                p_fmd.add(l_fmd);
                i_fmd.setBounds(20, 60, 100, 100);
                p_fmd.add(i_fmd);
                d_fmd.setBounds(140, 60, 320, 100);
                p_fmd.add(d_fmd);
                n_fmd.setBounds(438, 20, 46, 46);
                n_fmd.setEnabled(false);
                n_fmd.setHorizontalAlignment(JTextField.CENTER);
                p_fmd.add(n_fmd);
                a_fmd.setBounds(494, 20, 46, 46);
                a_fmd.addActionListener(e -> {
                    n_fmd.setText("" + (Integer.parseInt(n_fmd.getText()) + 1));
                    if (Integer.parseInt(n_fmd.getText()) > 0) r_fmd.setEnabled(true);
                });
                p_fmd.add(a_fmd);
                r_fmd.setBounds(382, 20, 46, 46);
                r_fmd.setEnabled(false);
                r_fmd.addActionListener(e -> {
                    n_fmd.setText("" + (Integer.parseInt(n_fmd.getText()) - 1));
                    if (Integer.parseInt(n_fmd.getText()) <= 0) r_fmd.setEnabled(false);
                });
                p_fmd.add(r_fmd);
                p_entrees.add(p_fmd);
            } // 4 Meat Delicacy

            {
                p_hs.setBackground(Color.WHITE);
                p_hs.setLayout(null);
                p_hs.setBounds(20, 1250, 560, 180);
                l_hs.setBounds(20, 20, 520, 30);
                l_hs.setFont(medium);
                p_hs.add(l_hs);
                i_hs.setBounds(20, 60, 100, 100);
                p_hs.add(i_hs);
                d_hs.setBounds(140, 60, 320, 100);
                p_hs.add(d_hs);
                n_hs.setBounds(438, 20, 46, 46);
                n_hs.setEnabled(false);
                n_hs.setHorizontalAlignment(JTextField.CENTER);
                p_hs.add(n_hs);
                a_hs.setBounds(494, 20, 46, 46);
                a_hs.addActionListener(e -> {
                    n_hs.setText("" + (Integer.parseInt(n_hs.getText()) + 1));
                    if (Integer.parseInt(n_hs.getText()) > 0) r_hs.setEnabled(true);
                });
                p_hs.add(a_hs);
                r_hs.setBounds(382, 20, 46, 46);
                r_hs.setEnabled(false);
                r_hs.addActionListener(e -> {
                    n_hs.setText("" + (Integer.parseInt(n_hs.getText()) - 1));
                    if (Integer.parseInt(n_hs.getText()) <= 0) r_hs.setEnabled(false);
                });
                p_hs.add(r_hs);
                p_entrees.add(p_hs);
            } // Hoop Samoa

            p_entrees.add(l_entrees);

            s_entrees.setVisible(false);
            add(s_entrees);
        } // Entrees

        setVisible(true);
    }
}
