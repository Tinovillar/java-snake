public class GUI{
    private final GameFrame gameFrame;
    private final GamePanel gamePanel;
    private final Game game;
    public GUI(Game game) {
        this.game = game;
        this.gamePanel = new GamePanel(this.game);
        this.gameFrame = new GameFrame(this.gamePanel);
    }

    public void asociateGraphicEntity(Entity entity) {
        if(entity.getColor() != null)
            new GraphicEntity(entity, gamePanel);
    }

    public void loseGame() {
        System.exit(0);
    }
}
