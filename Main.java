public class Main {
    public static void main(String[] args) {
        ChessBoard game = new ChessBoard();
        game.initGame();
        game.makeMove(new Move(6, 4, 4, 4)); // white pawn e2 to e4
        game.makeMove(new Move(1, 3, 3, 3)); // black pawn d7 to d5
        game.endGame();
        game.printWinner();
    }
}
