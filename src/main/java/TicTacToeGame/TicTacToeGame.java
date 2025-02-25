package TicTacToeGame;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.List;


public class TicTacToeGame {
    Board boardX;
    Deque<Player> players; //kyuki agar hamare pas n players hai to first wale ko remove karenge
    // aur usko last me daal denge

    public TicTacToeGame(){
        intializeGame();
        // we can make it dynamic
    }

    public void intializeGame(){
        // player, p2,.. n players create karne hai
        // har player ko ek symbol assign karne honge, i.e, 
        // playingPiece (jiska hamne enum banake rakha hai)
        // board ko intialize karna hoga
        players = new LinkedList<>();
        boardX = new Board(3);

        PlayingPiece1 cross = new PlayingPiece1();
        Player player1 = new Player("Alice", cross);
        players.add(player1);

        PlayingPiece2 dot = new PlayingPiece2();
        Player player2 = new Player("Bob", dot);
        players.add(player2);
        
    }

    public String startGame(){
        // jabtak winner or sare cells khatm nai ho jate tab tak game chalta rahega
        // har step pe jis player ka turn hai usko ek (row, column) chunna hoga
        // (row, col) agar occupied hai already to error throw karna hoga
        // if (row, col) is not occupied then fill that place 
        // check if the players win, or all columns filled, then move to next player 
        boolean noWinner = true;
        Scanner sc = new Scanner(System.in);
        while(noWinner)
        {
            Player player = players.getFirst();
            //System.out.print(player.name + " " + player.playingPiece.pieceType);

            boardX.printBoard();

            List<Pair<Integer, Integer>> freeCells = boardX.getFreeCells();
            if(freeCells.size()==0){
                noWinner = false;
                continue;
            }


            System.out.print(player.name + ", Please enter the row and column: ");
            int row = sc.nextInt();
            int col = sc.nextInt();
            System.out.println();

            if(!boardX.addPiece(row, col, player.playingPiece)){
                System.out.println("Error: Place already occupied");
                continue;
            }

            if(isTheirWinner(row, col, player.playingPiece.pieceType)){
                sc.close();
                boardX.printBoard();
                return player.name;
            }

            players.pollFirst();
            players.add(player);
        }
        sc.close();
        boardX.printBoard();
        return "Tie";
    }

    public boolean isTheirWinner(int row, int col, PieceType pieceType){
        // check for rows
        for(int i=0; i<boardX.size; i++){
            int count=0;
            for(int j=0; j<boardX.size; j++){
                if(boardX.board[i][j]==null){
                    break;
                }
                if(pieceType==boardX.board[i][j].pieceType){
                    count++;
                }
            }
            if(count==boardX.size){
                return true;
            }
        }
        
        //check for cloumns
        for(int j=0; j<boardX.size; j++){
            int count =0;
            for(int i=0; i<boardX.size; i++){
                if(boardX.board[i][j]==null){
                    break;
                }
                if(pieceType==boardX.board[i][j].pieceType){
                    count++;
                }
            }
            if(count==boardX.size){
                return true;
            }
        }

        // check for diagonals
        int count =0;
        for(int i=0; i<boardX.size; i++){
            if(boardX.board[i][i]==null){
                break;
            }
            if(pieceType==boardX.board[i][i].pieceType){
                count++;
            }
        }
        if(count==boardX.size){
            return true;
        }

        // check for anti-diagonals
        count =0;
        for(int i=0; i<boardX.size; i++){
            if(boardX.board[i][boardX.size-i-1]==null){
                break;
            }
            if(pieceType==boardX.board[i][boardX.size-i-1].pieceType){
                count++;
            }
        }
        if(count==boardX.size){
            return true;
        }

        // if none is found
        return false;
    }

}
