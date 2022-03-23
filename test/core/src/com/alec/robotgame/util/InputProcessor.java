package com.alec.robotgame.util;

public interface InputProcessor {
    boolean isKeyHeld(int key);
    boolean isKeyPressed(int key);
    boolean isKeybindHeld(String keybind);
    boolean isKeybindPressed(String keybind);
    boolean areAnyKeybindsHeld(String[] keys);
    boolean areAnyKeybindsNotHeld(String[] keys);
    boolean areAnyKeybindsPressed(String[] keys);
    boolean areAnyKeybindsNotPressed(String[] keys);
    void update();
}
