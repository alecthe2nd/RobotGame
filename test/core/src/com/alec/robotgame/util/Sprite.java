package com.alec.robotgame.util;

import com.alec.robotgame.RobotGame;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public abstract class Sprite {
    public Behavior behavior;
    public PhysicsComponent physics;
    public float mass;
    protected float x;
    protected float y;
    protected Vector2 heading;

    public abstract void update(RobotGame game);
    public abstract void render(Batch b);
    public abstract float getX();
    public abstract float getY();
    public abstract Vector2 getHeading();
    public abstract void setX(float value);
    public abstract void setY(float value);
    public abstract void setHeading(Vector2 value);

    protected void drawImage(Batch b, Texture image, float x, float y, float width, float height, float rot) {
        float alignx = (x*width)-(width/2);
        float aligny = (y*height)-(height/2);
        b.draw(image, alignx, aligny, (width/2), (height/2), width, height,1,1,rot-90,0,0,(int)width,(int)height,false,false);
    }
}
