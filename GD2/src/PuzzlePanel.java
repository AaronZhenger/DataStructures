import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PuzzlePanel extends JPanel implements MouseListener {
    private static BufferedImage buffer;
    private int[][] arr;

    public static final int PLAYING = 0;
    public static final int WON = 1;

    int missingI;
    int missingJ;

    int status;

    int moves;

    boolean images = false;

    BufferedImage[] sliced = new BufferedImage[16];

    public static final int[][] complete = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,-1}};

    public PuzzlePanel() {
        setSize(600, 800);
        addMouseListener(this);

        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
        reset();

        setVisible(true);
    }

    private void reset() {
        moves = 0;
        status = PLAYING;
        arr = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, -1}};
        missingI = 3;
        missingJ = 3;
        for (int i = 0; i < 500; i++) {
            int kI = (int)(Math.random()*4);
            int kJ = (int)(Math.random()*4);
            if ((kI == missingI - 1 && kJ == missingJ) || (kI == missingI + 1 && kJ == missingJ) || (kJ == missingJ + 1 && kI == missingI) || (kJ == missingJ - 1 && kI == missingI)) {
                arr[missingI][missingJ] = arr[kI][kJ];
                arr[kI][kJ] = -1;
                missingI = kI;
                missingJ = kJ;
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        Graphics bg = buffer.getGraphics();
        bg.setColor(new Color(30, 30, 30));
        bg.fillRect(0, 0, getWidth(), getHeight());

        boolean solved = true;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    BufferedImage img = ImageIO.read(new File("src/Images/job.png"));
                    Image tmp = img.getScaledInstance(400, 400, Image.SCALE_SMOOTH);
                    BufferedImage full = new BufferedImage(400, 400, BufferedImage.TYPE_INT_ARGB);

                    Graphics ig = full.createGraphics();
                    ig.drawImage(tmp, 0, 0, null);
                    ig.dispose();

                    sliced[i*4+j] = full.getSubimage(100*j, 100*i, 90, 90);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (arr[i][j]!=complete[i][j]) solved = false;
                bg.setColor(Color.WHITE);
                bg.drawRect(i*100+100, j*100+200, 90, 90);
                bg.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 40));
                if (arr[i][j]!=-1)
                    if (!images) {
                        bg.drawString(String.valueOf(arr[i][j]).length()==2 ? String.valueOf(arr[i][j]) : " "+arr[i][j], j*100+125, i*100+260);
                    } else {
                        bg.drawImage(sliced[arr[i][j]-1], j*100+100, i*100+200, null);
                    }
                else {
                    missingI = i;
                    missingJ = j;
                }
            }
        }

        bg.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 28));
        bg.drawRect(100, 120, 160, 70);
        bg.drawString("New Game", 110, 165);
        bg.drawRect(330, 120, 160, 70);
        bg.drawString("Moves: "+moves, 350, 165);
        bg.drawRect(330, 40, 160, 70);
        bg.drawString("Mode", 380, 85);

        if (solved) status = WON;

        g.drawImage(buffer, 0, 0, null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (status == PLAYING) {
            int i = -1;
            int j = -1;
            if (e.getX() >= 100 && e.getX() < 500)
                j = (e.getX() / 100) - 1;
            if (e.getY() >= 200 && e.getY() < 600)
                i = (e.getY() / 100) - 2;
            System.out.println(i+" "+j);
            if ((i == missingI - 1 && j == missingJ) || (i == missingI + 1 && j == missingJ) || (j == missingJ + 1 && i == missingI) || (j == missingJ - 1 && i == missingI)) {
                arr[missingI][missingJ] = arr[i][j];
                arr[i][j] = -1;
                moves++;
            }
        } else {
            System.out.println("WON");

        }

        if (e.getX()>=100 && e.getX()<=260 && e.getY()<=190 && e.getY()>=120) reset();

        if (e.getX()>=330 && e.getX()<=490 && e.getY()<=110 && e.getY()>=40) images = !images;

        System.out.println("Mouse X: "+ e.getX());
        System.out.println("Mouse Y: "+ e.getY());


        paint(getGraphics());
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void addNotify() {
        super.addNotify();
        requestFocus();
    }
}
