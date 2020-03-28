package Input;

import UI.Manager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener {

    private boolean leftpress, rightpress;
    private int mousex, mousey;
    private Manager manager;

    public MouseManager() {

    }

    public void setuimanager(Manager manager) {
        this.manager = manager;
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            leftpress = true;
        } else if (e.getButton() == MouseEvent.BUTTON2) {
            rightpress = true;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            leftpress = false;
        } else if (e.getButton() == MouseEvent.BUTTON2) {
            rightpress = false;
        }
        if (manager != null) {
            manager.onmouserelease(e);
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mousex = e.getX();
        mousey = e.getY();
        if (manager != null) {
            manager.onmousemove(e);
        }
    }


    public boolean isLeftpress() {
        return leftpress;
    }
    public boolean isRightpress() {
        return rightpress;
    }

    public int getMousex() {
        return mousex;
    }

    public int getMousey() {
        return mousey;
    }
}
