import javax.swing.*;
import java.awt.*;

public class IceCreamFrame extends JFrame {
    public IceCreamFrame() {
        super("Ice Cream Shop");
        setSize(800, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font large = new Font("Dialog", Font.BOLD, 36);
        Font medium = new Font("Dialog", Font.BOLD, 18);
        Font small = new Font("Dialog", Font.PLAIN, 18);

        JLabel shopName = new JLabel("Ice Cream (Scam, 1 star, Money Grab)");
        JLabel containerType = new JLabel("Container Type:");

        ButtonGroup containerGroup = new ButtonGroup();
        JRadioButton radBowl = new JRadioButton("Bowl ($0.50)");
        JRadioButton radWafBowl = new JRadioButton("Waffle Bowl ($2.00)");
        JRadioButton radWafCone = new JRadioButton("Waffle Cone ($2.00)");
        JRadioButton radChcCone = new JRadioButton("Chocolate Waffle Cone ($3.50)");

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

        setVisible(true);
    }
}
