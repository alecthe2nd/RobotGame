package com.alec.robotgame.world.Tiles.util;

import com.alec.robotgame.world.Tiles.EmptyTile;
import com.alec.robotgame.world.Tiles.Tile;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Array;


public class Map{
    private Array<Array<Tile>> map;
    private int width;
    private int height;

    public Map(int width,int height) {
        this.width=width;
        this.height=height;
        clear();
    }

    public void set (Tile t,int x,int y) {
        map.get(y).set(x,t.duplicate(x,y));
    }

    public Tile getTile (int x,int y) {
        return map.get(y).get(x);
    }

    public void clear () {
        map = new Array<>();
        for (int y = 0; y < height; ++y) {
            map.add(new Array<Tile>());
            for (int x = 0; x < width; ++x) {
                map.get(y).add(new EmptyTile(x,y));

            }
        }
    }

    public void fill (Tile t) {
        map = new Array<>();
        for (int y = 0; y < height; ++y) {
            map.add(new Array<Tile>());
            for (int x = 0; x < width; ++x) {
                map.get(y).add(t.duplicate(x,y));

            }
        }
    }

    public void render(Batch b){
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                getTile(x,y).render(b);
            }
        }
    }
}
