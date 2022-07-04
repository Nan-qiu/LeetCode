package leetcode.stringProblem;

import java.util.HashMap;

public class LongestPalindromebyConcatenatingTwoLetterWords {
    public int longestPalindrome(String[] words){
        HashMap<String, Integer> same = new HashMap<>();
        HashMap<String, Integer> diff = new HashMap<>();

        for(String word : words){
            char c1 = word.charAt(0);
            char c2 = word.charAt(1);
            if (c1 == c2){
                if (same.containsKey(word)){
                    same.put(word, same.get(word) + 1);
                } else same.put(word, 1);
            } else{
                if (diff.containsKey(word)){
                    diff.put(word, diff.get(word) + 1);
                } else diff.put(word, 1);
            }
        }

        int count = 0;
        for(String word : words){
            char c1 = word.charAt(0);
            char c2 = word.charAt(1);
            //相同的字符串 aa,bb
            if (c1 == c2){
                //当前字符串的数量
                Integer cur = same.getOrDefault(word,-1);
                while (cur >= 2) {
                    cur -= 2;
                    count += 2;
                }
                if (cur==0) same.remove(word);
                else if(cur>0) same.put(word, cur);
            } else{ //不同的字符串 ab, cd
                StringBuilder buffer = new StringBuilder().append(word);
                String reverse = buffer.reverse().toString();
                Integer cur = diff.getOrDefault(word,-1);
                Integer reCur = diff.getOrDefault(reverse,-1);
                while (cur > 0 && reCur > 0) {
                    count += 2;
                    cur -= 1;
                    reCur -= 1;
                }
                if (cur==0) diff.remove(word);
                else if (cur>0)diff.put(word,cur);
                if (reCur==0) diff.remove(reverse);
                else if (reCur>0)diff.put(reverse,reCur);
            }
        }
        if (same.size()!=0) count++;
        return count*2;
    }
}
