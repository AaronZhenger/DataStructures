import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class RestaurantFrameNew extends JFrame {

    public static final Color white = Color.WHITE;
    public static final Color gray = new Color(230, 230, 230);

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
    public static final JPanel p_cart = new JPanel();

    public static JTable t_cart;
    public static final ArrayList<String> l_cart = new ArrayList<>();

    public static final JScrollPane s_appetizers = new JScrollPane(p_appetizers);
    public static final JScrollPane s_entrees = new JScrollPane(p_entrees);
    public static final JScrollPane s_desserts = new JScrollPane(p_desserts);
    public static JScrollPane s_cart;

    public static final JLabel l_appetizers = new JLabel("Appetizers");
    public static final JLabel l_entrees = new JLabel("Entrees");
    public static final JLabel l_desserts = new JLabel("Desserts");

    public static final JLabel l_typical = new JLabel("Typical Pizzas");
    public static final JLabel l_evf = new JLabel("EXTRAVERYFINEST® Pizzas");
    public static final JLabel l_attenuate = new JLabel("Attenuate Pizzas");
    public static final JLabel l_other = new JLabel("Other Pizzas");

    public static final JLabel l_tipPercentage = new JLabel("Tip %:");
    public static final JLabel l_subtotal = new JLabel("Subtotal:");
    public static final JLabel l_tax = new JLabel("Tax:");
    public static final JLabel l_tip = new JLabel("Tip:");
    public static final JLabel l_total = new JLabel("Total:");
    public static final JTextField t_tipPercentage = new JTextField();
    public static final JTextField t_subtotal = new JTextField("$0.00");
    public static final JTextField t_tax = new JTextField("$0.00");
    public static final JTextField t_tip = new JTextField("$0.00");
    public static final JTextField t_total = new JTextField("$0.00");

    public static final ArrayList<RestaurantItem> order = new ArrayList<>();

    public RestaurantFrameNew() {
        super("Big Julius'");
        setSize(620, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        {
            mi_appetizers.addActionListener(e -> {
                s_appetizers.setVisible(true);
                s_entrees.setVisible(false);
                s_desserts.setVisible(false);
                p_cart.setVisible(false);
                revalidate();
                repaint();
            });
            m_menu.add(mi_appetizers);
            mi_entrees.addActionListener(e -> {
                s_entrees.setVisible(true);
                s_appetizers.setVisible(false);
                s_desserts.setVisible(false);
                p_cart.setVisible(false);
                revalidate();
                repaint();
            });
            m_menu.add(mi_entrees);
            mi_desserts.addActionListener(e -> {
                s_desserts.setVisible(true);
                s_entrees.setVisible(false);
                s_appetizers.setVisible(false);
                p_cart.setVisible(false);
                revalidate();
                repaint();
            });
            m_menu.add(mi_desserts);
            mb.add(m_menu);
            mi_viewCart.addActionListener(e -> {
                s_desserts.setVisible(false);
                s_entrees.setVisible(false);
                s_appetizers.setVisible(false);
                p_cart.setVisible(true);
                revalidate();
                repaint();
            });
            m_checkOut.add(mi_viewCart);
            mb.add(m_checkOut);
            setJMenuBar(mb);
        } // Menu

        {
            s_appetizers.setBounds(0, 0, 606, 340);
            s_appetizers.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            s_appetizers.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            s_appetizers.getVerticalScrollBar().setUnitIncrement(10);

            p_appetizers.setLayout(null);
            p_appetizers.setPreferredSize(new Dimension(600, 1335));

            l_appetizers.setFont(large);
            l_appetizers.setBounds(0, 0, 600, 40);
            l_appetizers.setHorizontalAlignment(JLabel.CENTER);
            p_appetizers.add(l_appetizers);

            p_appetizers.add(createItem(
                    "Wild Bread®",
                    "Eight margarine garlic flavored bread sticks, sprinkled with cheddar queso and served with Wild Sauce®",
                    "src\\Images\\wildBread.jpg",
                    3.98,
                    50,
                    white
            ));
            p_appetizers.add(createItem(
                    "Salami Wild Bread",
                    "Eight margarine garlic flavored bread sticks, sprinkled with cheddar queso, filled with Salami and served with Wild Sauce®",
                    "src\\Images\\pwb.jpg",
                    3.98,
                    250,
                    gray
            ));
            p_appetizers.add(createItem(
                    "Filled Wild Bread®",
                    "Three pieces of our famous Wild Bread® filled with Queso, plus Wild Sauce®",
                    "src\\Images\\swb.jpg",
                    3.48,
                    450,
                    white
            ));
            p_appetizers.add(createItem(
                    "Julius Wings®",
                    "Untraditionally dressed oven roasted wings",
                    "src\\Images\\jw.jpg",
                    0.99,
                    650,
                    gray
            ));
            p_appetizers.add(createItem(
                    "Wild Sauce®",
                    "Tomato dipping dip with a special blend of tasty herbs and spices",
                    "src\\Images\\ws.jpg",
                    8.98,
                    850,
                    white
            ));
            p_appetizers.add(createItem(
                    "Julius Dips®",
                    "Butter and garlic flavored dipping dip",
                    "src\\Images\\jd.jpg",
                    0.98,
                    1050,
                    gray
            ));
            s_appetizers.setVisible(false);
            add(s_appetizers);
        } //Appetizers

        {
            s_entrees.setBounds(0, 0, 606, 340);
            s_entrees.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            s_entrees.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            s_entrees.getVerticalScrollBar().setUnitIncrement(10);

            p_entrees.setLayout(null);
            p_entrees.setPreferredSize(new Dimension(600, 2655));

            l_entrees.setFont(large);
            l_entrees.setBounds(0, 0, 600, 40);
            l_entrees.setHorizontalAlignment(JLabel.CENTER);
            p_entrees.add(l_entrees);

            l_typical.setFont(medium);
            l_typical.setBounds(40, 50, 520, 40);
            p_entrees.add(l_typical);
            p_entrees.add(createItem(
                    "Large Typical Queso",
                    "Large round pizza with Queso",
                    "src\\Images\\ltq.jpg",
                    5.98,
                    90,
                    white
            ));
            p_entrees.add(createItem(
                    "Large Typical Salami",
                    "Large round pizza with Salami",
                    "src\\Images\\lts.jpg",
                    5.98,
                    290,
                    gray
            ));
            l_evf.setFont(medium);
            l_evf.setBounds(40, 490, 520, 40);
            p_entrees.add(l_evf);
            p_entrees.add(createItem(
                    "EXTRAVERYFINESTEST® Queso",
                    "Large round pizza with more Queso than our Typical pizza.",
                    "src\\Images\\evpq.jpg",
                    6.98,
                    530,
                    white
            ));
            p_entrees.add(createItem(
                    "EXTRAVERYFINESTEST® Salami",
                    "Large round pizza with more Salami and Queso than our Typical pizza.",
                    "src\\Images\\evps.jpg",
                    6.98,
                    730,
                    gray
            ));
            l_attenuate.setFont(medium);
            l_attenuate.setBounds(40, 930, 520, 40);
            p_entrees.add(l_attenuate);
            p_entrees.add(createItem(
                    "Attenuate Crust Salami",
                    "Large attenuate crust pizza topped right to the edge with Salami and Queso.",
                    "src\\Images\\acs.jpg",
                    8.48,
                    970,
                    white
            ));
            p_entrees.add(createItem(
                    "Attenuate Crust Queso",
                    "Large attenuate crust pizza topped right to the edge with Queso.",
                    "src\\Images\\acq.jpg",
                    8.48,
                    1170,
                    gray
            ));
            l_other.setFont(medium);
            l_other.setBounds(40, 1370, 520, 40);
            p_entrees.add(l_other);
            p_entrees.add(createItem(
                    "New World Fancerami Salami™",
                    "A large Salami pizza topped with over 101 crispy new world Salamis all the way to the edge and a crispy, caramelized crust.",
                    "src\\Images\\nwfs.jpg",
                    10.98,
                    1410,
                    white
            ));
            p_entrees.add(createItem(
                    "Cuts-N-Twigs®",
                    "Four slices of Salami pizza combined with eight Spanish Queso Twigs, plus Wild Dip®",
                    "src\\Images\\cnt.jpg",
                    8.98,
                    1610,
                    gray
            ));
            p_entrees.add(createItem(
                    "Paramount Superior",
                    "Large round pizza with Salami, German Wurst, Fungi, Onions, and Red Peppers",
                    "src\\Images\\ps.jpg",
                    13.99,
                    1810,
                    white
            ));
            p_entrees.add(createItem(
                    "4 Meat Delicacy®",
                    "Large round <strong>pizza</strong> topped with Pepperoni, Italian Sausage and Bacon",
                    "src\\Images\\fmd.jpg",
                    13.99,
                    2010,
                    gray
            ));
            p_entrees.add(createItem(
                    "Hoop Samoa®",
                    "WILD!WILD!™ AMOUNTS OF TOPPINGS AT THE COUNTRY'S BEST PRICE** Large round pizza with Smoky Turkey and Pineapple Pens",
                    "src\\Images\\nwfs.jpg",
                    11.99,
                    2210,
                    white
            ));
            p_entrees.add(createItem(
                    "Veggo",
                    "WILD!WILD!™ AMOUNTS OF TOPPINGS AT THE COUNTRY'S BEST PRICE** Large round pizza with Red Peppers, Onions, Fungi, Artichokes and Spanish Dressing",
                    "src\\Images\\v.jpg",
                    10.49,
                    2410,
                    gray
            ));

            s_entrees.setVisible(false);
            add(s_entrees);
        } //Entrees

        {
            s_desserts.setBounds(0, 0, 606, 340);
            s_desserts.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            s_desserts.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            s_desserts.getVerticalScrollBar().setUnitIncrement(10);

            p_desserts.setLayout(null);
            p_desserts.setPreferredSize(new Dimension(600, 935));

            l_desserts.setFont(large);
            l_desserts.setBounds(0, 0, 600, 40);
            l_desserts.setHorizontalAlignment(JLabel.CENTER);
            p_desserts.add(l_desserts);

            p_desserts.add(createItem(
                    "Salami Wild Puffs®",
                    "Four hand-held pizzas with Cheddar Queso, Salami and pizza dip topped with a buttery-garlic flavored drizzle, Spanish Herb and Parmesan Dressing",
                    "src\\Images\\swp.jpg",
                    3.98,
                    50,
                    white
            ));
            p_desserts.add(createItem(
                    "Queso Wild Puffs®",
                    "Four hand-held pizzas made with pule, monster, cheddar and parmesan quesos, pizza dip, and topped with a buttery-garlic flavored drizzle and Spanish herb dressing",
                    "src\\Images\\qwp.jpg",
                    3.98,
                    250,
                    gray
            ));
            p_desserts.add(createItem(
                    "KitKat® Cookie Brownie",
                    "Brownie topped with Cookie Dough Frosting and KitKat® Cookie Bar Pieces | 4-piece order",
                    "src\\Images\\kitkat.jpg",
                    4.88,
                    450,
                    white
            ));
            p_desserts.add(createItem(
                    "Smarties® Cookie Brownie",
                    "Brownie topped with Cookie Dough Frosting and Smarties® Chocolate Candies | 4-piece order",
                    "src\\Images\\smarties.jpg",
                    4.88,
                    650,
                    gray
            ));

            s_desserts.setVisible(false);
            add(s_desserts);
        } //Desserts

        {
            l_cart.add("Item Name");
            l_cart.add("Quantity");
            l_cart.add("Cost");
            l_cart.add("Extended Cost");
            t_cart = new JTable(new String[0][4], l_cart.toArray()) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            s_cart = new JScrollPane(t_cart);

            s_cart.setBounds(20, 20, 560, 240);
            s_cart.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            p_cart.setBounds(0, 0, 606, 340);
            p_cart.setLayout(null);
            p_cart.add(s_cart);

            l_tipPercentage.setBounds(20, 270, 40, 20);
            t_tipPercentage.setBounds(60, 270, 40, 20);
            t_tipPercentage.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    if (!Character.isDigit(e.getKeyChar()))
                        e.consume();
                    else updateTbl(e.getKeyChar());
                }
            });
            p_cart.add(l_tipPercentage);
            p_cart.add(t_tipPercentage);

            l_subtotal.setBounds(20, 300, 60, 20);
            t_subtotal.setBounds(80, 300, 60, 20);
            t_subtotal.setEnabled(false);
            p_cart.add(l_subtotal);
            p_cart.add(t_subtotal);

            l_tax.setBounds(170, 300, 60, 20);
            t_tax.setBounds(210, 300, 60, 20);
            t_tax.setEnabled(false);
            p_cart.add(l_tax);
            p_cart.add(t_tax);

            l_tip.setBounds(320, 300, 60, 20);
            t_tip.setBounds(360, 300, 60, 20);
            t_tip.setEnabled(false);
            p_cart.add(l_tip);
            p_cart.add(t_tip);

            l_total.setBounds(470, 300, 60, 20);
            t_total.setBounds(510, 300, 60, 20);
            t_total.setEnabled(false);
            p_cart.add(l_total);
            p_cart.add(t_total);

            t_cart.setCellSelectionEnabled(false);
            t_cart.setRowSelectionAllowed(true);

            p_cart.setVisible(false);
            add(p_cart);
        }//View Cart

        setVisible(true);
    }

    private JPanel createItem(
            String title,
            String description,
            String imagePath,
            double price,
            int y,
            Color bgColor
    ) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(bgColor);
        panel.setBounds(20, y, 560, 180);

        JLabel l_title = new JLabel(title + " ($" + price + ")");
        l_title.setBounds(20, 20, 520, 30);
        l_title.setFont(small_bold);
        panel.add(l_title);

        ImageIcon icon = new ImageIcon(
                new ImageIcon(imagePath)
                        .getImage()
                        .getScaledInstance(100, 100, Image.SCALE_DEFAULT)
        );
        JLabel image = new JLabel(icon);
        image.setBounds(20, 60, 100, 100);
        panel.add(image);

        JLabel desc = new JLabel("<html>" + description + "</html>");
        desc.setBounds(140, 60, 320, 100);
        panel.add(desc);

        JTextField quantity = new JTextField("0");
        quantity.setBounds(438, 20, 46, 46);
        quantity.setEnabled(false);
        quantity.setHorizontalAlignment(JTextField.CENTER);
        panel.add(quantity);

        JButton add = new JButton("+");
        add.setBounds(494, 20, 46, 46);
        panel.add(add);

        JButton remove = new JButton("-");
        remove.setBounds(382, 20, 46, 46);
        remove.setEnabled(false);
        panel.add(remove);

        add.addActionListener(e -> {
            int val = Integer.parseInt(quantity.getText()) + 1;
            quantity.setText("" + val);
            remove.setEnabled(true);
            if (val > 1) {
                System.out.println("check1");
                for (RestaurantItem item : order) {
                    if (item.getN().equals(title)) {
                        item.setQ(val);
                        updateTbl();
                        break;
                    }
                }
            }
            if (val==1) {
                System.out.println("check0");
                order.add(new RestaurantItem(title, price, 1));
                updateTbl();
            }
        });

        remove.addActionListener(e -> {
            int val = Integer.parseInt(quantity.getText()) - 1;
            quantity.setText("" + val);
            if (val <= 0) {
                for (RestaurantItem item : order) {
                    if (item.getN().equals(title)) {
                        order.remove(item);
                        updateTbl();
                        break;
                    }
                }
                remove.setEnabled(false);
            } else {
                for (RestaurantItem item : order) {
                    if (item.getN().equals(title)) {
                        item.setQ(val);
                        updateTbl();
                        break;
                    }
                }
            }
        });

        return panel;
    }

    public static void updateTbl(char e) {
        double s = 0.0;

        String[][] data = new String[order.size()][4];
        for (int i = 0; i < order.size(); i++) {
            data[i][0] = order.get(i).getN();
            data[i][1] = ""+order.get(i).getQ();
            data[i][2] = String.format("$%.2f", order.get(i).getC());
            data[i][3] = String.format("$%.2f", (order.get(i).getC()*order.get(i).getQ()));
            s+=order.get(i).getC()*order.get(i).getQ();
        }
        s_cart.remove(t_cart);
        t_cart = new JTable(data, l_cart.toArray()) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        s_cart.setViewportView(t_cart);
        s_cart.revalidate();

        double tipPercent = Integer.parseInt(t_tipPercentage.getText()+e) / 100.0;
        System.out.println(tipPercent);

        double tax = s * 0.0825;
        double tip = s * tipPercent;
        double total = s + tax + tip;

        t_subtotal.setText(String.format("$%.2f", s));
        t_tax.setText(String.format("$%.2f", tax));
        t_tip.setText(String.format("$%.2f", tip));
        t_total.setText(String.format("$%.2f", total));
    }

    public static void updateTbl() {
        double s = 0.0;

        String[][] data = new String[order.size()][4];
        for (int i = 0; i < order.size(); i++) {
            data[i][0] = order.get(i).getN();
            data[i][1] = ""+order.get(i).getQ();
            data[i][2] = String.format("$%.2f", order.get(i).getC());
            data[i][3] = String.format("$%.2f", (order.get(i).getC()*order.get(i).getQ()));
            s+=order.get(i).getC()*order.get(i).getQ();
        }
        s_cart.remove(t_cart);
        t_cart = new JTable(data, l_cart.toArray()) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        s_cart.setViewportView(t_cart);
        s_cart.revalidate();

        double tipPercent = 0.0;
        if (!t_tipPercentage.getText().isBlank()) {
            tipPercent = Integer.parseInt(t_tipPercentage.getText()) / 100.0;
        }

        double tax = s * 0.0825;
        double tip = s * tipPercent;
        double total = s + tax + tip;

        t_subtotal.setText(String.format("$%.2f", s));
        t_tax.setText(String.format("$%.2f", tax));
        t_tip.setText(String.format("$%.2f", tip));
        t_total.setText(String.format("$%.2f", total));
    }
}