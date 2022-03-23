package com.alec.robotgame.util;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Input.Keys;

import java.util.HashMap;

public class GameInputProcessor extends InputAdapter implements InputProcessor{

    protected HashMap<Integer,Boolean> heldKeys;
    protected HashMap<Integer,Boolean> pressedKeys;
    protected HashMap<String,Integer> keybinds;

    {Gdx.input.setInputProcessor(this);}

    public GameInputProcessor() {
        heldKeys=new HashMap<>();
        pressedKeys=new HashMap<>();
        keybinds=new HashMap<>();
        keybinds.put("w", Keys.W);
        keybinds.put("a", Keys.A);
        keybinds.put("s", Keys.S);
        keybinds.put("d", Keys.D);

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

    public boolean isKeybindPressed(String keybind){
        return isKeyPressed(keybinds.get(keybind));

    }

    public boolean isKeybindHeld(String keybind){
        return isKeyHeld(keybinds.get(keybind));

    }

    public boolean areAnyKeybindsPressed(String[] keys){
        for (String keybind:keys){
            if (!isKeyPressed(keybinds.get(keybind))){
                return false;
            }
        }
        return true;
    }

    public boolean areAnyKeybindsHeld(String[] keys){
        for (String keybind:keys){
            if (!isKeyHeld(keybinds.get(keybind))){
                return false;
            }
        }
        return true;
    }

    public boolean areAnyKeybindsNotPressed(String[] keys){
        for (String keybind:keys){
            if (isKeyPressed(keybinds.get(keybind))){
                return false;
            }
        }
        return true;
    }

    public boolean areAnyKeybindsNotHeld(String[] keys){
        for (String keybind:keys){
            if (isKeyHeld(keybinds.get(keybind))){
                return false;
            }
        }
        return true;
    }
}
