public class Board {
    private Entity[][] board;
    private Snake snake;
    private Game game;

    public Board(Game game) {
        this.game = game;
        this.board = new Entity[20][20];
        this.snake = new Snake(this);
        initializeBoard();
    }

    public void move() {
        this.snake.moveBody();
    }

    public void addFood() {
        int randomRow = (int) (Math.random() * 20);
        int randomColumn = (int) (Math.random() * 20);
        new Food(randomRow, randomColumn, this);
    }

    public void add(Entity entity) {
        this.board[entity.getRow()][entity.getColumn()] = entity;
        this.game.sendToGUI(entity);
    }

    public void remove(Entity entity) {
        this.board[entity.getRow()][entity.getColumn()] = null;
    }

    public void update(Entity entity) {
        this.board[entity.getRow()][entity.getColumn()] = entity;
    }

    public void fillWithAir(Entity entity) {
        this.board[entity.getRow()][entity.getColumn()] = new AirEntity(entity.getRow(),entity.getColumn(),this);
    }

    public void updateDirection(Direction direction) {
        this.snake.updateDirection(direction);
    }

    public void createBodyPart() {
        this.snake.addLast();
    }

    public Entity getEntity(int row, int column) {
        return board[row][column];
    }

    public void notifyWasDead() {
        this.game.loseGame();
    }

    public void initializeBoard() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if(this.board[i][j] == null)
                    this.board[i][j] = new AirEntity(i,j,this);
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(board[i][j] != null) {
                    System.out.print(" * ");
                } else {
                    System.out.print(" 0 ");
                }
            }
            System.out.println('\n');
        }
        System.out.println("-------------------------------------------------");
    }
}
