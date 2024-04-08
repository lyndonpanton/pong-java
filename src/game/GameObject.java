package game;

import utilities.ControlType;
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

    public abstract void update();

    public abstract void draw(Graphics2D g2D);

    public void checkCollision(GameObject other) {
        if (this.getClass() != other.getClass() && this.checkOverlap(other)) {
            this.handleCollision();
            other.handleCollision();
        }
    }

    public boolean checkOverlap(GameObject other) {
        // If the ball is between the
        //  - Left and right x coordinates of the paddle
        //  - Top and bottom y coordinates of the paddle

        if (this instanceof Ball ball && other instanceof Paddle paddle) {
            if (
                    (ball.position.x >= paddle.position.x)
                            && (ball.position.x <= paddle.position.x + Paddle.WIDTH)
                    || (ball.position.x - Ball.RADIUS >= paddle.position.x)
                            && (ball.position.x - Ball.RADIUS <= paddle.position.x + Paddle.WIDTH)
                    || (ball.position.x + Ball.RADIUS >= paddle.position.x)
                            && (ball.position.x + Ball.RADIUS <= paddle.position.x + Paddle.WIDTH)
            ) {
                 if (
                         (ball.position.y >= paddle.position.y)
                                 && (ball.position.y <= paddle.position.y + Paddle.HEIGHT)
                        || (ball.position.y - Ball.RADIUS >= paddle.position.y)
                                && (ball.position.y - Ball.RADIUS <= paddle.position.y + Paddle.HEIGHT)
                        || (ball.position.y + Ball.RADIUS >= paddle.position.y)
                                && (ball.position.y + Ball.RADIUS <= paddle.position.y + Paddle.HEIGHT)

                 ) {
                     handleCollision();
                 }

            }
        }

        return false;
    }

    public void handleCollision() {
        if (this.position.x < FRAME_WIDTH / 2.0 && this.velocity.x < 0) {
            this.velocity.x *= -1;
        } else if (this.position.x > FRAME_WIDTH / 2.0 && this.velocity.x > 0) {
            this.velocity.x *= -1;
        }
    }
}
