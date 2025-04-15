// Piece.java
public abstract class Piece {
    protected int pointsWorth;
    protected Color color;
    protected int[][] captureMethod;

    public Piece(Color color, int pointsWorth, int[][] captureMethod) {
        this.color = color;
        this.pointsWorth = pointsWorth;
        this.captureMethod = captureMethod;
    }

    public Color getColor() {
        return color;
    }

    public int getPointsWorth() {
        return pointsWorth;
    }

    public abstract boolean isValidMove(Move move, Piece[][] board);
}
