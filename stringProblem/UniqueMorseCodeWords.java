package leetcode.stringProblem;

import java.util.Arrays;

public class UniqueMorseCodeWords {

    public int uniqueMorseRepresentations(String[] words){
        if (words.length == 1) return 1;
        String[] tem = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        //String[] compare = new String[words.length];
        StringBuilder[] compare = new StringBuilder[words.length];
        for(int i = 0; i < words.length; i++){
            StringBuilder cur = new StringBuilder();
            for(char c : words[i].toCharArray()){
                cur.append(tem[c - 'a']);
            }
            compare[i] = cur;
        }
        Arrays.sort(compare);
        int res = 1;
        for(int i = 1; i < compare.length; i++){
            if (!compare[i].toString().equals(compare[i - 1].toString())) res++;
        }
        return res;
    }
}