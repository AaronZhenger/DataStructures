import javax.swing.*;

public class WumpusFrame extends JFrame {

    public WumpusFrame() {
        super("Wumpus World");
        setSize(621, 800);
        setFocusable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new WumpusPanel());

        setVisible(true);
    }
}
