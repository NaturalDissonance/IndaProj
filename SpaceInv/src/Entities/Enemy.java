package Entities;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;


public class Enemy implements Entity {
	
	private static final float SCALE = 1;
	private static final int STARTING_HEALTH = 5;
	private static final String SPRITE_NAME = "Images\\Enemy_Sprite.png";
	private static final int SPRITE_TILE_WIDTH = 106/2;
	private static final int SPRITE_TILE_HEIGHT = 39;
	
	public static final int DIRECTION_UP = 0;
	public static final int DIRECTION_DOWN = 1;
	public static final int DIRECTION_LEFT = 2;
	public static final int DIRECTION_RIGHT = 3;
	
	private double x;
	private double y;
	private int health;
	
	private SpriteSheet sprite;
	
	
	public Enemy(double xCoordinate, double yCoordinate) {
		setHealth(STARTING_HEALTH);
		setX(xCoordinate);
		setY(yCoordinate);
		
		try {
			sprite = new SpriteSheet(SPRITE_NAME, SPRITE_TILE_WIDTH, SPRITE_TILE_HEIGHT);
		} catch (Exception e) {
			System.err.println("Error: Image file \"" + SPRITE_NAME + "\" is missing.");
			System.exit(1);
		}
	}

	@Override
	public void render(Graphics g) {
		
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GameContainer c) {
		// TODO Auto-generated method stub
		
	}
	
	// ******************************
	// HEALTH
	/**
	 * Kills this enemy.
	 */
	public void kill() {
		// TODO
		System.out.println("dead");
	}
	
	/**
	 * Damages this enemy and kills it if its health drops to zero
	 */
	public void damage(int amount) {
		setHealth(getHealth() - amount);
		if (getHealth() <= 0) {
			kill();
		}
	}
	
	/**
	 * Returns the health of the enemy
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * Sets the health of the enemy
	 * @param health
	 */
	public void setHealth(int health) {
		this.health = health;
	}
	
	
	// ******************************
	// MOVEMENT
	/**
	 * Moves the enemy the desired amount in the desired direction
	 */
	public void move(int direction, double distance ) {
		if (direction == DIRECTION_UP) {
			setY(getY() - distance);
		} else if (direction == DIRECTION_DOWN) {
			setY(getY() + distance);
		} else if (direction == DIRECTION_LEFT) {
			setX(getX() - distance);
		} else if (direction == DIRECTION_DOWN) {
			setX(getX() + distance);
		}
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

}
