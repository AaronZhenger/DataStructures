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

    private static JPanel p_inv = new JPanel();

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
    private boolean showInfo = true;

    private int wumpusRow;
    private int wumpusCol;

    private boolean kill;

    public WumpusPanel() {
        setSize(10000, 10000);

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

        setVisible(true);
        reset();
    }

    public void reset() {
        status = PLAYING;
        map = new WumpusMap();
        map.createMap();
        System.out.println(map);
        wumpusCol=map.getWumpusPosX();
        wumpusRow=map.getWumpusPosY();
        player = new WumpusPlayer();
        player.setColPosition(map.getLadderC());
        player.setRowPosition(map.getLadderR());
    }

    @Override
    public void paint(Graphics g) {
        map.getSquare(map.getLadderC(), map.getLadderR()).setVisited(true);
        Graphics bg = buffer.getGraphics();
        bg.setColor(Color.GRAY);
        bg.fillRect(0, 0, getWidth(), getHeight());
        for (int i = 0; i < WumpusMap.NUM_ROWS; i++)
            for (int j = 0; j < WumpusMap.NUM_COLUMNS; j++) {
                int x = j*50+50;
                int y = i*50+50;
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
                bg.drawImage(playerDirection, player.getColPosition()*50+50, player.getRowPosition()*50+50, null);

                if (showInfo) {
                    bg.setColor(Color.BLACK);
                    bg.fillRect(0, 580, 180, 180);
                    bg.fillRect(190, 580, getWidth() - 190, 180);
                    bg.setColor(Color.RED);
                    bg.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 25));
                    bg.drawString("Inventory:", 10, 615);
                    bg.drawString("Messages:", 200, 615);
                    WumpusSquare currentSquare = map.getSquare(player.getColPosition(), player.getRowPosition());
                    if (player.getArrow())
                        bg.drawImage(arrow, 20, 660, null);
                    if (player.getGold())
                        bg.drawImage(gold, 110, 660, null);
                    int messageY = 650;
                    bg.setColor(Color.CYAN);
                    bg.setFont(new Font(Font.DIALOG_INPUT, Font.PLAIN, 20));
                    if (status == WON) {
                        bg.drawString("You win!", 200, messageY);
                    } else {
                        if (currentSquare.getBreeze()) {
                            bg.drawString("You feel a breeze", 200, messageY);
                            messageY += 25;
                        }
                        if (currentSquare.getStench() || currentSquare.getDeadWumpus()) {
                            bg.drawString("You smell a stench", 200, messageY);
                            messageY += 25;
                        }
                        if (currentSquare.getGold()) {
                            bg.drawString("You see a glimmer", 200, messageY);
                            messageY += 25;
                        }
                        if (currentSquare.getLadder()) {
                            bg.drawString("You bump into a ladder", 200, messageY);
                            messageY += 25;
                        }
                        if (currentSquare.getPit()) {
                            bg.drawString("You fell down a pit to your death", 200, messageY);
                            messageY += 25;
                        }
                        if (currentSquare.getWumpus()) {
                            bg.drawString("You feel a breeze", 200, messageY);
                            messageY += 25;
                        }
                        if (kill) {
                            bg.drawString("You hear a scream", 200, messageY);
                        }
                    }
                }
            }

        g.drawImage(buffer, 0, 0, null);
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

        if (status==PLAYING) {
            if (e.getKeyChar() == 'w' && player.getRowPosition() > 0) {
                player.setRowPosition(player.getRowPosition() - 1);
                player.setDirection(WumpusPlayer.NORTH);
            }

            if (e.getKeyChar() == 'a' && player.getColPosition() > 0) {
                player.setColPosition(player.getColPosition() - 1);
                player.setDirection(WumpusPlayer.WEST);
            }

            if (e.getKeyChar() == 's' && player.getRowPosition() < WumpusMap.NUM_ROWS - 1) {
                player.setRowPosition(player.getRowPosition() + 1);
                player.setDirection(WumpusPlayer.SOUTH);
            }

            if (e.getKeyChar() == 'd' && player.getColPosition() < WumpusMap.NUM_COLUMNS - 1) {
                player.setColPosition(player.getColPosition() + 1);
                player.setDirection(WumpusPlayer.EAST);
            }
            kill = false;
            if (e.getKeyChar() == 'i' && player.getArrow()) {
                player.setArrow(false);
                if (player.getRowPosition() > wumpusRow && player.getColPosition() == wumpusCol) {
                    map.getSquare(wumpusCol, wumpusRow).setWumpus(false);
                    map.getSquare(wumpusCol, wumpusRow).setDeadWumpus(true);
                    kill = true;
                }
            }
            if (e.getKeyChar() == 'j' && player.getArrow()) {
                player.setArrow(false);
                if (player.getRowPosition() == wumpusRow && player.getColPosition() > wumpusCol) {
                    map.getSquare(wumpusCol, wumpusRow).setWumpus(false);
                    map.getSquare(wumpusCol, wumpusRow).setDeadWumpus(true);
                    kill = true;
                }
            }
            if (e.getKeyChar() == 'l' && player.getArrow()) {
                player.setArrow(false);
                if (player.getRowPosition() == wumpusRow && player.getColPosition() < wumpusCol) {
                    map.getSquare(wumpusCol, wumpusRow).setWumpus(false);
                    map.getSquare(wumpusCol, wumpusRow).setDeadWumpus(true);
                    kill = true;
                }
            }
            if (e.getKeyChar() == 'k' && player.getArrow()) {
                player.setArrow(false);
                if (player.getRowPosition() < wumpusRow && player.getColPosition() == wumpusCol) {
                    map.getSquare(wumpusCol, wumpusRow).setWumpus(false);
                    map.getSquare(wumpusCol, wumpusRow).setDeadWumpus(true);
                    kill = true;
                }
            }
            WumpusSquare currentSquare = map.getSquare(player.getColPosition(), player.getRowPosition());
            currentSquare.setVisited(true);
            if (currentSquare.getLadder() && player.getGold() && e.getKeyChar()=='c')
                status=WON;
            if (currentSquare.getGold() && e.getKeyChar()=='p') {
                player.setGold(true);
                currentSquare.setGold(false);
            }
            if (currentSquare.getPit())
                status=DEAD;
            if (currentSquare.getWumpus())
                status=DEAD;
        }
        else {
            if (e.getKeyChar()=='n')
                reset();
        }

        if (e.getKeyChar()=='*')
            cheat = !cheat;
        if (e.getKeyChar()=='&')
            showInfo = !showInfo;
        paint(getGraphics());
    }

    @Override
    public void addNotify() {
        super.addNotify();
        requestFocus();
    }
}
