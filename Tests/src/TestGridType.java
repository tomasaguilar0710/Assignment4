import main.java.ch.uzh.board.GridType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGridType {
    @Test
    public void TestGridType() {
        GridType gridType = GridType.OCEAN_GRID;
        assertEquals("Ocean Grid", gridType.toString());
        gridType = GridType.TARGET_GRID;
        assertEquals("Target Grid", gridType.toString());
        gridType = GridType.CHEAT_GRID;
        assertEquals("Cheat Grid", gridType.toString());
    }
}
