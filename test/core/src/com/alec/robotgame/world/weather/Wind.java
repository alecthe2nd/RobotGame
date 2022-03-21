package com.alec.robotgame.world.weather;

import com.alec.robotgame.RobotGame;
import com.alec.robotgame.util.InputProcessor;
import com.alec.robotgame.util.Sprite;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class Wind implements Weather {

    public Wind() {}

    @Override
    public void update(RobotGame game) {
        InputProcessor input = game.getSpriteInput();
        Array<Sprite> sprites = game.getSprites();
        if (input.isKeyHeld(Keys.UP)) {
            for (Sprite sprite:sprites) {
                sprite.physics.addForce(new Vector2(0.05f,0f));
            }
        }
    }
}
