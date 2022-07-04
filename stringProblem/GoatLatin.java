package leetcode.stringProblem;

import java.util.HashSet;

public class GoatLatin {
    public String toGoatLatin(String sentence){
        String[] split = sentence.split(" ");
        HashSet<String> set = new HashSet<>();
        StringBuilder res = new StringBuilder();
        set.add("a");
        set.add("e");
        set.add("i");
        set.add("o");
        set.add("u");
        for(int i = 0; i < split.length; i++){
            String s = split[i].substring(0, 1);
            if (set.contains(s.toLowerCase())){
                StringBuilder builder = new StringBuilder().append(split[i]).append("ma");
                for(int j = 0; j < i + 1; j++){
                    builder.append("a");
                }
                split[i] = builder.toString();
            } else{
                StringBuilder builder = new StringBuilder().append(split[i]);
                String head = builder.substring(0, 1);
                builder.deleteCharAt(0);
                builder.append(head).append("ma");
                for(int j = 0; j < i + 1; j++){
                    builder.append("a");
                }
                split[i] = builder.toString();
            }
        }
        res.append(split[0]);
        for(int i = 1; i < split.length; i++){
            res.append(" ").append(split[i]);
        }
        return res.toString();
    }
}
