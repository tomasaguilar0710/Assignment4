package main.java.ch.uzh.board.positionState;

import main.java.ch.uzh.board.Position;

public class EmptyState implements IPositionState {

    public boolean takeHit(Position position){
        position.setHasBeenAttacked(true);
        position.setStatusView(position.getOceanHit());
        return false;
    }
}
