package leetcode.digitalProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {

    int[][] Up;
    int[][] Down;

    public List<List<Integer>> pacificAtlantic(int[][] heights){
        List<List<Integer>> res = new ArrayList<>();
        Up = new int[heights.length][heights[0].length];
        Down = new int[heights.length][heights[0].length];
        for(int i = 0; i < heights.length; i++){
            process(heights, i, 0, -1, true);
            process(heights, i, heights[0].length - 1, -1, false);
        }

        for(int i = 0; i < heights[0].length; i++){
            process(heights, 0, i, 1000000, true);
            process(heights, heights.length - 1, i, -1, false);
        }

        System.out.println(Arrays.deepToString(Up));

        for(int i = 0; i < Up.length; i++){
            for(int j = 0; j < Up[0].length; j++){
                if (Up[i][j] == -1 && Down[i][j] == -1){
                    ArrayList<Integer> cur = new ArrayList<>();
                    cur.add(i);
                    cur.add(j);
                    res.add(cur);
                }
            }
        }
        return res;
    }

    private void process(int[][] heights, int i, int j, int last, boolean flag){
        if (i < 0 || i > heights.length - 1 || j < 0 || j > heights[0].length - 1) return;
        int tem = heights[i][j];
        if (tem < last) return;
        if (flag){
            if (Up[i][j] == -1) return;
            Up[i][j] = -1;
        } else{
            if (Down[i][j] == -1) return;
            Down[i][j] = -1;
        }

        process(heights, i + 1, j, tem, flag);
        process(heights, i - 1, j, tem, flag);
        process(heights, i, j + 1, tem, flag);
        process(heights, i, j - 1, tem, flag);
    }
}
