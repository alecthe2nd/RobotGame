package com.alec.robotgame.util;

import com.alec.robotgame.RobotGame;

public interface Behavior {

    public void moveTowards( Sprite s, float x,float y);

    public void turnTowards( Sprite s, float x,float y);

    public void update(Sprite s, RobotGame game);

}
