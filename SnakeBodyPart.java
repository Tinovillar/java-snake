public class SnakeBodyPart {
    private int posX;
    private int posY;
    private Direction direction;
    private SnakeBodyPart next;
    public SnakeBodyPart(int posX, int posY, Direction direction) {
        this.posX = posX;
        this.posY = posY;
        this.direction = direction;
    }

    public void move() {
        moveTo(this.direction);
        if(hasNext()) {
            this.direction = this.next.getDirection();
            this.next.move();
        }
    }

    public void moveTo(Direction direction) {
        if(direction == Direction.UP)
            this.posY--;
        else if(direction == Direction.DOWN)
            this.posY++;
        else if(direction == Direction.LEFT)
            this.posX--;
        else if(direction == Direction.RIGHT)
            this.posX++;
    }

    public boolean hasNext() {
        return this.next != null;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setNextBodyPart(SnakeBodyPart bodyPart) {
        this.next = bodyPart;
    }

    public SnakeBodyPart getNextBodyPart() {
        return this.next;
    }
}
