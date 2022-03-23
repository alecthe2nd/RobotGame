package com.alec.robotgame.player.BehaviorStates;

import com.alec.robotgame.RobotGame;
import com.alec.robotgame.player.BehaviorStates.util.PlayerBehaviorState;
import com.alec.robotgame.player.PlayerBehavior;
import com.alec.robotgame.util.InputProcessor;
import com.alec.robotgame.util.PhysicsComponent;
import com.alec.robotgame.util.Sprite;
import com.badlogic.gdx.Input;

public class Walking extends PlayerBehaviorState {
    @Override
    public void enter(RobotGame game, Sprite sprite) {
        System.out.println("Entering state 'Walking' of "+sprite);
        sprite.animator.setAnimation(0);
    }

    @Override
    public void exit(RobotGame game,Sprite sprite) {
        System.out.println("Exiting state 'Walking' of "+sprite);

    }

    @Override
    public void execute(RobotGame game,Sprite sprite) {
        PlayerBehavior behavior = (PlayerBehavior)sprite.behavior;
        InputProcessor input = game.getSpriteInput();
        PhysicsComponent physics = sprite.physics;
        float x = sprite.getX();
        float y = sprite.getY();

        if (input.areAnyKeybindsNotHeld(new String[]{"w", "a", "s", "d"})) {
            behavior.changeState(new Idle(),game,sprite);
        }

        if (input.isKeybindHeld("w")) {

            behavior.moveTowards(sprite, x, y + 1);
        }
        if (input.isKeybindHeld("s")) {

            behavior.moveTowards(sprite, x, y - 1);
        }
        if (input.isKeybindHeld("a")) {

            behavior.moveTowards(sprite, x - 1, y);
        }
        if (input.isKeybindHeld("d")) {

            behavior.moveTowards(sprite, x + 1, y);
        }

    }
}
