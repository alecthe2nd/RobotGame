package com.alec.robotgame.physics;

import com.alec.robotgame.util.Sprite;
import com.badlogic.gdx.math.Vector2;

public interface Physics {
    void watchSprite();
    void ignoreSprite();
    void applyForce(Sprite sprite, Vector2 force);
}
