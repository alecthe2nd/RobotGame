package com.alec.robotgame.animations;

import com.alec.robotgame.util.FontSpriteBatch;

public interface Animator {
    int getRenderRegion();
    void update();
    void setAnimation(int id);
    ProgressBar addProgressBar(float x, float y, int size, int maxvalue);
    void removeProgressBar(ProgressBar bar);
    void render(FontSpriteBatch b);
}
