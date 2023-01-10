package main.java.ch.uzh.boat.BoatState;

import main.java.ch.uzh.board.GridType;
import main.java.ch.uzh.board.Position;
import main.java.ch.uzh.boat.Boat;

import java.util.List;

public class DestroyedState implements BoatState{

    @Override
    public boolean takeHit(Position position, Boat boat, List<Position> span) {
            return true;
    }

    public String showStatus(Position position, GridType gridType, Boat boat) {
        return boat.getRepresentator();
    }

    @Override
    public void expandSize(Position position, Boat boat, List<Position> span) {
        //Do nothing
    }

    @Override
    public boolean stillAlive() {
        return false;
    }
}
