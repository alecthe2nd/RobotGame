package com.alec.robotgame.player;

import com.alec.robotgame.RobotGame;
import com.alec.robotgame.animations.RobotAnimator;
import com.alec.robotgame.items.RobotInventory;
import com.alec.robotgame.util.Behavior;
import com.alec.robotgame.util.FontSpriteBatch;
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



    public Robot(Behavior behavior, PhysicsComponent physics) {
        x=1.5f;
        y=1.5f;
        mass = 1;
        horsepower = 0.05f;
        heading = new Vector2();
        bounds.x = x-(WIDTH/2f);
        bounds.y = y-(HEIGHT/2f);
        bounds.width = WIDTH;
        bounds.height = HEIGHT;
        this.behavior = behavior;
        this.physics = physics;
        this.animator = new RobotAnimator();
        this.inventory = new RobotInventory();

    }

    public void update(RobotGame game) {
        behavior.update(this,game);
        physics.update(this,game);


    }

    @Override
    public void render(FontSpriteBatch b) {
        float rot = heading.angleDeg();
        drawImage(b,image,x,y,bounds.width,bounds.height,rot, animator.getRenderRegion());
        animator.render(b);

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
