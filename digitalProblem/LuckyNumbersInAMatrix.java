package leetcode.digitalProblem;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbersInAMatrix {
    public List<Integer> luckyNumbers(int[][] matrix){
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            row[i] = 100001;
            for(int j = 0; j < matrix[0].length; j++){
                row[i] = Math.min(matrix[i][j],row[i]);
                col[j] = Math.max(matrix[i][j],col[j]);
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < row.length; i++){
            for(int j = 0; j < col.length; j++){
                if (matrix[i][j] == row[i] && matrix[i][j] == col[j]) res.add(matrix[i][j]);
            }
        }
        return res;
    }

}
