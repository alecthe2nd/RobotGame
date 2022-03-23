package com.alec.robotgame.world.Tiles;

import com.alec.robotgame.items.Item;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class IronOre extends Tile {
    static Texture Image = new Texture(Gdx.files.internal("IronOre.png"));

    public IronOre(float x, float y) {
        super(x, y);
        this.image = Image;
        this.isMineable = true;
        VeinPlacePercent = 2;
        VeinGrowPercent = 70;
        MaxVeinSize = 3;
        GenType = "Vein";
    }

    public Item getOre(){
        return new Item("Iron",1);
    }
}
