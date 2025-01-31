package nl.tudelft.jpacman.ui;

import java.awt.*;
import java.io.IOException;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Image;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.ui.ScorePanel.ScoreFormatter;
import org.json.simple.JSONObject;
import java.io.FileWriter;

import nl.tudelft.jpacman.Launcher;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;


/**
 * The default JPacMan UI frame. The PacManUI consists of the following
 * elements:
 *
 * <ul>
 * <li>A score panel at the top, displaying the score of the player(s).
 * <li>A board panel, displaying the current level, i.e. the board and all units
 * on it.
 * <li>A button panel, containing all buttons provided upon creation.
 * </ul>
 *
 * @author Jeroen Roosen
 *
 */
public class PacManUI extends JFrame {

	/**
	 * Default serialisation UID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The desired frame rate interval for the graphics in milliseconds, 40
	 * being 25 fps.
	 */
	private static final int FRAME_INTERVAL = 40;

    /**
	 * The panel displaying the player scores.
	 */
	private final ScorePanel scorePanel;

	/**
	 * The panel displaying the game.
	 */
	private final BoardPanel boardPanel;

	/**
	 * Creates a new UI for a JPacman game.
	 *
	 * @param game
	 *                       The game to play.
	 * @param buttons
	 *                       The map of caption-to-action entries that will appear
	 *                       as
	 *                       buttons on the interface.
	 * @param keyMappings
	 *                       The map of keyCode-to-action entries that will be added
	 *                       as key
	 *                       listeners to the interface.
	 * @param scoreFormatter
	 *                       The formatter used to display the current score.
	 */

	public int mapLevel;

    static Launcher launcher = new Launcher();
    //public static JSONObject obj = new JSONObject();
    //public static String username = showUsernameDialog();
    public static JSONArray array = new JSONArray();


    // public void setLevel(int level) {
	// this.mapLevel = level;
	// System.out.println("PacUI Setter Level : " + this.mapLevel);
	// }

	// public int getLevel() {
	// System.out.println("PacUI Getter Level : " + this.mapLevel);
	// return mapLevel;
	// }
	/**
	 * Starts the "engine", the thread that redraws the interface at set
	 * intervals.
	 */


	public void start() {
		setSize(600, 800);
		setVisible(true);
		this.setLocationRelativeTo(null);
		setResizable(false);
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		service.scheduleAtFixedRate(this::nextFrame, 0, FRAME_INTERVAL, TimeUnit.MILLISECONDS);
		ImageIcon icon = new ImageIcon("src/main/resources/icon.png");
		Image iconImg = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);

        setIconImage(iconImg);


	}

	public PacManUI(final Game game, final Map<String, Action> buttons,
			final Map<Integer, Action> keyMappings,
			ScoreFormatter scoreFormatter, int level){
		super("JPacman");
		assert game != null;
		assert buttons != null;
		assert keyMappings != null;

        System.out.println("--------"+array);
        //public static String username = launcher.showUsernameDialog();


//        obj.put("name", username);
//        obj.put("time", null);

        //System.out.println(obj);

        //JSONArray array = new JSONArray();


        /*
        try (FileWriter file = new FileWriter("scoreboard.json")) {
            file.write(obj.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }*/

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		PacKeyListener keys = new PacKeyListener(keyMappings);
		addKeyListener(keys);

		JPanel buttonPanel = new ButtonPanel(buttons, this);

		scorePanel = new ScorePanel(game.getPlayers(),level);
		if (scoreFormatter != null) {
			scorePanel.setScoreFormatter(scoreFormatter);
		}

		setMap(level);

		boardPanel = new BoardPanel(game, level);

		Container contentPanel = getContentPane();
		contentPanel.setLayout(new BorderLayout());
		contentPanel.add(buttonPanel, BorderLayout.SOUTH);
		contentPanel.add(scorePanel, BorderLayout.NORTH);
		contentPanel.add(boardPanel, BorderLayout.CENTER);

		pack();
	}

	public int currentMap;

	public void setMap(int map) {
		this.currentMap = map;
	};

	public int getMap() {
		return currentMap;
	}

	/**
	 * Draws the next frame, i.e. refreshes the scores and game.
	 */
	private void nextFrame() {
		boardPanel.repaint();
		scorePanel.refresh();
	}
}
