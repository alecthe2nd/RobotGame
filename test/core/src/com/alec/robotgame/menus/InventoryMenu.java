package com.alec.robotgame.menus;

import com.alec.robotgame.RobotGame;
import com.alec.robotgame.items.Inventory;
import com.alec.robotgame.items.Item;
import com.alec.robotgame.menus.utils.ItemIcon;
import com.alec.robotgame.menus.utils.Menu;
import com.alec.robotgame.util.FontSpriteBatch;
import com.alec.robotgame.util.InputProcessor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;

import java.util.HashMap;

public class InventoryMenu implements Menu {
    static Texture image = new Texture(Gdx.files.internal("Inventory.png"));

    protected ItemIcon item;
    protected Inventory inventory;

    public InventoryMenu(Inventory inventory) {
        item = new ItemIcon();
        this.inventory = inventory;
    }

    @Override
    public void render(FontSpriteBatch b) {

        b.draw(image,400,180);
        HashMap<String,Item> items = inventory.getItems();
        int posaccum = 0;
        for (String itemtype:Inventory.ITEM_TYPES){
            Item item = items.get(itemtype);
            item.render(b,posaccum,0);
            posaccum++;

        }




    }

    @Override
    public void update(RobotGame g) {
        InputProcessor input = g.getInput();

    }
}
