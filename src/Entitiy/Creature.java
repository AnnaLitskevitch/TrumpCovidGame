package Entitiy;

import Tiles.Tile;
import pangame.Game;
import pangame.Handler;

public abstract class Creature extends Entity {

    public static final int default_health = 10;
    public static final int default_speed = 4;
    public static final int default_width = 100;
    public static final int default_height = 100;

    protected int health;
    protected float speed;
    protected float xmove = 0;
    protected float ymove = 0;
    protected long healthtimer = 0;
    protected long lasttime = System.currentTimeMillis();

    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
        health = default_health;
        speed = default_speed;
    }

    public void move() {
        movex();
        movey();
    }

    public void movex() {
        if (xmove > 0) {
            int tx = (int) (x + xmove + bounds.x + bounds.width)/ Tile.default_tilewidth;
            if (!collisionwithtile(tx, (int) (y + bounds.y)/Tile.default_tileheight) &&
                    !collisionwithtile(tx, (int) (y + bounds.y + bounds.height)/Tile.default_tileheight)) {
                x+= xmove;
            } else {
                changexmove();
            }

        } else if (xmove < 0) {
            int tx = (int) (x + xmove + bounds.x)/ Tile.default_tilewidth;
            if (!collisionwithtile(tx, (int) (y + bounds.y)/Tile.default_tileheight) &&
                    !collisionwithtile(tx, (int) (y + bounds.y + bounds.height)/Tile.default_tileheight)) {
                x+= xmove;
            } else {
                changexmove();
            }
        }
    }

    public void movey() {
        if (ymove > 0) {
            int ty = (int) (y + ymove + bounds.y + bounds.height)/ Tile.default_tileheight;
            if (!collisionwithtile((int) (x + bounds.x)/Tile.default_tilewidth, ty) &&
                    !collisionwithtile((int) (x + bounds.x + bounds.width)/Tile.default_tilewidth, ty)) {
                y += ymove;
            } else {
                changeymove();
            }

        } else if (ymove < 0) {
            int ty = (int) (y + ymove + bounds.y)/ Tile.default_tileheight;
            if (!collisionwithtile((int) (x + bounds.x)/Tile.default_tilewidth, ty) &&
                    !collisionwithtile((int) (x + bounds.x + bounds.width)/Tile.default_tilewidth, ty)) {
                y += ymove;
            } else {
                changeymove();
            }
        }
    }

    protected boolean collisionwithtile(int x, int y) {
        return handler.getWorld().gettile(x,y).issolid();
    }

    protected void changeymove() {

    }
    protected void changexmove() {

    }
    public void setXmove(float xmove) {
        this.xmove = xmove;
    }

    public void setYmove(float ymove) {
        this.ymove = ymove;
    }

    public float getXmove() {
        return xmove;
    }

    public float getYmove() {
        return ymove;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getHealth() {
        return health;
    }

    public float getSpeed() {
        return speed;
    }

}
