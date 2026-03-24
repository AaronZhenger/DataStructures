import javax.swing.*;
import java.awt.*;

public class RestaurantFrame extends JFrame {
    public static final Font large = new Font(Font.DIALOG, Font.BOLD, 36);
    public static final Font medium = new Font(Font.DIALOG, Font.PLAIN, 26);
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
    public static final JLabel l_wildBread = new JLabel("Wild Bread®");
    public static final ImageIcon ic_wildBread = new ImageIcon(new ImageIcon("src\\Images\\wildBread.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    public static final JLabel i_wildBread = new JLabel(ic_wildBread);

    public RestaurantFrame() {
        super("Big Julius'");
        setSize(620, 400);

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
            p_appetizers.setBackground(Color.white);

            l_appetizers.setFont(large);
            l_appetizers.setHorizontalAlignment(JLabel.CENTER);
            l_appetizers.setBounds(0, 0, 600, 40);

            p_wildBread.setBackground(Color.LIGHT_GRAY);
            p_wildBread.setLayout(null);
            p_wildBread.setBounds(20, 50, 560, 160);
            i_wildBread.setBounds(20, 20, 100, 100);
            p_wildBread.add(i_wildBread);
            p_appetizers.add(p_wildBread);

            p_appetizers.add(l_appetizers);

            s_appetizers.setVisible(true);
            add(s_appetizers);
        } // Appetizers

        setVisible(true);
    }
}
