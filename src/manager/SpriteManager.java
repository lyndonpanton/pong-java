package manager;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

public class SpriteManager {
    public final static String path =
            "sprites/simple-ping-pong-2d-game-assets/arts/";
    public final static String ext = ".png";

    public static Map<String, Image> images = new HashMap<String, Image>();

    public static Image BALL, PLAYER_ONE, PLAYER_TWO, BOARD;
    static {
        try {
            BALL = SpriteManager.loadImage("ball");
            PLAYER_ONE = SpriteManager.loadImage("player");
            PLAYER_TWO = SpriteManager.loadImage("computer");
            BOARD = SpriteManager.loadImage("board");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Image getImage(String s) {
        return images.get(s);
    }

    public static Image loadImage(String fname) throws IOException {
        BufferedImage img = null;
        img = ImageIO.read(new File(path + fname + ext));
        images.put(fname, img);
        return img;
    }

    public static Image loadImage(String imName, String fname) throws IOException {
        BufferedImage img = null;
        img = ImageIO.read(new File(path + fname + ext));
        images.put(imName, img);
        return img;
    }

    public static void loadImages(String[] fNames) throws IOException {
        for (String s : fNames)
            loadImage(s);
    }

    public static void loadImages(Iterable<String> fNames) throws IOException {
        for (String s : fNames)
            loadImage(s);
    }

}