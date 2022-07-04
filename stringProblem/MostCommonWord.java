package leetcode.stringProblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned){
        HashSet<String> set = new HashSet<>(Arrays.asList(banned));
        HashMap<String, Integer> map = new HashMap<>();

        StringBuilder builder = new StringBuilder();
        builder.append(paragraph);
        String[] split = paragraph.split(" |,|\\.|!|\\?|'|;");
        for(String s : split){
            String lowerCase = s.toLowerCase();
            if (!s.equals("") && !set.contains(lowerCase)){
                if (!map.containsKey(lowerCase)){
                    map.put(lowerCase, 1);
                } else{
                    int cur = map.get(lowerCase) + 1;
                    map.put(lowerCase, cur);
                }
            }
        }

        int max = 0;
        String res = null;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if (entry.getValue() > max){
                max = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }
}
