package main.java.ch.uzh.board.positionState;

import main.java.ch.uzh.board.Position;

public class OccupiedState implements IPositionState {

    public boolean takeHit(Position position){
        position.setHasBeenAttacked(true);
        return position.getBoatAtPosition().takeHitAtPosition(position);
    }
}
