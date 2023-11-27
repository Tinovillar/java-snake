import javax.swing.*;
import java.awt.*;

public class GraphicEntity extends JLabel {
    private Entity logicalEntity;
    private GamePanel gamePanel;
    public GraphicEntity(Entity logicalEntity, GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.logicalEntity = logicalEntity;
        this.logicalEntity.setGraphicEntity(this);
        setBounds(logicalEntity.getColumn()*Utils.entitySize, logicalEntity.getRow()*Utils.entitySize,Utils.entitySize,Utils.entitySize);
        setBackground(logicalEntity.getColor());
        setOpaque(true);
        setVisible(true);
        gamePanel.add(this);
        gamePanel.repaint();
    }

    public void updateLocation() {
        setLocation(logicalEntity.getColumn()*Utils.entitySize, logicalEntity.getRow()*Utils.entitySize);
        gamePanel.repaint();
    }

    public void destroy() {
        gamePanel.remove(this);
    }
}
