package game;

import utilities.JEasyFrame;

import static utilities.Constants.*;

public class Pong {
    private static final String TITLE = "Pong";
    public Ball ball;

    public Pong() {
        ball = Ball.makeNewBall();
    }

    public static void main(String[] args) throws InterruptedException {
        Pong pong = new Pong();
        View view = new View(pong);

        JEasyFrame easyFrame = new JEasyFrame(view, TITLE);

        while (true) {
            pong.update();
            view.repaint();
            Thread.sleep(DELAY);
        }
    }

    public void update() {
        ball.update();

        if (ball.dead) ball = Ball.makeNewBall();
    }
}
