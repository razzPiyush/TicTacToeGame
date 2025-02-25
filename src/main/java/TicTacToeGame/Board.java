package TicTacToeGame;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int size;
    PlayingPiece[][] board; // 2-d array of playingPieces
    // intialized with null
    // board[i][j] = PlayingPiece hoaga ("X, O")

    public Board(int size){
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public boolean addPiece(int row, int col, PlayingPiece playingPiece){
        if(board[row][col]!=null){
            return false;
        }
        board[row][col] = playingPiece;
        return true;
    }

    public List<Pair<Integer, Integer>> getFreeCells(){
        List<Pair<Integer, Integer>> freeCells = new ArrayList<>();
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(board[i][j]==null){
                    freeCells.add(new Pair<Integer,Integer>(i, j));
                }
            }
        }
        return freeCells;
    }

    public void printBoard(){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(board[i][j]!=null){
                    System.out.print(board[i][j].pieceType);
                }
                else{
                    System.out.print(" ");
                }
                System.out.print(" |   ");
            }
            System.out.println();
        }
    }
}
