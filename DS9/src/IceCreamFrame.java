import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class IceCreamFrame extends JFrame {
    public IceCreamFrame() {
        super("Ice Cream Shop");
        setSize(1200, 1000);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font large = new Font(Font.DIALOG, Font.BOLD, 36);
        Font medium = new Font(Font.DIALOG, Font.BOLD, 18);
        Font small = new Font(Font.DIALOG, Font.PLAIN, 18);

        JLabel shopName = new JLabel("Ice Cream");
        JLabel containerType = new JLabel("Container Type:");
        JLabel flavor = new JLabel("Flavor:");
        JLabel scoops = new JLabel("Number of Scoops:");
        JLabel toppings = new JLabel("Toppings:");

        ButtonGroup containerGroup = new ButtonGroup();
        JRadioButton radBowl = new JRadioButton("Bowl ($0.50)");
        JRadioButton radWafBowl = new JRadioButton("Waffle Bowl ($2.00)");
        JRadioButton radWafCone = new JRadioButton("Waffle Cone ($2.00)");
        JRadioButton radChcCone = new JRadioButton("Chocolate Waffle Cone ($3.50)");

        String[] arrFlv = new String[]{"Cookies and Cream", "Chocolate", "Vanilla", "Butter Pecan", "Strawberry", "Chocolate Chip Cookie Dough", "Coffee", "Cinnamon"};
        JComboBox<String> flav = new JComboBox<>(arrFlv);

        String[] arrNum = new String[]{"1 ($3.00)", "2 ($5.50)", "3 ($7.00)"};
        JComboBox<String> num = new JComboBox<>(arrNum);

        JCheckBox cbChS = new JCheckBox("Chocolate Syrup ($0.75)");
        JCheckBox cbCaS = new JCheckBox("Carmel Syrup ($0.75)");
        JCheckBox cbMM = new JCheckBox("M&M's ($1.00)");
        JCheckBox cbOr = new JCheckBox("Oreos ($1.00)");
        JCheckBox cbPb = new JCheckBox("Peanut Butter ($1.25)");
        JCheckBox cbChC = new JCheckBox("Chocolate Chip ($1.00)");
        JCheckBox cbS = new JCheckBox("Sprinkles ($0.75)");

        ArrayList<String> arr = new ArrayList<>();
        arr.add("Container Type");
        arr.add("Flavor");
        arr.add("Number of Scoops");
        arr.add("Toppings");
        JTable tbl = new JTable(new String[0][4], arr.toArray());
        JScrollPane scr = new JScrollPane(tbl);

        {
            shopName.setFont(large);
            shopName.setBounds(40, 20, 720, 40);
            shopName.setHorizontalAlignment(JLabel.CENTER);
            add(shopName);
        }//Shop Name

        {
            containerType.setFont(medium);
            containerType.setBounds(40, 80, 300, 40);
            add(containerType);

            radBowl.setFont(small);
            radBowl.setBounds(60, 120, 280, 30);
            add(radBowl);
            radWafBowl.setFont(small);
            radWafBowl.setBounds(60, 150, 280, 30);
            add(radWafBowl);
            radWafCone.setFont(small);
            radWafCone.setBounds(60, 180, 280, 30);
            add(radWafCone);
            radChcCone.setFont(small);
            radChcCone.setBounds(60, 210, 280, 30);
            add(radChcCone);
            containerGroup.add(radBowl);
            containerGroup.add(radWafBowl);
            containerGroup.add(radWafCone);
            containerGroup.add(radChcCone);
            containerGroup.setSelected(radBowl.getModel(), true);
        }//Container Type

        {
            flavor.setFont(medium);
            flavor.setBounds(40, 250, 300, 40);
            add(flavor);
            flav.setFont(small);
            flav.setBounds(40,290,300, 30);
            flav.setSelectedIndex(2);
            add(flav);
        }//Flavor

        {
            scoops.setFont(medium);
            scoops.setBounds(40, 330, 300, 40);
            add(scoops);
            num.setFont(small);
            num.setBounds(40,370,300, 30);
            num.setSelectedIndex(0);
            add(num);
        }//Scoops

        {
            toppings.setFont(medium);
            toppings.setBounds(40, 410, 300, 40);
            add(toppings);
            cbChS.setFont(small);
            cbChS.setBounds(40,450,300, 30);
            add(cbChS);
            cbCaS.setFont(small);
            cbCaS.setBounds(40,480,300, 30);
            add(cbCaS);
            cbMM.setFont(small);
            cbMM.setBounds(40,510,300, 30);
            add(cbMM);
            cbOr.setFont(small);
            cbOr.setBounds(40,540,300, 30);
            add(cbOr);
            cbPb.setFont(small);
            cbPb.setBounds(40,570,300, 30);
            add(cbPb);
            cbChC.setFont(small);
            cbChC.setBounds(40,600,300, 30);
            add(cbChC);
            cbS.setFont(small);
            cbS.setBounds(40,630,300, 30);
            add(cbS);
        }//Toppings

        {
            scr.setBounds(360, 80, 800, 580);
            scr.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            add(scr);
        }//Display

        setVisible(true);
    }
}
