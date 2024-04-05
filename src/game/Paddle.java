package game;

import utilities.Action;
import utilities.Controller;
import utilities.Vector2D;

import java.awt.*;

public class Paddle {
    public static final int WIDTH = 10;
    public static final int HEIGHT = 40;

    public static final double SPEED = 200;

    public Color colour;

    public Vector2D position;
    public Vector2D velocity;
    public Vector2D direction;

    private final Controller controller;

    public Paddle(Controller controller, Vector2D position, Vector2D direction, Color colour) {
        this.controller = controller;
        this.position = position;
        this.velocity = new Vector2D(0, 0);
        this.direction = direction;
        this.colour = colour;
    }

    public void draw(Graphics2D g2D) {
        g2D.setColor(this.colour);
        g2D.fillRect((int) position.x, (int) position.y, WIDTH, HEIGHT);
    }

    public void update() {
        Action action = controller.getAction();
    }
}
