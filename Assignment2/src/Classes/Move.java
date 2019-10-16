package Classes;

import Enumerations.PieceType;
import Exceptions.IllegalMoveException;
import Interfaces.IPiece;

public class Move {

    private String algebraicIdentifier;
    private IPiece performingPiece;
    private Coordinate startCoordinate;
    private Coordinate endCoordinate;

    public Move(IPiece piece, Coordinate start, Coordinate end) {

        this.performingPiece = piece;
        this.startCoordinate = start;
        this.endCoordinate = end;

        this.calculateAlgebraicIdentifier();

    }

    private void calculateAlgebraicIdentifier() {
        String identifier = "";

        switch (this.performingPiece.getType()) {
            case QUEEN: identifier = "Q"; break;
            case KING: identifier = "K"; break;
            case PAWN: identifier = ""; break;
            case TOWER: identifier = "T"; break;
            case BISHOP: identifier = "B"; break;
            case KNIGHT: identifier = "N"; break;
        }

        identifier += endCoordinate.getAlgebraicNotation();

        algebraicIdentifier = identifier;
    }

    public void make() {
        try {
            this.performingPiece.move(this);
        } catch (IllegalMoveException e) {
            e.printStackTrace();
            System.out.println("Move.make in Move Class not working");
        }
    }

    public boolean isLegal() {

        //TODO: return if move is legal or not
        return true;
    }

    public String getAlgebraicIdentifier() {
        return algebraicIdentifier;
    }

    public Coordinate getEndCoordinate() {
        return endCoordinate;
    }

    public void correctAmbiguousIdentifier() {

        String additive = startCoordinate.getAlgebraicNotation();

        //Move by a Pawn
        if (performingPiece.getType() == PieceType.PAWN) {
            if (algebraicIdentifier.length() == 2) {
                algebraicIdentifier = additive.charAt(0) + algebraicIdentifier;
            }
            else if (algebraicIdentifier.length() == 3 && additive.charAt(0) == algebraicIdentifier.charAt(0)) {
                algebraicIdentifier = additive.charAt(1) + algebraicIdentifier;
            }
            else {
                algebraicIdentifier = additive + algebraicIdentifier;
            }
        }

    }
}
