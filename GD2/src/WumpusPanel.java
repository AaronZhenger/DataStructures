import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class WumpusPanel extends JPanel {
    public static final int PLAYING = 0;
    public static final int DEAD = 1;
    public static final int WON = 2;

    private int status;
    private WumpusPlayer player;
    private WumpusMap map;

    private BufferedImage floor;
    private BufferedImage arrow;
    private BufferedImage fog;
    private BufferedImage gold;
    private BufferedImage ladder;
    private BufferedImage pit;
    private BufferedImage breeze;
    private BufferedImage wumpus;
    private BufferedImage deadWumpus;
    private BufferedImage stench;
    private BufferedImage playerUp;
    private BufferedImage playerDown;
    private BufferedImage playerLeft;
    private BufferedImage playerRight;
    private BufferedImage buffer;

    public WumpusPanel() {
        setSize(600, 700);

        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
        try {
            floor = ImageIO.read(new File("src/Images/Floor.gif"));
            arrow = ImageIO.read(new File("src/Images/arrow.gif"));
            fog = ImageIO.read(new File("src/Images/black.gif"));
            gold = ImageIO.read(new File("src/Images/gold.gif"));
            ladder = ImageIO.read(new File("src/Images/ladder.gif"));
            pit = ImageIO.read(new File("src/Images/pit.gif"));
            breeze = ImageIO.read(new File("src/Images/breeze.gif"));
            wumpus = ImageIO.read(new File("src/Images/wumpus.gif"));
            deadWumpus = ImageIO.read(new File("src/Images/deadwumpus.GIF"));
            stench = ImageIO.read(new File("src/Images/stench.gif"));
            playerUp = ImageIO.read(new File("src/Images/playerUp.png"));
            playerDown = ImageIO.read(new File("src/Images/playerDown.png"));
            playerLeft = ImageIO.read(new File("src/Images/playerLeft.png"));
            playerRight = ImageIO.read(new File("src/Images/playerRight.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        reset();
    }

    public void reset() {
        status = PLAYING;
        map = new WumpusMap();
        map.createMap();
        player = new WumpusPlayer();
        player.setColPosition(map.getLadderC());
        player.setRowPosition(map.getLadderR());
    }

    @Override
    public void paint(Graphics g) {
        Graphics bg = buffer.getGraphics();
        for (int i = 0; i < WumpusMap.NUM_ROWS; i++)
            for (int j = 0; j < WumpusMap.NUM_COLUMNS; j++)
                bg.drawImage(floor, j*50+20, i*50+20, null);

        g.drawImage(buffer, 50, 50, null);
    }
}
