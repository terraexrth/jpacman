package nl.tudelft.jpacman.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import nl.tudelft.jpacman.board.Board;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.board.Unit;
import nl.tudelft.jpacman.game.Game;

/**
 * Panel displaying a game.
 *
 * @author Jeroen Roosen
 *
 */
class BoardPanel extends JPanel {

	/**
	 * Default serialisation ID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The background colour of the board.
	 */
	private static final Color BACKGROUND_COLOR = Color.BLACK;

	/**
	 * The size (in pixels) of a square on the board. The initial size of this
	 * panel will scale to fit a board with square of this size.
	 */
	private static final int SQUARE_SIZE = 16;

	/**
	 * The game to display.
	 */
	private final Game game;

	/**
	 * Creates a new board panel that will display the provided game.
	 *
	 * @param game
	 *             The game to display.
	 */

	public int level;

	public void setLevel(int level) {
		this.level = level;
		System.out.println("BoardPanel Setter Level : " + this.level);
	}

	public int getLevel() {
		System.out.println("BoardPanel Getter Level : " + this.level);
		return this.level;

	}

	BoardPanel(Game game, int input) {
		super();

		assert game != null;
		this.game = game;

		Board board = game.getLevel().getBoard();

		int w = board.getWidth() * SQUARE_SIZE;
		int h = board.getHeight() * SQUARE_SIZE;

		Dimension size = new Dimension(w, h);
		setMinimumSize(size);
		setPreferredSize(size);
		setLevel(input);
		getLevel();
	}

	@Override
	public void paint(Graphics g) {
		assert g != null;
		render(game.getLevel().getBoard(), g, getSize());
	}

	/**
	 * Renders the board on the given graphics context to the given dimensions.
	 *
	 * @param board
	 *                 The board to render.
	 * @param graphics
	 *                 The graphics context to draw on.
	 * @param window
	 *                 The dimensions to scale the rendered board to.
	 */

	ImageIcon Map1Floor = new ImageIcon("src/main/resources/mapbg/map1.png");
	Image map1 = Map1Floor.getImage().getScaledInstance(600, 800, Image.SCALE_SMOOTH);
	ImageIcon RealMap1 = new ImageIcon(map1);

	ImageIcon Map2Floor = new ImageIcon("src/main/resources/mapbg/map2.png");
	Image map2 = Map2Floor.getImage().getScaledInstance(600, 800, Image.SCALE_SMOOTH);
	ImageIcon RealMap2 = new ImageIcon(map2);

	ImageIcon Map3Floor = new ImageIcon("src/main/resources/mapbg/map3.png");
	Image map3 = Map3Floor.getImage().getScaledInstance(600, 800, Image.SCALE_SMOOTH);
	ImageIcon RealMap3 = new ImageIcon(map3);

	ImageIcon Map4Floor = new ImageIcon("src/main/resources/mapbg/map4.png");
	Image map4 = Map4Floor.getImage().getScaledInstance(600, 800, Image.SCALE_SMOOTH);
	ImageIcon RealMap4 = new ImageIcon(map4);

	ImageIcon Map5Floor = new ImageIcon("src/main/resources/mapbg/map5.png");
	Image map5 = Map5Floor.getImage().getScaledInstance(600, 800, Image.SCALE_SMOOTH);
	ImageIcon RealMap5 = new ImageIcon(map5);

	private void render(Board board, Graphics graphics, Dimension window) {
		int cellW = window.width / board.getWidth();
		int cellH = window.height / board.getHeight();

		graphics.fillRect(0, 0, window.width, window.height);

		if (level == 1) {
			graphics.drawImage(RealMap1.getImage(), 0, 0, this);
		} else if (level == 2) {
			graphics.drawImage(RealMap2.getImage(), 0, 0, this);
		} else if (level == 3) {
			graphics.drawImage(RealMap3.getImage(), 0, 0, this);
		}else if (level == 4) {
			graphics.drawImage(RealMap4.getImage(), 0, 0, this);
		}else if (level == 5) {
			graphics.drawImage(RealMap5.getImage(), 0, 0, this);
		}

		for (int y = 0; y < board.getHeight(); y++) {
			for (int x = 0; x < board.getWidth(); x++) {
				int cellX = x * cellW;
				int cellY = y * cellH;
				Square square = board.squareAt(x, y);
				render(square, graphics, cellX, cellY, cellW, cellH);
			}
		}
	}

	/**
	 * Renders a single square on the given graphics context on the specified
	 * rectangle.
	 *
	 * @param square
	 *                 The square to render.
	 * @param graphics
	 *                 The graphics context to draw on.
	 * @param x
	 *                 The x position to start drawing.
	 * @param y
	 *                 The y position to start drawing.
	 * @param width
	 *                 The width of this square (in pixels.)
	 * @param height
	 *                 The height of this square (in pixels.)
	 */

	private void render(Square square, Graphics graphics, int x, int y, int width, int height) {

		square.getSprite().draw(graphics, x, y, width, height);

		for (Unit unit : square.getOccupants()) {
			unit.getSprite().draw(graphics, x, y, width, height);
		}
	}
}
