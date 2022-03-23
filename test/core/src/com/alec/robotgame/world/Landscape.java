package com.alec.robotgame.world;
import com.alec.robotgame.util.FontSpriteBatch;
import com.alec.robotgame.util.Sprite;
import com.alec.robotgame.world.Tiles.Tile;
import com.alec.robotgame.world.Tiles.util.Map;
import com.alec.robotgame.world.gen.DefaultGenerator;
import com.alec.robotgame.world.gen.terrainGenerator;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;

import java.awt.*;

public class Landscape{
    private Map tiles;
    private int width;
    private int height;
    private terrainGenerator gen;

    public Landscape () {
        width = 25;
        height = 15;
        gen = new DefaultGenerator();
        gen.config(width,height);
        tiles = gen.generate();
    }



    public void render(FontSpriteBatch b) {
        tiles.render(b);
    }

    public Tile getTile (float x, float y) {
        int narrowedx = (int) x;
        int narrowedy = (int) y;
        return tiles.getTile(narrowedx, narrowedy);
    }

    public Rectangle getBounds() {
        Rectangle r = new Rectangle();
        r.x = 0;
        r.y = 0;
        r.width = width;
        r.height = height;
        return r;
    }
}
