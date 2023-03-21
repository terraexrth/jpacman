package nl.tudelft.jpacman.ui;

import org.json.simple.parser.ParseException;

/**
 * An action that can be executed.
 *
 * @author Jeroen Roosen 
 */
public interface Action {

    /**
     * Executes the action.
     */
    void doAction();
}
