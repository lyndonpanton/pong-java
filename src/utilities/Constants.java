package utilities;

import java.awt.*;

public class Constants {
    public static final int FRAME_HEIGHT = 450;
    public static final int FRAME_WIDTH = 600;
    public static final Dimension FRAME_SIZE =
            new Dimension(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
    // The sleep time between frames (ms)
    public static final int DELAY = 20;
    // The sleep time between frames (s)
    public static final double DT = (double) DELAY / 1000;
}
