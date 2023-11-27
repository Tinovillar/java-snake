public class Board {
    private SnakeBodyPart[][] board;
    private Snake snake;
    private Game game;

    public Board(Game game) {
        this.game = game;
        this.board = new SnakeBodyPart [20][20];
        this.snake = new Snake(this);
    }

    public void move() {
        this.snake.moveBody();
        printBoard();
    }

    public void add(SnakeBodyPart bodyPart) {
        this.board[bodyPart.getRow()][bodyPart.getColumn()] = bodyPart;
        this.game.sendToGUI(bodyPart);
        printBoard();
    }

    public void remove(SnakeBodyPart bodyPart) {
        this.board[bodyPart.getRow()][bodyPart.getColumn()] = null;
    }

    public void update(SnakeBodyPart bodyPart) {
        this.board[bodyPart.getRow()][bodyPart.getColumn()] = bodyPart;
    }

    public void updateDirection(Direction direction) {
        this.snake.updateDirection(direction);
    }

    public void createBodyPart() {
        this.snake.addLast();
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
