package nl.tudelft.jpacman.game;

import java.io.FileWriter;
import java.util.List;

import org.json.simple.JSONObject;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Level.LevelObserver;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.ui.MapSelector;
import nl.tudelft.jpacman.ui.PacManUI;
import nl.tudelft.jpacman.ui.YouLose;
import nl.tudelft.jpacman.ui.YouWin;

/**
 * A basic implementation of a Pac-Man game.
 *
 * @author Jeroen Roosen
 */
public abstract class Game implements LevelObserver {

	/**
	 * <code>true</code> if the game is in progress.
	 */

	private static FileWriter file;
	private boolean inProgress;
	private PacManUI pacManUI;
	private Player player;
	private Level level;

	private static double totaltime;

	public static double getTotaltime() {
		return totaltime;
	}
    public  static String getStringtotaltime(){
        return String.format("%.3f",totaltime);
    }

	public static String calulatetime() {
		double minutes = (double) getTotaltime() / 60;
		double second = (double) getTotaltime() % 60;
		if (getTotaltime() >= 60.0) {

            System.out.format("%d minutes : %.2f second", (int) minutes, second);

			// System.out.format("Your time is: %f min %f second",minutes,remainingSec);
		} else {
			System.out.println(getTotaltime());

		}
		return String.format("%d : %.2f s", (int) minutes, second);
	}

	public void setTotaltime(double totaltime) {
		this.totaltime = totaltime;
	}

	public void resetTime() {
		setTotaltime(0.0);
	}

	/**
	 * Object that locks the start and stop methods.
	 */
	private final Object progressLock = new Object();

	/**
	 * The algorithm used to calculate the points that
	 * they player gets whenever some action happens.
	 */
	private final PointCalculator pointCalculator;

	/**
	 * Creates a new game.
	 *
	 * @param pointCalculator
	 *                        The way to calculate points upon collisions.
	 */

	protected Game(PointCalculator pointCalculator) {
		this.pointCalculator = pointCalculator;
		inProgress = false;
	}

	/**
	 * Starts or resumes the game.
	 */
	public void start() {
		synchronized (progressLock) {
			if (isInProgress()) {
				return;
			}
			if (getLevel().isAnyPlayerAlive() && getLevel().remainingPellets() > 0) {
				inProgress = true;
				getLevel().addObserver(this);
				getLevel().start();
			}
			Stopwatch.start();
			System.out.println("Start");
			System.out.println("Always Start from : ");
			Stopwatch.getElapsedTimeSecs(); // Count from 0
			System.out.println("Continue Counting : "); // Continue Counting
			calulatetime();
			System.out.println("----------------------------");

		}
	}

	/**
	 * Pauses the game.
	 */

	public void stop() {
		synchronized (progressLock) {
			if (!isInProgress()) {
				return;
			}
			inProgress = false;
			getLevel().stop();
			Stopwatch.stop();
			System.out.println("Pause");
			System.out.println("Time at that time : ");
			setTotaltime(getTotaltime() + Stopwatch.getElapsedTimeSecs()); // Count from 0
			System.out.println("Total Time : ");
			calulatetime();
			System.out.println("----------------------------");
		}
	}

	public void exit() {
		synchronized (progressLock) {
			System.exit(0);
		}
	}

	public void retry() {
		if (pacManUI != null) {
			Launcher.setVisible(false);
		}
		Launcher.dispose();
		Launcher.setVisible(false);
		if (Launcher.getMap() == 1) {
			new Launcher().launch_map1();
		} else if (Launcher.getMap() == 2) {
			new Launcher().launch_map2();
		} else if (Launcher.getMap() == 3) {
			new Launcher().launch_map3();
		} else if (Launcher.getMap() == 4) {
			new Launcher().launch_map4();
		} else if (Launcher.getMap() == 5) {
			new Launcher().launch_map5();
		}

	}

	public void back() {
		{
			Launcher.dispose();
			new MapSelector().setVisible(true);
		}
	}

	/**
	 * @return <code>true</code> iff the game is started and in progress.
	 */
	public boolean isInProgress() {
		return inProgress;
	}

	/**
	 * @return An immutable list of the participants of this game.
	 */
	public List<Player> getPlayers() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getPlayers'");
	}

	/**
	 * @return The level currently being played.
	 */
	public abstract Level getLevel();

	/**
	 * Moves the specified player one square in the given direction.
	 *
	 * @param player
	 *                  The player to move.
	 * @param direction
	 *                  The direction to move in.
	 */
	public void move(Player player, Direction direction) {
		if (isInProgress()) {
			// execute player move.
			getLevel().move(player, direction);
			pointCalculator.pacmanMoved(player, direction);
		}
	}

	public int getPlayerScore() {
		return getPlayers().get(0).getScore();
	}

	JSONObject scoreboard = new JSONObject();

	@Override
	public void levelWon() {
		stop();
		Launcher.dispose();
		new YouWin().setVisible(true);

		resetTime();
	}

	@Override
	public void levelLost() {
		stop();
		Launcher.dispose();

		new YouLose();
		;

		resetTime();

	}

	// public int getCurrentMap(){
	// return pacManUI.getMap();
	// }

}
