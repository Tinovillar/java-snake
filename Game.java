public class Game {
    private GUI myGUI;
    private Board myBoard;
    private GameLoop gameLoop;
    private boolean losed;
    public Game() {
        this.losed = false;
        this.myGUI = new GUI(this);
        this.myBoard = new Board(this);
        this.gameLoop = new GameLoop(this);
        this.gameLoop.start();
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
        this.losed = true;
        myGUI.loseGame();
    }
    public boolean isLosed() {
        return this.losed;
    }

    public static void main(String[] args) {
        new Game();
    }
}
