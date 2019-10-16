package Classes;

import Classes.Pieces.*;
import Enumerations.PieceColor;
import Exceptions.IllegalMoveException;
import Interfaces.IPiece;

public class Game {



    static public void main(String[] args) {
        Board board = new Board();

        // initialize piece setup
        pieceSetup(board);

        /* tester

        board.printBoard();
        try {
            pawn.move(pawn.getPieceMoves().get(0));
        } catch (IllegalMoveException e) {
            e.printStackTrace();
        }
        System.out.println();
        */

        //Test Move Class
//        IPiece pawn = new Pawn(board, 1, 1, PieceColor.WHITE);
//        Coordinate start = new Coordinate(1, 1);
//        Coordinate end = new Coordinate(1, 0);
//        Move move = new Move(pawn, start, end);
//        System.out.println(move.getAlgebraicIdentifier());


        board.printBoard();

    }

    private static void pieceSetup(Board board) {
        // WHITE Player
        // --pawns
        for (int i = 0; i <= 7; i++) {
            IPiece pawn = new Pawn(board, i, 1, PieceColor.WHITE);
            board.addPiece(pawn);
        }
        // --towers
        IPiece tower_w_1 = new Tower(board, 0, 0, PieceColor.WHITE);
        board.addPiece(tower_w_1);
        IPiece tower_w_2= new Tower(board, 7, 0, PieceColor.WHITE);
        board.addPiece(tower_w_2);

        // --knights
        IPiece knight_w_1 = new Knight(board, 1, 0, PieceColor.WHITE);
        board.addPiece(knight_w_1);
        IPiece knight_w_2= new Knight(board, 6, 0, PieceColor.WHITE);
        board.addPiece(knight_w_2);

        // --bishops
        IPiece bishop_w_1 = new Bishop(board, 2, 0, PieceColor.WHITE);
        board.addPiece(bishop_w_1);
        IPiece bishop_w_2= new Bishop(board, 5, 0, PieceColor.WHITE);
        board.addPiece(bishop_w_2);

        // --queen
        IPiece queen_w = new Queen(board, 3, 0, PieceColor.WHITE);
        board.addPiece(queen_w);

        // --king
        IPiece king_w = new King(board, 4, 0, PieceColor.WHITE);
        board.addPiece(king_w);

        // BLACK Player
        // --pawns
        for (int i = 0; i <= 7; i++) {
            IPiece pawn = new Pawn(board, i, 6, PieceColor.BLACK);
            board.addPiece(pawn);
        }
        // --towers
        IPiece tower_b_1 = new Tower(board, 0, 7, PieceColor.BLACK);
        board.addPiece(tower_b_1);
        IPiece tower_b_2= new Tower(board, 7, 7, PieceColor.BLACK);
        board.addPiece(tower_b_2);

        // --knights
        IPiece knight_b_1 = new Knight(board, 1, 7, PieceColor.BLACK);
        board.addPiece(knight_b_1);
        IPiece knight_b_2= new Knight(board, 6, 7, PieceColor.BLACK);
        board.addPiece(knight_b_2);

        // --bishops
        IPiece bishop_b_1 = new Bishop(board, 2, 7, PieceColor.BLACK);
        board.addPiece(bishop_b_1);
        IPiece bishop_b_2= new Bishop(board, 5, 7, PieceColor.BLACK);
        board.addPiece(bishop_b_2);

        // --queen
        IPiece queen_b = new Queen(board, 3, 7, PieceColor.BLACK);
        board.addPiece(queen_b);

        // --king
        IPiece king_b = new King(board, 4, 7, PieceColor.BLACK);
        board.addPiece(king_b);
    }
}
