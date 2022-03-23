package com.alec.robotgame.world.Tiles;

import com.alec.robotgame.items.Item;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class WaterTile extends Tile {
    static Texture Image = new Texture(Gdx.files.internal("Water.png"));


    public WaterTile(float x, float y) {
        super(x, y);
        this.image = Image;
        this.isMineable = false;
        BlobPlacePercent = 0.1f;
        BlobGrowPercent = 60;
        MaxBlobRadius = 5;
        GenType = "Blob";
    }

    public Item getOre(){
        return new Item("Coal",1);
    }
}
