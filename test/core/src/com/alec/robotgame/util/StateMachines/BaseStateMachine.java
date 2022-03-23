package com.alec.robotgame.util.StateMachines;

import com.alec.robotgame.RobotGame;
import com.badlogic.gdx.graphics.g2d.Batch;

public abstract class BaseStateMachine<S extends State> {

    protected S current_state;

    protected S previous_state;

    public abstract void update(RobotGame game);

    public void changeState(S state, RobotGame game) {
        current_state.exit(game);
        previous_state = current_state;
        current_state = state;
        current_state.enter(game);
    }
}
