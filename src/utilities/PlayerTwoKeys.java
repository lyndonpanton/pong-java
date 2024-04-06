package utilities;

import java.awt.event.KeyEvent;

public class PlayerTwoKeys extends Keys {
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_UP:
                action.movement = -1;
                break;
            case KeyEvent.VK_DOWN:
                action.movement = 1;
                break;
            case KeyEvent.VK_ESCAPE:
                action.togglePause = !action.togglePause;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
                action.movement = 0;
                break;
        }
    }
}
