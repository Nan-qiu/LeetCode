package leetcode.stringProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class LongestWordInDictionary {
    public static void main(String[] args){
        String[] s = {"a","banana","app","appl","ap","apply","apple"};
        System.out.println(longestWord(s));
    }

    public static String longestWord(String[] words){
        int max = 0;
        Arrays.sort(words);
        ArrayList<String> strings = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        set.add("");
        for(String word : words){
            String substring = word.substring(0,word.length() - 1);
            if (set.contains(substring)){
                set.add(word);
                if (word.length() > max){
                    strings.clear();
                    max = word.length();
                    strings.add(word);
                } else if (word.length() == max) strings.add(word);
            }
        }
        return strings.size() == 0 ? "" : strings.get(0);
    }
}
