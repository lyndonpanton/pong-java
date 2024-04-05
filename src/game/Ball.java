package game;

import utilities.Vector2D;

import java.awt.*;
import java.beans.VetoableChangeListener;
import java.lang.management.GarbageCollectorMXBean;

import static utilities.Constants.*;

public class Ball {
    public static final int RADIUS = 10;
    public static final double MAX_SPEED = 100;

    private Vector2D position;
    private Vector2D velocity;
    public boolean dead;

    public Ball(double x, double y, double velocityX, double velocityY) {
        this.position = new Vector2D(x, y);
        this.velocity = new Vector2D(velocityX, velocityY);
//        this.dead = false;
    }

    public Ball(Vector2D position, Vector2D velocity) {
        this.position = position;
        this.velocity = velocity;
    }

    public static Ball makeNewBall() {
        // Start in the center position
        Vector2D position = new Vector2D(
                (double) FRAME_WIDTH / 2,
                (double) FRAME_HEIGHT / 2
        );

        // Allow ball to also go up or left
        int velocityXMultiplier = 1;
        int velocityYMultiplier = 1;

        if (Math.random() < 0.5) {
            velocityXMultiplier *= -1;
        }

        if (Math.random() < 0.5) {
            velocityYMultiplier *= -1;
        }

        Vector2D velocity = new Vector2D(
                ((Math.random() * MAX_SPEED) + 1) * velocityXMultiplier,
                ((Math.random() * MAX_SPEED) + 1) * velocityYMultiplier
        );

        return new Ball(position, velocity);
    }

    public void draw(Graphics2D g2D) {
        g2D.setColor(Color.WHITE);
        g2D.fillOval(
                (int) this.position.x - RADIUS,
                (int) this.position.y - RADIUS,
                2 * RADIUS,
                2 * RADIUS
        );
    }

    public void update() {
        this.position.x += this.velocity.x * DT;
        this.position.y += this.velocity.y * DT;

        if (getX() < -Ball.RADIUS
                || getX() > FRAME_WIDTH + Ball.RADIUS
        ) {
            this.dead = true;
        } else if (getY() - Ball.RADIUS <= 0
                || getY() + Ball.RADIUS >= FRAME_HEIGHT)
        {
            reverseVelocityY();
        }
    }

    public double getX() {
        return this.position.x;
    }

    public double getY() {
        return this.position.y;
    }

    public void reverseVelocityY()
    {
        this.velocity.y *= -1;
    }
}
