package com.alec.robotgame.util;

import com.alec.robotgame.RobotGame;
import com.alec.robotgame.animations.Animator;
import com.alec.robotgame.items.Inventory;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public abstract class Sprite {
    public Behavior behavior;
    public PhysicsComponent physics;
    public Animator animator;
    public Inventory inventory;
    public float mass;
    public float horsepower;
    protected float x;
    protected float y;
    protected Vector2 heading;
    public boolean isMining;

    public abstract void update(RobotGame game);
    public abstract void render(FontSpriteBatch b);
    public abstract float getX();
    public abstract float getY();
    public abstract Vector2 getHeading();
    public abstract void setX(float value);
    public abstract void setY(float value);
    public abstract void setHeading(Vector2 value);

    protected void drawImage(Batch b, Texture image, float x, float y, float width, float height, float rot,int region) {
        float alignx = (x*width)-(width/2);
        float aligny = (y*height)-(height/2);
        b.draw(image, alignx, aligny, (width/2), (height/2), width, height,1,1,rot-90,(int)width*region,0,(int)width,(int)height,false,false);
    }
}
