package leetcode.stringProblem;

import java.util.ArrayList;
import java.util.Arrays;

public class KeyboardRow {
    public  static void main(String[] args){
//        String[] a={"Hello","Alaska","Dad","Peace"};
        String[] a={"omk"};
        System.out.println(Arrays.toString(findWords(a)));
    }
    public static String[] findWords(String[] words){
        int[] chars = new int[58];
        String[] tmp = {"qwertyuiopQWERTYUIOP","asdfghjklASDFGHJKL","zxcvbnmZXCVBNM"};
        int row = 1;
        for(String a : tmp){
            char[] c = a.toCharArray();
            for(char b : c){
                chars[b - 'A'] = row;
            }
            row++;
        }

        ArrayList<String> res = new ArrayList<>();
        for(String a : words){
            char[] c = a.toCharArray();
            int flag=chars[c[0]-'A'];
            boolean f = true;
            for(char value : c){
                if (chars[value - 'A'] != flag){
                    // 不在同一行
                    f = false;
                    break;
                }
            }
            if (f) res.add(a);
        }
        return res.toArray(new String[0]);
    }
}
