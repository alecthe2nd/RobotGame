package com.alec.robotgame.menus;

import com.alec.robotgame.RobotGame;
import com.alec.robotgame.menus.utils.Menu;
import com.alec.robotgame.util.InputProcessor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

public class InventoryMenu implements Menu {
    static Texture image = new Texture(Gdx.files.internal("Inventory.png"));

    @Override
    public void render(Batch b) {
        b.draw(image,400,180);
    }

    @Override
    public void update(RobotGame g) {
        InputProcessor input = g.getInput();
        if (input.isKeyPressed((Input.Keys.E))) {
            g.closeMenu(this);
        }

    }
}
