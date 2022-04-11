package leetcode.digitalProblem;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left,int right){
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = left; i <= right; i++){
            if (isSelfD(i)) res.add(i);
        }
        return res;
    }

    private boolean isSelfD(int i){
        int cur = i;
        int div;
        while (cur != 0) {
            div = cur % 10;
            if (div == 0 || i % div != 0) return false;
            cur /= 10;
        }
        return true;
    }

}
