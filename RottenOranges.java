import java.util.*;

public class RottenOranges {

    public int orangesRottingBFS(int[][] grid) {

        //TC: O(MN) - MN - 2(MN) - One for add the rottan orange. and another one for traversal. But ignoring the constant. It wille be O(N)
        //SC: O(MN) - Considering all 1s then it will be O(MN) in the queue.
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return -1;

        int numberOfMinutes = -1;

        // Find rotten oranges and put it the queue
        // Traverse until the queue became empty.
        // Traverse all the adj elements.
        // Make them rottan
        // increment the count

        Queue<int[]> queue = new LinkedList();
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0)
            return 0;
    
        int[][] dirs = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] currentNode = queue.poll();
                if (grid[currentNode[0]][currentNode[1]] != 0) {
                    for (int[] dir : dirs) {
                        int row = dir[0] + currentNode[0];
                        int column = dir[1] + currentNode[1];
                        if (row >= 0 && row < m && column >= 0 && column < n && grid[row][column] == 1) {
                            grid[row][column] = 2;
                            fresh--;
                            queue.add(new int[] { row, column });
                        }
                    }
                }
            }
            numberOfMinutes++;
        }
        if (fresh > 0)
            return -1;
        return numberOfMinutes - 1;
    }

    public static void main(String[] args) {
        RottenOranges rottenOranges = new RottenOranges();
        int[][] grid = new int[][] { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };
        int result = rottenOranges.orangesRottingBFS(grid);
        System.out.println("The Number of oranges" + result);
    }
}