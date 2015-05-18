package Entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public interface Entity {
	public void render(Graphics g);
	public void update();
	public void init(GameContainer c);
}
