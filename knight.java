// Knight.java
public class Knight extends Piece {
    private int[][] jumpSpaces = {
            {-2, -1}, {-1, -2}, {1, -2}, {2, -1},
            {2, 1}, {1, 2}, {-1, 2}, {-2, 1}
    };

    public Knight(Color color) {
        super(color, 3, null); // knights usually worth 3 points
    }

    @Override
    public boolean isValidMove(Move move, Piece[][] board) {
        int dr = move.destRow - move.sourceRow;
        int dc = move.destCol - move.sourceCol;
        for (int[] jump : jumpSpaces) {
            if (jump[0] == dr && jump[1] == dc) {
                return true;
            }
        }
        return false;
    }
}
