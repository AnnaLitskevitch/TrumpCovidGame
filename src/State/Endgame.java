package State;

import Graphic.Assests;
import UI.Manager;
import UI.UIImageButton;
import pangame.ClickListener;
import pangame.Handler;

import java.awt.*;

public class Endgame extends State {

    private Manager manager;

    public Endgame(Handler handler) {
        super(handler);
        manager = new Manager(handler);
        manager.addobject(new UIImageButton(300, 200, 200, 200,
                Assests.retry, new ClickListener() {
            @Override
            public void onClick() {
                handler.getmousemanager().setuimanager(null);
                handler.getGame().gamestate = new GameState(handler);
                State.setstate(handler.getGame().gamestate);

            }
        }));
    }

    @Override
    public void tick() {
        if (handler.getmousemanager().isLeftpress()) {
            State.setstate(handler.getGame().gamestate);
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assests.menubackground, 0, 0, 800, 600, null);
        manager.render(g);
    }

    @Override
    public void setman() {
        handler.getmousemanager().setuimanager(manager);

    }
}
