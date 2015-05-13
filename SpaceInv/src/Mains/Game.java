package Mains;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.SpriteSheet;

import Entities.Player;

@SuppressWarnings("unused")
public class Game extends BasicGameState {

	private Player player;
	
	
	public Game() {
		player = new Player(100, 100);

	}

	@Override
	public void init(GameContainer container, StateBasedGame game) 
			throws SlickException {
		
		

	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		
		// Render the player's spaceship
		player.render();
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
