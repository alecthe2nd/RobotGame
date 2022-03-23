package com.alec.robotgame.player;

import com.alec.robotgame.RobotGame;
import com.alec.robotgame.util.PhysicsComponent;
import com.alec.robotgame.util.Sprite;
import com.alec.robotgame.world.Landscape;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

public class PlayerPhysics implements PhysicsComponent {

    private Array<Vector2> forces;
    private Array<Vector2> rforces;
    private Array<Vector2> impulses;
    private Array<Vector2> rimpulses;
    private Vector2 velocity;
    private Vector2 ivelocity;
    private Vector2 rvelocity;

    public PlayerPhysics(){
        forces = new Array<>();
        rforces = new Array<>();
        impulses = new Array<>();
        rimpulses = new Array<>();
        velocity = new Vector2();
        ivelocity = new Vector2();
        rvelocity = new Vector2();
    }

    @Override
    public Vector2 getMotionHeading() {return velocity.cpy().nor();}

    @Override
    public Vector2 getImpulseHeading() {return ivelocity.cpy().nor();}

    @Override
    public void update(Sprite s, RobotGame game) {
        Landscape terrain = game.getTerrain();
        //velocity.set(0,0);
        rvelocity.set(0,0);

        float x = s.getX();
        float y = s.getY();
        Vector2 Heading = s.getHeading();

        Vector2 totalForce = (velocity.cpy()).scl(s.mass);
        Vector2 totalImpulse = (ivelocity.cpy()).scl(s.mass);
        for (Vector2 force : forces) {
            totalForce.add(force);
        }
        for (Vector2 impulse : impulses) {
            totalForce.add(impulse);
            totalImpulse.add(impulse);
        }

        if (totalForce.isZero(0.000001f)) {
            totalForce = new Vector2(0,0);
        }

        if (totalImpulse.isZero(0.000001f)) {
            totalImpulse = new Vector2(0,0);
        }

        Vector2 friction = (totalForce.cpy()).scl(-0.4f);
        totalForce = totalForce.add(friction);

        Vector2 ifriction = (totalImpulse.cpy()).scl(-0.4f);
        totalImpulse = totalImpulse.add(ifriction);



        Vector2 totalrotForce = new Vector2(0, 0);
        for (Vector2 rimpulse : rimpulses) {
            totalrotForce.add(rimpulse);
        }
        //System.out.println("Force = x"+totalForce.x+",y"+totalForce.y+"|Friction = x"+friction.x+",y"+friction.y);

        Vector2 acceleration = totalForce.cpy().scl((1 / s.mass));
        Vector2 iacceleration = totalImpulse.cpy().scl((1 / s.mass));
        Vector2 racceleration = totalrotForce.cpy().scl((1 / s.mass));

        velocity = (acceleration.scl(1));
        ivelocity = (iacceleration.scl(1));
        rvelocity.add(racceleration.scl(1));

        x += velocity.x;
        y += velocity.y;
        Heading = Heading.add(rvelocity).nor();

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
        impulses.clear();
        rimpulses.clear();

    }

    @Override
    public void addForce(Vector2 f) {
        forces.add(f);
    }

    @Override
    public void addRotForce(Vector2 f) {
        rforces.add(f);
    }

    @Override
    public void addImpulse(Vector2 f) {
        impulses.add(f);
    }

    @Override
    public void addRotImpulse(Vector2 f) {
        rimpulses.add(f);
    }
}
