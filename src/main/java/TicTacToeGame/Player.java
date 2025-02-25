package TicTacToeGame;

public class Player {
    public PlayingPiece playingPiece;
    public String name;

    public Player(String name, PlayingPiece playingPiece){
        this.name = name;
        this.playingPiece = playingPiece;
    }

    public String getName(){
        return this.name;
    }

    public PlayingPiece getPlayingPiece(){
        return this.playingPiece;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPlayingPiece(PlayingPiece playingPiece){
        this.playingPiece = playingPiece;
    }

}
