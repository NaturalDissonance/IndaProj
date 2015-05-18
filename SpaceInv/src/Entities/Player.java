package Entities;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import Mains.Main;

/**
 * The Player class, doing stuff like rendering the spaceship,
 * moving it around and shooting lasers (pew pew)
 * 
 * The spaceship's sprite is hard-coded to use two
 * images beside each other.
 */
@SuppressWarnings("unused")
public class Player implements Entity {
	
	// **************************************************
	// SETTINGS
	
	// The name of the spaceship's image file.
	private final String SPACESHIP_IMAGE_NAME = "Images\\Player_Spaceship.png";
	
	// The ship will update its animation (switch sprite) this
	// many times per second.
	private final int SWITCH_SPRITE_FREQUENCY = 50;
	
	private final float SCALE = 3; // The scale of the ship.
	private final int SPEED = 700; // The spaceship moves this many pixels per second.
	private final float SPACESHIP_BOTTOM_OFFSET = 20; // The gap between the bottom of the screen and the spaceship, in pixels
	
	// **************************************************
	// CODE
	private Image spaceshipImage;
	private Image leftSprite;
	private Image rightSprite;
	private double x;
	private double y;
	Animation ani;
	
	private int numberOfRenders = 0;
	private long timeWhenLastSpriteWasStarted = 0;
	private long timePassedSinceLastSpriteSwitch = 0;
	private double timePassedSinceLastRender = 0;
	private Image im;
	private boolean useLeftSprite = true;
	
	Input input;
	
	
	/**
	 * Constructs a spaceship from the given SpriteSheet.
	 * The SpriteSheet is hard-coded to be two images beside each other.
	 */
	public Player() {
		
	}

	
	/**
	 * Renders the spaceship on the screen. Switches sprite
	 * according to the SWITCH_SPRITE_FREQUENCY global constant.
	 */
	public void render(Graphics g) {
		ani.getCurrentFrame().setRotation(180);
		ani.draw((float)(getX()), (float)(getY()));
	}

	@Override
	public void update() {
		// Move the spaceship sideways, if it's within the game's bounds
		timePassedSinceLastRender = (System.currentTimeMillis() - timePassedSinceLastRender)/1000;
		if (input.isKeyDown(input.KEY_LEFT) && getX() > 10) {
			setX(getX() - SPEED*timePassedSinceLastRender);
		} else if (input.isKeyDown(input.KEY_RIGHT) && getX() < Main.DEFAULT_WIDTH - ani.getCurrentFrame().getWidth() - 10) {
			setX(getX() + SPEED*timePassedSinceLastRender);
		}
		
		timePassedSinceLastRender = System.currentTimeMillis();
	}

	@Override
	public void init(GameContainer c) {
		input = c.getInput(); // Used for keyboard input	
		
		// Create the spaceship image from the file.
		try {
			spaceshipImage = new Image(SPACESHIP_IMAGE_NAME);
		} catch (Exception e) {
			System.err.println("Error: Image file \"" + SPACESHIP_IMAGE_NAME + "\" is missing.");
			System.exit(1);
		}
		
		// Scale the image and create the sprite
		spaceshipImage = spaceshipImage.getScaledCopy(SCALE);
		SpriteSheet sprite = new SpriteSheet(spaceshipImage, spaceshipImage.getWidth()/2, spaceshipImage.getHeight());
		
		// Create the animation from the sprite
		ani = new Animation(sprite, 0, 0, 1, 0, false, SWITCH_SPRITE_FREQUENCY, true);
		
		// Set the ship's initial coordinates..
		setX(Main.DEFAULT_WIDTH/2); // Center of screen
		int bottomOfScreen = (int)(Main.ASPECT_RATIO_Y*Main.DEFAULT_WIDTH/Main.ASPECT_RATIO_X);
		setY(bottomOfScreen - spaceshipImage.getHeight() - SPACESHIP_BOTTOM_OFFSET);
	}
	
	// **************************************************
	// Coordinate getters and setters
	/**
	 * Returns the x-coordinate.
	 */
	public double getX() {
		return x;
	}

	/**
	 * Sets the x-coordinate.
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * Returns the y-coordinate.
	 */
	public double getY() {
		return y;
	}

	/**
	 * Sets the y-coordinate.
	 */
	public void setY(double y) {
		this.y = y;
	}
	

	

}