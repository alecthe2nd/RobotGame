package com.alec.robotgame.util;

import com.alec.robotgame.RobotGame;


public interface Behavior {

    void moveTowards( Sprite s, float x,float y);

    void turnTowards( Sprite s, float x,float y);

    void update(Sprite s, RobotGame game);

}
