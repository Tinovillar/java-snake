package Utils;

public class Utils {
    public static final int UP = 111;
    public static final int DOWN = 121;
    public static final int LEFT = 131;
    public static final int RIGHT = 141;
    private static final int cellWidth = 15;
    private static final int cellHeight = 15;
    private static final int life = 5;
    public static int getCellWidth() {
        return cellWidth;
    }
    public static int getBoardHeight() {
        return cellHeight;
    }
    public static int getLife() {
        return life;
    }
    public static int getOppositeDirection(int direction) {
        int toReturn = 0;
        if(direction == UP) toReturn = DOWN;
        else if (direction == DOWN) toReturn = UP;
        else if (direction == LEFT) toReturn = RIGHT;
        else if (direction == RIGHT) toReturn = LEFT;
        return toReturn;
    }
}
