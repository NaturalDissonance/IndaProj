package Entities;

import java.awt.Font;
import java.io.InputStream;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

public class Buttons {
int x, y, width, height;
String content;
TrueTypeFont font;
boolean isPressed;
	public Buttons(int x, int y,int w,int h, String content){
		this.x=x;
		this.y=y;
		width=w;
		height=h;
		this.content=content;
	}
	
	public boolean isPressed(){
		return isPressed;
	}
	

	public void render(Graphics g) {
		if()

	}


	public void update() {
		if()

	}


	public void init() {
		try {
			InputStream inputStream	= ResourceLoader.getResourceAsStream("Fonts/spaceage.ttf");
	 
			Font awtFont2 = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			awtFont2 = awtFont2.deriveFont(24f); // set font size
			font = new TrueTypeFont(awtFont2, false);
	 
		} catch (Exception e) {
			e.printStackTrace();
		}	
		

	}

}
