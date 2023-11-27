public class Snake {
    private SnakeBodyPart head;
    private SnakeBodyPart tail;
    private Board board;

    public Snake(Board board) {
        this.board = board;
        this.head = new SnakeBodyPart(0,0,Direction.RIGHT, this.board);
        this.tail = this.head;
    }

    public void moveBody() {
        this.head.move(head.getDirection());
    }

    public void addLast() {
        SnakeBodyPart bodyPart = createBehind(this.tail);
        this.tail.setPrevious(bodyPart);
        this.tail = bodyPart;
    }

    public void updateDirection(Direction direction) {
        this.head.setDirection(direction);
    }

    public SnakeBodyPart getLast() {
        return this.tail;
    }

    public SnakeBodyPart createBehind(SnakeBodyPart ahead) {
        SnakeBodyPart bodyPart = null;
        if(ahead.getDirection() == Direction.UP)
            bodyPart = new SnakeBodyPart(ahead.getRow()+1,  ahead.getColumn(), ahead.getDirection(), this.board);
        else if(ahead.getDirection() == Direction.DOWN)
            bodyPart = new SnakeBodyPart(ahead.getRow()-1, ahead.getColumn(), ahead.getDirection(), this.board);
        else if(ahead.getDirection() == Direction.LEFT)
            bodyPart = new SnakeBodyPart(ahead.getRow(), ahead.getColumn()+1, ahead.getDirection(), this.board);
        else if(ahead.getDirection() == Direction.RIGHT)
            bodyPart = new SnakeBodyPart(ahead.getRow(), ahead.getColumn()-1, ahead.getDirection(), this.board);
        return bodyPart;
    }
}
