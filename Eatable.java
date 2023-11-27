public interface Eatable {
    public boolean canEatMe(Entity entity);
    public boolean canEat(Food food);
    public boolean canEat(AirEntity airEntity);
    public boolean canEat(SnakeBodyPart snakeBodyPart);
}
