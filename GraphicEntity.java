import javax.swing.*;
import java.awt.*;

public class GraphicEntity extends JLabel {
    private SnakeBodyPart logicalEntity;
    public GraphicEntity(SnakeBodyPart logicalEntity) {
        this.logicalEntity = logicalEntity;
        this.logicalEntity.setGraphicEntity(this);
        setBounds(logicalEntity.getColumn()*25, logicalEntity.getRow()*25,25,25);
        setBackground(Color.GREEN);
        setOpaque(true);
        setVisible(true);
    }

    public void updateLocation() {
        setLocation(logicalEntity.getColumn()*25, logicalEntity.getRow()*25);
    }
}
