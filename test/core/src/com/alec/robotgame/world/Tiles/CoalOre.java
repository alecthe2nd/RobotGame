package com.alec.robotgame.world.Tiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class CoalOre extends Tile{
    static Texture Image = new Texture(Gdx.files.internal("CoalOre.png"));

    public CoalOre(float x, float y) {
        super(x, y);
        this.image = Image;
    }
}
