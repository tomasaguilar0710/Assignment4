package main.java.ch.uzh.boat;

import main.java.ch.uzh.board.Direction;
import main.java.ch.uzh.board.GridType;
import main.java.ch.uzh.board.Position;
import main.java.ch.uzh.board.positionState.IPositionState;
import main.java.ch.uzh.boat.BoatState.BoatState;
import main.java.ch.uzh.boat.BoatState.DestroyedState;
import main.java.ch.uzh.boat.BoatState.FloatingState;

import java.util.ArrayList;
import java.util.List;

public abstract class Boat {

    /**
     * Maybe we only have to count the number of hits and not store position.
     * We must make sure, that a position can only be shot once!
     */

    private boolean isDestroyed;
    private final String type;
    private final String representator;
    private final int size;
    private final String damage;
    private final List<Position> span = new ArrayList<>();
    private int hitCount;
    private BoatState boatState;

    public Boat(String type, String representator, int size) {
        this.type = type;
        this.representator = representator;
        this.size = size;
        this.hitCount = 0;
        this.damage = "X";
        setState(new FloatingState());
    }

    public void setState(BoatState boatState){
        this.boatState = boatState;
    }

    public void expandSize(Position position) {
        this.boatState.expandSize(position, this, this.span);
    }

    public boolean takeHitAtPosition(Position position) {
        return this.boatState.takeHit(position, this, this.span);
    }

    //set the state of the boat to destroyed
    public void destroy(){
        setState(new DestroyedState());
    }

    public String showStatusAtPosition(Position position, GridType gridType) {
        return boatState.showStatus(position, gridType,this);
    }

    public boolean fitsBetween(Position start, Position end) {
        int targetSize = start.distanceTo(end).orElse(-1) + 1;
        // If coordinates are not a straight line, distanceTo returns null.
        // We count the number of cells here, therefore the +1 at the end
        return this.getSize() == targetSize;
    }

    public Position getEndPositionForDirection(Position start, Direction direction) {
        int distance = this.size - 1;
        Position end = start;
        while (distance > 0 && end != null) {
            end = end.neighbour(direction);
            distance--;
        }
        return end; // end is null, if neighbour of last iteration of while loop was no valid position
    }

    public boolean stillAlive() {
        return this.boatState.stillAlive();
    }

    @Override
    public String toString() {
        return this.type;
    }

    public int getSize(){
        return this.size;
    }

    //getter span


    public List<Position> getSpan() {
        return new ArrayList<>(this.span);
    }

    //getter for representator
    public String getRepresentator() {
        return representator;
    }

    //getter for damage
    public String getDamage() {
        return damage;
    }
}
