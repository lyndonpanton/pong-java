package game;

import utilities.*;

import java.awt.*;

import static utilities.Constants.*;

public class Game {
    private static final String TITLE = "Pong";
    private static final Color PLAYER_ONE_COLOR = Color.RED;
    private static final Color PLAYER_TWO_COLOR = Color.GREEN;
    public Ball ball;
    public Paddle playerOne;
    public Paddle playerTwo;
    public PlayerOneKeys playerOneController;
    public PlayerTwoKeys playerTwoController;
    public static int playerOneScore;
    public static int playerTwoScore;

    public Game() {
        ball = Ball.makeNewBall();
        playerOneController = new PlayerOneKeys();
        playerTwoController = new PlayerTwoKeys();
        playerOne = new Paddle(
                playerOneController,
                new Vector2D(
                        50,
                        (double) FRAME_HEIGHT / 2 - (double) Paddle.HEIGHT / 2
                ),
                new Vector2D(0,0),
                ControlType.LETTERS,
                PLAYER_ONE_COLOR
        );
        playerTwo = new Paddle(
                playerTwoController,
                new Vector2D(
                        FRAME_WIDTH - 50,
                        (double) FRAME_HEIGHT / 2 - (double) Paddle.HEIGHT / 2
                ),
                new Vector2D(0,0),
                ControlType.ARROWS,
                PLAYER_TWO_COLOR
        );
        playerOneScore = 0;
        playerTwoScore = 0;
    }

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        View view = new View(game);

        JEasyFrame easyFrame = new JEasyFrame(view, TITLE);
        easyFrame.addKeyListener(game.playerOneController);
        easyFrame.addKeyListener(game.playerTwoController);

        while (true) {
            game.update();
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

    public static void incrementPlayerOneScore() {
        playerOneScore += 1;
    }

    public static void incrementPlayerTwoScore() {
        playerTwoScore += 1;
    }

    public static int getPlayerOneScore() {
        return playerOneScore;
    }

    public static int getPlayerTwoScore() {
        return playerTwoScore;
    }
}