import main.java.ch.uzh.board.Column;
import main.java.ch.uzh.board.Position;
import main.java.ch.uzh.board.Row;
import main.java.ch.uzh.board.positionState.EmptyState;
import main.java.ch.uzh.board.positionState.OccupiedState;
import main.java.ch.uzh.boat.Battleship;
import main.java.ch.uzh.boat.Boat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPositionState {

    @Test
    public void TestStateChange() {
        Column column = Column.parse("A");
        Row row = Row.parse("0");
        Position position = new Position(column,  row);
        assertTrue(position.getPositionState() instanceof EmptyState);
        Boat boat = new Battleship();
        position.placeBoat(boat);
        assertTrue(position.getPositionState() instanceof OccupiedState);
    }

    @Test
    public void TestTakeHitEmptyState() {
        Column column = Column.parse("A");
        Row row = Row.parse("0");
        Position position = new Position(column,  row);
        assertTrue(position.getPositionState() instanceof EmptyState);
        assertFalse(position.attack());
    }

    @Test
    public void TestTakeHitOccupiedState() {
        Column column = Column.parse("A");
        Row row = Row.parse("0");
        Position position = new Position(column,  row);
        Boat boat = new Battleship();
        position.placeBoat(boat);
        boat.expandSize(position);
        assertTrue(position.attack());
    }

}