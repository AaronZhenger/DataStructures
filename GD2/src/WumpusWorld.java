import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class WumpusWorld extends JFrame {
    private static BufferedImage wumpusPanel;

    private static BufferedImage ladder;
    private static BufferedImage floor;

    public WumpusWorld() {
        super("Wumpus World");
        setSize(300, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        wumpusPanel = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_4BYTE_ABGR);

        try {
            ladder = ImageIO.read(new File("src/Images/ladder.gif"));
            floor = ImageIO.read(new File("src/Images/Floor.gif"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.drawImage(ladder, 50, 50, null);
        g.drawImage(floor, 150, 50, null);
    }

    public static void main(String[] args) {
        new WumpusWorld();
    }
}
