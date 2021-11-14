package com.alec.robotgame.util;

import com.alec.robotgame.RobotGame;
import com.alec.robotgame.world.Landscape;
import com.badlogic.gdx.math.Vector2;

public interface PhysicsComponent {

    public Vector2 getMotionHeading ();
    public void update(Sprite s , RobotGame game);
    public void addForce(Vector2 f);
    public void addRotForce(Vector2 f);

}
