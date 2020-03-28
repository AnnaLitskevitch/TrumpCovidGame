package Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    public static Tile[] tiles = new Tile[256];
    public static Tile floorboardtile = new Floorboardtile(0);
    public static Tile bricktile = new BrickTile(3);
    public static Tile sandtile = new SandTile(2);
    public static Tile rocktile = new RockTile(1);



    public static final int default_tilewidth = 100;
    public static final int default_tileheight = 100;
    protected BufferedImage image;
    protected final int id;

    public Tile(BufferedImage texture, int id) {
        image = texture;
        this.id = id;
        tiles[id] = this;
    }

    public void tick() {
    }

    public boolean issolid() {
        return false;
    }


    public void render(Graphics g, int x, int y) {
        g.drawImage(image, x,  y,
                default_tilewidth, default_tileheight, null);
    }
    public int getId() {
        return id;
    }


}
