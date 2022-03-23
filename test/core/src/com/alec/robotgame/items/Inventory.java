package com.alec.robotgame.items;

import com.badlogic.gdx.utils.Array;

import java.util.HashMap;

public interface Inventory {
    String[] ITEM_TYPES = {
            "Coal",
            "Iron",
    };

    void addItem(Item item);

    boolean canPayItems(Array<Item> totalcost);

    void payItems(Array<Item> totalcost);

    HashMap<String,Item> getItems();

}
