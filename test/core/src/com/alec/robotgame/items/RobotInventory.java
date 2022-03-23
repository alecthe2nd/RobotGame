package com.alec.robotgame.items;

import com.badlogic.gdx.utils.Array;

import java.util.HashMap;

public class RobotInventory implements Inventory {

    private HashMap<String,Item> items;
    private int inventory_size = 5;

    public RobotInventory(){

        items = new HashMap<>();
        for (String type: ITEM_TYPES) {
            items.put(type,new Item(type,0));
        }

    }

    @Override
    public void addItem(Item item) {
        if (item.amount>0) {
            Item itemslot=items.get(item.type);

            if (itemslot.amount+item.amount<=inventory_size) {
                items.put(item.type,new Item(item.type,itemslot.amount+item.amount));
            }else{
                items.put(item.type,new Item(item.type,inventory_size));
            }
        }
    }

    @Override
    public boolean canPayItems(Array<Item> totalcost) {
        for (Item itemcost:totalcost){
            Item itemslot=items.get(itemcost.type);
            if (itemslot.amount<itemcost.amount) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void payItems(Array<Item> totalcost) {
        if (canPayItems(totalcost)) {
            for (Item itemcost : totalcost) {
                Item itemslot = items.get(itemcost.type);
                items.put(itemcost.type,new Item(itemcost.type,itemslot.amount-itemcost.amount));
            }
        }
    }
    @Override
    public HashMap<String,Item> getItems(){
        return new HashMap<>(items);
    }
}

