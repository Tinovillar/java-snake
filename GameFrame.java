import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private GamePanel gamePanel;
    public GameFrame(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);
        setLocation(500,50);
        setVisible(true);
        getContentPane().add(gamePanel);
        pack();
    }
}
