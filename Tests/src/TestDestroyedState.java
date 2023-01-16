import main.java.ch.uzh.board.Column;
import main.java.ch.uzh.board.GridType;
import main.java.ch.uzh.board.Position;
import main.java.ch.uzh.board.Row;
import main.java.ch.uzh.boat.Battleship;
import main.java.ch.uzh.boat.Boat;
import main.java.ch.uzh.boat.BoatState.DestroyedState;
import main.java.ch.uzh.boat.PatrolBoat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestDestroyedState {

    @Test
    public void TestTakeHitDestroyedState() {
        Boat boat = new Battleship();
        Column column = Column.parse("A");
        Row row = Row.parse("0");
        Position position = new Position(column,  row);
        boat.expandSize(position);
        boat.destroy();
        assertTrue(boat.takeHitAtPosition(position));
    }

    @Test
    public void TestShowStatusDestroyedState() {
        Boat boat = new PatrolBoat();
        Column column = Column.parse("A");
        Row row = Row.parse("0");
        Position position = new Position(column,  row);
        boat.expandSize(position);
        boat.setState(new DestroyedState());
        GridType gridType = GridType.TARGET_GRID;
        assertTrue(boat.showStatusAtPosition(position, gridType).equals("P"));
    }

    @Test
    public void TestExpandDestroyedState(){
        Boat boat = new PatrolBoat();
        Column column = Column.parse("A");
        Row row = Row.parse("0");
        Position position = new Position(column,  row);
        boat.destroy();
        assertTrue(boat.getSpan().isEmpty());
        boat.expandSize(position);
        assertTrue(boat.getSpan().isEmpty());
    }

    @Test
    public void TestStillAliveDestroyedState(){
        Boat boat = new PatrolBoat();
        boat.destroy();
        assertFalse(boat.stillAlive());
    }
}
