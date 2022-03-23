package com.alec.robotgame.world.Tiles;

import com.alec.robotgame.util.FontSpriteBatch;
import com.badlogic.gdx.graphics.g2d.Batch;

public class EmptyTile  extends Tile{
    public EmptyTile(float x, float y) {
        super(x, y);
    }

    @Override
    public void render(FontSpriteBatch b) {}
}
