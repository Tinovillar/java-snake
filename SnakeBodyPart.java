import java.awt.*;

public class SnakeBodyPart extends Entity{
    private Direction direction;
    private SnakeBodyPart previous;
    public SnakeBodyPart(int row, int column, Direction direction, Board board) {
        super(row,column,board);
        this.direction = direction;
        this.color = Color.GREEN;
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
        int[] nextMove = nextMove(direction);
        Entity nextEntity = this.board.getEntity(this.row + nextMove[0], this.column + nextMove[1]);
        if(nextEntity.canRecibeMe(this)) {
            this.board.fillWithAir(this);
            if(nextEntity.canEatMe(this)) {
                nextEntity.destroy();
            }
            this.row += nextMove[0];
            this.column += nextMove[1];
            this.board.update(this);
        } else {
            this.board.notifyWasDead();
        }
    }

    public boolean inRange(int row, int column) {
        int possibleRow = this.row + row;
        int possibleColumn = this.column + column;
        return possibleRow >= 0 && possibleRow < 20 && possibleColumn >= 0 && possibleColumn < 20;
    }

    public int[] nextMove(Direction direction) {
        int[] nextMove = {0,0};
        if(direction == Direction.UP) {
            if(inRange(-1,0))
                nextMove[0] = -1;
        } else if(direction == Direction.DOWN) {
            if (inRange(1, 0))
                nextMove[0] = 1;
        } else if(direction == Direction.LEFT) {
            if (inRange(0, -1))
                nextMove[1] = -1;
        } else if(direction == Direction.RIGHT) {
            if (inRange(0, 1))
                nextMove[1] = 1;
        }
        return nextMove;
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

    public void eat(Food food) {
        this.board.createBodyPart();
        this.board.addFood();
    }

    @Override
    public boolean canRecibeMe(Entity entity) {
        return entity.canRecibe(this);
    }

    @Override
    public boolean canRecibe(Food food) {
        return true;
    }

    @Override
    public boolean canRecibe(SnakeBodyPart snakeBodyPart) {
        return false;
    }

    @Override
    public boolean canRecibe(AirEntity airEntity) {
        return true;
    }

    public boolean canEatMe(Entity entity) {
        return entity.canEat(this);
    }

    @Override
    public boolean canEat(Food food) {
        this.eat(food);
        return true;
    }

    @Override
    public boolean canEat(AirEntity airEntity) {
        return false;
    }

    @Override
    public boolean canEat(SnakeBodyPart snakeBodyPart) {
        return false;
    }
}
