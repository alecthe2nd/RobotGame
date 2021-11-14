package com.alec.robotgame.world.gen;
import com.alec.robotgame.world.Tiles.util.Map;

public interface terrainGenerator {
    public void config(int width,int height);
    public Map generate();
}
