package Entitiy;

import Graphic.Animation;
import Graphic.Assests;
import pangame.Game;
import pangame.Handler;

import java.awt.*;

public class Humanoid extends Creature {


    private Animation anim;
    private Game mygame;


    public Humanoid(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        anim = new Animation(100, Assests.corona);
        mygame = handler.getGame();
        bounds.x = 35;
        bounds.y = 45;
        bounds.width = 33;
        bounds.height = 40;
        setSpeed(2);
        ymove = speed;
        xmove = speed;
    }

    @Override
    protected void changeymove() {
        ymove = -ymove;
    }

    @Override
    protected void changexmove() {
        xmove = -xmove;
    }

    @Override
    public void tick() {
        anim.tick();
        move();
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(anim.getcurrentframe(), (int) (x - mygame.getCamera().getXoffset()),
                (int) (y - mygame.getCamera().getYoffset()), width, height, null);

    }

    public Rectangle getbounds() {
        return bounds;
    }
}
