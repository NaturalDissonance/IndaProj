package Mains;

import org.newdawn.slick.GameContainer;

import Entities.Buttons;
import Entities.ChangeableButton;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.*;

public class Options extends BasicGameState {
	Buttons returns;
	ChangeableButton resolution, fullscreen;

	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		returns= new Buttons(container.getWidth()/2-110, container.getHeight()-200, 220, 45, "Return");
		resolution= new ChangeableButton(container.getWidth()/2-300, container.getHeight()-300, 280, 45, "800x600");
		fullscreen= new ChangeableButton(container.getWidth()/2+20, container.getHeight()-300, 280, 45, "FS: Off");
		returns.init(container);
		resolution.init(container);
		fullscreen.init(container);
		resolution.setState(2);
	}


	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		returns.render(g, container);
		fullscreen.render(g, container);
		resolution.render(g, container);
	}


	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		if(returns.isPressed(container)){
			game.enterState(0,new FadeOutTransition(), new FadeInTransition());
		}
		if(fullscreen.isPressed(container)){
			if(!container.isFullscreen()){
				Main.app.setFullscreen(true);
				fullscreen.changeText("FS: On");
			}
			else if(container.isFullscreen()){
				Main.app.setFullscreen(false);
				fullscreen.changeText("FS: Off");
			}
		}
		if(resolution.isPressed(container)){
			boolean fs= Main.app.isFullscreen();
			
			if(resolution.getState()==0){
				Main.app.setDisplayMode(1024,768, fs);
				resolution.setState(1);
				resolution.changeText("1024x768");
			}
			else if(resolution.getState()==1){
				Main.app.setDisplayMode(1280, 960, fs);
				resolution.setState(2);
				resolution.changeText("1280x960");
			}
			else if(resolution.getState()==2){
				Main.app.setDisplayMode(800, 600, fs);
				resolution.setState(0);
				resolution.changeText("800x600");
			}

		}


	}


	public int getID() {
		// TODO Auto-generated method stub
		return 2;
	}

}
