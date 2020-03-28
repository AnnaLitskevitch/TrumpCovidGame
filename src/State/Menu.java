package State;

import Graphic.Assests;
import UI.Manager;
import UI.UIImageButton;
import pangame.ClickListener;
import pangame.Handler;

import java.awt.*;

public class Menu extends State {

    private Manager manager;

    public Menu(Handler handler) {
        super(handler);
        manager = new Manager(handler);
        //handler.getmousemanager().setuimanager(manager);
        manager.addobject(new UIImageButton(300, 200, 200, 150,
                Assests.start, new ClickListener() {
            @Override
            public void onClick() {
                handler.getmousemanager().setuimanager(null);
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

    public void setman() {
        handler.getmousemanager().setuimanager(manager);
    }
}
