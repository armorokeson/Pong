package me.sna.pong.gamestates;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.RoundedRectangle;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class InGame extends BasicGameState {

    private static final int ID = 1;

    private Circle ball;
    private Rectangle paddlePlayer;
    private Rectangle paddleCPU;
    private Vector2f ballVelocity;
    private int scorePlayer = 0;
    private int scoreCPU = 0;

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
	gc.getInput().enableKeyRepeat();
	paddlePlayer = new RoundedRectangle(5, 480 / 2, 10, 80, 3);
	paddleCPU = new RoundedRectangle(640 - 15, 480 / 2, 10, 80, 3);
	ball = new Circle(640 / 2, 480 / 2, 6);
	ballVelocity = new Vector2f(-3, 1);
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
	g.fill(paddlePlayer);
	g.fill(paddleCPU);
	g.fill(ball);
	g.drawString("Player: " + String.valueOf(scorePlayer), 10, 10);
	g.drawString("CPU: " + String.valueOf(scoreCPU), 570, 10);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
	if (gc.getInput().isKeyDown(Input.KEY_UP)) {
	    if (paddlePlayer.getMinY() > 0)
		paddlePlayer.setY(paddlePlayer.getY() - 10.0f);
	} else if (gc.getInput().isKeyDown(Input.KEY_DOWN)) {
	    if (paddlePlayer.getMaxY() < 480)
		paddlePlayer.setY(paddlePlayer.getY() + 10.0f);
	}

	ball.setLocation(ball.getX() + ballVelocity.getX(), ball.getY() + ballVelocity.getY());

	if (ball.getMinX() <= 0) {
	    ballVelocity.x = -ballVelocity.getX();
	    ball.setLocation(640/2, 480/2);
	    scoreCPU++;
	}

	if (ball.getMaxX() >= 640) {
	    ballVelocity.x = -ballVelocity.getX();
	    ball.setLocation(640/2, 480/2);
	    scorePlayer++;
	}

	if (ball.getMinY() <= 0)
	    ballVelocity.y = -ballVelocity.getY();

	if (ball.getMaxY() >= 480)
	    ballVelocity.y = -ballVelocity.getY();

	if (ball.intersects(paddlePlayer) || ball.intersects(paddleCPU)) {
	    ballVelocity.x = -ballVelocity.getX();
	}
	
	float ypos = ball.getCenterY() - paddleCPU.getHeight() / 2;
	
	paddleCPU.setY(ypos);
    }

    public int getID() {
	return InGame.ID;
    }

}
