package src.main.Practice;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Pair {
    int first;
    int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class NumberOfIslands {

    private final int[][] dir = {{0,-1},{-1,0},{0,1},{1,0}};

    //TC:O(M*N) ; SC:O(min(M,N))
    public int numIslandsBFS(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int res = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1') {
                    res++;
                    Queue<Pair> bfsQue = new ArrayDeque<>();
                    bfsQue.offer(new Pair(i, j));
                    grid[i][j] = '0';
                    while(!bfsQue.isEmpty()) {
                        Pair p = bfsQue.poll();
                        for(int d = 0; d < 4; d++) {
                            int x = p.first + dir[d][0];
                            int y = p.second + dir[d][1];
                            if(x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == '1') {
                                bfsQue.add(new Pair(x, y));
                                grid[x][y] = '0';
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    //TC:0(N*M); SC:O(N*M)
    public int numIslandsDFS(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int res = 0;
        int rows = grid.length;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    res++;
                    markGridUsingDFS(grid, i, j, rows, grid[i].length);
                }
            }
        }
        return res;
    }

    private void markGridUsingDFS(char[][] grid, int i, int j, int n, int m) {
        if(grid[i][j] == '1') {
            grid[i][j] = '0';
        }
        for(int d = 0; d < 4; d++) {
            int x = i + dir[d][0];
            int y = j + dir[d][1];
            if(x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == '1') {
                markGridUsingDFS(grid, x, y, n, m);
            }
        }
    }

}
