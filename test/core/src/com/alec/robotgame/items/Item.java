package com.alec.robotgame.items;

import com.alec.robotgame.util.FontSpriteBatch;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;

import java.util.HashMap;

public class Item {

    public static HashMap<String, Texture> images = new HashMap<>();
    protected static boolean images_loaded = false;


    public String type;
    public int amount;
    protected Rectangle bounds = new Rectangle();
    public static final int WIDTH = 32;
    public static final int HEIGHT = 32;
    protected float x;
    protected float y;
    public boolean highlighted;

    public Item(String type,int amount) {
        this.type=type;
        this.amount=amount;
        x = 500f;
        y = 615f;
        bounds.x = x - (WIDTH / 2f);
        bounds.y = y - (HEIGHT / 2f);
        bounds.width = WIDTH;
        bounds.height = HEIGHT;
        if (!images_loaded) {
            images.put("Coal", new Texture(Gdx.files.internal("Coal Item.png")));
            images.put("Iron", new Texture(Gdx.files.internal("Iron Item.png")));
            images_loaded = true;
        }
    }

    public void render(FontSpriteBatch b, int x, int y) {
        bounds.x = (x*60)+484;
        bounds.y = (-y*60)+599;
        b.draw(images.get(this.type), bounds.x, bounds.y, (bounds.width/2), (bounds.height/2), bounds.width, bounds.height,1,1,0,0,0,(int)bounds.width,(int)bounds.height,false,false);
        b.font.draw(b, Integer.toString(this.amount),bounds.x+32,bounds.y);
        //if (highlighted) {
        //    b.draw(image, bounds.x*bounds.width, bounds.y*bounds.height, (bounds.width/2), (bounds.height/2), bounds.width, bounds.height,1,1,0,64,0,(int)bounds.width,(int)bounds.height,false,false);
        //}
        //highlighted = false;
    }

}
