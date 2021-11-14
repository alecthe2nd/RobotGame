package com.alec.robotgame.player;

import com.alec.robotgame.RobotGame;
import com.alec.robotgame.util.PhysicsComponent;
import com.alec.robotgame.util.Sprite;
import com.alec.robotgame.world.Landscape;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class PlayerPhysics implements PhysicsComponent {

    private Array<Vector2> forces;
    private Array<Vector2> rforces;
    private Vector2 velocity;
    private Vector2 rvelocity;

    public PlayerPhysics(){
        forces = new Array<>();
        rforces = new Array<>();
        velocity = new Vector2();
        rvelocity = new Vector2();
    }

    @Override
    public Vector2 getMotionHeading() {
        return velocity.nor();
    }

    @Override
    public void update(Sprite s, RobotGame game) {
        Landscape terrain = game.getTerrain();
        velocity.set(0,0);
        rvelocity.set(0,0);

        float x = s.getX();
        float y = s.getY();
        Vector2 Heading = s.getHeading();

        Vector2 totalForce = new Vector2(0, 0);
        for (Vector2 force : forces) {
            totalForce.add(force);
        }
        Vector2 totalrotForce = new Vector2(0, 0);
        for (Vector2 rforce : rforces) {
            totalrotForce.add(rforce);
        }

        Vector2 acceleration = totalForce.scl((1 / s.mass));
        Vector2 racceleration = totalrotForce.scl((1 / s.mass));

        velocity.add(acceleration.scl(1));
        rvelocity.add(racceleration.scl(1));

        x += velocity.x;
        y += velocity.y;
        Heading = Heading.add(rvelocity.nor());

        Rectangle terrainBounds = terrain.getBounds();

        if (x >= terrainBounds.width) {
            x = terrainBounds.width - 0.01f;
        }
        if (x < 0) {
            x = 0;
        }
        if (y >= terrainBounds.height) {
            y = terrainBounds.height - 0.01f;
        }
        if (y < 0) {
            y = 0;
        }

        s.setX(x);
        s.setY(y);
        s.setHeading(Heading);
        forces.clear();
        rforces.clear();

    }

    @Override
    public void addForce(Vector2 f) {
        forces.add(f);
    }

    @Override
    public void addRotForce(Vector2 f) {
        rforces.add(f);
    }
}
