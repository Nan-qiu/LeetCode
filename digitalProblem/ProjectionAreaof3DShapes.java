package leetcode.digitalProblem;

public class ProjectionAreaof3DShapes {
    public int projectionArea(int[][] grid){
        int xy = 0;
        int zy = 0;
        int zx = 0;

        for(int[] g : grid){
            int max = 0;
            for(int n : g){
                zy += n == 0 ? 0 : 1;
                max = Math.max(max, n);
            }
            zy += max;
        }

        for(int i = 0; i < grid.length; i++){
            int max = 0;
            for(int j = 0; j < grid[0].length; j++){
                max = Math.max(grid[j][i], max);
            }
            zx += max;
        }

        return xy + zy + zx;
    }
}
