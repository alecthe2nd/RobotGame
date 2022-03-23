package com.alec.robotgame.util.StateMachines;

import com.alec.robotgame.RobotGame;

public interface State {

    void enter(RobotGame game);

    void exit(RobotGame game);

    void execute(RobotGame game);
}
