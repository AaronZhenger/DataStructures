import javax.swing.*;
import java.awt.*;

public class WumpusFrame extends JFrame {
    public WumpusFrame() {
        super("Wumpus World");
        setSize(621, 700);
        setFocusable(true);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new WumpusPanel());
        setVisible(true);
    }
}
