import main.java.ch.uzh.boat.Boat;
import main.java.ch.uzh.boat.Submarine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBoat {
    @Test
    public void testToString() {
        Boat boat = new Submarine();
        assertEquals("Submarine", boat.toString());
    }
}
