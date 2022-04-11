package leetcode.digitalProblem;

import java.util.Arrays;
import java.util.HashMap;

public class ArrayofDoubledPairs {

    public static void main(String[] args){
        int[] n = {2,4,0,0,8,1};
        System.out.println(canReorderDoubled1(n));
    }

    public static boolean canReorderDoubled1(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(arr);
        for(int i : arr){
            map.put(i,map.getOrDefault(i,0) + 1);
        }
        if (map.containsKey(0) && map.get(0) % 2 == 1) return false;
        map.remove(0);

        for(int i : arr){
            if (i == 0) continue;
            if (map.containsKey(i) && map.containsKey(i * 2)){
                decr(map,i);
                decr(map,i * 2);
            }
        }
        return map.isEmpty();
    }

    private static void decr(HashMap<Integer, Integer> map,int i){
        Integer integer = map.get(i);
        if (integer - 1 == 0) map.remove(i);
        else map.put(i,integer - 1);
    }

    public static boolean canReorderDoubled(int[] arr){
        int[] tem = new int[arr.length];
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            if (tem[i] == 1) continue;
            for(int j = i + 1; j < arr.length; j++){
                if (tem[j] == 1) continue;
                if (arr[i] == 2 * arr[j] || arr[j] == arr[i] * 2){
                    tem[i] = 1;
                    tem[j] = 1;
                    break;
                }
            }
        }
        for(int i : tem){
            if (i == 0) return false;
        }
        return true;
    }
}
