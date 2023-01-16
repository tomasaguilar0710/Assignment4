import main.java.ch.uzh.board.Column;
import main.java.ch.uzh.board.GridType;
import main.java.ch.uzh.board.Position;
import main.java.ch.uzh.board.Row;
import main.java.ch.uzh.boat.Boat;
import main.java.ch.uzh.boat.PatrolBoat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestFloatingState {

    @Test
    public void TestTakeHitFloatingState() {
        Boat boat = new PatrolBoat();
        Column column1 = Column.parse("A");
        Row row1 = Row.parse("0");
        Column column2 = Column.parse("B");
        Row row2 = Row.parse("0");
        Position position1 = new Position(column1,  row1);
        Position position2 = new Position(column2,  row2);
        boat.expandSize(position1);
        boat.expandSize(position2);
        assertTrue(boat.getSpan().size() == 2);
        assertFalse(boat.takeHitAtPosition(position1)); //hit but not destroyed
        assertTrue(boat.getSpan().size() == 1);
        assertTrue(boat.takeHitAtPosition(position2)); //hit and destroyed
        assertTrue(boat.getSpan().size() == 0);
    }

    @Test
    public void TestShowStatusFloatingState() {
        Boat boat = new PatrolBoat();
        Column column1 = Column.parse("A");
        Row row1 = Row.parse("0");
        Position position1 = new Position(column1,  row1);
        boat.expandSize(position1);
        GridType gridType1 = GridType.OCEAN_GRID;
        assertTrue(boat.showStatusAtPosition(position1, gridType1).equals("P"));//show boat on ocean grid
        GridType gridType2 = GridType.OCEAN_GRID;
        Column column2 = Column.parse("C");
        Row row2 = Row.parse("0");
        Position position2 = new Position(column2,  row2);
        assertTrue(boat.showStatusAtPosition(position2, gridType2).equals("X"));//show no boat on ocean grid
        GridType gridType3 = GridType.TARGET_GRID;
        assertTrue(boat.showStatusAtPosition(position2, gridType3).equals("X"));//show status target grid
    }

    @Test
    public void TestExpandFloatingState(){
        Boat boat = new PatrolBoat();
        Column column = Column.parse("A");
        Row row = Row.parse("0");
        Position position = new Position(column,  row);
        assertTrue(boat.getSpan().isEmpty());
        boat.expandSize(position);
        assertFalse(boat.getSpan().isEmpty());
    }

    @Test
    public void TestStillAliveFloatingState(){
        Boat boat = new PatrolBoat();
        assertTrue(boat.stillAlive());
    }
}
