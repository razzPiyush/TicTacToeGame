package TicTacToeGame;

public class Main {
    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        game.intializeGame();
        String result = game.startGame();
        if(result.equalsIgnoreCase("Tie")){
            System.out.println("The game is tie");
        }
        else{
            System.out.println("The winner of the game is " + result);
        }
    }
}