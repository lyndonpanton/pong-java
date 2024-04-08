package game;

import utilities.Vector2D;

import java.awt.*;

import static utilities.Constants.*;

public class Ball extends GameObject {
    public static final int RADIUS = 10;
    public static final double HORIZONTAL_SPEED = 150;

    public Ball(double x, double y, double velocityX, double velocityY) {
        super(new Vector2D(x, y), new Vector2D(velocityX, velocityY));
    }

    public Ball(Vector2D position, Vector2D velocity) {
        super(position, velocity);
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
                (HORIZONTAL_SPEED) * Math.cos(position.angle())
                        * velocityXMultiplier * DT,
                (HORIZONTAL_SPEED) * Math.sin(position.angle())
                        * velocityYMultiplier * DT
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
//        this.position.x += this.velocity.x * DT;
//        this.position.y += this.velocity.y * DT;

        this.position.add(this.velocity);

        if (getX() < -Ball.RADIUS) {
            this.isDead = true;
            Game.incrementPlayerTwoScore();
        } else if (getX() > FRAME_WIDTH + Ball.RADIUS) {
            this.isDead = true;
            Game.incrementPlayerOneScore();
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
