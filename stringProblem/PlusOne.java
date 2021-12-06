package leetcode.stringProblem;

import java.util.ArrayList;
import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args){
        int[] a = {9,9,9,9,9,9,9};
        System.out.println(Arrays.toString(plusOne(a)));
    }

    public static int[] plusOne(int[] digits){
        if (digits.length == 1 && Arrays.stream(digits).findFirst().getAsInt() == 0) return new int[]{1};
        ArrayList<Integer> list = new ArrayList<>();
        for(int a : digits){
            list.add(a);
        }
        boolean plus = false;
        for(int i = digits.length - 1; i >= 0; i--){
            if (plus){
                list.set(i,list.get(i) + 1);
                plus = false;
            }
            if (i == digits.length - 1) list.set(i,list.get(i) + 1);
            if (list.get(i) != 1 && list.get(i) % 9 == 1){
                list.set(i,0);
                plus = true;
            }
        }
        if (plus){
            list.add(0,1);
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
