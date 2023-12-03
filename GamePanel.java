import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {
    private Game game;
    public GamePanel(Game game) {
        this.game = game;
        setLayout(null);
        setPreferredSize(new Dimension(Utils.entitySize*Utils.boardDimension,Utils.entitySize*Utils.boardDimension));
        setOpaque(true);
        setFocusable(true);
        setBackground(Color.BLACK);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT -> {
                        game.notifyMove(Direction.LEFT);
                    }
                    case KeyEvent.VK_RIGHT -> {
                        game.notifyMove(Direction.RIGHT);
                    }
                    case KeyEvent.VK_UP -> {
                        game.notifyMove(Direction.UP);
                    }
                    case KeyEvent.VK_DOWN -> {
                        game.notifyMove(Direction.DOWN);
                    }
                }
            }
        });
        setVisible(true);
        requestFocusInWindow();
    }
}
