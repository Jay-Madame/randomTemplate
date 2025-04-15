// ChessBoard.java
public class ChessBoard {
    private Piece[][] board = new Piece[8][8];
    private boolean isWhiteTurn = true;

    public void initGame() {
        // Add pawns
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(Color.BLACK);
            board[6][i] = new Pawn(Color.WHITE);
        }
        // Add queens
        board[0][3] = new Queen(Color.BLACK);
        board[7][3] = new Queen(Color.WHITE);
        // Add knights
        board[0][1] = new Knight(Color.BLACK);
        board[0][6] = new Knight(Color.BLACK);
        board[7][1] = new Knight(Color.WHITE);
        board[7][6] = new Knight(Color.WHITE);
    }

    public boolean makeMove(Move move) {
        Piece piece = board[move.sourceRow][move.sourceCol];
        if (piece == null) return false;
        if ((isWhiteTurn && piece.getColor() != Color.WHITE) ||
                (!isWhiteTurn && piece.getColor() != Color.BLACK)) return false;

        if (piece.isValidMove(move, board)) {
            board[move.destRow][move.destCol] = piece;
            board[move.sourceRow][move.sourceCol] = null;
            isWhiteTurn = !isWhiteTurn;
            return true;
        }
        return false;
    }

    public void endGame() {
        System.out.println("Game Over!");
    }

    public void printWinner() {
        int whitePoints = 0, blackPoints = 0;
        for (Piece[] row : board) {
            for (Piece p : row) {
                if (p != null) {
                    if (p.getColor() == Color.WHITE) whitePoints += p.getPointsWorth();
                    else blackPoints += p.getPointsWorth();
                }
            }
        }

        if (whitePoints > blackPoints)
            System.out.println("White wins with " + whitePoints + " points!");
        else if (blackPoints > whitePoints)
            System.out.println("Black wins with " + blackPoints + " points!");
        else
            System.out.println("It's a draw!");
    }
}
