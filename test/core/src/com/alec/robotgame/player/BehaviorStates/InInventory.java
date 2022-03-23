package com.alec.robotgame.player.BehaviorStates;

import com.alec.robotgame.RobotGame;
import com.alec.robotgame.items.RobotInventory;
import com.alec.robotgame.menus.InventoryMenu;
import com.alec.robotgame.menus.utils.Menu;
import com.alec.robotgame.player.BehaviorStates.util.PlayerBehaviorState;
import com.alec.robotgame.player.PlayerBehavior;
import com.alec.robotgame.util.InputProcessor;
import com.alec.robotgame.util.PhysicsComponent;
import com.alec.robotgame.util.Sprite;
import com.badlogic.gdx.Input;

public class InInventory extends PlayerBehaviorState {

    static Menu menu;

    public InInventory(){
    }

    @Override
    public void enter(RobotGame game, Sprite sprite) {
        menu = new InventoryMenu(sprite.inventory);
        System.out.println("Entering state 'InInventory' of "+sprite);
        game.openMenu(menu);
        sprite.animator.setAnimation(1);
    }

    @Override
    public void exit(RobotGame game,Sprite sprite) {
        System.out.println("Exiting state 'InInventory' of "+sprite);
        game.closeMenu(menu);

    }

    @Override
    public void execute(RobotGame game,Sprite sprite) {
        PlayerBehavior behavior = (PlayerBehavior)sprite.behavior;
        InputProcessor input = game.getSpriteInput();
        PhysicsComponent physics = sprite.physics;
        float x = sprite.getX();
        float y = sprite.getY();

        if (input.isKeyPressed(Input.Keys.E)) {
            behavior.changeState(new Idle(),game,sprite);
        }

    }
}