// Pawn.java
public class Pawn extends Piece {
    private int[][] enPassantSpaces;

    public Pawn(Color color) {
        super(color, 1, new int[][] {{1, 0}}); // simple forward movement
        enPassantSpaces = new int[][] {{1, 1}, {1, -1}};
    }

    @Override
    public boolean isValidMove(Move move, Piece[][] board) {
        int direction = (color == Color.WHITE) ? -1 : 1;
        int dr = move.destRow - move.sourceRow;
        int dc = move.destCol - move.sourceCol;

        // Standard move
        if (dc == 0 && dr == direction && board[move.destRow][move.destCol] == null) {
            return true;
        }

        // Capture
        if (Math.abs(dc) == 1 && dr == direction && board[move.destRow][move.destCol] != null &&
                board[move.destRow][move.destCol].getColor() != this.color) {
            return true;
        }

        // En passant logic placeholder
        // Can expand with actual game history later
        return false;
    }
}
