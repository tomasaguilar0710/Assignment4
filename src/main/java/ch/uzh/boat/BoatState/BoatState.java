package main.java.ch.uzh.boat.BoatState;

import main.java.ch.uzh.board.GridType;
import main.java.ch.uzh.board.Position;
import main.java.ch.uzh.boat.Boat;

import java.util.List;

public interface BoatState {
    boolean takeHit(Position position, Boat boat, List<Position> span);
    String showStatus(Position position, GridType gridType, Boat boat);

    void expandSize(Position position, Boat boat, List<Position> span);

    boolean stillAlive();
}
