package Worlds;

import Tiles.Tile;
import pangame.Game;
import pangame.Handler;
import pangame.Utils;

import java.awt.*;
import java.util.ArrayList;

public class World {
    private int width;
    private int height;
    private int spawnx;
    private int spawny;
    private int enemies;
    private Handler handler;
    private ArrayList<int[]> notsolid;



    private int[][] tiles;

    public World(Handler handler, String Path) {
        this.handler = handler;
        loadworld(Path);
    }
    public void tick() {

    }
    public void render(Graphics g) {
        int xstart = (int) Math.max(0, handler.getcamera().getXoffset()/Tile.default_tilewidth);
        int ystart = (int) Math.max(0, handler.getcamera().getYoffset()/Tile.default_tileheight);;
        int xend = (int) Math.min(width, 1 + (handler.getcamera().getXoffset() + handler.getwidth())/Tile.default_tilewidth);
        int yend = (int) Math.min(height, 1 + (handler.getcamera().getYoffset() + handler.getheight())/Tile.default_tileheight);
        for (int y = ystart; y < yend; y++) {
            for (int x = xstart; x < xend; x++) {
                gettile(x,y).render(g,(int) (x*Tile.default_tilewidth - handler.getcamera().getXoffset()),
                        (int) (y*Tile.default_tileheight - handler.getcamera().getYoffset()));


            }
        }

    }
    public Tile gettile(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return Tile.floorboardtile;
        }
        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null) {
            return Tile.sandtile;
        }
        return t;

    }

    private void loadworld(String Path) {
        String loadedfile = Utils.loadfileasstring(Path);
        String[] tokens = loadedfile.split("\\s+");
        width = Utils.parseint(tokens[0]);
        height = Utils.parseint(tokens[1]);
        spawnx = Utils.parseint(tokens[2]);
        spawny = Utils.parseint(tokens[3]);
        enemies = Utils.parseint(tokens[4]);
        notsolid = new ArrayList<int[]>();


        tiles = new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int id = Utils.parseint(tokens[x + y * width + 5]);
                tiles[x][y] = id;
                if (!Tile.tiles[id].issolid()) {
                    notsolid.add(new int[] {x,y});
                }
            }
        }
    }

    public int getspawnx() {
        return spawnx;
    }
    public int getspawny() {
        return spawny;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getenemies() { return enemies;}

    public ArrayList<int[]> getNotsolid() {
        return notsolid;
    }


}
