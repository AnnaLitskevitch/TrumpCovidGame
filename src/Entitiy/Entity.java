package Entitiy;

import pangame.Game;
import pangame.Handler;

import java.awt.*;

public abstract class Entity {

    protected Handler handler;
    protected float x,y;
    protected int width, height;
    protected Rectangle bounds;

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Entity(Handler handler,float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.handler = handler;
        bounds = new Rectangle(0, 0, width, height);
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

}
