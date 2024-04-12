package utilities;

import java.awt.event.KeyEvent;

public class PlayerOneKeys extends Keys {

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_W:
                action.movement = -1;
                break;
            case KeyEvent.VK_S:
                action.movement = 1;
                break;
            case KeyEvent.VK_ESCAPE:
                action.isPaused = !action.isPaused;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_S:
                action.movement = 0;
                break;
        }
    }
}
