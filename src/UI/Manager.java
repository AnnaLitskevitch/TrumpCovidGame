package UI;

import pangame.Handler;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Manager {

    private Handler handler;
    private ArrayList<UIObject> objects;
    public Manager(Handler handler) {
        this.handler = handler;

        objects = new ArrayList<UIObject>();
    }

    public void tick() {
        for (UIObject o: objects) {
            o.tick();
        }

    }
    public void render(Graphics g) {
        for(UIObject o: objects) {
            o.render(g);
        }

    }

    public void onmousemove(MouseEvent e) {
        for(UIObject o: objects) {
            o.onmousemove(e);
        }

    }

    public void onmouserelease(MouseEvent e) {
        for(UIObject o: objects) {
            o.onmouserelease(e);
        }

    }

    public void addobject(UIObject o) {
        objects.add(o);
    }
    public void removeobject(UIObject o) {
        objects.remove(o);
    }
}
