public class Game {
    private GUI myGUI;
    private Board myBoard;
    private GameLoop gameLoop;
    private boolean paused;
    public Game() {
        this.paused = false;
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
        myGUI.loseGame();
    }
    public boolean isPaused() {
        return this.paused;
    }

    public void pauseGame() {
        this.paused = !this.paused;
    }

    public static void main(String[] args) {
        new Game();
    }
}
