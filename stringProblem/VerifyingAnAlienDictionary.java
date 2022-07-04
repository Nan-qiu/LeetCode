package leetcode.stringProblem;

import java.util.HashMap;

public class VerifyingAnAlienDictionary {
    public static void main(String[] args){
        VerifyingAnAlienDictionary verifyingAnAlienDictionary = new VerifyingAnAlienDictionary();
        System.out.println(verifyingAnAlienDictionary.isAlienSorted(new String[]{"fxasxpc", "dfbdrifhp", "nwzgs", "cmwqriv", "ebulyfyve", "miracx", "sxckdwzv", "dtijzluhts", "wwbmnge", "qmjwymmyox"}, "zkgwaverfimqxbnctdplsjyohu"));
    }


    public boolean isAlienSorted(String[] words, String order){
        char[] chars = order.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        //把字符位置放入map
        for(int i = 0; i < chars.length; i++){
            map.put(chars[i], i);
        }

        for(int i = 1; i < words.length; i++){
            boolean flag = false;

            int min = Math.min(words[i].length(), words[i - 1].length());
            //int lastState = 0;
            for(int j = 0; j < min; j++){
                char c = words[i - 1].charAt(j);
                char v = words[i].charAt(j);
                Integer n = map.get(c);
                Integer m = map.get(v);
                if (n > m) return false;
                else if (n < m){
                    flag = true;
                    break;
                }
            }

            if (!flag && words[i - 1].length() > words[i].length()) return false;

        }
        return true;
    }
}
