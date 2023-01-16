import main.java.ch.uzh.board.Column;
import main.java.ch.uzh.board.Grid;
import main.java.ch.uzh.board.Position;
import main.java.ch.uzh.board.Row;
import main.java.ch.uzh.player.AttackStrategy.HumanPlayerAttack;
import main.java.ch.uzh.player.AttackStrategy.IAttackStrategy;
import main.java.ch.uzh.player.ComputerPlayer;
import main.java.ch.uzh.player.IPlayer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;


public class TestHumanPlayerAttack {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private ByteArrayInputStream testIn;


    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testShootAt() {
        IPlayer opponent = new ComputerPlayer();
        Grid grid = new Grid("Test");
        opponent.assignGrid(grid);
        opponent.placeFleet();
        IAttackStrategy attackStrategy = new HumanPlayerAttack();
        Position position1 = new Position(Column.A, Row._5);
        opponent.takeShotAt(position1);
        assertTrue(opponent.wasAttackedAtPosition(position1)); //A5 should be attacked
        Position position2 = new Position(Column.B, Row._5);
        assertFalse(opponent.wasAttackedAtPosition(position2)); //B5 is not yet attacked
        String moves = "A05\na5\nA5\nB5\n";
        testIn = new ByteArrayInputStream(moves.getBytes());
        System.setIn(testIn);
        attackStrategy.shootAt(opponent);
        String output = outContent.toString();
        String[] results = output.split(System.lineSeparator());
        assertEquals(results[0], ("Please enter the position to shoot at."));
        assertEquals(results[1], ("An error occurred, please try again: Please enter valid input"));
        assertEquals(results[2], ("Please enter the position to shoot at."));
        assertEquals(results[3], ("An error occurred, please try again: Please enter valid location"));
        assertEquals(results[4], ("Please enter the position to shoot at."));
        assertEquals(results[5], ("A shot has already been fired at A5"));
        assertEquals(results[6], ("Please enter the position to shoot at."));
        assertEquals(results.length, 7);
        assertTrue(opponent.wasAttackedAtPosition(position2)); //B5 was succesfully attacked

    }

    @Test
    public void testVerifyInput() {
        HumanPlayerAttack humanPlayerAttack = new HumanPlayerAttack();
        assertThrows(InputMismatchException.class, () -> {
            humanPlayerAttack.verifyInput("A10");
        });
        assertThrows(InputMismatchException.class, () -> {
            humanPlayerAttack.verifyInput(":2");
        });

    }
}

