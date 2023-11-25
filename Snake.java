public class Snake {
    private SnakeBodyPart head;
    private SnakeBodyPart tail;

    public Snake() {
        this.head = new SnakeBodyPart(0,0,Direction.RIGHT);
        this.tail = this.head;
    }

    public void moveBody() {
        tail.move();
    }

    public void addLast() {
        SnakeBodyPart bodyPart = createBehind(this.tail);
        bodyPart.setNextBodyPart(this.tail);
        this.tail = bodyPart;
    }

    public void changeDirection(Direction direction) {
        this.head.setDirection(direction);
    }

    public SnakeBodyPart createBehind(SnakeBodyPart ahead) {
        SnakeBodyPart bodyPart = null;
        if(ahead.getDirection() == Direction.UP)
            bodyPart = new SnakeBodyPart(ahead.getPosX(), ahead.getPosY()+1, ahead.getDirection());
        else if(ahead.getDirection() == Direction.DOWN)
            bodyPart = new SnakeBodyPart(ahead.getPosX(), ahead.getPosY()-1, ahead.getDirection());
        else if(ahead.getDirection() == Direction.LEFT)
            bodyPart = new SnakeBodyPart(ahead.getPosX()+1, ahead.getPosY(), ahead.getDirection());
        else if(ahead.getDirection() == Direction.RIGHT)
            bodyPart = new SnakeBodyPart(ahead.getPosX()-1, ahead.getPosY(), ahead.getDirection());
        return bodyPart;
    }
}
