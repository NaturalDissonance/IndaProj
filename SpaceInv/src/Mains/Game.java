package Mains;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


import Entities.Player;

public class Game extends BasicGameState {

	// **************************************************
	// SETTINGS
	
	
	
	
	private Player player;

	@Override
	public void init(GameContainer container, StateBasedGame game) 
			throws SlickException {
		
		// Construct the spaceship
		player = new Player(200,200);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		
		// Render the player's spaceship
		player.render(g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		
		
		
		
		// TODO Auto-generated method stub

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}

}
