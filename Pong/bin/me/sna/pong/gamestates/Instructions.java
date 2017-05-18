package me.sna.pong.gamestates;

import java.awt.Font;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Instructions extends BasicGameState {
	
	private static final int ID = 3;
	
	// Font
	private static TrueTypeFont font1 = new TrueTypeFont(new Font("Optima", Font.CENTER_BASELINE, 16), true);
	private static TrueTypeFont font2 = new TrueTypeFont(new Font("Optima", Font.BOLD, 24), true);
	
	// Button
	private Rectangle mainMenu;

	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		
	}

	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		// Player 1 controls
		font2.drawString(100, 100, "Player 1");
		font1.drawString(100, 130, "Up Arrow - Up");
		font1.drawString(100, 150, "Down Arrow - Down");
		
		// Player 2 controls
		font2.drawString(300, 100, "Player 2");
		font1.drawString(300, 130, "W Key - Up");
		font1.drawString(300, 150, "S Key - Down");
		
		// Button to go back to the main menu
		mainMenu = new Rectangle(100, 250, 100, 40);
		arg2.draw(mainMenu);
		font1.drawString(110, 260, "Main Menu");
	}

	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		
		// Move back to main menu state
		if ((posX >= 100 && posX <= 200) && (posY >= 190 && posY <= 230)) {
			if (Mouse.isButtonDown(0)) {
				arg1.enterState(0);
			}
		}
	}

	public int getID() {
		return Instructions.ID;
	}
	
}
