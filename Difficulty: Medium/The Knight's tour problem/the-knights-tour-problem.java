import java.util.*;

class Solution {
    private static final int[] rowDir = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] colDir = {1, 2, 2, 1, -1, -2, -2, -1};
    
    public ArrayList<ArrayList<Integer>> knightTour(int n) {
        ArrayList<ArrayList<Integer>> board = new ArrayList<>();
        
        // Initialize board with -1 (unvisited)
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>(Collections.nCopies(n, -1));
            board.add(row);
        }
        
        board.get(0).set(0, 0); // starting position
        if (solve(0, 0, 1, n, board)) {
            return board;
        } else {
            return new ArrayList<>(); // No valid tour
        }
    }

    private boolean solve(int x, int y, int moveCount, int n, ArrayList<ArrayList<Integer>> board) {
        // If all squares are visited
        if (moveCount == n * n) {
            return true;
        }
        
        for (int i = 0; i < 8; i++) {
            int nextX = x + rowDir[i];
            int nextY = y + colDir[i];
            
            if (isSafe(nextX, nextY, n, board)) {
                board.get(nextX).set(nextY, moveCount);
                if (solve(nextX, nextY, moveCount + 1, n, board))
                    return true;
                // Backtrack
                board.get(nextX).set(nextY, -1);
            }
        }
        return false;
    }

    private boolean isSafe(int x, int y, int n, ArrayList<ArrayList<Integer>> board) {
        return (x >= 0 && x < n && y >= 0 && y < n && board.get(x).get(y) == -1);
    }
}
