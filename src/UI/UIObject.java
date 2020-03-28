package UI;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class UIObject {

    protected float x,y;
    protected int width, height;
    protected boolean hover = false;
    protected Rectangle bounds;

    public UIObject(float x, float y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        bounds = new Rectangle((int) x, (int) y, width, height);
    }

    public abstract void onClick();

    public void onmousemove(MouseEvent e) {
        System.out.println("mousemove");
        if (bounds.contains(e.getX(),e.getY())) {
            hover = true;
            System.out.println("hoveristrue");
        } else {
            System.out.println("becamefalse");
            hover = false;
        }

    }
    public void onmouserelease(MouseEvent e) {
        if (hover) {
            onClick();
        }

    }

    public abstract void tick();
    public abstract void render(Graphics g);

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isHover() {
        return hover;
    }

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

    public void setHover(boolean hover) {
        this.hover = hover;
    }
}
