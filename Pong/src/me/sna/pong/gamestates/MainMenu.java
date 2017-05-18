package me.sna.pong.gamestates;

import java.awt.Font;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenu extends BasicGameState {

	// Game state ID
	private static final int ID = 0;

	// Image
	private static Image bg;

	// Font
	private static TrueTypeFont font = new TrueTypeFont(new Font("Optima", Font.CENTER_BASELINE, 16), true);

	// Music
	private static Music music;
	private Rectangle singlePlayer;
	private Rectangle twoPlayer;
	private Rectangle instructions;

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		music = new Music("assets/Game-Menu.wav");

		music.loop(1, 0.5f);
		// Background image
		bg = new Image("assets/black.gif");
		bg.setFilter(Image.FILTER_LINEAR);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// Drawing the background image
		bg.draw(142, 100);
		// Made by statements
		font.drawString(175, 250, "Made by Sam Leighton and Armor Okeson");
		// Button for single player
		singlePlayer = new Rectangle(195, 300, 100, 40);
		g.draw(singlePlayer);
		font.drawString(201, 308, "Single Player");
		// Button for two player
		twoPlayer = new Rectangle(345, 300, 100, 40);
		g.draw(twoPlayer);
		font.drawString(356, 308, "Two Player");
		// Instructions
		instructions = new Rectangle(270, 360, 100, 40);
		g.draw(instructions);
		font.drawString(279, 369, "Instructions");
	}

	public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
		// Change the gamestate
		
		int posX = Mouse.getX();
		int posY = Mouse.getY();

		// Move to single player state
		if ((posX >= 195 && posX <= 295) && (posY >= 140 && posY <= 180)) {
			if (Mouse.isButtonDown(0)) {
				sbg.enterState(1);
			}
		}
		
		// Move to two player state
		if ((posX >= 345 && posX <= 445) && (posY >= 140 && posY <= 180)) {
			if (Mouse.isButtonDown(0)) {
				sbg.enterState(2);
			}
		}
		
		// Move to instructions state
		if ((posX >= 270 && posX <= 370) && (posY >= 80 && posY <= 120)) {
			if (Mouse.isButtonDown(0)) {
				sbg.enterState(3);
			}
		}
	}

	public int getID() {
		return MainMenu.ID;
	}

}
