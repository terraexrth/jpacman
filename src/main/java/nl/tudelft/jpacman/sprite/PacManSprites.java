package nl.tudelft.jpacman.sprite;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import nl.tudelft.jpacman.PacmanConfigurationException;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.npc.ghost.GhostColor;

/**
 * Sprite Store containing the classic Pac-Man sprites.
 *
 * @author Jeroen Roosen
 */
public class PacManSprites extends SpriteStore {

	/**
	 * The sprite files are vertically stacked series for each direction, this
	 * array denotes the order.
	 */
	private static final Direction[] DIRECTIONS = {
			Direction.NORTH,
			Direction.EAST,
			Direction.SOUTH,
			Direction.WEST
	};

	/**
	 * The image size in pixels.
	 */
	private static final int SPRITE_SIZE = 16;

	/**
	 * The amount of frames in the pacman animation.
	 */
	private static final int PACMAN_ANIMATION_FRAMES = 4;

	/**
	 * The amount of frames in the pacman dying animation.
	 */
	private static final int PACMAN_DEATH_FRAMES = 11;

	/**
	 * The amount of frames in the ghost animation.
	 */
	private static final int GHOST_ANIMATION_FRAMES = 2;

	/**
	 * The delay between frames.
	 */
	private static final int ANIMATION_DELAY = 200;

	public int level;

	/**
	 * @return A map of animated Pac-Man sprites for all directions.
	 */
	public Map<Direction, Sprite> getPacmanSprites() {
		if (this.level == 1) {
			return directionSprite("/sprite/forest/pacman_forest.png", PACMAN_ANIMATION_FRAMES);
		} else if (this.level == 3) {
			return directionSprite("/sprite/desert/pacman_desert.png", PACMAN_ANIMATION_FRAMES);
		} else if (this.level == 4) {
			return directionSprite("/sprite/water/pacman_water.png", PACMAN_ANIMATION_FRAMES);
		} else {
			return directionSprite("/sprite/pacman.png", PACMAN_ANIMATION_FRAMES);
		}
	}

	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * @return The animation of a dying Pac-Man.
	 */
	public AnimatedSprite getPacManDeathAnimation() {
		String resource = null;

		if (level == 1) {
			resource = "/sprite/forest/dead_forest.png";
		} else if (level == 3) {
			resource = "/sprite/desert/dead_desert.png";
		} else {
			resource = "/sprite/dead.png";
		}

		Sprite baseImage = loadSprite(resource);
		AnimatedSprite animation = createAnimatedSprite(baseImage, PACMAN_DEATH_FRAMES,
				ANIMATION_DELAY, false);
		animation.setAnimating(false);

		return animation;
	}

	/**
	 * Returns a new map with animations for all directions.
	 *
	 * @param resource
	 *                 The resource name of the sprite.
	 * @param frames
	 *                 The number of frames in this sprite.
	 * @return The animated sprite facing the given direction.
	 */
	private Map<Direction, Sprite> directionSprite(String resource, int frames) {
		Map<Direction, Sprite> sprite = new HashMap<>();

		Sprite baseImage = loadSprite(resource);
		for (int i = 0; i < DIRECTIONS.length; i++) {
			Sprite directionSprite = baseImage.split(0, i * SPRITE_SIZE, frames
					* SPRITE_SIZE, SPRITE_SIZE);
			AnimatedSprite animation = createAnimatedSprite(directionSprite,
					frames, ANIMATION_DELAY, true);
			animation.setAnimating(true);
			sprite.put(DIRECTIONS[i], animation);
		}

		return sprite;
	}

	/**
	 * Returns a map of animated ghost sprites for all directions.
	 *
	 * @param color
	 *              The colour of the ghost.
	 * @return The Sprite for the ghost.
	 */
	public Map<Direction, Sprite> getGhostSprite(GhostColor color, int level) {
		assert color != null;
		String resource = null;
		if (level == 1) {
			setLevel(level);
			resource = "/sprite/forest/ghost_" + color.name().toLowerCase() + "_forest"
					+ ".png";
		} else if (level == 3) {
			setLevel(level);
			resource = "/sprite/desert/ghost_" + color.name().toLowerCase() + "_desert"
					+ ".png";
		} else if (level == 4) {
			setLevel(level);
			resource = "/sprite/water/ghost_" + color.name().toLowerCase() + "_water"
					+ ".png";
		} else {
			resource = "/sprite/ghost_" + color.name().toLowerCase()
					+ ".png";

		}
		return directionSprite(resource, GHOST_ANIMATION_FRAMES);

	}

	/**
	 * @return The sprite for the wall.
	 */
	public Sprite getWallSprite(int level) {
		if (level == 1) {
			return loadSprite("/sprite/wall_forest.png");
		} else if (level == 2) {
			return loadSprite("/sprite/wall_snow.png");
		} else if (level == 3) {
			return loadSprite("/sprite/wall_desert.png");
		} else if (level == 4) {
			return loadSprite("/sprite/wall_water.png");
		} else if (level == 5) {
			return loadSprite("/sprite/wall_water.png");
		} else {
			return loadSprite("/sprite/wall.png");
		}

	}

	/**
	 * @return The sprite for the ground.
	 */
	public Sprite getGroundSprite(int level) {
		if (level == 1) {
			return loadSprite("/sprite/floor.png");
		} else if (level == 2) {
			return loadSprite("/sprite/floor_snow.png");
		} else if (level == 3) {
			return loadSprite("/sprite/floor_desert.png");
		} else if (level == 4) {
			return loadSprite("/sprite/floor_water.png");
		} else if (level == 5) {
			return loadSprite("/sprite/floor_candy.png");
		} else {
			return loadSprite("/sprite/floor.png");
		}

	}

	/**
	 * @return The sprite for the
	 */
	public Sprite getPelletSprite() {
		return loadSprite("/sprite/pellet.png");
	}

	/**
	 * Overloads the default sprite loading, ignoring the exception. This class
	 * assumes all sprites are provided, hence the exception will be thrown as a
	 * {@link RuntimeException}.
	 *
	 * {@inheritDoc}
	 */
	@Override
	public Sprite loadSprite(String resource) {
		try {
			return super.loadSprite(resource);
		} catch (IOException e) {
			throw new PacmanConfigurationException("Unable to load sprite: " + resource, e);
		}
	}
}
