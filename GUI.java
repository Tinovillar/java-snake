import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI{
    private final GameFrame gameFrame;
    private final GamePanel gamePanel;
    private final Game game;
    public GUI(Game game) {
        this.game = game;
        this.gamePanel = new GamePanel(this.game);
        this.gameFrame = new GameFrame(this.gamePanel);
    }

    public void asociateGraphicEntity(SnakeBodyPart snakeBodyPart) {
        GraphicEntity graphicEntity = new GraphicEntity(snakeBodyPart);
        gamePanel.add(graphicEntity);
    }
}
