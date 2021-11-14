package com.alec.robotgame.world.Tiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class Dirt extends Tile {
    static Texture Image = new Texture(Gdx.files.internal("tile.png"));

    public Dirt(float x, float y) {
        super(x, y);
        this.image = Image;
    }
}
