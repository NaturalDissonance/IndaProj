package Mains;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame {
	public Main(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
	          AppGameContainer app;
			try {
				app = new AppGameContainer(new Main("vidya"));
				app.setDisplayMode(800, 600, false);
				app.setAlwaysRender(true);
				app.start();
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		this.addState(new Meny());
		this.addState(new Game());
		
	}

}
