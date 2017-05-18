package me.sna.pong.gamestates;

import java.awt.Font;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.RoundedRectangle;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class TwoPlayer extends BasicGameState {

    // Game state ID
    private static final int ID = 2;

    // Ball and Paddles
    private Circle ball;
    private Rectangle paddlePlayer;
    private Rectangle paddleCPU;
    private Vector2f ballVelocity;
    private Sound ball_impact;
    private Music inGameMusic;

    // Scores
    private int scorePlayer = 0;
    private int scoreCPU = 0;
    
    //Font
    private static TrueTypeFont font = new TrueTypeFont(new Font("Optima", Font.CENTER_BASELINE, 16), true);

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
	//
	gc.getInput().enableKeyRepeat();
	paddlePlayer = new RoundedRectangle(5, 480 / 2, 8, 80, 3);
	paddleCPU = new RoundedRectangle(640 - 10, 480 / 2, 8, 80, 3);
	ball = new Circle(640 / 2, 480 / 2, 6);
	ballVelocity = new Vector2f(10, 10);
	ball_impact = new Sound("assets/ball_impact.wav");
	inGameMusic = new Music("assets/background_music.wav");
	inGameMusic.loop(1, 0.2f);
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
	// Fill paddle and ball entities
	g.fill(paddlePlayer);
	g.fill(paddleCPU);
	g.fill(ball);
	
	g.setFont(font);

	// draw scores on canvas
	g.drawString("Player 1: " + String.valueOf(scorePlayer), 10, 10);
	g.drawString("Player 2: " + String.valueOf(scoreCPU), 555, 10);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
	// Testing for key input
	if (gc.getInput().isKeyDown(Input.KEY_UP)) {
	    if (paddlePlayer.getMinY() >= 2)
		paddlePlayer.setY(paddlePlayer.getY() - 10.0f);
	} else if (gc.getInput().isKeyDown(Input.KEY_DOWN)) {
	    if (paddlePlayer.getMaxY() <= 478)
		paddlePlayer.setY(paddlePlayer.getY() + 10.0f);
	}
	
	if(gc.getInput().isKeyDown(Input.KEY_W)){
	    if(paddleCPU.getMinY() >=  2){
		paddleCPU.setY(paddleCPU.getY() - 10.0f);
	    }
	}else if(gc.getInput().isKeyDown(Input.KEY_S)){
	    if(paddleCPU.getMaxY() <= 478){
		paddleCPU.setY(paddleCPU.getY() + 10.0f);
	    }
	}

	if (gc.getInput().isKeyDown(Input.KEY_ESCAPE)) {
	    System.exit(0);
	}

	// Moving the ball with the set velocity
	ball.setLocation(ball.getX() + ballVelocity.getX(), ball.getY() + ballVelocity.getY());

	// Testing if the ball has hit the players wall
	if (ball.getMinX() <= 0) {
	    ballVelocity.x = -ballVelocity.getX();
	    ball.setLocation(640 / 2, 480 / 2);
	    scoreCPU++;
	}

	// Testing if the ball has hit the cpu's wall
	if (ball.getMaxX() >= 640) {
	    ballVelocity.x = -ballVelocity.getX();
	    ball.setLocation(640 / 2, 480 / 2);
	    scorePlayer++;
	}

	// Changing Directions after collisions
	if (ball.getMinY() <= 0) {
	    ball_impact.play();
	    ballVelocity.y = -ballVelocity.getY();
	}

	if (ball.getMaxY() >= 480) {
	    ball_impact.play();
	    ballVelocity.y = -ballVelocity.getY();
	}

	if (ball.intersects(paddlePlayer) || ball.intersects(paddleCPU)) {
	    ball_impact.play();
	    ballVelocity.x = -ballVelocity.getX();
	}
    }

    // Returns the game-state ID of this class
    public int getID() {
	return TwoPlayer.ID;
    }
}
