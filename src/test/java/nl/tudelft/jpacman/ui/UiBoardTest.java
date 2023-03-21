package nl.tudelft.jpacman.ui;

import static org.assertj.core.api.Assertions.assertThat;

import javax.swing.JButton;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Level;
import nl.tudelft.jpacman.level.Player;
import nl.tudelft.jpacman.npc.Ghost;
import org.junit.jupiter.api.*;

import nl.tudelft.jpacman.ui.MainMenu;
import nl.tudelft.jpacman.ui.MapSelector;
import nl.tudelft.jpacman.ui.Tutorial;


import java.util.Random;


public class UiBoardTest {

    private Launcher launcher;

    @BeforeEach
    void setUp() {
        launcher = new Launcher();
    }

    @AfterEach
    void tearDown() {
        launcher.dispose();
    }

    private Direction getRandomDirection() {
        return Direction.values()[new Random().nextInt(Direction.values().length)];
    }
    @Test
    @Order(1)
    @DisplayName("T01: Start Game And Stop Game")
    void Test1() throws InterruptedException{
        launcher = new Launcher();
        launcher.launch_map1();
        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);

        game.start();
        int total = game.getLevel().remainingPellets();
        Thread.sleep(2000);
        for (int i=0;i<10;i++){
            game.move(player,getRandomDirection());
            Thread.sleep(50);
        }

        game.stop();
        Thread.sleep(2000);
        game.start();
        for (int i=0;i<10;i++){
            game.move(player,getRandomDirection());
            Thread.sleep(50);
        }
        game.stop();
        Thread.sleep(2000);
        assertThat(game.isInProgress()).isFalse();
        assertThat(launcher.getGame()).isNotNull();

    }
    @Test
    @Order(2)
    @DisplayName("T02: Retry Game")
    void Test2() throws InterruptedException{
        Thread.sleep(2000);
        launcher = new Launcher();
        launcher.launch_map1();
        Game game = launcher.getGame();
        Player player = game.getPlayers().get(0);
        game.start();
        for (int i=0;i<10;i++){
            game.move(player,getRandomDirection());
            Thread.sleep(50);
        }
        game.stop();
        Thread.sleep(2000);
        game.retry();
        Thread.sleep(2000);

        assertThat(game.isInProgress()).isFalse();
        assertThat(launcher.getGame()).isNotNull();


    }
    @Test
    @Order(3)
    @DisplayName("T03: Back To MapSelection")
    void Test3() throws InterruptedException{
        launcher = new Launcher();
        launcher.launch_map1();
        Game game = launcher.getGame();
        Thread.sleep(2000);
        game.start();
        Thread.sleep(2000);
        game.back();
        Thread.sleep(1000);

        assertThat(!game.isInProgress()).isFalse();
    }

}
