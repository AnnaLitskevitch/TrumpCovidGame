package Entitiy;

import Graphic.Assests;
import pangame.Handler;

import javax.swing.*;
import java.awt.*;

public class HandSan extends Entity {


    public HandSan(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assests.handsanitizer, (int) (x - handler.getGame().getCamera().getXoffset()),
                (int) (y - handler.getGame().getCamera().getYoffset()), width, height, null);
    }


}
