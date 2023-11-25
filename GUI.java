import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI{
    private final JFrame frame;
    private final JPanel gamePanel;
    private final Snake snake;
    public GUI() {
        snake = new Snake();

        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        frame.setSize(900,900);
        frame.setLocation(500,50);
        frame.setVisible(true);

        gamePanel = new JPanel();
        gamePanel.setSize(900,900);
        gamePanel.setBackground(Color.GREEN);
        gamePanel.setFocusable(true);
        gamePanel.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_SPACE -> {
                        snake.moveBody();
                    }
                    case KeyEvent.VK_LEFT -> {
                        snake.changeDirection(Direction.LEFT);
                    }
                    case KeyEvent.VK_RIGHT -> {
                        snake.changeDirection(Direction.RIGHT);
                    }
                    case KeyEvent.VK_UP -> {
                        snake.changeDirection(Direction.UP);
                    }
                    case KeyEvent.VK_DOWN -> {
                        snake.changeDirection(Direction.DOWN);
                    }
                    case KeyEvent.VK_ENTER -> {
                        snake.addLast();
                    }
                }
            }
        });
        gamePanel.setVisible(true);
        frame.add(gamePanel);
        gamePanel.requestFocusInWindow();
    }

    public static void main(String[] args) {
        new GUI();
    }
}
