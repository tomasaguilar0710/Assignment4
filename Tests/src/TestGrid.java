import main.java.ch.uzh.board.Column;
import main.java.ch.uzh.board.Grid;
import main.java.ch.uzh.board.Position;
import main.java.ch.uzh.board.Row;
import main.java.ch.uzh.boat.PatrolBoat;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestGrid {

        @Test
        public void TestPutBoatAtPosition() {
            Grid grid = new Grid("Test");
            PatrolBoat patrolBoat = new PatrolBoat();
            Column column = Column.A;
            Row row = Row._0;
            Position position = new Position(column,  row);
            assertTrue(grid.putBoatAtPosition(patrolBoat, position));
            assertFalse(grid.putBoatAtPosition(patrolBoat,null));
        }

        @Test
        public void TestAttackAtPosition(){
            Grid grid = new Grid("Test");
            Column column = Column.A;
            Row row = Row._0;
            Position position = new Position(column,  row);
            assertFalse(grid.attackAtPosition(position));
            assertFalse(grid.attackAtPosition(null));
        }



}
