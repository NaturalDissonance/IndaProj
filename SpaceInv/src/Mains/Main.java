package Mains;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import Menus.Meny;
import Menus.Options;

public class Main extends StateBasedGame {
	
	// **************************************************
	// SETTINGS
	private static final int FPS_LIMIT = 60;
	private static final boolean START_IN_FULLSCREEN = false;
	public static final int DEFAULT_WIDTH = 800;
	public static final int ASPECT_RATIO_X = 4;
	public static final int ASPECT_RATIO_Y = 3;
	
	
	
	// **************************************************
	// CODE
    public static AppGameContainer app;
    
	public Main(String name) {
		super(name);
	}

	
	/**
	 * First method that runs when the application starts.
	 */
	public static void main(String[] args) {
			try {
				app = new AppGameContainer(new Main("vidya"));
				app.setTargetFrameRate(FPS_LIMIT); // limits the FPS
				app.setDisplayMode(DEFAULT_WIDTH, (int)(ASPECT_RATIO_Y*DEFAULT_WIDTH/ASPECT_RATIO_X), START_IN_FULLSCREEN); // width and height
				app.setAlwaysRender(true);
				app.start();
			} catch (SlickException e) {
				System.err.println("Error: Main.main() caught SlickException.");
				System.exit(1);
			}
	}
	
	
	/**
	 * Adds the different game states to the StateBasedGame. Is run
	 * from somewhere inside the main() method's try/catch block
	 */
	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		this.addState(new Meny()); // starts the game in the "Meny" game state, state ID = 0
		this.addState(new Options()); // state ID = 2
		this.addState(new Game()); // state ID = 1
	}
	
}