package pangame;

import Display.Visual;
import Graphic.Assests;
import Graphic.Camera;
import Input.Keymanager;
import Input.MouseManager;
import State.State;
import State.GameState;
import State.Menu;
import State.Endgame;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {

    private Thread thread;
    private Visual visual;
    private Boolean running = false;
    private BufferStrategy bs;
    private Graphics g;
    public State gamestate;
    public State MenuState;
    public State endgame;
    private Keymanager keyManager;
    private Camera camera;
    private Handler handler;
    private MouseManager mousemanager;


    public Game() {

        keyManager = new Keymanager();
        mousemanager = new MouseManager();
    }

    private void init() {
        visual = new Visual();
        Assests.init();

        handler = new Handler(this);
        camera = new Camera(handler,0,0);
        visual.getjframe().addKeyListener(keyManager);
        visual.getjframe().addMouseListener(mousemanager);
        visual.getjframe().addMouseMotionListener(mousemanager);
        visual.getcanvas().addMouseListener(mousemanager);
        visual.getcanvas().addMouseMotionListener(mousemanager);
        gamestate = new GameState(handler);
        MenuState = new Menu(handler);
        endgame = new Endgame(handler);
        MenuState.setman();
        State.setstate(MenuState);

    }


    private void tick() {
        keyManager.tick();
        if (State.getstate() != null) {
            State.getstate().tick();
        }

    }

    private void render() {
        bs = visual.getcanvas().getBufferStrategy();
        if (bs == null) {
            visual.getcanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0,0, 800, 600);
        if (State.getstate() != null) {
            State.getstate().render(g);
        }
        bs.show();
        g.dispose();
    }

    public void run(){
        init();

        int fps = 60;
        double timepertick = 1000000000/fps;
        double delta = 0;
        long now;
        long lasttime = System.nanoTime();

        while(running) {
            now = System.nanoTime();
            delta += (now - lasttime)/timepertick;
            lasttime = now;
            if (delta >= 1) {
                tick();
                render();
                delta--;
            }
        }

        stop();
    }

    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if (!running) {
            return;
        }
        try {
            thread.join();;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public Keymanager getKeyManager() {
        return keyManager;
    }

    public MouseManager getMousemanager() { return mousemanager;}

    public Camera getCamera() { return camera;}

    public int getwidth() { return visual.getcanvas().getWidth(); }

    public int getheight() { return visual.getcanvas().getHeight();}

    public GameState getgamestate() {
        return (GameState) gamestate;
    }

    private String sep = System.getProperty("file.separator");
}
