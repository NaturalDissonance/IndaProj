package Menus;

import org.newdawn.slick.GameContainer;

import Entities.Buttons;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.*;

public class Meny extends BasicGameState {
	// **************************************************
	// SETTINGS
	private final int BUTTON_WIDTH = 220; 
	private final int BUTTON_HEIGHT = 45;
	private final int FIRST_BUTTON_OFFSET = -50;
	
	private final String TITLE_IMAGE_NAME = "Images\\Title_Image.png";
	private final int TITLE_IMAGE_OFFSET = -200;
	private final int TITLE_WIDTH = 600;
	private final int TITLE_HEIGHT = 100;
	
	
	Buttons start, options, quit;
	Image title;

	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		
		start= new Buttons(container.getWidth()/2-BUTTON_WIDTH/2, container.getHeight()/2+FIRST_BUTTON_OFFSET, BUTTON_WIDTH, BUTTON_HEIGHT, "Start");
		options= new Buttons(container.getWidth()/2-BUTTON_WIDTH/2, container.getHeight()/2+FIRST_BUTTON_OFFSET+BUTTON_HEIGHT+10, BUTTON_WIDTH, BUTTON_HEIGHT, "Options");
		quit= new Buttons(container.getWidth()/2-BUTTON_WIDTH/2, container.getHeight()/2+FIRST_BUTTON_OFFSET+2*(BUTTON_HEIGHT+10), BUTTON_WIDTH, BUTTON_HEIGHT, "Quit");
		start.init(container);
		options.init(container);
		quit.init(container);
		
		// Title image
		try {
			title = new Image(TITLE_IMAGE_NAME);
		} catch (RuntimeException e) {
			System.err.println("Error: Title image file missing.");
			System.exit(1);
		}

	}


	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		start.render(g, container);
		options.render(g, container);
		quit.render(g, container);
		
		// Render the title image
		title.draw(container.getWidth()/2-TITLE_WIDTH/2, container.getHeight()/2+TITLE_IMAGE_OFFSET, TITLE_WIDTH, TITLE_HEIGHT);

	}


	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		if(start.isPressed(container)){
			game.enterState(1,new FadeOutTransition(), new FadeInTransition());
		}
		if(options.isPressed(container)){
			game.enterState(2,new FadeOutTransition(), new FadeInTransition());
		}
		if(quit.isPressed(container)){
			container.exit();
		}

	}


	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
