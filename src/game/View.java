package game;

import utilities.Constants;

import javax.swing.*;
import java.awt.*;

public class View extends JComponent {
    public static final Color BACKGROUND_COLOR = Color.BLACK;

    private Pong game;

    public View(Pong game) {
        this.game = game;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        g2D.setColor(BACKGROUND_COLOR);
        g2D.fillRect(0, 0, getWidth(), getHeight());
        game.ball.draw(g2D);
    }

    @Override
    public Dimension getPreferredSize() {
        return Constants.FRAME_SIZE;
    }
}
