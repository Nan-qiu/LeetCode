package leetcode.digitalProblem;

import java.util.Arrays;
import java.util.HashMap;

public class MatchsticksToSquare {

    public static void main(String[] args){

    }

    public boolean makesquare(int[] matchsticks){
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) return false;
        int qua = sum / 4;

        Arrays.sort(matchsticks);
        int i = 0, j = matchsticks.length - 1;
        while (i < j) {
            int tem = matchsticks[j];
            matchsticks[j] = matchsticks[i];
            matchsticks[i] = tem;
            i++;
            j--;
        }
        int[] bucket = new int[4];

        return dfs(0, matchsticks, bucket, qua);
    }

    private boolean dfs(int index, int[] matchsticks, int[] bucket, int qua){
        if (index == matchsticks.length) return true;
        for(int i = 0; i < bucket.length; i++){
            bucket[i] += matchsticks[index];
            if (bucket[i] <= qua && dfs(index + 1, matchsticks, bucket, qua)) return true;
            bucket[i] -= matchsticks[index];
        }
        return false;
    }


    public boolean makesquare1(int[] matchsticks){
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) return false;
        int qua = sum / 4;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < matchsticks.length; j++){
                if (matchsticks[j] > qua) return false;
                else if (matchsticks[j] == qua){
                    matchsticks[j] = 0;
                    continue;
                } else if (matchsticks[j] == 0) continue;

                if (map.containsKey(qua - matchsticks[j])){
                    matchsticks[j] = 0;
                    Integer index = map.get(qua - matchsticks[j]);
                    if (index == null) continue;
                    else matchsticks[index] = 0;
                }

                map.put(matchsticks[j], j);
            }
            map.clear();
        }

        for(int matchstick : matchsticks){
            if (matchstick != 0) return false;
        }
        return true;
    }
}
