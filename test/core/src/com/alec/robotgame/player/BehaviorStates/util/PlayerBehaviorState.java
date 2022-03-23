package com.alec.robotgame.player.BehaviorStates.util;

import com.alec.robotgame.RobotGame;
import com.alec.robotgame.player.Robot;
import com.alec.robotgame.util.Sprite;
import com.alec.robotgame.util.StateMachines.State;

public abstract class PlayerBehaviorState {
    public abstract void enter(RobotGame game,Sprite sprite);

    public abstract void exit(RobotGame game,Sprite sprite);

    public abstract void execute(RobotGame game,Sprite sprite);


}