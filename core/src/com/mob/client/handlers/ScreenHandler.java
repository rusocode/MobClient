/**
 * ****************************************************************************
 * Copyright (C) 2014  Rodrigo Troncoso
 * <p/>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * *****************************************************************************
 */
package com.mob.client.handlers;

import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.mob.client.Game;
import com.mob.client.screens.GameScreen;
import com.mob.client.screens.Screen;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

// import javafx.scene.effect.Reflection;

public class ScreenHandler {

	protected static HashMap<String, Screen> screens = new HashMap<String, Screen>();
	protected static Screen currentScreen;
	private static Game game;

	public static Screen load(String screenClassName) throws Throwable {

		screenClassName = "com.mob.client.screens." + screenClassName; // screenClassName = com.mob.client.screens.GameScreen
		Screen newScreen = null;

		if (!screens.containsKey(screenClassName)) {
			try {
				/* Ahora a partir del objeto Class puedo obtener las caracteristicas del objeto GameScreen, ya que estan
				 * asociados. */
				Class<?> screenClass = ClassReflection.forName(screenClassName);
				Constructor<?> constructor = screenClass.getConstructor(Game.class); // constructor = public com.mob.client.screens.GameScreen(com.mob.client.Game)

				// Que causa InvocationTargetException?
				// https://stackoverflow.com/questions/6020719/what-could-cause-java-lang-reflect-invocationtargetexception
				newScreen = (Screen) constructor.newInstance(game);
				newScreen.print();

				screens.put(screenClassName, newScreen);
			} catch (InvocationTargetException e) {
				throw e.getCause();
				// System.err.println(e.getMessage() + " Exception in Screen.");
				// e.printStackTrace();
			} catch (ReflectionException ex) {
				System.err.println(ex.getMessage() + " Exception in Screen.");
				ex.printStackTrace();
			} catch (NoSuchMethodException ex) {
			} catch (InstantiationException ex) {
				System.err.println(ex + " Screen Must be a concrete class.");
				ex.printStackTrace();
			} catch (IllegalAccessException ex) {
				System.err.println(ex + " Screen with Wrong number of args.");
				ex.printStackTrace();
			}
		} else {
			newScreen = screens.get(screenClassName);
		}

		if (currentScreen != null) {
			currentScreen.dispose();
		}

		currentScreen = newScreen;
		return currentScreen;
	}

	/**
	 * @param currentScreen the currentScreen to set
	 */
	public static void setCurrent(Screen currentScreen) {
		currentScreen = currentScreen;
	}

	/**
	 * @return the currentScreen
	 */
	public static Screen getCurrent() {
		return ScreenHandler.currentScreen;
	}

	public static Game getGameInstance() {
		return game;
	}

	public static void setGameInstance(Game game) {
		ScreenHandler.game = game;
	}
}
