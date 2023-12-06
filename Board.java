public class Board {
    private Entity[][] board;
    private Snake snake;
    private Game game;

    public Board(Game game) {
        this.game = game;
        this.board = new Entity[Utils.boardDimension][Utils.boardDimension];
        this.snake = new Snake(this);
        initializeBoard();
    }

    public void move() {
        this.snake.moveBody();
    }

    public void addFood() {
        Food food = null;
        int randomRow, randomColumn;
        do {
            randomRow = (int) (Math.random() * Utils.boardDimension);
            randomColumn = (int) (Math.random() * Utils.boardDimension);
            food = new Food(randomRow, randomColumn, this);
        } while(!food.canRecibeMe(board[randomRow][randomColumn]));
        add(food);
    }

    public void add(Entity entity) {
        this.board[entity.getRow()][entity.getColumn()] = entity;
        this.game.sendToGUI(entity);
    }

    public void remove(Entity entity) {
        this.board[entity.getRow()][entity.getColumn()] = new AirEntity(entity.getRow(),entity.getColumn(),this);
    }

    public void update(Entity entity) {
        this.board[entity.getRow()][entity.getColumn()] = entity;
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
        for (int i = 0; i < Utils.boardDimension; i++) {
            for (int j = 0; j < Utils.boardDimension; j++) {
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
