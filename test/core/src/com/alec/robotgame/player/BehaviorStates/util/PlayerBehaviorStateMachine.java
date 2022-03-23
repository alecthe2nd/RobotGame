package com.alec.robotgame.player.BehaviorStates.util;

import com.alec.robotgame.RobotGame;
import com.alec.robotgame.util.Sprite;
import com.alec.robotgame.util.StateMachines.BaseStateMachine;

public abstract class PlayerBehaviorStateMachine<S extends PlayerBehaviorState> {

    protected S current_state;

    protected S previous_state;

    public abstract void update(RobotGame game);

    public void changeState(S state, RobotGame game, Sprite sprite) {
        current_state.exit(game,sprite);
        previous_state = current_state;
        current_state = state;
        current_state.enter(game,sprite);
    }
}
