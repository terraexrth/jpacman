package nl.tudelft.jpacman.board;

import nl.tudelft.jpacman.Launcher;
import nl.tudelft.jpacman.board.Direction;
import nl.tudelft.jpacman.game.Game;
import nl.tudelft.jpacman.level.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {
    private Launcher launcher;

    /**
     * Launch the user interface.
     */
    /*@BeforeEach
    void setUpPacman() {
        //mainmenu = new MainMenu();
        launcher = new Launcher();
        launcher.withMapFile("/board1test.txt");
        launcher.launch();
        //mainmenu.openMap();
    }*/

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

    private Direction getRandomDirection() {
        return Direction.values()[new Random().nextInt(Direction.values().length)];
    }

    @DisplayName("TC01: Score BoMainmenuStartTestard 1")
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
    @DisplayName("TC02 : Pallet after pacman ate all Board 1")
    @Test
    void GetPalletAfterPacmanAteAll1() throws InterruptedException {
        launcher = new Launcher();
        launcher.withMapFile("/board1test.txt");
        launcher.launch();
        Game game = launcher.getGame();

        Player player = game.getPlayers().get(0);
        game.start();
        int total = 0;
        while(game.getLevel().remainingPellets() != 0){
            game.move(player,getRandomDirection());
            total = game.getLevel().remainingPellets();
        }
        Thread.sleep(2000);
        assertThat(total).isEqualTo(0);
        game.stop();
    }

    @DisplayName("TC03: Score Board 2")
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

    @DisplayName("T04 : Pallet after pacman ate all Board 2")
    @Test
    void GetPalletAfterPacmanAteAll2() throws InterruptedException {
        launcher = new Launcher();
        launcher.withMapFile("/board2test.txt");
        launcher.launch();
        Game game = launcher.getGame();

        Player player = game.getPlayers().get(0);
        game.start();
        int total = 0;
        while(game.getLevel().remainingPellets() != 0){
            game.move(player,getRandomDirection());
            total = game.getLevel().remainingPellets();
        }
        Thread.sleep(2000);
        assertThat(total).isEqualTo(0);
        game.stop();
    }

    @DisplayName("TC05: Score Board 3")
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
    @DisplayName("T06 : Pallet after pacman ate all Board 3")
    @Test
    void GetPalletAfterPacmanAteAll3() throws InterruptedException {
        launcher = new Launcher();
        launcher.withMapFile("/board3test.txt");
        launcher.launch();
        Game game = launcher.getGame();

        Player player = game.getPlayers().get(0);
        game.start();
        int total = 0;
        while(game.getLevel().remainingPellets() != 0){
            game.move(player,getRandomDirection());
            total = game.getLevel().remainingPellets();
        }
        Thread.sleep(2000);
        assertThat(total).isEqualTo(0);
        game.stop();
    }

    @DisplayName("TC07: Score Board 4")
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
    @DisplayName("T08 : Pallet after pacman ate all Board 4")
    @Test
    void GetPalletAfterPacmanAteAll4() throws InterruptedException {
        launcher = new Launcher();
        launcher.withMapFile("/board4test.txt");
        launcher.launch();
        Game game = launcher.getGame();

        Player player = game.getPlayers().get(0);
        game.start();
        int total = 0;
        while(game.getLevel().remainingPellets() != 0){
            game.move(player,getRandomDirection());
            total = game.getLevel().remainingPellets();
        }
        Thread.sleep(2000);
        assertThat(total).isEqualTo(0);
        game.stop();
    }

    @DisplayName("TC09: Score Board 5")
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
    @DisplayName("TC10 : Pallet after pacman ate all Board 5")
    @Test
    void GetPalletAfterPacmanAteAll5() throws InterruptedException {
        launcher = new Launcher();
        launcher.withMapFile("/board5test.txt");
        launcher.launch();
        Game game = launcher.getGame();

        Player player = game.getPlayers().get(0);
        game.start();
        int total = 0;
        while(game.getLevel().remainingPellets() != 0){
            game.move(player,getRandomDirection());
            total = game.getLevel().remainingPellets();
        }
        Thread.sleep(2000);
        assertThat(total).isEqualTo(0);
        game.stop();
    }
}
