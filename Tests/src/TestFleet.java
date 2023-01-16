import main.java.ch.uzh.boat.Boat;
import main.java.ch.uzh.boat.Fleet;
import org.junit.jupiter.api.Test;
import java.util.Iterator;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestFleet {
    @Test
    public void TestStillStanding() {
        Fleet fleet = new Fleet();
        assertTrue(fleet.stillStanding());
        Iterator<Boat> boats = fleet.iterator();
        while (boats.hasNext()) {
            Boat boat = boats.next();
            boat.destroy();
        }
        assertFalse(fleet.stillStanding());
    }
}
