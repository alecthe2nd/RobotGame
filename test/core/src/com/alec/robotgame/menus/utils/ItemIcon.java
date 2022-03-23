package com.alec.robotgame.menus.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;

public class ItemIcon {
    static Texture image = new Texture(Gdx.files.internal("Coal Item.png"));
    protected Rectangle bounds = new Rectangle();
    public static final int WIDTH = 32;
    public static final int HEIGHT = 32;
    protected float x;
    protected float y;
    public boolean highlighted;

    public ItemIcon() {
        x = 500f;
        y = 615f;
        bounds.x = x - (WIDTH / 2f);
        bounds.y = y - (HEIGHT / 2f);
        bounds.width = WIDTH;
        bounds.height = HEIGHT;
    }

    public void render(Batch b,int x, int y) {
        bounds.x = (x*60)+484;
        bounds.y = (-y*60)+599;
        b.draw(image, bounds.x, bounds.y, (bounds.width/2), (bounds.height/2), bounds.width, bounds.height,1,1,0,0,0,(int)bounds.width,(int)bounds.height,false,false);
        //if (highlighted) {
        //    b.draw(image, bounds.x*bounds.width, bounds.y*bounds.height, (bounds.width/2), (bounds.height/2), bounds.width, bounds.height,1,1,0,64,0,(int)bounds.width,(int)bounds.height,false,false);
        //}
        //highlighted = false;
    }
}
