package com.alec.robotgame.menus.utils;

import com.alec.robotgame.RobotGame;
import com.badlogic.gdx.graphics.g2d.Batch;

public interface Menu {
    public void render(Batch b);
    public void update(RobotGame g);
}
