package nl.tudelft.jpacman;

import nl.tudelft.jpacman.ui.MainMenu;
import nl.tudelft.jpacman.ui.MapSelector;
import nl.tudelft.jpacman.ui.Tutorial;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainMenuTest {
    private MainMenu mainMenu;
    private MapSelector mapSelector;
    private Tutorial tutorialSelector;

    /**
     * Launch the user interface.
     */
    @BeforeEach
    void setUp() {
        mainMenu = new MainMenu();
        mapSelector = new MapSelector();
        tutorialSelector = new Tutorial();
    }

    /**
     * Quit the user interface when we're done.
     */
    @AfterEach
    void tearDown() {
        mainMenu.dispose();
        mapSelector.dispose();
        tutorialSelector.dispose();
    }

    /**
     * Launch the game, and imitate what would happen in a typical game.
     * The test is only a smoke test, and not a focused small test.
     * Therefore it is OK that the method is a bit too long.
     *
     * @throws InterruptedException Since we're sleeping in this test.
     */

    @DisplayName("T01 : MainMenu Should Start")
    @Test
    void MainMenuStartTest() throws InterruptedException{
        //start cleanly
        assertTrue(mainMenu.isVisible());
        Thread.sleep(2000);
    }

    @DisplayName("T02 : Map page Should show")
    @Test
    void GoMapTest() throws InterruptedException{
        mainMenu.openMap();
        assertThat(mapSelector.isVisible()).isTrue();
        Thread.sleep(4000);
    }

    @DisplayName("T03 : Tutorial page Should show")
    @Test
    void GoTutorialTest() throws InterruptedException{
        mainMenu.openTutorial();
        assertThat(tutorialSelector.isVisible()).isTrue();
        Thread.sleep(4000);
    }
}

