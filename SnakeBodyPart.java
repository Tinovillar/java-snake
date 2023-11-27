public class SnakeBodyPart {
    private int row;
    private int column;
    private Direction direction;
    private SnakeBodyPart previous;
    private Board board;
    private GraphicEntity graphicEntity;
    public SnakeBodyPart(int row, int column, Direction direction, Board board) {
        this.row = row;
        this.column = column;
        this.direction = direction;
        this.board = board;
        this.board.add(this);
    }

    public void move(Direction direction) {
        moveTo(this.direction);
        updateGraphicEntity();
        if(hasPrevious()) {
            this.previous.move(this.direction);
        }
        this.direction = direction;
    }

    public void moveTo(Direction direction) {
        this.board.remove(this);
        if(direction == Direction.UP)
            this.row--;
        else if(direction == Direction.DOWN)
            this.row++;
        else if(direction == Direction.LEFT)
            this.column--;
        else if(direction == Direction.RIGHT)
            this.column++;
        this.board.update(this);
    }

    public void updateGraphicEntity() {
        graphicEntity.updateLocation();
    }

    public void setGraphicEntity(GraphicEntity graphicEntity) {
        this.graphicEntity = graphicEntity;
    }

    public boolean hasPrevious() {
        return this.previous != null;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction direction) {
        if(!areOpposite(direction, this.direction))
            this.direction = direction;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setPrevious(SnakeBodyPart bodyPart) {
        this.previous = bodyPart;
    }

    public SnakeBodyPart getPrevious() {
        return this.previous;
    }

    public String toString() {
        return "row: " + row + " - column: " + column + " - Direction: " + direction.toString();
    }

    public boolean areOpposite(Direction direction1, Direction direction2) {
        boolean toReturn = false;
        if(direction1 == Direction.UP && direction2 == Direction.DOWN) toReturn = true;
        else if(direction1 == Direction.DOWN && direction2 == Direction.UP) toReturn = true;
        else if(direction1 == Direction.LEFT && direction2 == Direction.RIGHT) toReturn = true;
        else if(direction1 == Direction.RIGHT && direction2 == Direction.LEFT) toReturn = true;
        return toReturn;
    }
}
