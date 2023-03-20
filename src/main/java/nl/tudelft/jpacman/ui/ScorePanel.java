package nl.tudelft.jpacman.ui;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.*;
import javax.swing.plaf.metal.OceanTheme;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.level.Player;

/**
 * A panel consisting of a column for each player, with the numbered players on
 * top and their respective scores underneath.
 *
 * @author Jeroen Roosen 
 *
 */
public class ScorePanel extends JPanel {

    /**
     * Default serialisation ID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The map of players and the labels their scores are on.
     */
    private final Map<Player, JLabel> scoreLabels;

    private PacManUiBuilder pacManUiBuilder;



    /**
     * The default way in which the score is shown.
     */
    public static final ScoreFormatter DEFAULT_SCORE_FORMATTER =
        (Player player) -> String.format("Score: %3d", player.getScore());

    /**
     * The way to format the score information.
     */
    private ScoreFormatter scoreFormatter = DEFAULT_SCORE_FORMATTER;

    /**
     * Creates a new score panel with a column for each player.
     *
     * @param players The players to display the scores of.
     * @param level
     */
    public ScorePanel(List<Player> players, int level) {
        super();
        assert players != null;

        setLayout(new GridLayout(3, players.size()));

        String MapName = " ";
        if (level== 1) {
            MapName = "Forest";
        } else if (level == 2) {
            MapName = "Snow";
        } else if (level == 3) {
            MapName = "Desert";
        } else if (level == 4) {
            MapName = "Water";
        } else if (level == 5) {
            MapName = "Candy";
        }
        JLabel MapLabel = new JLabel("Map : "+ MapName,JLabel.CENTER);
        add(MapLabel);

        for (int i = 1; i <= players.size(); i++) {
            add(new JLabel("Player " + i, JLabel.CENTER));
        }
        scoreLabels = new LinkedHashMap<>();
        for (Player player : players) {
            JLabel scoreLabel = new JLabel("0", JLabel.CENTER);
            scoreLabels.put(player, scoreLabel);
            add(scoreLabel);
        }


    }





    /**
     * Refreshes the scores of the players.
     */
    protected void refresh() {
        for (Map.Entry<Player, JLabel> entry : scoreLabels.entrySet()) {
            Player player = entry.getKey();
            String score = "";
            if (!player.isAlive()) {
                score = "You died. ";
            }
            score += scoreFormatter.format(player);
            entry.getValue().setText(score);
        }
    }

    /**
     * Provide means to format the score for a given player.
     */
    public interface ScoreFormatter {

        /**
         * Format the score of a given player.
         * @param player The player and its score
         * @return Formatted score.
         */
        String format(Player player);
    }

    /**
     * Let the score panel use a dedicated score formatter.
     * @param scoreFormatter Score formatter to be used.
     */
    public void setScoreFormatter(ScoreFormatter scoreFormatter) {
        assert scoreFormatter != null;
        this.scoreFormatter = scoreFormatter;
    }
}
