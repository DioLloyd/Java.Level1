import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ColorMenuMouseListener implements MouseListener {
    private Color color;

    public ColorMenuMouseListener(Color color, JPanel jPanel) {
        this.color = color;
        this.jPanel = jPanel;
    }

    private JPanel jPanel;

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        jPanel.setBackground(color);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
