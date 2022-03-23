package com.alec.robotgame.animations;

import com.alec.robotgame.util.FontSpriteBatch;
import com.badlogic.gdx.utils.Array;

public class RobotAnimator implements Animator{

    protected int current_animation = 0;
    protected Array<ProgressBar> bars = new Array<>();

    @Override
    public int getRenderRegion() {
        return current_animation;
    }

    @Override
    public void update() {

    }

    @Override
    public void setAnimation(int id) {
        current_animation = id;
        System.out.println("Changing to animation "+id);
    }

    @Override
    public ProgressBar addProgressBar(float x, float y, int size, int maxvalue) {
        ProgressBar createdBar = new ProgressBar(x,y,size,maxvalue,0);
        bars.add(createdBar);
        return createdBar;

    }

    @Override
    public void removeProgressBar(ProgressBar bar) {
        bars.removeValue(bar,true);
    }

    @Override
    public void render(FontSpriteBatch b) {
        for (ProgressBar bar:bars){
            bar.render(b);
        }
    }
}
