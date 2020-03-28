package pangame;

import javax.swing.JFrame;

public class Main {

    public static void main(String...args) {
        Game game = new Game();
        game.start();
        System.out.println(System.getProperty("user.dir") + sep + "");
    }

    private static String sep = System.getProperty("file.separator");
}
