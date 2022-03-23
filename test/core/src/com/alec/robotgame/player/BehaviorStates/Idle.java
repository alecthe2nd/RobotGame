package com.alec.robotgame.player.BehaviorStates;

import com.alec.robotgame.RobotGame;
import com.alec.robotgame.player.BehaviorStates.util.PlayerBehaviorState;
import com.alec.robotgame.player.PlayerBehavior;
import com.alec.robotgame.util.Behavior;
import com.alec.robotgame.util.InputProcessor;
import com.alec.robotgame.util.PhysicsComponent;
import com.alec.robotgame.util.Sprite;
import com.badlogic.gdx.Input;

public class Idle extends PlayerBehaviorState {
    @Override
    public void enter(RobotGame game, Sprite sprite) {
        System.out.println("Entering state 'Idle' of "+sprite);
        sprite.animator.setAnimation(0);
    }

    @Override
    public void exit(RobotGame game,Sprite sprite) {
        System.out.println("Exiting state 'Idle' of "+sprite);

    }

    @Override
    public void execute(RobotGame game,Sprite sprite) {
        PlayerBehavior behavior = (PlayerBehavior)sprite.behavior;
        InputProcessor input = game.getSpriteInput();
        PhysicsComponent physics = sprite.physics;
        float x = sprite.getX();
        float y = sprite.getY();

        if (input.isKeyPressed(Input.Keys.W)) {
            behavior.changeState(new Walking(),game,sprite);
        }
        if (input.isKeyPressed(Input.Keys.S)) {
            behavior.changeState(new Walking(),game,sprite);
        }
        if (input.isKeyPressed(Input.Keys.A)) {
            behavior.changeState(new Walking(),game,sprite);
        }
        if (input.isKeyPressed(Input.Keys.D)) {
            behavior.changeState(new Walking(),game,sprite);
        }

        if (input.isKeyPressed(Input.Keys.E)) {
            behavior.changeState(new InInventory(),game,sprite);
        }

        if (input.isKeyPressed(Input.Keys.Q)) {
            behavior.changeState(new Mining(),game,sprite);
        }

    }
}
