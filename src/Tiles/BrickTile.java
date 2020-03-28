package Tiles;

import Graphic.Assests;

public class BrickTile extends Tile{

    public BrickTile(int id) {
        super(Assests.brick, id);
    }

    @Override
    public boolean issolid() {
        return true;
    }
}
