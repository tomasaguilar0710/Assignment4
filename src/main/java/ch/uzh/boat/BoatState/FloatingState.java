package main.java.ch.uzh.boat.BoatState;

import main.java.ch.uzh.board.GridType;
import main.java.ch.uzh.board.Position;
import main.java.ch.uzh.boat.Boat;

import java.util.List;

public class FloatingState implements BoatState {

    @Override
    public boolean takeHit(Position position, Boat boat, List<Position> span) {
        if (span.contains(position)) {
            span.remove(position);
            if (span.isEmpty()) {
                boat.destroy();
                return true;
            }
        }
        return false;
    }

    @Override
    public String showStatus(Position position, GridType gridType, Boat boat) {
        if (gridType == GridType.OCEAN_GRID) {
            // Show X for damaged positions, representator for all other positions
            if (boat.getSpan().contains(position)) {
                return boat.getRepresentator();
            } else {
                return boat.getDamage();
            }
        } else {
            // Only show damaged positions
            return boat.getDamage();
        }
    }

    @Override
    public void expandSize(Position position, Boat boat, List<Position> span) {
        if (!span.contains(position)) {
            span.add(position);
        }
    }

    @Override
    public boolean stillAlive() {
        return true;
    }
}



