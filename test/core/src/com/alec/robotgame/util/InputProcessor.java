package com.alec.robotgame.util;

public interface InputProcessor {
    public boolean isKeyHeld(int key);
    public boolean isKeyPressed(int key);
    public void update();
}
