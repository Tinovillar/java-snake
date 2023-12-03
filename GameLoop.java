public class GameLoop extends Thread{
    private final Game game;
    public GameLoop(Game game) {
        this.game = game;
        this.game.addFood();
    }

    @Override
    public void run() {
        try {
            while (!this.game.isLosed()) {
                this.game.move();
                sleep(150);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
