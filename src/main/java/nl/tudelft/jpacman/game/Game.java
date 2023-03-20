package nl.tudelft.jpacman.game;

import java.util.ArrayList;
import java.util.List;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.Board;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Level.LevelObserver;
import nl.tudelft.jpacman.level.MapParser;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.points.PointCalculator;
import nl.tudelft.jpacman.ui.MapSelector;
import nl.tudelft.jpacman.ui.PacManUI;
import nl.tudelft.jpacman.ui.PacManUiBuilder;

/**
 * A basic implementation of a Pac-Man game.
 *
 * @author Jeroen Roosen
 */
public abstract class Game implements LevelObserver {

	/**
	 * <code>true</code> if the game is in progress.
	 */
	private boolean inProgress;
	private PacManUI pacManUI;
    private Player player;
    private Level level;



    private double totaltime;
    public double getTotaltime() {
        return totaltime;
    }

    public void setTotaltime(double totaltime) {
        this.totaltime = totaltime;
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
            Stopwatch.getElapsedTimeSecs();
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
            setTotaltime(getTotaltime() + Stopwatch.getElapsedTimeSecs());
            System.out.println(getTotaltime());
		}
	}

	public void exit() {
		synchronized (progressLock) {
			System.exit(0);
		}
	}
    public void retry(){
<<<<<<< HEAD
        {
            Launcher.dispose();
            new MapSelector().setVisible(true);
=======
        if (pacManUI!=null){
            Launcher.setVisible(false);
        }
        Launcher.dispose();
        Launcher.setVisible(false);
        if  (Launcher.getMap() == 1){
            new Launcher().launch_map1();
        }
        else if  (Launcher.getMap() == 2){
            new Launcher().launch_map2();
        }
        else if  (Launcher.getMap() == 3){
            new Launcher().launch_map3();
        }
        else if  (Launcher.getMap() == 4){
            new Launcher().launch_map4();
        }
        else if  (Launcher.getMap() == 5){
            new Launcher().launch_map5();
>>>>>>> origin
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
	public abstract List<Player> getPlayers();

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

	@Override
	public void levelWon() {
		stop();
	}

	@Override
<<<<<<< HEAD
	public void levelLost() {
        stop();
=======
	public void levelLost() { stop();
>>>>>>> origin
	}
}
