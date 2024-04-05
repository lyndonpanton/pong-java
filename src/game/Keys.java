package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.PackedColorModel;

public class Keys extends KeyAdapter implements Controller {
    Action action;

    public Keys() {
        action = new Action();
    }

    // Defined to comply with the interface definition
    public Action getAction() {
        return action;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch(key) {
            case KeyEvent.VK_UP:
                action.thrust = 1;
                break;
            case KeyEvent.VK_RIGHT:
                action.turn = 1;
                break;
            case KeyEvent.VK_LEFT:
                action.turn = -1;
                break;
            case KeyEvent.VK_SPACE:
                action.isShooting = true;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_UP:
                action.thrust = 0;
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_LEFT:
                action.turn = 0;
                break;
            case KeyEvent.VK_SPACE:
                action.isShooting = false;
        }
    }
}
