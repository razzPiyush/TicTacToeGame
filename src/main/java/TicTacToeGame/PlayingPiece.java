package TicTacToeGame;

public class PlayingPiece {
    PieceType pieceType;
    // PlayingPiece jo hai 2 types ke hosakte ya jitne enum me hai
    // PlayingPiece me koi ek piecetype aayega usko constructor se intialize kardenge

    public PlayingPiece(PieceType pieceType){
        this.pieceType = pieceType;
    }
}
