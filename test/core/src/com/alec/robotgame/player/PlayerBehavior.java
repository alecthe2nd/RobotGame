package com.alec.robotgame.player;

import com.alec.robotgame.RobotGame;
import com.alec.robotgame.menus.InventoryMenu;
import com.alec.robotgame.util.Behavior;
import com.alec.robotgame.util.InputProcessor;
import com.alec.robotgame.util.PhysicsComponent;
import com.alec.robotgame.util.Sprite;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;

public class PlayerBehavior implements Behavior {
    public Vector2 Heading;

    public PlayerBehavior () {
        Heading = new Vector2(0,0);
    }

    @Override
    public void moveTowards( Sprite s, float x, float y) {
        Vector2 steeringdir = new Vector2(x,y).sub(s.getX(),s.getY()).nor();
        Vector2 force = steeringdir.scl(0.1f);
        s.physics.addForce(force);
    }

    @Override
    public void turnTowards(Sprite s, float x, float y) {
        Vector2 heading = s.getHeading();
        Vector2 dir = new Vector2(x,y).sub(heading.x,heading.y).nor();
        System.out.println("x="+x+"/y="+y+"/dir="+dir);
        Vector2 rforce = dir;
        s.physics.addRotForce(rforce);
    }

    @Override
    public void update(Sprite s, RobotGame game) {
        InputProcessor input = game.getSpriteInput();
        PhysicsComponent physics = s.physics;
        float x = s.getX();
        float y = s.getY();
        if (input.isKeyHeld(Keys.W)) {

            moveTowards(s, x, y + 1);
            System.out.println("W");
        }
        if (input.isKeyHeld(Keys.S)) {

            moveTowards(s, x, y - 1);
            System.out.println("S");
        }
        if (input.isKeyHeld(Keys.A)) {

            moveTowards(s, x - 1, y);
            System.out.println("A");
        }
        if (input.isKeyHeld(Keys.D)) {

            moveTowards(s, x + 1, y);
            System.out.println("D");
        }
        if (input.isKeyPressed(Keys.Q)) {
            System.out.println("Q");
        }

        if (input.isKeyPressed((Keys.E))) {
            game.openMenu(new InventoryMenu());
        }
        Vector2 dir = physics.getMotionHeading();
        turnTowards(s,dir.x,dir.y);
        System.out.println(dir.x+"/"+dir.y);
    }
}
