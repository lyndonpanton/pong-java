package game;

import utilities.JEasyFrame;
import javax.swing.*;

public class Pong {
//    private static final String TITLE = "Pong";

    public static void main(String[] args) {
        Pong pong = new Pong();
        View view = new View(pong);

        JEasyFrame easyFrame = new JEasyFrame(view, "Pong");
    }
}
