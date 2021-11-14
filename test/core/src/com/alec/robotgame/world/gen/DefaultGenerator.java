package com.alec.robotgame.world.gen;

import com.alec.robotgame.world.Tiles.CoalOre;
import com.alec.robotgame.world.Tiles.Dirt;
import com.alec.robotgame.world.Tiles.Tile;
import com.alec.robotgame.world.Tiles.util.Map;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

public class DefaultGenerator implements terrainGenerator {

    private int width;
    private int height;
    public boolean isConfigured;
    private int CoalVeinPercent = 2;
    private int CoalCutoffPercent = 15;
    private int MaxCoal = 5;

    public DefaultGenerator() {
        width=0;
        height=0;
        isConfigured = false;
    }
    @Override
    public Map generate() {
        Map tiles=new Map(width,height);
        tiles.fill(new Dirt(0,0));
        tiles = generateVeins(tiles,new CoalOre(0,0));
        return tiles;
    }

    @Override
    public void config(int width, int height) {
        this.width = width;
        this.height = height;
        isConfigured=true;
    }

    private Map generateVeins(Map tiles,Tile ore) {
        for (int y = 0;y<height;++y ) {
            for (int x = 0; x<width; ++x) {
                int randnum = MathUtils.random(1,100);
                if (randnum <= CoalVeinPercent) {
                    tiles = generateVein(tiles,ore,x,y);
                }
            }
        }
        return tiles;
    }

    private Map generateVein(Map tiles,Tile ore,int x,int y) {
        int veinx = x;
        int veiny = y;
        for (int size = 1; size <= MaxCoal; ++size) {
            tiles.set( ore, veinx, veiny);
            int randveinnum = MathUtils.random(1,100);
            if (randveinnum <= 100-CoalCutoffPercent) {
                int direction = (int) ( (4*randveinnum) / (100-CoalCutoffPercent) );
                if (direction==1 && veinx < width-1) {
                    ++veinx;
                }
                if (direction==2 && veinx > 0) {
                    --veinx;
                }
                if (direction==3 && veiny < height-1) {
                    ++veiny;
                }
                if (direction==4 && veiny > 0) {
                    --veiny;
                }
            }
        }
        return tiles;
    }
}
