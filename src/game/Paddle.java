package game;

import utilities.*;

import java.awt.*;

import static utilities.Constants.*;

public class Paddle extends GameObject {
    public static final int WIDTH = 10;
    public static final int HEIGHT = 40;

    public static double SPEED = 200;

    public Color colour;
    public Vector2D direction;

    private final Controller controller;
    public ControlType controlType;
    public boolean hasWon;

//    public Paddle(
//            Controller controller,
//            Vector2D position,
//            Vector2D direction,
//            ControlType controlType,
//            Color colour
//    ) {
//        super(position, direction);
//        this.controller = controller;
//        this.position = position;
//        this.velocity = new Vector2D(0, 0);
//        this.direction = direction;
//        this.controlType = controlType;
//        this.colour = colour;
//    }

    public Paddle(
            Controller controller,
            Vector2D position,
            Vector2D velocity,
            ControlType controlType,
            Color colour
    ) {
        super(position, velocity);
        this.controller = controller;
        this.controlType = controlType;
        this.colour = colour;
    }

    public void draw(Graphics2D g2D) {
        g2D.setColor(this.colour);
        g2D.fillRect((int) position.x, (int) position.y, WIDTH, HEIGHT);
    }

    public void update() {
        Action action = controller.getAction();

        if (action.isPaused) {
            Game.GAME_STATE = GameState.PAUSED;
        } else {
            Game.GAME_STATE = GameState.PLAYING;
        }

        if (Game.GAME_STATE == GameState.PLAYING) {

        /* TODO
            Stop the paddle past the vertical edges of the screen
         */

            if (action.movement > 0 && position.y + HEIGHT < FRAME_HEIGHT) {
                this.position.y += SPEED * DT;
            } else if (action.movement < 0 && position.y > 0) {
                this.position.y -= SPEED * DT;
            }

//        if (controlType == ControlType.LETTERS) {
//            if (action.togglePause) {
//
//            } else if (action.movement > 0) {
//                this.position.y += SPEED * DT;
//            } else if (action.movement < 0) {
//                this.position.y -= SPEED * DT;
//            }
//        } else if (controlType == ControlType.ARROWS) {
//            if (action.togglePause) {
//
//            } else if (action.movement > 0) {
//                this.position.y += SPEED * DT;
//            } else if (action.movement < 0) {
//                this.position.y -= SPEED * DT;
//            }
//        }
        }
    }

    public void resetPosition() {
        this.position.y = (double) FRAME_HEIGHT / 2 - (double) Paddle.HEIGHT / 2;
    }
}
