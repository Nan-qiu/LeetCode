package leetcode.stringProblem;

import java.util.HashMap;

public class RomantoInteger {
    public int romanToInt(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0;
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            int k1 = map.get(chars[i]);
            int k2 = i + 1 < chars.length ? map.get(chars[i + 1]) : 0;
            if (k1 < k2){
                res += k2 - k1;
                i++;
            } else res += k1;
        }
        return res;
    }
}
