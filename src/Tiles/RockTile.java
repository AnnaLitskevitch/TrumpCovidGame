package Tiles;

import java.awt.image.BufferedImage;
import Graphic.Assests;

public class RockTile extends Tile{

    public RockTile( int id) {
        super(Assests.cobblestone, id);
    }

    @Override
    public boolean issolid() {
        return true;
    }
}
