package leetcode.stringProblem;

import java.util.ArrayList;

public class RemoveOutermostParentheses {

    public String removeOuterParentheses(String s){
        int count = 0;
        int index = 1;
        ArrayList<String> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if (chars[i] == '(') count++;
            else count--;
            if (count == 0){
                String substring = s.substring(index, i);
                index = i + 1;
                list.add(substring);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(String s1 : list){
            stringBuilder.append(s1);
        }
        return stringBuilder.toString();
    }
}
