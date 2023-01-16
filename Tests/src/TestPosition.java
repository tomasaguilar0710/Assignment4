import main.java.ch.uzh.board.Column;
import main.java.ch.uzh.board.Position;
import main.java.ch.uzh.board.Row;
import main.java.ch.uzh.boat.Battleship;
import main.java.ch.uzh.boat.Boat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPosition {
    @Test
    public void testPlaceBoat(){
        Column column = Column.parse("A");
        Row row = Row.parse("0");
        Position position = new Position(column,  row);
        Boat boat = new Battleship();
        assertTrue(position.isFree());
        position.placeBoat(boat);
        assertFalse(position.isFree());
        assertEquals(position.getBoatAtPosition(), boat);
    }

    @Test
    public void testParse(){
        assertNull(Position.parse("A"));
        assertNull(Position.parse("A10"));
        assertNull(Position.parse(":1"));
        Column column =Column.B;
        Row row = Row._0;
        Position position = new Position(column, row);
        Position tester = Position.parse("B0");
        assertEquals(position, tester);
    }
}
