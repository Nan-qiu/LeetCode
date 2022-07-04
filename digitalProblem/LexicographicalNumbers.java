package leetcode.digitalProblem;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1, j = 1; i <= n; i++){
            list.add(j);
            if (j * 10 <= n) j *= 10;
            else{
                while (j % 10 == 9 || j + 1 > n) j /= 10;
                j++;
            }
        }
        return list;
    }
}
