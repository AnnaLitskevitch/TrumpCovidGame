package Graphic;

import Entitiy.Entity;
import Tiles.Tile;
import pangame.Game;
import pangame.Handler;

import java.util.Map;

public class Camera {

    private float xoffset;
    private float yoffset;
    private Handler handler;

    public Camera(Handler handler, float xoffset, float yoffset) {
        this.xoffset = xoffset;
        this.yoffset = yoffset;
        this.handler = handler;

    }

    public void checkblankspace( ) {
        if (xoffset < 0) {
            xoffset = 0;
        } else if (xoffset > handler.getWorld().getWidth()* Tile.default_tilewidth -
                handler.getwidth()) {
            xoffset = handler.getWorld().getWidth()* Tile.default_tilewidth -
                    handler.getwidth();

        }
        if (yoffset < 0) {
            yoffset = 0;
        } else if (yoffset > handler.getWorld().getHeight()* Tile.default_tileheight -
                handler.getheight()) {
            yoffset = handler.getWorld().getHeight()* Tile.default_tileheight -
                    handler.getheight();

        }
    }

    public void move(float xamount, float yamount) {
        xoffset += xamount;
        yoffset += yamount;
        checkblankspace();
    }

    public void centeronentity(Entity ent) {
        xoffset = ent.getX() - handler.getwidth()/2 + ent.getWidth()/2;
        yoffset = ent.getY() - handler.getheight()/2 + ent.getHeight()/2;
        checkblankspace();

    }


    public void setXoffset(float xoffset) {
        this.xoffset = xoffset;
        checkblankspace();
    }

    public void setYoffset(float yoffset) {

        this.yoffset = yoffset;
        checkblankspace();
    }

    public float getXoffset() {
        return xoffset;
    }

    public float getYoffset() {
        return yoffset;
    }

}
