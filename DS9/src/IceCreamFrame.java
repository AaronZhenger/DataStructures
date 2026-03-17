import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Enumeration;

public class IceCreamFrame extends JFrame {
    private static JTable tbl;
    private static ArrayList<IceCream> order = new ArrayList<>();

    private static JCheckBox cbChS = new JCheckBox("Chocolate Syrup ($0.75)");
    private static JCheckBox cbCaS = new JCheckBox("Carmel Syrup ($0.75)");
    private static JCheckBox cbMM = new JCheckBox("M&M's ($1.00)");
    private static JCheckBox cbOr = new JCheckBox("Oreos ($1.00)");
    private static JCheckBox cbPb = new JCheckBox("Peanut Butter ($1.25)");
    private static JCheckBox cbChC = new JCheckBox("Chocolate Chip ($1.00)");
    private static JCheckBox cbS = new JCheckBox("Sprinkles ($0.75)");

    private static String[] arrFlv = new String[]{"Cookies and Cream", "Chocolate", "Vanilla", "Butter Pecan", "Strawberry", "Chocolate Chip Cookie Dough", "Coffee", "Cinnamon"};
    private static JComboBox<String> flav = new JComboBox<>(arrFlv);

    private static JScrollPane scr;
    private static ArrayList<String> arr;

    private static String[] arrNum = new String[]{"1 ($3.00)", "2 ($5.50)", "3 ($7.00)"};
    private static JComboBox<String> num = new JComboBox<>(arrNum);

    private static ButtonGroup containerGroup = new ButtonGroup();
    private static JRadioButton radBowl = new JRadioButton("Bowl ($0.50)");
    private static JRadioButton radWafBowl = new JRadioButton("Waffle Bowl ($2.00)");
    private static JRadioButton radWafCone = new JRadioButton("Waffle Cone ($2.00)");
    private static JRadioButton radChcCone = new JRadioButton("Chocolate Waffle Cone ($3.50)");

    private static JButton update = new JButton("Add");
    private static JButton delete = new JButton("Delete");

    private static JLabel subtotal = new JLabel("Subtotal:");
    private static JLabel tax = new JLabel("Tax:");
    private static JLabel total = new JLabel("Tax:");
    private static JTextField tSubtotal = new JTextField("$0.00");
    private static JTextField tTax = new JTextField("$0.00");
    private static JTextField tTotal = new JTextField("$0.00");



    private static ListSelectionModel sm;

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

        arr = new ArrayList<>();
        arr.add("Container Type");
        arr.add("Flavor");
        arr.add("Number of Scoops");
        arr.add("Toppings");
        arr.add("Cost");
        tbl = new JTable(new String[0][5], arr.toArray());
        scr = new JScrollPane(tbl);

        {
            shopName.setFont(large);
            shopName.setBounds(40, 20, 1120, 40);
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
            update.setFont(medium);
            update.setBounds(40, 670, 300, 30);
            update.addActionListener(e -> {
                double cost = 0.0;
                String selectedRadio = "";
                for (Enumeration<AbstractButton> b = containerGroup.getElements(); b.hasMoreElements();) {
                    AbstractButton bu = b.nextElement();
                    if (bu.isSelected()) {
                        selectedRadio = bu.getText();
                        switch (bu.getText()) {
                            case "Bowl ($0.50)" -> cost+=0.5;
                            case "Chocolate Waffle Cone ($3.50)" -> cost+=3.5;
                            default -> cost+=2.0;
                        }
                    }
                }
                switch (num.getSelectedIndex()) {
                    case 0 -> cost+=3;
                    case 1 -> cost+=5.5;
                    case 2 -> cost+=7;
                }
                ArrayList<String> topings = new ArrayList<>();
                if (cbChS.isSelected()) {topings.add(cbChS.getText()); cost+=0.75;}
                if (cbCaS.isSelected()) {topings.add(cbCaS.getText()); cost+=0.75;}
                if (cbMM.isSelected()) {topings.add(cbMM.getText()); cost+=1.00;}
                if (cbOr.isSelected()) {topings.add(cbOr.getText()); cost+=1.00;}
                if (cbPb.isSelected()) {topings.add(cbPb.getText()); cost+=1.25;}
                if (cbChC.isSelected()) {topings.add(cbChC.getText()); cost+=1.00;}
                if (cbS.isSelected()) {topings.add(cbS.getText()); cost+=0.75;}

                if (tbl.getSelectedRow()!=-1) {
                    order.set(tbl.getSelectedRow(), new IceCream(selectedRadio, flav.getSelectedItem().toString(), num.getSelectedItem().toString(), topings, cost));
                } else order.add(new IceCream(selectedRadio, flav.getSelectedItem().toString(), num.getSelectedItem().toString(), topings, cost));

                updateTbl();
            });
            add(update);
        }//Add/Save

        {
            delete.setFont(medium);
            delete.setEnabled(false);
            delete.setBounds(40, 710, 300, 30);
            delete.addActionListener(e -> {
                order.remove(tbl.getSelectedRow());
                updateTbl();
            });
            add(delete);
        }//Delete

        {
            subtotal.setFont(medium);
            subtotal.setBounds(40, 750, 150, 30);
            add(subtotal);
            tax.setFont(medium);
            tax.setBounds(40, 780, 150, 30);
            add(tax);
            total.setFont(medium);
            total.setBounds(40, 810, 150, 30);
            add(total);

            tSubtotal.setFont(medium);
            tSubtotal.setEnabled(false);
            tSubtotal.setBounds(190, 750, 150, 30);
            add(tSubtotal);
            tTax.setFont(medium);
            tTax.setEnabled(false);
            tTax.setBounds(190, 780, 150, 30);
            add(tTax);
            tTotal.setFont(medium);
            tTotal.setEnabled(false);
            tTotal.setBounds(190, 810, 150, 30);
            add(tTotal);
        }//Payment

        {
            scr.setBounds(360, 80, 800, 660);
            scr.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            add(scr);

            tbl.setCellSelectionEnabled(false);
            tbl.setRowSelectionAllowed(true);
        }//Display

        setVisible(true);
    }

    public static void updateTbl() {
        String[][] data = new String[order.size()][5];
        for (int i = 0; i < order.size(); i++) {
            data[i][0] = order.get(i).getC();
            data[i][1] = order.get(i).getF();
            data[i][2] = order.get(i).getN();
            data[i][3] = !order.get(i).getT().isEmpty() ? order.get(i).getT().toString() : "N/A";
            data[i][4] = String.format("$%.2f",order.get(i).getM());
        }
        scr.remove(tbl);
        tbl = new JTable(data, arr.toArray()) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        scr.setViewportView(tbl);
        scr.revalidate();
        containerGroup.clearSelection();
        containerGroup.setSelected(radBowl.getModel(), true);
        flav.setSelectedIndex(2);
        num.setSelectedIndex(0);
        cbChS.setSelected(false);
        cbCaS.setSelected(false);
        cbMM.setSelected(false);
        cbOr.setSelected(false);
        cbPb.setSelected(false);
        cbChC.setSelected(false);
        cbS.setSelected(false);

        tbl.setCellSelectionEnabled(false);
        tbl.setRowSelectionAllowed(true);
        sm = tbl.getSelectionModel();

        updateTxt();

        update.setText("Add");
        delete.setEnabled(false);

        sm.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = tbl.getSelectedRow();
                if (row != -1) {
                    loadSelection(row);
                }
            }
        });
    }

    private static void updateTxt() {
        double sub = 0.0;
        double t = 0.0;
        double tot = 0.0;

        for (IceCream ic : order)
            sub+=ic.getM();

        t = 0.0825*sub;
        tot = sub+t;

        tSubtotal.setText(String.format("$%.2f", sub));
        tTax.setText(String.format("$%.2f", t));
        tTotal.setText(String.format("$%.2f", tot));
    }

    public static void loadSelection(int row) {
        update.setText("Save");
        delete.setEnabled(true);

        IceCream ic = order.get(row);

        for (Enumeration<AbstractButton> b = containerGroup.getElements(); b.hasMoreElements();) {
            AbstractButton btn = b.nextElement();
            if (btn.getText().equals(ic.getC())) {
                containerGroup.setSelected(btn.getModel(), true);
            }
        }

        flav.setSelectedItem(ic.getF());

        num.setSelectedItem(ic.getN());

        cbChS.setSelected(false);
        cbCaS.setSelected(false);
        cbMM.setSelected(false);
        cbOr.setSelected(false);
        cbPb.setSelected(false);
        cbChC.setSelected(false);
        cbS.setSelected(false);

        for (String t : ic.getT()) {
            if (t.equals(cbChS.getText())) cbChS.setSelected(true);
            if (t.equals(cbCaS.getText())) cbCaS.setSelected(true);
            if (t.equals(cbMM.getText())) cbMM.setSelected(true);
            if (t.equals(cbOr.getText())) cbOr.setSelected(true);
            if (t.equals(cbPb.getText())) cbPb.setSelected(true);
            if (t.equals(cbChC.getText())) cbChC.setSelected(true);
            if (t.equals(cbS.getText())) cbS.setSelected(true);
        }
    }
}
