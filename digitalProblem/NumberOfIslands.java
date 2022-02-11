package leetcode.digitalProblem;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    infect(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }

    //感染算法 by:lz
    private void infect(char[][] grid,int i,int j){
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length){
            return;
        }
        if (grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        infect(grid,i-1,j);
        infect(grid,i+1,j);
        infect(grid,i,j-1);
        infect(grid,i,j+1);
    }
}
