package Graphic;

import java.awt.image.BufferedImage;

public class SpriteSource {

    private BufferedImage sheet;

    public SpriteSource(BufferedImage image) {
        sheet = image;
    }

    public BufferedImage crop(int x, int y, int width, int height) {
        return sheet.getSubimage(x, y, width, height);
    }
}
