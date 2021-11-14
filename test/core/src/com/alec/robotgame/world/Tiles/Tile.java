package com.alec.robotgame.world.Tiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;

public class Tile implements Cloneable{
    Texture image;
    protected Rectangle bounds = new Rectangle();
    protected static final int WIDTH = 64;
    protected static final int HEIGHT = 64;
    protected boolean highlighted = false;

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

    public void render(Batch b) {
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
        t = this.clone();
        t.setPos(x,y);
        return t;
    }

    protected Tile clone() {
        try{
            return (Tile)super.clone();
        } catch (CloneNotSupportedException e){
            return null;
        }
    }

    public void highlight() {
        highlighted = true;
    }
}
