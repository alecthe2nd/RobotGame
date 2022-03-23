package com.alec.robotgame.player.BehaviorStates;

import com.alec.robotgame.RobotGame;
import com.alec.robotgame.animations.ProgressBar;
import com.alec.robotgame.items.Item;
import com.alec.robotgame.player.BehaviorStates.util.PlayerBehaviorState;
import com.alec.robotgame.player.PlayerBehavior;
import com.alec.robotgame.util.InputProcessor;
import com.alec.robotgame.util.PhysicsComponent;
import com.alec.robotgame.util.Sprite;
import com.alec.robotgame.world.Landscape;
import com.alec.robotgame.world.Tiles.Tile;
import com.badlogic.gdx.Input;

public class Mining extends PlayerBehaviorState {

    private int mining_timer=0;
    private int mine_time=300;
    private ProgressBar progressBar;


    @Override
    public void enter(RobotGame game, Sprite sprite) {
        float x = sprite.getX();
        float y = sprite.getY();
        System.out.println("Entering state 'Mining' of "+sprite);
        sprite.animator.setAnimation(1);
        progressBar = sprite.animator.addProgressBar(x,y,0,mine_time);
        sprite.isMining = true;
        mining_timer = 0;
    }

    @Override
    public void exit(RobotGame game,Sprite sprite) {
        System.out.println("Exiting state 'Mining' of "+sprite);
        sprite.isMining = false;
        sprite.animator.removeProgressBar(progressBar);

    }

    @Override
    public void execute(RobotGame game,Sprite sprite) {
        PlayerBehavior behavior = (PlayerBehavior)sprite.behavior;
        InputProcessor input = game.getSpriteInput();
        PhysicsComponent physics = sprite.physics;
        float x = sprite.getX();
        float y = sprite.getY();
        Landscape terrain = game.getTerrain();
        Tile tileBelow = terrain.getTile(x,y);

        if (input.isKeyPressed(Input.Keys.Q)) {
            behavior.changeState(new Idle(),game,sprite);
        }
        if (mining_timer>=mine_time){
            if (tileBelow.isMineable()) {
                sprite.inventory.addItem(tileBelow.getOre());
            }
            mining_timer = 0;
        }
        mining_timer++;
        progressBar.value = mining_timer;
        System.out.println(mining_timer);

    }
}
