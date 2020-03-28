package State;

import Entitiy.Creature;
import Entitiy.HandSan;
import Entitiy.Humanoid;
import Entitiy.Player;
import Graphic.Assests;
import State.State;
import Tiles.Tile;
import Worlds.World;
import pangame.Game;
import pangame.Handler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GameState extends State {

    private Player player;
    private World world;
    private Humanoid[] human;
    private ArrayList<HandSan> handsan;
    private ArrayList<int[]> nonsolid;
    private int nonsolidsize;
    Random r = new Random();
    private long lasttime = System.currentTimeMillis();
    private long currtime;

    public GameState(Handler handler) {
        super(handler);
        world = new World(handler,"res" + sep + "world2.txt");
        handler.setWorld(world);
        player = new Player(handler,
                world.getspawnx()*Tile.default_tilewidth,
                world.getspawny()*Tile.default_tilewidth,
                Creature.default_width,Creature.default_height);
        human = new Humanoid[handler.getWorld().getenemies()];
        nonsolid = handler.getWorld().getNotsolid();
        nonsolidsize = nonsolid.size();
        for (int i = 0; i < handler.getWorld().getenemies(); i++) {
            int[] randomarray = nonsolid.get(r.nextInt(nonsolidsize));
            human[i] = new Humanoid(handler, randomarray[0]*Tile.default_tilewidth,
                    randomarray[1]*Tile.default_tileheight, 100,100);
        }
        handsan = new ArrayList<HandSan>();
        for (int a = 0; a < 5; a++) {
            int[] randomar = nonsolid.get(r.nextInt(nonsolidsize));
            handsan.add(new HandSan(handler, randomar[0]*Tile.default_tilewidth,
                    randomar[1]*Tile.default_tileheight, 30,50));
        }
    }

    @Override
    public void tick() {
        world.tick();
        player.tick();
        for (Humanoid human: human) {
            human.tick();
        }
        for (HandSan hanny: handsan){
            hanny.tick();
        }
        currtime = System.currentTimeMillis();
        if (currtime - lasttime > 15000) {
            lasttime = currtime;
            int[] randomar = nonsolid.get(r.nextInt(nonsolidsize));
            handsan.add(new HandSan(handler, randomar[0] * Tile.default_tilewidth,
                    randomar[1] * Tile.default_tileheight, 30, 50));
        }
        if (player.getHealth() <= 0) {
            player.setHealth(10);
            handler.getGame().endgame.setman();
            State.setstate(handler.getGame().endgame);
        }
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
        player.render(g);
        for (Humanoid human: human) {
            human.render(g);
        }
        for (HandSan hanny: handsan){
            hanny.render(g);
        }
        g.drawImage(Assests.healthbar[player.getHealth()], 5, 5, 150, 50, null);
    }

    @Override
    public void setman() {}

    public Humanoid[] getHuman() {
        return human;
    }

    public ArrayList<HandSan> getHandsan(){
        return handsan;
    }

    public void removehansan(HandSan h) {
        handsan.remove(h);
    }

    private String sep = System.getProperty("file.separator");
}
