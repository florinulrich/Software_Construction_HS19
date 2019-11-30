
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GameTest {

    //TODO: Finish implementing tests

    private Game testGame;
    Player testPlayer1;
    Player testPlayer2;
    Square middleSquare;
    ArrayList<ISquare> testSquares;
    Square startSquare;
    int stepsToMiddleSquare;


    @Before public void setUp() {
        testGame = new Game(10);
        testSquares = testGame.getSquares();
        startSquare = (Square) testGame.firstSquare();
        testPlayer1 = new Player("Player1", startSquare);
        testPlayer2 = new Player("Player2", startSquare);
        testGame.addNewPlayer(testPlayer1);
        testGame.addNewPlayer(testPlayer2);

        //Make sure the middle square is not a snake or ladder
        int i = 2;
        while (true) {
            try {
                middleSquare = (Square) testSquares.get(i);
                break;
            } catch (Exception e) {
                i +=1;
            }
        }

        stepsToMiddleSquare = i;
    }

    /**
     * After the player moved, it should be on a new square and the square in turn the new player on it
     * The old square should no longer have the player on it
     * If the square is occupied the player lands on start
     * If player reaches last square gameOver == true
     */
    @Test public void testMovePlayer() {

        Player movingPlayer = testGame.players.peek(); //The player about to move
        testGame.movePlayer(stepsToMiddleSquare);
        assertEquals(middleSquare, movingPlayer.square());

        //There now should only be one player on start
        assertEquals(1, startSquare.getPlayerOnSquare().size());

        //Second player moves to last square which leads to game over
        testGame.movePlayer(testSquares.size()-1);

        assertTrue("The game should be game over", testGame.gameOver());

    }

    /**
     * This method tests the findSquare method, which returns the square the player has to go to next
     * If the player wants to move to far, he has to move back the remaining steps
     */
    @Test public void testFindSquare() {

        //Should return the middle square
        assertEquals(middleSquare, testGame.findSquare(stepsToMiddleSquare, 0));
        testGame.movePlayer(stepsToMiddleSquare); //Player1 is on middle square
        assertEquals(middleSquare, testPlayer1.square());

        //Player will end on middle square because of stepping back
        int totalStepsToMove = 2*(testSquares.size()-1) - stepsToMiddleSquare;
        assertEquals(middleSquare, testGame.findSquare(totalStepsToMove, 0));

    }

    /**
     * At the beginning gameOver == false
     * After a player reaches the last square gameOver == true
     */
    @Test public void testGameOver() {

        assertFalse("GameOver returns false value", testGame.gameOver());

        testGame.movePlayer(9);

        assertTrue("Player reached last square but game is not game Over!", testGame.gameOver());

    }

}
