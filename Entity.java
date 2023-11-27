import java.awt.*;

public abstract class Entity implements Movable, Eatable{
    protected int row;
    protected int column;
    protected Board board;
    protected GraphicEntity graphicEntity;
    protected Color color;

    public Entity(int row, int column, Board board) {
        this.row = row;
        this.column = column;
        this.board = board;
    }

    public Color getColor() {
        return this.color;
    }

    public void destroy() {
        this.board.remove(this);
        this.graphicEntity.destroy();
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

    public void updateGraphicEntity() {
        graphicEntity.updateLocation();
    }

    public void setGraphicEntity(GraphicEntity graphicEntity) {
        this.graphicEntity = graphicEntity;
    }

    public String toString() {
        return "row: " + row + " - column: " + column;
    }
}
