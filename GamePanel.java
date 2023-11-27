import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {
    private Game game;
    public GamePanel(Game game) {
        this.game = game;
        setLayout(null);
        setPreferredSize(new Dimension(30*20,30*20));
        setOpaque(true);
        setFocusable(true);
        setBackground(Color.BLACK);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT -> {
                        game.notifyMove(Direction.LEFT);
                        game.move();
                    }
                    case KeyEvent.VK_RIGHT -> {
                        game.notifyMove(Direction.RIGHT);
                        game.move();
                    }
                    case KeyEvent.VK_UP -> {
                        game.notifyMove(Direction.UP);
                        game.move();
                    }
                    case KeyEvent.VK_DOWN -> {
                        game.notifyMove(Direction.DOWN);
                        game.move();
                    }
                    case KeyEvent.VK_SPACE -> {
                        game.addFood();
                    }
                    case KeyEvent.VK_ENTER -> {
                        game.createBodyPart();
                    }
                }
            }
        });
        setVisible(true);
        requestFocusInWindow();
    }
}
