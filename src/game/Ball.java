package game;

import java.awt.*;
import java.lang.management.GarbageCollectorMXBean;

import static utilities.Constants.*;

public class Ball {
    public static final int RADIUS = 10;
    public static final double MAX_SPEED = 100;

    private double x, y;
    private double velocityX, velocityY;

    public Ball(double x, double y, double velocityX, double velocityY) {
        this.x = x;
        this.y = y;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public static Ball makeNewBall() {
        // Start in the center position
        double x = (double) FRAME_WIDTH / 2;
        double y = (double) FRAME_HEIGHT / 2;

        // Allow ball to also go up or left
        int velocityXMultiplier = 1;
        int velocityYMultiplier = 1;

        if (Math.random() < 0.5) {
            velocityXMultiplier *= -1;
        }

        if (Math.random() < 0.5) {
            velocityYMultiplier *= -1;
        }

        double velocityX = ((Math.random() * MAX_SPEED) + 1) * velocityXMultiplier;
        double velocityY = ((Math.random() * MAX_SPEED) + 1) * velocityYMultiplier;

        return new Ball(x, y, velocityX, velocityY);
    }

    public void draw(Graphics2D g2D) {
        g2D.setColor(Color.WHITE);
        g2D.fillOval(
                (int) x - RADIUS,
                (int) y - RADIUS,
                2 * RADIUS,
                2 * RADIUS
        );
    }

    public void update() {
        x += velocityX * DT;
        y += velocityY * DT;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
}
