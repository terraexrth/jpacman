package nl.tudelft.jpacman;

import nl.tudelft.jpacman.board.BoardFactory;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.game.GameFactory;
import nl.tudelft.jpacman.level.*;
import nl.tudelft.jpacman.npc.ghost.GhostFactory;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.points.PointCalculatorLoader;
import nl.tudelft.jpacman.sprite.PacManSprites;
import nl.tudelft.jpacman.ui.Action;
import nl.tudelft.jpacman.ui.MainMenu;
import nl.tudelft.jpacman.ui.PacManUI;
import nl.tudelft.jpacman.ui.PacManUiBuilder;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import javax.swing.JOptionPane;


/**
 * Creates and launches the JPacMan UI.
 * 
 * @author Jeroen Roosen
 */
@SuppressWarnings("PMD.TooManyMethods")
public class Launcher {

	private static final PacManSprites SPRITE_STORE = new PacManSprites();

	public static final String DEFAULT_MAP = "/board2.txt";
	private String levelMap = DEFAULT_MAP;

	private static PacManUI pacManUI;
	private Game game;
    private static int map;
	/**
	 * @return The game object this launcher will start when {@link #launch()}
	 *         is called.
	 */
	public Game getGame() {
		return game;
	}
    public static void setVisible(boolean b) {
    }

    public static int getMap(){
        return map;
    }


    /**
	 * The map file used to populate the level.
	 *
	 * @return The name of the map file.
	 */
	protected String getLevelMap() {
		return levelMap;
	}

	/**
	 * Set the name of the file containing this level's map.
	 *
	 * @param fileName
	 *                 Map to be used.
	 * @return Level corresponding to the given map.
	 */
	public Launcher withMapFile(String fileName) {
		levelMap = fileName;
		return this;
	}

	/**
	 * Creates a new game using the level from {@link #makeLevel()}.
	 *
	 * @return a new Game.
	 */
	public Game makeGame() {
		GameFactory gf = getGameFactory();
		Level level = makeLevel();
		game = gf.createSinglePlayerGame(level, loadPointCalculator());
		return game;
	}

	public Game makeGame_1() {
		GameFactory gf = getGameFactory();
		Level level = makeLevel_1();
		game = gf.createSinglePlayerGame(level, loadPointCalculator());
		return game;
	}

	public Game makeGame_2() {
		GameFactory gf = getGameFactory();
		Level level = makeLevel_2();
		game = gf.createSinglePlayerGame(level, loadPointCalculator());
		return game;
	}

	public Game makeGame_3() {
		GameFactory gf = getGameFactory();
		Level level = makeLevel_3();
		game = gf.createSinglePlayerGame(level, loadPointCalculator());
		return game;
	}

	public Game makeGame_4() {
		GameFactory gf = getGameFactory();
		Level level = makeLevel_4();
		game = gf.createSinglePlayerGame(level, loadPointCalculator());
		return game;
	}

	public Game makeGame_5() {
		GameFactory gf = getGameFactory();
		Level level = makeLevel_5();
		game = gf.createSinglePlayerGame(level, loadPointCalculator());
		return game;
	}

	public Game makeGame_t() {
		GameFactory gf = getGameFactory();
		Level level = makeLevel_t();
		game = gf.createSinglePlayerGame(level, loadPointCalculator());
		return game;
	}

	private PointCalculator loadPointCalculator() {
		return new PointCalculatorLoader().load();
	}

	/**
	 * Creates a new level. By default this method will use the map parser to
	 * parse the default board stored in the <code>board.txt</code> resource.
	 *
	 * @return A new level.
	 */
	public Level makeLevel() {
		try {
			return getMapParser(0).parseMap(getLevelMap());
		} catch (IOException e) {
			throw new PacmanConfigurationException(
					"Unable to create level, name = " + getLevelMap(), e);
		}
	}

	public Level makeLevel_1() {
		try {
			return getMapParser(1).parseMap("/board1.txt");
		} catch (IOException e) {
			throw new PacmanConfigurationException(
					"Unable to create level, name = " + "/board1.txt", e);
		}
	}

	public Level makeLevel_2() {
		try {
			return getMapParser(2).parseMap("/board2.txt");
		} catch (IOException e) {
			throw new PacmanConfigurationException(
					"Unable to create level, name = " + "/board2.txt", e);
		}
	}

	public Level makeLevel_3() {
		try {
			return getMapParser(3).parseMap("/board3.txt");
		} catch (IOException e) {
			throw new PacmanConfigurationException(
					"Unable to create level, name = " + "/board3.txt", e);
		}
	}

	public Level makeLevel_4() {
		try {
			return getMapParser(4).parseMap("/board4.txt");
		} catch (IOException e) {
			throw new PacmanConfigurationException(
					"Unable to create level, name = " + "/board4.txt", e);
		}
	}

	public Level makeLevel_5() {
		try {
			return getMapParser(5).parseMap("/board5.txt");
		} catch (IOException e) {
			throw new PacmanConfigurationException(
					"Unable to create level, name = " + "/board5.txt", e);
		}
	}

	public Level makeLevel_t() {
		try {
			return getMapParser(6).parseMap("/boardtutorial.txt");
		} catch (IOException e) {
			throw new PacmanConfigurationException(
					"Unable to create level, name = " + "/boardtutorial.txt", e);
		}
	}

	/**
	 * @return A new map parser object using the factories from
	 *         {@link #getLevelFactory()} and {@link #getBoardFactory()}.
	 */
	protected MapParser getMapParser(int level) {
		MapParser getmap = new MapParser(getLevelFactory(), getBoardFactory());
		getmap.setLevel(level);
		return getmap;
	}

	/**
	 * @return A new board factory using the sprite store from
	 *         {@link #getSpriteStore()}.
	 */
	protected BoardFactory getBoardFactory() {
		return new BoardFactory(getSpriteStore());
	}

	/**
	 * @return The default {@link PacManSprites}.
	 */
	protected PacManSprites getSpriteStore() {
		return SPRITE_STORE;
	}

	/**
	 * @return A new factory using the sprites from {@link #getSpriteStore()}
	 *         and the ghosts from {@link #getGhostFactory()}.
	 */
	protected LevelFactory getLevelFactory() {
		return new LevelFactory(getSpriteStore(), getGhostFactory(), loadPointCalculator());
	}

	/**
	 * @return A new factory using the sprites from {@link #getSpriteStore()}.
	 */
	protected GhostFactory getGhostFactory() {
		return new GhostFactory(getSpriteStore());
	}

	/**
	 * @return A new factory using the players from {@link #getPlayerFactory()}.
	 */
	protected GameFactory getGameFactory() {
		return new GameFactory(getPlayerFactory());
	}

	/**
	 * @return A new factory using the sprites from {@link #getSpriteStore()}.
	 */
	protected PlayerFactory getPlayerFactory() {
		return new PlayerFactory(getSpriteStore());
	}

	/**
	 * Adds key events UP, DOWN, LEFT and RIGHT to a game.
	 *
	 * @param builder
	 *                The {@link PacManUiBuilder} that will provide the UI.
	 */
	protected void addSinglePlayerKeys(final PacManUiBuilder builder) {
		builder.addKey(KeyEvent.VK_UP, moveTowardsDirection(Direction.NORTH))
				.addKey(KeyEvent.VK_DOWN, moveTowardsDirection(Direction.SOUTH))
				.addKey(KeyEvent.VK_LEFT, moveTowardsDirection(Direction.WEST))
				.addKey(KeyEvent.VK_RIGHT, moveTowardsDirection(Direction.EAST))
				.addKey(KeyEvent.VK_W, moveTowardsDirection(Direction.NORTH))
				.addKey(KeyEvent.VK_S, moveTowardsDirection(Direction.SOUTH))
				.addKey(KeyEvent.VK_A, moveTowardsDirection(Direction.WEST))
				.addKey(KeyEvent.VK_D, moveTowardsDirection(Direction.EAST));
	}

	private Action moveTowardsDirection(Direction direction) {
		return () -> {
			assert game != null;
			getGame().move(getSinglePlayer(getGame()), direction);
		};
	}

	private Player getSinglePlayer(final Game game) {
		List<Player> players = game.getPlayers();
		if (players.isEmpty()) {
			throw new IllegalArgumentException("Game has 0 players.");
		}
		return players.get(0);
	}

	/**
	 * Creates and starts a JPac-Man game.
	 */

	public void launch(){
		makeGame();
		PacManUiBuilder builder = new PacManUiBuilder().withDefaultButtons();
		addSinglePlayerKeys(builder);
		pacManUI = builder.build(getGame(), 0);
		pacManUI.start();
	}

	public void launch_map1(){
		makeGame_1();
		PacManUiBuilder builder = new PacManUiBuilder().withDefaultButtons();
		addSinglePlayerKeys(builder);
		pacManUI = builder.build(getGame(), 1);
        map = 1;
		pacManUI.start();
	}

	public void launch_map2(){
		makeGame_2();
		PacManUiBuilder builder = new PacManUiBuilder().withDefaultButtons();
		addSinglePlayerKeys(builder);
		pacManUI = builder.build(getGame(), 2);
        map = 2;
		pacManUI.start();
	}

	public void launch_map3(){
		makeGame_3();
		PacManUiBuilder builder = new PacManUiBuilder().withDefaultButtons();
		addSinglePlayerKeys(builder);
		pacManUI = builder.build(getGame(), 3);
        map = 3;
		pacManUI.start();
	}

	public void launch_map4(){
		makeGame_4();
		PacManUiBuilder builder = new PacManUiBuilder().withDefaultButtons();
		addSinglePlayerKeys(builder);
		pacManUI = builder.build(getGame(), 4);
        map = 4;
		pacManUI.start();

	}

	public void launch_map5(){
		makeGame_5();
		PacManUiBuilder builder = new PacManUiBuilder().withDefaultButtons();
		addSinglePlayerKeys(builder);
		pacManUI = builder.build(getGame(), 5);
        map = 5;
		pacManUI.start();
	}

	public void launch_tutorial() {
		makeGame_t();
		PacManUiBuilder builder = new PacManUiBuilder().withDefaultButtons();
		addSinglePlayerKeys(builder);
		pacManUI = builder.build(getGame(), 6);
		pacManUI.start();
	}

	/**
	 * Disposes of the UI. For more information see
	 * {@link javax.swing.JFrame#dispose()}.
	 *
	 * Precondition: The game was launched first.
	 */
	public static void dispose() {
		assert pacManUI != null;
		pacManUI.dispose();
	}

	/**
     * Main execution method for the Launcher.
     *
     * @param args The command line arguments - which are ignored.
     * @return
     * @throws IOException When a resource could not be read.
     */
    /*public static String showUsernameDialog() {
        String username = JOptionPane.showInputDialog(null, "Enter your username:", "JPacman", JOptionPane.QUESTION_MESSAGE);
        if (username == null || username.trim().isEmpty()) {
            username = "Player";
        }
        //return username;
        return username;
    }*/


	public static void main(String[] args) throws IOException {
		new MainMenu();
		// new Launcher().launch();
	}
}
