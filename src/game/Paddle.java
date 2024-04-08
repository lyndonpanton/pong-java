package game;

import utilities.Action;
import utilities.ControlType;
import utilities.Controller;
import utilities.Vector2D;

import java.awt.*;

import static utilities.Constants.DT;

public class Paddle extends GameObject {
    public static final int WIDTH = 10;
    public static final int HEIGHT = 40;

    public static final double SPEED = 200;

    public Color colour;
    public Vector2D direction;

    private final Controller controller;
    private ControlType controlType;

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

        /* TODO
            Stop the paddle past the vertical edges of the screen
         */

        if (action.movement > 0) {
            this.position.y += SPEED * DT;
        } else if (action.movement < 0) {
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
