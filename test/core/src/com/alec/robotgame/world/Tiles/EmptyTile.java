package com.alec.robotgame.world.Tiles;

import com.badlogic.gdx.graphics.g2d.Batch;

public class EmptyTile  extends Tile{
    public EmptyTile(float x, float y) {
        super(x, y);
    }

    @Override
    public void render(Batch b) {}
}
