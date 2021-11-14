package com.alec.robotgame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.alec.robotgame.RobotGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "RobotGame";
		config.width = 1600;
		config.height = 960;
		new LwjglApplication(new RobotGame(), config);
	}
}
