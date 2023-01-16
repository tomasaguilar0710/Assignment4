import main.java.ch.uzh.board.Grid;
import main.java.ch.uzh.board.GridType;
import main.java.ch.uzh.boat.Fleet;
import main.java.ch.uzh.player.PlaceBoatsStrategy.HumanPlayerPlacement;
import main.java.ch.uzh.player.PlaceBoatsStrategy.IPlacementStrategy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestHumanPlayerPlacement {

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
    public void TestHumanPlayerPlacement() {
        IPlacementStrategy placementStrategy = new HumanPlayerPlacement();
        Fleet fleet = new Fleet();
        Grid grid = new Grid(GridType.OCEAN_GRID.toString());
        String moves = "A0,A4\na0,a5\nA0,A5\nA5,A8\nB0,B3\nC0,C3\nD0,D2\nE0,E2\nF0,F2\nG0,G1\nH0,H1\nI0,I1\nJ0,J1\n";
        testIn = new ByteArrayInputStream(moves.getBytes());
        System.setIn(testIn);
        placementStrategy.placeBoats(fleet, grid);
        String output = outContent.toString();
        String[] results = output.split(System.lineSeparator());
        assertEquals(results[16], ("Please enter the starting and ending position for your Carrier (size 6), separated by comma."));
        assertEquals(results[17], ("An error occurred, please try again: The ship can't be inserted, provided coordinates don't match the size of the ship"));
        assertEquals(results[35], ("An error occurred, please try again: Please enter valid location for the start coordinate"));
        assertEquals(results[53], ("Thank you!"));
        assertEquals(results[71], ("An error occurred, please try again: You cannot put a boat on occupied places."));
        assertEquals(results[89], ("Thank you!"));
        assertEquals(results[107], ("Thank you!"));
        assertEquals(results[125], ("Thank you!"));
        assertEquals(results[143], ("Thank you!"));
        assertEquals(results[161], ("Thank you!"));
        assertEquals(results[179], ("Thank you!"));
        assertEquals(results[197], ("Thank you!"));
        assertEquals(results[215], ("Thank you!"));
        assertEquals(results[233], ("Thank you!"));
        assertEquals(results[234], ("The boats are placed!"));

    }

}

