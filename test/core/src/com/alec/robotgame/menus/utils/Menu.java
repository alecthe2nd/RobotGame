package com.alec.robotgame.menus.utils;

import com.alec.robotgame.RobotGame;
import com.alec.robotgame.util.FontSpriteBatch;

public interface Menu {
    void render(FontSpriteBatch b);
    void update(RobotGame g);
}
