package State;

import pangame.Game;
import pangame.Handler;

import java.awt.*;

public abstract class State {

    protected Handler handler;

    private static State currentstate = null;

    public State(Handler handler) {
        this.handler = handler;
    }
    public static void setstate(State state) {
        currentstate = state;
    }

    public static State getstate() {
        return currentstate;
    }
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract void setman();
}
