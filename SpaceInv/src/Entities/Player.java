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
	private final String SPACESHIP_IMAGE_NAME = "Sprites\\Player_Spaceship.png";
	
	// The ship will update its animation (switch sprite) this
	// many times per second.
	private final int SWITCH_SPRITE_FREQUENCY = 30;
	
	private final float SCALE = 3; // The scale of the ship.
	private final int SPEED = 7; // The spaceship moves this many tiles per second.
	
	// **************************************************
	// CODE
	private Image spaceshipImage;
	private Image leftSprite;
	private Image rightSprite;
	private int x;
	private int y;
	
	private int numberOfRenders = 0;
	private long timeWhenLastSpriteWasStarted = 0;
	private long timePassedSinceLastSpriteSwitch = 0;
	private Image im;
	private boolean useLeftSprite = true;
	
	
	/**
	 * Constructs a space ship from the given SpriteSheet.
	 * The SpriteSheet is hard-coded to be two images beside eachother.
	 */
	public Player(int xCoordinate, int yCoordinate) {
		// Create the spaceship image from the file.
		try {
			spaceshipImage = new Image(SPACESHIP_IMAGE_NAME);
		} catch (SlickException e) {
			System.err.println("Error: Image file \"" + SPACESHIP_IMAGE_NAME + "\" is missing.");
		}
		
		// Create a sprite from the image
		SpriteSheet sprite = new SpriteSheet(spaceshipImage, spaceshipImage.getWidth()/2, spaceshipImage.getHeight());

		// Set the two images from the sprite
		leftSprite = sprite.getSprite(0, 0);
		leftSprite.rotate(180);
		rightSprite = sprite.getSprite(1, 0);
		rightSprite.rotate(180);
		
		// Set the ship's initial coordinates and scale.
		setX(xCoordinate);
		setY(xCoordinate);
	}

	
	/**
	 * Renders the spaceship on the screen. Switches sprite
	 * according to the SWITCH_SPRITE_FREQUENCY global constant.
	 */
	public void render(Graphics g) {		
		if (useLeftSprite) {
			im = leftSprite;
		} else {
			im = rightSprite;
		}
		
		im.draw(getX(), getY(), SCALE);
		
		// Too tired to explain how this works...
		timePassedSinceLastSpriteSwitch = System.nanoTime() - timeWhenLastSpriteWasStarted;
		if (timePassedSinceLastSpriteSwitch > (1000000000 / SWITCH_SPRITE_FREQUENCY)) {
			useLeftSprite = !useLeftSprite;
			timeWhenLastSpriteWasStarted = System.nanoTime();
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
