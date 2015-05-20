package Mains;

import java.util.ArrayList;
import java.util.Iterator;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import Entities.Player;
import Entities.Enemy;

public class Game extends BasicGameState {

	private Player player;
	private ArrayList<Enemy> enemies;

	@Override
	public void init(GameContainer container, StateBasedGame game) 
			throws SlickException {
		
		player = new Player();
		player.init(container);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		
		// Render the player's spaceship
		player.render(g);
		
		// Render all the enemies
		Iterator<Enemy> it = enemies.iterator();
		Enemy en;
		while (it.hasNext()) {
			en = it.next();
			en.render(g);
		}
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		
		player.update();
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}

}
