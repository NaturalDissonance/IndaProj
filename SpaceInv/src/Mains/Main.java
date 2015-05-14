package Mains;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame {
	
	private static final int FPS_LIMIT = 60;
    static AppGameContainer app;
	
	
	
	public Main(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
			try {
				app = new AppGameContainer(new Main("vidya"));
				app.setDisplayMode(800, 600, true);
				app.setAlwaysRender(true);
				app.setTargetFrameRate(FPS_LIMIT); // limits the FPS
				app.start();
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

	}
	

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		this.addState(new Meny());// state ID = 0
		this.addState(new Options());// state ID = 2
		this.addState(new Game()); // state ID = 1
	}
	
}
