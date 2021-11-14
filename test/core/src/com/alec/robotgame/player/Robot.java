package com.alec.robotgame.player;

import com.alec.robotgame.RobotGame;
import com.alec.robotgame.util.Behavior;
import com.alec.robotgame.util.PhysicsComponent;
import com.alec.robotgame.util.Sprite;
import com.alec.robotgame.world.Landscape;
import com.alec.robotgame.world.Tiles.Tile;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Robot extends Sprite {
    static Texture image = new Texture(Gdx.files.internal("robot.png"));
    protected Rectangle bounds = new Rectangle();
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    protected float x;
    protected float y;

// just a test
    public Robot(Behavior behavior, PhysicsComponent physics) {
        x=1.5f;
        y=1.5f;
        mass = 1;
        heading = new Vector2();
        bounds.x = x-(WIDTH/2);
        bounds.y = y-(HEIGHT/2);
        bounds.width = WIDTH;
        bounds.height = HEIGHT;
        this.behavior = behavior;
        this.physics = physics;

    }

    public void update(RobotGame game) {
        Landscape terrain = game.getTerrain();
        Tile tileBelow = terrain.getTile(x,y);
        tileBelow.highlight();
        behavior.update(this,game);
        physics.update(this,game);


    }

    @Override
    public void render(Batch b) {
        float rot = heading.angleDeg();
        drawImage(b,image,x,y,bounds.width,bounds.height,rot);
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public Vector2 getHeading() {
        return heading;
    }

    @Override
    public void setX(float value) {
        x=value;
        bounds.x=x- (float)WIDTH /2;
    }

    @Override
    public void setY(float value) {
        y=value;
        bounds.y=y-((float)HEIGHT / 2);

    }

    @Override
    public void setHeading(Vector2 value) {
        heading = value;
    }
}
