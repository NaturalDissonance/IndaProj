package Entities;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/**
 * The Player class, doing stuff like rendering the spaceship,
 * moving it around and shooting lasers (pew pew)
 * 
 * The spaceship's sprite is hard-coded to use two
 * images beside each other.
 */
public class Player implements Entity {
	
	// **************************************************
	// SETTINGS
	
	// The name of the spaceship's image file.
	private final String SPACESHIP_IMAGE_NAME = "Images/Player_Spaceship.png";
	
	// The ship will update its animation (switch sprite) when
	// this many frames have been rendered.
	private final int SWITCH_SPRITE_FREQUENCY = 3;
	
	// The scale of the ship
	private final float SCALE = 3;
	
	// **************************************************
	// CODE
	private Image spaceshipImage;
	private SpriteSheet sprite;
	private int x;
	private int y;
	
	private int numberOfRenders = 0;
	private boolean useLeftSprite = true;
	
	
	/**
	 * Constructs a space ship from the given SpriteSheet.
	 * The SpriteSheet is hard-coded to be a 46x19 image.
	 */
	public Player(int xCoordinate, int yCoordinate) {
		// Create the spaceship image.
		try {
			spaceshipImage = new Image(SPACESHIP_IMAGE_NAME);
		} catch (SlickException e) {
			System.err.println("Error: Image file \"" + SPACESHIP_IMAGE_NAME + "\" is missing.");
		}
		
		// Create a sprite from the image.
		this.sprite = new SpriteSheet(spaceshipImage, spaceshipImage.getWidth()/2, spaceshipImage.getHeight());
		
		// Starts using the spaceship sprite
		sprite.startUse();
		
		// Set the ship's initial coordinates and scale.
		setX(xCoordinate);
		setY(xCoordinate);
	}

	public void render(Graphics g) {

	}
	
	public void render() {
		
		// Draw the spaceship image from either the left or the
		// right sprite cell, depending on which iteration the
		// animation is on.
		Image im;
		if (useLeftSprite) {
			im = sprite.getSprite(0, 0);
		} else {
			im = sprite.getSprite(1, 0);
		}
		
		im.rotate(180);
		im.draw(getX(), getY(), SCALE);
		
		numberOfRenders++;
		if (numberOfRenders >= SWITCH_SPRITE_FREQUENCY) {
			useLeftSprite = !useLeftSprite;
			numberOfRenders = 0;
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		//sprite= new SpriteSheet()

	}
	
	// **************************************************
	// Coordinate getters and setters
	/**
	 * Returns the x-coordinate.
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the x-coordinate.
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Returns the y-coordinate.
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the y-coordinate.
	 */
	public void setY(int y) {
		this.y = y;
	}
	

	

}
