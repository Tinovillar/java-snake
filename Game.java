public class Game {
    private GUI myGUI;
    private Board myBoard;
    public Game() {
        this.myGUI = new GUI(this);
        this.myBoard = new Board(this);
    }

    public void notifyMove(Direction direction) {
        myBoard.updateDirection(direction);
    }

    public void move() {
        myBoard.move();
    }

    public void createBodyPart() {
        myBoard.createBodyPart();
    }

    public void sendToGUI(SnakeBodyPart snakeBodyPart) {
        myGUI.asociateGraphicEntity(snakeBodyPart);
    }

    public static void main(String[] args) {
        new Game();
    }
}
