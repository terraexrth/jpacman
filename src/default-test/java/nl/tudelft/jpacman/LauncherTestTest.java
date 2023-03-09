package nl.tudelft.jpacman;

import jdk.jfr.Description;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.ui.MainMenu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class LauncherTestTest {
    private Launcher launcher;
    private MainMenu mainmenu;

    /**
     * Launch the user interface.
     */
    @BeforeEach
    void setUpPacman() {
        //mainmenu = new MainMenu();
        launcher = new Launcher();
        launcher.withMapFile("/boardtest.txt");
        launcher.launch();
    }

    /**
     * Quit the user interface when we're done.
     */
    @AfterEach
    void tearDown() {
        launcher.dispose();
    }

    /**
     * Launch the game, and imitate what would happen in a typical game.
     * The test is only a smoke test, and not a focused small test.
     * Therefore it is OK that the method is a bit too long.
     *
     * @throws InterruptedException Since we're sleeping in this test.
     */

    @DisplayName("T01 : Game Should Start")
    @Test
    void GameStartTest() throws InterruptedException{
        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);
        // start cleanly.
        assertThat(game.isInProgress()).isFalse();
        game.start();
        assertThat(game.isInProgress()).isTrue();
        assertThat(player.getScore()).isZero();
        Thread.sleep(1000);
    }


    @DisplayName("T02 : Packman should eat all padlet (Padlet remaining = 0)")
    @Test
    void GetAllPadletTest() throws InterruptedException {
        Game game = launcher.getGame();

        Player player = game.getPlayers().get(0);
        //GameEndTest
        game.start();
        int total = game.getLevel().remainingPellets();
        while(game.getLevel().remainingPellets() != 0){
            game.move(player,getRandomDirection());
        }
        Thread.sleep(2000);
        assertThat(player.getScore()).isEqualTo(total*10);
        game.stop();
    }

    private Direction getRandomDirection() {
        return Direction.values()[new Random().nextInt(Direction.values().length)];
    }


    @DisplayName("T03 : Tutorial")
    @Test
    void TutorialTest() throws InterruptedException{
        launcher = new Launcher();
        launcher.withMapFile("/boardtutorialtest.txt");
        launcher.launch();
        Game game = launcher.getGame();

        Player player = game.getPlayers().get(0);
        //GameEndTest
        game.start();
        int total = game.getLevel().remainingPellets();
        while(game.getLevel().remainingPellets() != 0){
            game.move(player,getRandomDirection());
        }
        Thread.sleep(2000);
        assertThat(player.getScore()).isEqualTo(total*10);
        game.stop();
    }

    @Test
    void Board1Test() throws InterruptedException{
        launcher = new Launcher();
        launcher.withMapFile("/board1test.txt");
        launcher.launch();
        Game game = launcher.getGame();

        Player player = game.getPlayers().get(0);
        //GameEndTest
        game.start();
        int total = game.getLevel().remainingPellets();
        while(game.getLevel().remainingPellets() != 0){
            game.move(player,getRandomDirection());
        }
        Thread.sleep(2000);
        assertThat(player.getScore()).isEqualTo(total*10);
        game.stop();
    }

    @Test
    void Board2Test() throws InterruptedException{
        launcher = new Launcher();
        launcher.withMapFile("/board2test.txt");
        launcher.launch();
        Game game = launcher.getGame();

        Player player = game.getPlayers().get(0);
        //GameEndTest
        game.start();
        int total = game.getLevel().remainingPellets();
        while(game.getLevel().remainingPellets() != 0){
            game.move(player,getRandomDirection());
        }
        Thread.sleep(2000);
        assertThat(player.getScore()).isEqualTo(total*10);
        game.stop();
    }

    @Test
    void Board3Test() throws InterruptedException{
        launcher = new Launcher();
        launcher.withMapFile("/board3test.txt");
        launcher.launch();
        Game game = launcher.getGame();

        Player player = game.getPlayers().get(0);
        //GameEndTest
        game.start();
        int total = game.getLevel().remainingPellets();
        while(game.getLevel().remainingPellets() != 0){
            game.move(player,getRandomDirection());
        }
        Thread.sleep(2000);
        assertThat(player.getScore()).isEqualTo(total*10);
        game.stop();
    }

    @Test
    void Board4Test() throws InterruptedException{
        launcher = new Launcher();
        launcher.withMapFile("/board4test.txt");
        launcher.launch();
        Game game = launcher.getGame();

        Player player = game.getPlayers().get(0);
        //GameEndTest
        game.start();
        int total = game.getLevel().remainingPellets();
        while(game.getLevel().remainingPellets() != 0){
            game.move(player,getRandomDirection());
        }
        Thread.sleep(2000);
        assertThat(player.getScore()).isEqualTo(total*10);
        game.stop();
    }

    @Test
    void Board5Test() throws InterruptedException{
        launcher = new Launcher();
        launcher.withMapFile("/board5test.txt");
        launcher.launch();
        Game game = launcher.getGame();

        Player player = game.getPlayers().get(0);
        //GameEndTest
        game.start();
        int total = game.getLevel().remainingPellets();
        while(game.getLevel().remainingPellets() != 0){
            game.move(player,getRandomDirection());
        }
        Thread.sleep(2000);
        assertThat(player.getScore()).isEqualTo(total*10);
        game.stop();
    }
}
