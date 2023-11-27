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

    public void addFood() {
        this.myBoard.addFood();
    }

    public void move() {
        myBoard.move();
    }

    public void createBodyPart() {
        myBoard.createBodyPart();
    }

    public void sendToGUI(Entity entity) {
        myGUI.asociateGraphicEntity(entity);
    }

    public void loseGame() {
        myGUI.loseGame();
    }

    public static void main(String[] args) {
        new Game();
    }
}
