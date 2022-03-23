package com.alec.robotgame.util;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FontSpriteBatch extends SpriteBatch {

    public BitmapFont font;

    public FontSpriteBatch(){
        super();
        font = new BitmapFont();
    }


}
