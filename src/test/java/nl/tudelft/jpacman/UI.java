package nl.tudelft.jpacman;

import static org.assertj.core.api.Assertions.assertThat;

import javax.swing.JButton;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nl.tudelft.jpacman.ui.MainMenu;
import nl.tudelft.jpacman.ui.MapSelector;
import nl.tudelft.jpacman.ui.Tutorial;

public class UI {
	private MainMenu mainMenu;

	@BeforeEach
	void setUp() {
		mainMenu = new MainMenu();
	}

	@AfterEach
	void tearDown() {
		mainMenu.dispose();
	}

	@Test
	@DisplayName("T01: MainMenu should be visible on startup")
	void testMainMenuVisible() {
		assertThat(mainMenu.isVisible()).isTrue();
	}

	@Test
	@DisplayName("T02: Clicking the start button should open the map selector")
	void testStartButton() {
		JButton startButton = mainMenu.getStartButton();
		MapSelector mapSelector = mainMenu.getMapSelector();
		startButton.doClick();
		assertThat(mainMenu.isVisible()).isFalse();
		assertThat(mainMenu.getMapSelector()).isNotNull();
		// assertThat(mapSelector.isVisible()).isTrue();
	}

	@Test
	@DisplayName("T03: Clicking the tutorial button should open the tutorial selector")
	void testTutorialButton() {
		JButton tutorialButton = mainMenu.getTutorialButton();
		Tutorial tutorialSelector = mainMenu.getTutorialSelector();
		tutorialButton.doClick();
		assertThat(mainMenu.isVisible()).isFalse();
		assertThat(mainMenu.getTutorialSelector()).isNotNull();
		// assertThat(tutorialSelector.isVisible()).isTrue();
	}

	// @Test
	// @DisplayName("T04: Clicking the leader button should open leaderboard pages")
	// void testLeaderButton() {
	// JButton leaderButton = mainMenu.getLeaderButton();
	// leaderButton.doClick();
	// assertThat(mainMenu.isVisible()).isFalse();
	// assertThat(mainMenu.getLeaderBorderSelector()).isNotNull();
	// assertThat(mainMenu.getMapSelector()).isNull();
	// assertThat(mainMenu.getTutorialSelector()).isNull();
	// }

	@Test
	@DisplayName("T04: Clicking the exit button should close the window")
	void testExitButton() {
		JButton exitButton = mainMenu.getExitButton();
		exitButton.doClick();
		assertThat(mainMenu.isVisible()).isFalse();
	}
}
