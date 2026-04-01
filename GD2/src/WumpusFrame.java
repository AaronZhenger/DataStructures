import javax.swing.*;

public class WumpusFrame extends JFrame {
    public WumpusFrame() {
        super("Wumpus World");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new WumpusPanel());
        setVisible(true);
    }
}
