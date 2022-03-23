package com.alec.robotgame.world.Tiles;

import com.alec.robotgame.items.Item;
import com.alec.robotgame.util.FontSpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public abstract class Tile implements Cloneable{
    Texture image;
    protected Rectangle bounds = new Rectangle();
    protected static final int WIDTH = 64;
    protected static final int HEIGHT = 64;
    protected boolean highlighted = false;
    protected boolean isMineable = false;
    protected static float VeinPlacePercent = 0;
    protected static float VeinGrowPercent = 0;
    protected static int MaxVeinSize = 0;
    protected static float BlobPlacePercent = 0;
    protected static float BlobGrowPercent = 0;
    protected static int MaxBlobRadius = 0;
    protected static String GenType = "None";

    public Tile() {
        bounds.x = 0;
        bounds.y = 0;
        bounds.width = WIDTH;
        bounds.height = HEIGHT;

    }

    public Tile(float x,float y){
        bounds.x = x;
        bounds.y = y;
        bounds.width = WIDTH;
        bounds.height = HEIGHT;
    }

    public void render(FontSpriteBatch b) {
        b.draw(image, bounds.x*bounds.width, bounds.y*bounds.height, (bounds.width/2), (bounds.height/2), bounds.width, bounds.height,1,1,0,0,0,(int)bounds.width,(int)bounds.height,false,false);
        if (highlighted) {
            b.draw(image, bounds.x*bounds.width, bounds.y*bounds.height, (bounds.width/2), (bounds.height/2), bounds.width, bounds.height,1,1,0,64,0,(int)bounds.width,(int)bounds.height,false,false);
        }
        highlighted = false;
    }

    private void setPos(int x, int y) {
        bounds = new Rectangle();
        bounds.x = x;
        bounds.y = y;
        bounds.width = WIDTH;
        bounds.height = HEIGHT;
    }

    public Tile duplicate(int x,int y) {
        Tile t;
        try{
            t = this.clone();
        } catch (CloneNotSupportedException e){
            return null;
        }
        t.setPos(x,y);
        return t;
    }

    protected Tile clone() throws CloneNotSupportedException {
        return (Tile)super.clone();
    }

    public void highlight() {
        highlighted = true;
    }

    public Item getOre(){
        return new Item("Coal",1);
    }

    public boolean isMineable() {
        return isMineable;
    }

    public float getVeinPlacePercent(){
        return VeinPlacePercent;
    }

    public float getVeinGrowPercent(){
        return VeinGrowPercent;
    }

    public int getMaxVeinSize(){
        return MaxVeinSize;
    }

    public float getBlobPlacePercent(){
        return BlobPlacePercent;
    }

    public float getBlobGrowPercent(){
        return BlobGrowPercent;
    }

    public int getMaxBlobRadius(){
        return MaxBlobRadius;
    }

    public String getGenType(){
        return GenType;
    }


}
