package utilities;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public abstract class Keys extends KeyAdapter implements Controller {
    protected Action action;

    public Keys()
    {
        action = new Action();
    }

    public Action getAction() {
        // Defined to be inline with the interface definition
        return action;
    }

    public abstract void keyPressed(KeyEvent e);

    public abstract void keyReleased(KeyEvent e);
}
