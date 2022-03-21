package com.alec.robotgame.util;

import com.alec.robotgame.RobotGame;
import com.badlogic.gdx.math.Vector2;

public interface PhysicsComponent {

    Vector2 getMotionHeading ();

    Vector2 getImpulseHeading ();

    void update(Sprite s , RobotGame game);

    void addForce(Vector2 f);

    void addRotForce(Vector2 f);

    void addImpulse(Vector2 f);

    void addRotImpulse(Vector2 f);

}
