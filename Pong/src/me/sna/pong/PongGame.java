package me.sna.pong;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import me.sna.pong.gamestates.InGame;
import me.sna.pong.gamestates.MainMenu;
import me.sna.pong.gamestates.TwoPlayer;

public class PongGame extends StateBasedGame{
    
    //Constructor for StateBasedGame class
    public PongGame(String title) {
	super(title);
    }
    
    //Main method
    public static void main(String[] args){
	try {
	    //Creating a new game container called "Pong"
	    AppGameContainer app = new AppGameContainer(new PongGame("Pong"));
	    //Setting the window size and full-screen mode
	    app.setDisplayMode(640, 480, false);
	    app.setShowFPS(false);
	    app.setVSync(true);
	    app.start();
	} catch (SlickException e) {
	    e.printStackTrace();
	}
    }
    
    public void initStatesList(GameContainer gc) throws SlickException {
	addState(new MainMenu());
	addState(new InGame());
	addState(new TwoPlayer());
    }
}
