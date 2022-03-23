package com.alec.robotgame.player;

import com.alec.robotgame.RobotGame;
import com.alec.robotgame.player.BehaviorStates.Idle;
import com.alec.robotgame.player.BehaviorStates.util.PlayerBehaviorState;
import com.alec.robotgame.player.BehaviorStates.util.PlayerBehaviorStateMachine;
import com.alec.robotgame.util.Behavior;
import com.alec.robotgame.util.InputProcessor;
import com.alec.robotgame.util.PhysicsComponent;
import com.alec.robotgame.util.Sprite;
import com.alec.robotgame.world.Landscape;
import com.alec.robotgame.world.Tiles.Tile;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

public class PlayerBehavior extends PlayerBehaviorStateMachine<PlayerBehaviorState> implements Behavior {

    public PlayerBehavior () {
        current_state = new Idle();
        previous_state = new Idle();
    }

    @Override
    public void moveTowards( Sprite s, float x, float y) {
        Vector2 steeringdir = new Vector2(x,y).sub(s.getX(),s.getY()).nor();
        Vector2 force = steeringdir.scl(s.horsepower);
        s.physics.addImpulse(force);
    }

    @Override
    public void turnTowards(Sprite s, float x, float y) {
        Vector2 heading = s.getHeading();

        Vector2 rforce = new Vector2(x,y).sub(heading.x,heading.y);
        s.physics.addRotImpulse(rforce);
    }

    @Override
    public void update(Sprite s, RobotGame game) {
        InputProcessor input = game.getSpriteInput();
        PhysicsComponent physics = s.physics;
        float x = s.getX();
        float y = s.getY();
        Landscape terrain = game.getTerrain();
        Tile tileBelow = terrain.getTile(x,y);
        tileBelow.highlight();

        if (input.isKeyPressed(Keys.Q)) {
            System.out.println("Q");
        }
        current_state.execute(game,s);
        Vector2 dir = physics.getImpulseHeading();
        if (!dir.isZero()) {
            turnTowards(s, dir.x, dir.y);
        }
    }

    @Override
    public void update(RobotGame game) {

    }
}
