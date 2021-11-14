package com.alec.robotgame.util;

import com.badlogic.gdx.InputAdapter;

public class DummyInputProcessor extends InputAdapter implements InputProcessor {


    public DummyInputProcessor()  {
    }

    public boolean isKeyHeld(int key) {
        return false;
    }


    public boolean isKeyPressed(int key) {
        return false;
    }

    @Override
    public void update() {

    }
}
