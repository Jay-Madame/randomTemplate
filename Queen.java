// Queen.java
public class Queen extends Piece {
    public Queen(Color color) {
        super(color, 9, new int[][] {
                {1, 0}, {-1, 0}, {0, 1}, {0, -1},
                {1, 1}, {-1, -1}, {-1, 1}, {1, -1}
        });
    }

    @Override
    public boolean isValidMove(Move move, Piece[][] board) {
        int dr = move.destRow - move.sourceRow;
        int dc = move.destCol - move.sourceCol;
        if (dr == 0 || dc == 0 || Math.abs(dr) == Math.abs(dc)) {
            return true;
        }
        return false;
    }
}
