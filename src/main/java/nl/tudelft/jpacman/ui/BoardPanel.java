package nl.tudelft.jpacman.ui;

import java.awt.*;
import java.util.Map;

import javax.swing.*;

import nl.tudelft.jpacman.board.Board;
import nl.tudelft.jpacman.board.Square;
import nl.tudelft.jpacman.board.Unit;
import nl.tudelft.jpacman.game.Game;

import javax.swing.JLayeredPane;
import javax.swing.JFrame;

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
     *            The game to display.
     */

    BoardPanel(Game game,final Map<String, Action> buttons,final JFrame parent) {
        super();
        assert game != null;
        this.game = game;

        Board board = game.getLevel().getBoard();

        int w = board.getWidth() * SQUARE_SIZE;
        int h = board.getHeight() * SQUARE_SIZE;

        Dimension size = new Dimension(w, h);
        setMinimumSize(size);
        setPreferredSize(size);

        assert buttons != null;
        assert parent != null;

        ImageIcon startIcon = new ImageIcon("src/main/resources/start_btn.png");
        Image startImg = startIcon.getImage().getScaledInstance(100, 25, Image.SCALE_SMOOTH);
        ImageIcon startBtn = new ImageIcon(startImg);

        ImageIcon stopIcon = new ImageIcon("src/main/resources/pause_btn.png");
        Image stopImg = stopIcon.getImage().getScaledInstance(100, 25, Image.SCALE_SMOOTH);
        ImageIcon stopBtn = new ImageIcon(stopImg);

        ImageIcon exitIcon = new ImageIcon("src/main/resources/exit_btn.png");
        Image exitImg = exitIcon.getImage().getScaledInstance(100, 25, Image.SCALE_SMOOTH);
        ImageIcon exitBtn = new ImageIcon(exitImg);

        for (final String caption : buttons.keySet()) {

            JButton Startbutton = new JButton(caption);
            JButton Stopbutton = new JButton(caption);
            JButton Exitbutton = new JButton(caption);


            Startbutton.addActionListener(e -> {
                buttons.get(caption).doAction();
                parent.requestFocusInWindow();
            });

            Stopbutton.addActionListener(e -> {
                buttons.get(caption).doAction();
                parent.requestFocusInWindow();
            });

            Exitbutton.addActionListener(e -> {
                buttons.get(caption).doAction();
                parent.requestFocusInWindow();
            });


            if (Startbutton.getText().equals("Start")) {
                Startbutton.setIcon(startBtn);
                Startbutton.setOpaque(false);
                Startbutton.setBorder(null);
                Startbutton.setBorderPainted(false);
                Startbutton.setContentAreaFilled(false);
                Startbutton.setText(" ");
                setComponentZOrder(Startbutton, 0);
                add(Startbutton, BorderLayout.CENTER);
                Startbutton.setBounds(80, 670, 200, 50);


            } else if (Stopbutton.getText().equals("Stop")) {
                Stopbutton.setIcon(stopBtn);
                Stopbutton.setOpaque(false);
                Stopbutton.setBorder(null);
                Stopbutton.setBorderPainted(false);
                Stopbutton.setContentAreaFilled(false);
                Stopbutton.setText(" ");
                add(Stopbutton);

            }else if (Exitbutton.getText().equals("Exit")) {
                Exitbutton.setIcon(exitBtn);
                Exitbutton.setOpaque(false);
                Exitbutton.setBorder(null);
                Exitbutton.setBorderPainted(false);
                Exitbutton.setContentAreaFilled(false);
                Exitbutton.setText(" ");
                add(Exitbutton);
            }
        }
    }

    //@Override
    /*public void paint(Graphics g) {
        assert g != null;
        render(game.getLevel().getBoard(), g, getSize());

    }*/


    /**
     * Renders the board on the given graphics context to the given dimensions.
     *
     * @param board
     *            The board to render.
     * @param graphics
     *            The graphics context to draw on.
     * @param window
     *            The dimensions to scale the rendered board to.
     */
    /*private void render(Board board, Graphics graphics, Dimension window) {
        int cellW = window.width / board.getWidth();
        int cellH = window.height / board.getHeight();

        graphics.setColor(BACKGROUND_COLOR);
        //graphics.setColor(BACKGROUND_COLOR);
        graphics.fillRect(0, 0, window.width, window.height);

        for (int y = 0; y < board.getHeight(); y++) {
            for (int x = 0; x < board.getWidth(); x++) {
                int cellX = x * cellW;
                int cellY = y * cellH;
                Square square = board.squareAt(x, y);
                render(square, graphics, cellX, cellY, cellW, cellH);
            }
        }
    }*/

    /**
     * Renders a single square on the given graphics context on the specified
     * rectangle.
     *
     * @param square
     *            The square to render.
     * @param graphics
     *            The graphics context to draw on.
     * @param x
     *            The x position to start drawing.
     * @param y
     *            The y position to start drawing.
     * @param width
     *            The width of this square (in pixels.)
     * @param height
     *            The height of this square (in pixels.)
     */
    private void render(Square square, Graphics graphics, int x, int y, int width, int height) {
        square.getSprite().draw(graphics, x, y, width, height);
        for (Unit unit : square.getOccupants()) {
            unit.getSprite().draw(graphics, x, y, width, height);
        }
    }
}
