package UI;

import pangame.ClickListener;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UIImageButton extends UIObject {

    private BufferedImage[] array;
    private ClickListener clicker;

    public UIImageButton(float x, float y, int width, int height, BufferedImage[] array,
                         ClickListener
                         clicker) {
        super(x, y, width, height);
        this.array = array;
        this.clicker = clicker;
    }

    @Override
    public void onClick() {
        clicker.onClick();
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        //System.out.println(hover);
        if (hover) {
            System.out.println(hover);
            g.drawImage(array[1], (int) x, (int) y, width, height, null);
        } else {
            g.drawImage(array[0], (int) x, (int) y, width, height, null);
        }


    }
}
