import javax.swing.*;

public class PuzzleFrame extends JFrame {
    public PuzzleFrame() {
        super("Puzzle");
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new PuzzlePanel());
        setVisible(true);
    }
}
