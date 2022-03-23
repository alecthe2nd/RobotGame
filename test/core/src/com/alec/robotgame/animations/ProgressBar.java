package com.alec.robotgame.animations;

import com.alec.robotgame.util.FontSpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class ProgressBar {
    static Texture image = new Texture(Gdx.files.internal("ProgressBar.png"));

    public float x;
    public float y;
    public int size;
    public int maxvalue;
    public int value;
    protected float width = 64;
    protected float regionwidth;
    protected float regionheight = 16;
    protected final float height = 16;

    public ProgressBar(float x, float y, int size, int maxvalue, int start){
        this.x = x;
        this.y = y;
        this.size = size;
        this.value = start;
        this.maxvalue = maxvalue;
        this.regionwidth = (float)((value*64)/maxvalue);
    }

    public void add(int amount){
        this.value += amount;
    }

    public void sub(int amount){
        this.value -= amount;
    }

    public void mul(int amount){
        this.value *= amount;
    }

    public void div(int amount){
        this.value /= amount;
    }

    public void render(FontSpriteBatch b){
        float alignx = (x*64)-(float)(64/2);
        float aligny = (y*64)-(float)(64/2);
        this.regionwidth = (float)((value*64)/maxvalue);
        b.draw(image, alignx, aligny, 0, 0, regionwidth, regionheight,1,1,0,0,0,(int)regionwidth,(int)regionheight,false,false);

    }

}
