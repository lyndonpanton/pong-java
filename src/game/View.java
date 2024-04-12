package game;

import manager.SpriteManager;
import utilities.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

import static utilities.Constants.FRAME_HEIGHT;
import static utilities.Constants.FRAME_WIDTH;

public class View extends JComponent {
    public static final Color BACKGROUND_COLOR = Color.BLACK;
    public static final Color TEXT_COLOR = Color.WHITE;
    public static final int SCORE_FONT_SIZE = 36;
    public static final String font = Font.MONOSPACED;

    private final Game game;
    private Image BACKGROUND_IMAGE = SpriteManager.BOARD;
    private final AffineTransform backgroundTransformation;

    public View(Game game) {
        this.game = game;

        double imageWidth = BACKGROUND_IMAGE.getWidth(null);
        double imageHeight = BACKGROUND_IMAGE.getHeight(null);
        double stretchX =
                imageWidth < FRAME_WIDTH ? 1 : FRAME_WIDTH / imageWidth;
        double stretchY =
                imageHeight < FRAME_HEIGHT ? 1 : FRAME_HEIGHT / imageHeight;

        backgroundTransformation = new AffineTransform();
        backgroundTransformation.scale(stretchX, stretchY);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

//        g2D.setColor(BACKGROUND_COLOR);
//        g2D.fillRect(0, 0, getWidth(), getHeight());
        g2D.drawImage(BACKGROUND_IMAGE, backgroundTransformation, null);

        synchronized (Game.class) {
            for (GameObject gameObject : game.gameObjects) {
                gameObject.draw(g2D);
            }
        }

        g2D.setColor(TEXT_COLOR);

        g2D.setFont(new Font(
                font, Font.PLAIN, SCORE_FONT_SIZE
        ));

        g2D.drawString(
                String.valueOf(Game.getPlayerOneScore()),
                50,
                50
        );
        g2D.drawString(
                String.valueOf(Game.getPlayerTwoScore()),
                FRAME_WIDTH - 50,
                50
        );
    }

    @Override
    public Dimension getPreferredSize() {
        return Constants.FRAME_SIZE;
    }
}
