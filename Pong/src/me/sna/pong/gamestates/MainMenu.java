package me.sna.pong.gamestates;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenu extends BasicGameState {

    // Game state ID
    private static final int ID = 0;

    // Image
    private static Image bg;

    // Music
    private static Music music;

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
	music = new Music("assets/Game-Menu.wav");

	music.loop(1, 0.5f);
	// Background image
	bg = new Image("assets/black.gif");
	bg.setFilter(Image.FILTER_LINEAR);
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
	// Drawing the background image
	bg.draw(125, 100);
	// Drawing control command to start the game
	g.drawString("Press space to play!", 215, 250);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
	// Change the gamestate
	changeState(gc, sbg);
    }

    public void changeState(GameContainer gc, StateBasedGame sbg) {
	Input in = gc.getInput();
	if (in.isKeyPressed(Input.KEY_SPACE)) {
	    if(music.playing())
		music.stop();
	    sbg.enterState(1);
	}
    }

    public int getID() {
	return MainMenu.ID;
    }

}
