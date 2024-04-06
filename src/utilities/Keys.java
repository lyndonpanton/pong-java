package utilities;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keys extends KeyAdapter implements Controller {
    private Action action;

    public Keys()
    {
        action = new Action();
    }

    public Action getAction() {
        // Defined to be inline with the interface definition
        return action;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                action.movement = -1;
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                action.movement = 1;
                break;
            case KeyEvent.VK_ESCAPE:
                action.togglePause = !action.togglePause;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                action.movement = 0;
                break;
        }
    }
}
