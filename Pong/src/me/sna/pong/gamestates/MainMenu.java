package me.sna.pong.gamestates;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenu extends BasicGameState{

    private static final int ID = 0;
    
    private static Image bg;
    
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
	bg = new Image("assets/black.gif");
	bg.setFilter(Image.FILTER_LINEAR);
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
	bg.draw(125, 100);
	g.drawString("Press space to play!", 215, 250);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
	changeState(gc,sbg);
    }
    
    public void changeState(GameContainer gc, StateBasedGame sbg){
	Input in = gc.getInput();
	if(in.isKeyPressed(Input.KEY_SPACE)){
	    sbg.enterState(1);
	}
    }

    public int getID() {
	return MainMenu.ID;
    }

}
