package com.alec.robotgame;

import com.alec.robotgame.menus.InventoryMenu;
import com.alec.robotgame.menus.utils.Menu;
import com.alec.robotgame.util.DummyInputProcessor;
import com.alec.robotgame.util.GameInputProcessor;
import com.alec.robotgame.player.PlayerBehavior;
import com.alec.robotgame.player.PlayerPhysics;
import com.alec.robotgame.player.Robot;
import com.alec.robotgame.util.InputProcessor;
import com.alec.robotgame.util.Sprite;
import com.alec.robotgame.world.Landscape;
import com.alec.robotgame.world.weather.Weather;
import com.alec.robotgame.world.weather.Wind;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

public class RobotGame extends ApplicationAdapter {
	GameInputProcessor input;
	SpriteBatch batch;
	Texture img;
	Landscape terrain;
	Robot bot;
	Weather wind;
	Array<Sprite> renderedSprites;
	Array<Sprite> loadedSprites;
	Array<Menu> menus;
	boolean doSpriteInput;
	boolean nextDoSpriteInput = true;

	
	@Override
	public void create () {
		doSpriteInput = true;
		input = new GameInputProcessor();
		batch = new SpriteBatch();
		renderedSprites = new Array<>();
		loadedSprites = new Array<>();
		menus = new Array<>();
		img = new Texture("badlogic.jpg");
		terrain = new Landscape();
		bot = new Robot( new PlayerBehavior(), new PlayerPhysics());
		wind = new Wind();
		addSprite(bot);
		//Menu inv = new InventoryMenu();
		//openMenu(inv);
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		terrain.render(batch);
		for (Sprite sprite: renderedSprites) {
			sprite.render(batch);
		}
		for (Menu menu : menus) {
			menu.render(batch);
		}
		batch.end();
		wind.update(this);
		for (Menu menu : menus) {
			menu.update(this);
		}

		for (Sprite sprite: loadedSprites){
			sprite.update(this);
		}
		if (input.isKeyPressed(Keys.SPACE)) {
			if (doSpriteInput) {
				doSpriteInput = false;
				System.out.println("on");
			} else {
				doSpriteInput = true;
				System.out.println("off");
			}
		}

		//System.out.println(doSpriteInput);
		doSpriteInput = nextDoSpriteInput;
		input.update();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}

	public void addSprite(Sprite s) {
		renderedSprites.add(s);
		loadedSprites.add(s);
	}

	public void openMenu(Menu m) {
		menus.add(m);
		System.out.println("open");
		lockSpriteInput();
	}

	public void closeMenu(Menu m) {
		menus.removeValue(m,true);
		System.out.println("closed");
		if (menus.isEmpty()) {
			unlockSpriteInput();
		}
	}

	public Landscape getTerrain() {
		return terrain;
	}

	public InputProcessor getInput() {

		return input;

	}

	public Array<Sprite> getSprites() {
		return loadedSprites;
	}

	public InputProcessor getSpriteInput() {
		if (doSpriteInput) {
			return input;
		} else {
			return new DummyInputProcessor();
		}

	}

	public void lockSpriteInput() {
		nextDoSpriteInput = false;
	}

	public void unlockSpriteInput() {
		nextDoSpriteInput = true;
	}
}
