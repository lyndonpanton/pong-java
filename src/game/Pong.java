package game;

import utilities.*;

import java.awt.*;

import static utilities.Constants.*;

public class Pong {
    private static final String TITLE = "Pong";
    private static final Color PLAYER_ONE_COLOR = Color.RED;
    private static final Color PLAYER_TWO_COLOR = Color.GREEN;
    public Ball ball;
    public Keys controller;
    public Paddle playerOne;
    public Paddle playerTwo;

    public Pong() {
        ball = Ball.makeNewBall();
        controller = new Keys();
        playerOne = new Paddle(
                controller,
                new Vector2D(
                        50,
                        (double) FRAME_HEIGHT / 2 - (double) Paddle.HEIGHT / 2
                ),
                new Vector2D(0,0),
                ControlType.LETTERS,
                PLAYER_ONE_COLOR
        );
        playerTwo = new Paddle(
                controller,
                new Vector2D(
                        FRAME_WIDTH - 50,
                        (double) FRAME_HEIGHT / 2 - (double) Paddle.HEIGHT / 2
                ),
                new Vector2D(0,0),
                ControlType.ARROWS,
                PLAYER_TWO_COLOR
        );
    }

    public static void main(String[] args) throws InterruptedException {
        Pong pong = new Pong();
        View view = new View(pong);

        JEasyFrame easyFrame = new JEasyFrame(view, TITLE);
        easyFrame.addKeyListener(pong.controller);

        while (true) {
            pong.update();
            view.repaint();
            Thread.sleep(DELAY);
        }
    }

    public void update() {
        playerOne.update();
        playerTwo.update();
        ball.update();

        if (ball.dead) ball = Ball.makeNewBall();
    }
}
