package com.alec.robotgame.world.gen;

import com.alec.robotgame.world.Tiles.*;
import com.alec.robotgame.world.Tiles.util.Map;
import com.badlogic.gdx.math.MathUtils;

public class DefaultGenerator implements terrainGenerator {

    private int width;
    private int height;
    public boolean isConfigured;

    public DefaultGenerator() {
        width=0;
        height=0;
        isConfigured = false;
    }
    @Override
    public Map generate() {
        Map tiles=new Map(width,height);
        tiles.fill(new Dirt(0,0));
        generate(tiles,new CoalOre(0,0));
        generate(tiles,new IronOre(0,0));
        generate(tiles,new WaterTile(0,0));
        return tiles;
    }

    private void generate(Map tiles, Tile tile) {
        if (tile.getGenType().equals("Vein")) {
            generateVeins(tiles, tile);
        }
        if (tile.getGenType().equals("Blob")) {
            generateBlobs(tiles , tile);
        }
    }

    @Override
    public void config(int width, int height) {
        this.width = width;
        this.height = height;
        isConfigured=true;
    }

    private void generateVeins(Map tiles,Tile ore) {
        for (int y = 0;y<height;++y ) {
            for (int x = 0; x<width; ++x) {
                int randnum = MathUtils.random(1,100);
                if (randnum <= ore.getVeinPlacePercent()) {
                    generateVein(tiles,ore,x,y);
                }
            }
        }
    }

    private void generateVein(Map tiles,Tile ore,int x,int y) {
        int veinx = x;
        int veiny = y;
        for (int size = 1; size <= ore.getMaxVeinSize(); ++size) {
            tiles.set( ore, veinx, veiny);
            int randveinnum = MathUtils.random(1,100);
            if (randveinnum <= ore.getVeinGrowPercent()) {
                int direction = (int) ( (4*randveinnum) / (ore.getVeinGrowPercent()) );
                if (direction==1 && veinx < width-1 ) {
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
    }

    public void generateBlobs(Map tiles, Tile tile){
        for (int y = 0;y<height;++y ) {
            for (int x = 0; x<width; ++x) {
                float randnum = MathUtils.random(0L, 100L);
                if (randnum <= tile.getBlobPlacePercent()) {
                    generateBlob(tiles,tile,x,y,1);
                }
            }
        }
    }

    public void generateBlob(Map tiles, Tile tile, int x, int y,int accum){
        int randnum = MathUtils.random(1,100);
        if ( randnum <= tile.getBlobGrowPercent() && accum <= tile.getMaxBlobRadius()){

            tiles.set( tile, x, y);
            generateBlob(tiles,tile,x,y,accum+1);
            if (x < width-1 ) {
                generateBlob(tiles,tile,x+1,y,accum+1);
            }
            if (x > 0) {
                generateBlob(tiles,tile,x-1,y,accum+1);
            }
            if (y < height-1) {
                generateBlob(tiles,tile,x,y+1,accum+1);
            }
            if (y > 0) {
                generateBlob(tiles,tile,x,y-1,accum+1);
            }
        }
    }
}
