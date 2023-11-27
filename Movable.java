public interface Movable {
    public boolean canRecibeMe(Entity entity);
    public boolean canRecibe(Food food);
    public boolean canRecibe(SnakeBodyPart snakeBodyPart);
    public boolean canRecibe(AirEntity airEntity);
}
