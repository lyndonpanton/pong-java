package game;

import utilities.Vector2D;

import java.awt.*;

import static utilities.Constants.*;

public abstract class GameObject {
    public Vector2D position;
    public Vector2D velocity;
    public boolean isDead;

    public GameObject(Vector2D position, Vector2D velocity) {
        this.position = position;
        this.velocity = velocity;
    }

    public void collision() {

    }

    public abstract void update();

    public abstract void draw(Graphics2D g2D);
}
