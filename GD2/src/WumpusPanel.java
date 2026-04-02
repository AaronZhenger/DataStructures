import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class WumpusPanel extends JPanel implements KeyListener {
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

    private boolean cheat = false;

    public WumpusPanel() {
        setSize(621, 700);
        addKeyListener(this);

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
        System.out.println(map);
        player = new WumpusPlayer();
        player.setColPosition(map.getLadderC());
        player.setRowPosition(map.getLadderR());
    }

    @Override
    public void paint(Graphics g) {
        map.getSquare(map.getLadderC(), map.getLadderR()).setVisited(true);
        Graphics bg = buffer.getGraphics();
        for (int i = 0; i < WumpusMap.NUM_ROWS; i++)
            for (int j = 0; j < WumpusMap.NUM_COLUMNS; j++) {
                int x = j*50;
                int y = i*50;
                WumpusSquare tile = map.getSquare(j, i);
                if (!cheat && !tile.getVisited()) {
                    bg.drawImage(fog, x, y, null);
                }
                else {
                    bg.drawImage(floor, x, y, null);
                    switch (tile.toString()) {
                        case "W" -> bg.drawImage(wumpus, x, y, null);
                        case "D" -> bg.drawImage(deadWumpus, x, y, null);
                        case "L" -> bg.drawImage(ladder, x, y, null);
                        case "P" -> bg.drawImage(pit, x, y, null);
                        case "G" -> bg.drawImage(gold, x, y, null);
                        case "@" -> {
                            bg.drawImage(wumpus, x, y, null);
                            bg.drawImage(gold, x, y, null);
                        }
                        case "!" -> {
                            bg.drawImage(deadWumpus, x, y, null);
                            bg.drawImage(gold, x, y, null);
                        }
                    }
                    if (tile.getBreeze()) bg.drawImage(breeze, x, y, null);
                    if (tile.getStench()) bg.drawImage(stench, x, y, null);
                }
                BufferedImage playerDirection = playerUp;
                switch (player.getDirection()) {
                    case WumpusPlayer.NORTH -> playerDirection = playerUp;
                    case WumpusPlayer.EAST -> playerDirection = playerRight;
                    case WumpusPlayer.SOUTH -> playerDirection = playerDown;
                    case WumpusPlayer.WEST -> playerDirection = playerLeft;
                }
                bg.drawImage(playerDirection, player.getColPosition()*50, player.getRowPosition()*50, null);
            }

        g.drawImage(buffer, 50, 50, null);
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar()=='w' && player.getRowPosition()>0) {
            player.setRowPosition(player.getRowPosition()-1);
            player.setDirection(WumpusPlayer.NORTH);
        }

        if (e.getKeyChar()=='a' && player.getColPosition()>0) {
            player.setColPosition(player.getColPosition()-1);
            player.setDirection(WumpusPlayer.WEST);
        }

        if (e.getKeyChar()=='s' && player.getRowPosition()<WumpusMap.NUM_ROWS-1) {
            player.setRowPosition(player.getRowPosition()+1);
            player.setDirection(WumpusPlayer.SOUTH);
        }

        if (e.getKeyChar()=='d' && player.getColPosition()<WumpusMap.NUM_COLUMNS-1) {
            player.setColPosition(player.getColPosition()+1);
            player.setDirection(WumpusPlayer.EAST);
        }

        map.getSquare(player.getColPosition(), player.getRowPosition()).setVisited(true);

        if (e.getKeyChar()=='*')
            cheat = !cheat;
        paint(getGraphics());
    }

    @Override
    public void addNotify() {
        super.addNotify();
        requestFocus();
    }
}
