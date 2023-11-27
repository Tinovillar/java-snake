import java.awt.*;

public class AirEntity extends Entity{
    public AirEntity(int row, int column, Board board) {
        super(row, column, board);
        this.board.add(this);
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
        return true;
    }

    @Override
    public boolean canRecibe(AirEntity airEntity) {
        return true;
    }

    @Override
    public boolean canEatMe(Entity entity) {
        return entity.canEat(this);
    }

    @Override
    public boolean canEat(Food food) {
        return false;
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
