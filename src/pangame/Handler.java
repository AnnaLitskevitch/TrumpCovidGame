package pangame;

import Graphic.Camera;
import Input.Keymanager;
import Input.MouseManager;
import Worlds.World;

import javax.net.ssl.KeyManager;

public class Handler {

    private Game game;
    private World world;

    public Handler(Game game) {
        this.game = game;
    }

    public int getheight() {
        return game.getheight();
    }

    public int getwidth() {
        return game.getwidth();
    }

    public Camera getcamera() {
        return game.getCamera();
    }

    public Keymanager getkeymanager() {
        return game.getKeyManager();
    }

    public MouseManager getmousemanager() {
        return game.getMousemanager();
    }

    public Game getGame() {
        return game;
    }

    public World getWorld() {
        return world;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
