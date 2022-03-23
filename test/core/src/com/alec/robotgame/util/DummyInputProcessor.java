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
    public boolean isKeybindHeld(String keybind) {
        return false;
    }

    @Override
    public boolean isKeybindPressed(String keybind) {
        return false;
    }

    @Override
    public boolean areAnyKeybindsHeld(String[] keys) {
        return false;
    }

    @Override
    public boolean areAnyKeybindsNotHeld(String[] keys) {
        return false;
    }

    @Override
    public boolean areAnyKeybindsPressed(String[] keys) {
        return false;
    }

    @Override
    public boolean areAnyKeybindsNotPressed(String[] keys) {
        return false;
    }

    @Override
    public void update() {

    }
}
