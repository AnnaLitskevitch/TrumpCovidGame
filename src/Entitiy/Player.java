package Entitiy;

import Entitiy.Creature;
import Graphic.Animation;
import Graphic.Assests;
import Graphic.Camera;
import pangame.Game;
import pangame.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Creature {

    private Animation anidown;
    private Animation animup;
    private Animation anileft;
    private Animation aniright;
    private Animation animidle;


    private Game mygame;
    public Player(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        anidown = new Animation(100, Assests.down);
        animup = new Animation(100, Assests.up);
        anileft = new Animation(100, Assests.left);
        aniright = new Animation(100, Assests.right);
        animidle = new Animation(100, Assests.idle);
        mygame = handler.getGame();
        bounds.x = 35;
        bounds.y = 45;
        bounds.width = 33;
        bounds.height = 40;
    }

    @Override
    public void tick() {
        anidown.tick();
        aniright.tick();
        anileft.tick();
        animup.tick();
        animidle.tick();
        getinput();
        move();
        healthtimer += System.currentTimeMillis() - lasttime;
        lasttime = System.currentTimeMillis();
        mygame.getCamera().centeronentity(this);
        Rectangle getpeep = new Rectangle((int) x,(int) y,width,height);
        for (Humanoid human: handler.getGame().getgamestate().getHuman()) {
            Rectangle hubound  = human.getbounds();
            if (getpeep.contains((int) human.getX() + hubound.x + hubound.width,
                    human.getY() + hubound.y)
            || getpeep.contains((int) human.getX() + hubound.x + hubound.width ,
                    human.getY() + hubound.y + hubound.height)
            || getpeep.contains((int) human.getX() + hubound.x,
                    human.getY() + hubound.y)
            || getpeep.contains((int) human.getX() + hubound.x,
                    human.getY() + hubound.y + hubound.width)) {
                if (getHealth() > 0 && healthtimer > 1000) {
                    healthtimer = 0;
                    setHealth(getHealth() - 1);
                }
            }

        }
        HandSan bumpedhan = null;
        for (HandSan handsan: handler.getGame().getgamestate().getHandsan()) {
            if (getpeep.contains((int) handsan.getX() + handsan.width/2, (int) handsan.getY() + handsan.height/2)) {
                bumpedhan = handsan;
                if (getHealth() < 10) {
                    setHealth(getHealth() + 1);
                }
            }
        }
        handler.getGame().getgamestate().removehansan(bumpedhan);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getcurrframe(), (int) (x - mygame.getCamera().getXoffset()),
                (int) (y - mygame.getCamera().getYoffset()), width, height, null);
//        g.setColor(Color.red);
//        g.drawRect((int) (x + bounds.x - mygame.getCamera().getXoffset()),
//                (int) (y + bounds.y - mygame.getCamera().getYoffset()), bounds.width, bounds.height);

    }

    private void getinput() {
        xmove = 0;
        ymove = 0;
        if (mygame.getKeyManager().up) {
            ymove = -speed;
        }
        if (mygame.getKeyManager().down) {
            ymove = speed;
        }
        if (mygame.getKeyManager().left) {
            xmove = -speed;
        }
        if (mygame.getKeyManager().right) {
            xmove = speed;
        }

    }

    private BufferedImage getcurrframe() {
        if (xmove < 0) {
            return anileft.getcurrentframe();
        } else if (xmove > 0) {
            return aniright.getcurrentframe();
        } else if (ymove < 0) {
            return animup.getcurrentframe();
        } else if (ymove > 0){
            return anidown.getcurrentframe();
        } else {
            return animidle.getcurrentframe();
        }
    }
}
