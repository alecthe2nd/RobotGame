package com.alec.robotgame.GameStates;

public interface GameState {
    public void enter();
    public void updateSprites();
    public void renderSprites();
    public void exit();
}
