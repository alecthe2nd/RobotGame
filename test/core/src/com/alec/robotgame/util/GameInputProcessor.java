package com.alec.robotgame.util;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Input.Keys;

import java.util.HashMap;

public class GameInputProcessor extends InputAdapter implements InputProcessor{

    protected HashMap<Integer,Boolean> heldKeys;
    protected HashMap<Integer,Boolean> pressedKeys;

    {Gdx.input.setInputProcessor(this);}

    public GameInputProcessor() {
        heldKeys=new HashMap<>();
        pressedKeys=new HashMap<>();

    }

    public boolean isKeyHeld(int key) {
        if (heldKeys.containsKey(key)) {
            return heldKeys.get(key);
        } else {
            return false;
        }
    }

    public boolean isKeyPressed(int key) {
        if (pressedKeys.containsKey(key)) {
            return pressedKeys.get(key);
        } else {
            return false;
        }
    }

    @Override
    public boolean keyDown(int keycode) {
            heldKeys.put( keycode ,true);
            pressedKeys.put( keycode ,true);
        return false;
    }
    @Override
    public boolean keyUp(int keycode) {
            heldKeys.put( keycode ,false);

        return false;
    }

    public void update() {
        pressedKeys = new HashMap<>();

    }
}
