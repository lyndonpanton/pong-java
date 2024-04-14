package game;

import manager.SoundManager;
import manager.SpriteManager;
import utilities.GameState;
import utilities.Sprite;
import utilities.Vector2D;

import java.awt.*;
import java.awt.geom.AffineTransform;

import static utilities.Constants.*;
import static manager.SpriteManager.BALL;

public class Ball extends GameObject {
    public static final int RADIUS = 10;
    public static double HORIZONTAL_SPEED = 150;
    public static double SPEED_INCREMENT_FACTOR = 1.1f;
    public int paddleCollisions;
    public Sprite sprite;

//    private final AffineTransform ballTransformation;

    public Ball(double x, double y, double velocityX, double velocityY) {
        super(new Vector2D(x, y), new Vector2D(velocityX, velocityY));
//        sprite = new Sprite(
//                Sprite.BALL,
//                new Vector2D(
//                        (double) FRAME_WIDTH / 2,
//                        (double) FRAME_HEIGHT / 2
//                ),
//                new Vector2D(0, 0),
//                Sprite.BALL.getWidth(null),
//                Sprite.BALL.getHeight(null)
//        );
//
//        double imageWidth = BALL.getWidth(null);
//        double imageHeight = BALL.getHeight(null);
//        double stretchX = 0.5;
//        double stretchY = 0.5;
//
//        ballTransformation = new AffineTransform();
//        ballTransformation.scale(stretchX, stretchY);
    }

    public Ball(Vector2D position, Vector2D velocity) {
        super(position, velocity);
//        sprite = new Sprite(
//                Sprite.BALL,
//                new Vector2D(
//                        (double) FRAME_WIDTH / 2,
//                        (double) FRAME_HEIGHT / 2
//                ),
//                new Vector2D(0, 0),
//                Sprite.BALL.getWidth(null),
//                Sprite.BALL.getHeight(null)
//        );
//
//        double imageWidth = BALL.getWidth(null);
//        double imageHeight = BALL.getHeight(null);
//        double stretchX = 0.5;
//        double stretchY = 0.5;
//
//        ballTransformation = new AffineTransform();
//        ballTransformation.scale(stretchX, stretchY);
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

//        g2D.drawImage(sprite.image, ballTransformation, null);
    }

    public void update() {
        if (Game.GAME_STATE == GameState.PLAYING) {
            this.position.x += this.velocity.x;
            this.position.y += this.velocity.y;

//            this.position.add(this.velocity.multiply(DT));

            if (getX() < -Ball.RADIUS) {
                this.isDead = true;
                SoundManager.play(SoundManager.select1);
                Game.incrementPlayerTwoScore();
            } else if (getX() > FRAME_WIDTH + Ball.RADIUS) {
                this.isDead = true;
                SoundManager.play(SoundManager.select2);
                Game.incrementPlayerOneScore();
            } else if (getY() - Ball.RADIUS <= 0
                    || getY() + Ball.RADIUS >= FRAME_HEIGHT) {
                reverseVelocityY();
            }
        }
    }

    public double getX() {
        return this.position.x;
    }

    public double getY() {
        return this.position.y;
    }

    @Override
    public void handleCollision() {
        super.handleCollision();

        if (this.velocity.x < 0) {
            SoundManager.play(SoundManager.popupClose1);
        } else {
            SoundManager.play(SoundManager.popupOpen1);
        }

        if (paddleCollisions < 10) {
            this.velocity.multiply(SPEED_INCREMENT_FACTOR);
        }
        
        paddleCollisions++;
    }

    public void reverseVelocityY()
    {
        this.velocity.y *= -1;
        SoundManager.play(SoundManager.cancel1);
    }
}
