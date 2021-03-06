package com.alec.robotgame.world.Tiles;

import com.alec.robotgame.items.Item;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class CoalOre extends Tile{
    static Texture Image = new Texture(Gdx.files.internal("CoalOre.png"));


    public CoalOre(float x, float y) {
        super(x, y);
        this.image = Image;
        this.isMineable = true;
        VeinPlacePercent = 2;
        VeinGrowPercent = 85;
        MaxVeinSize = 5;
        GenType = "Vein";
    }

    public Item getOre(){
        return new Item("Coal",1);
    }
}
