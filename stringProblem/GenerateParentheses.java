package leetcode.stringProblem;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args){
        System.out.println(generateParenthesis(1));
    }


    public static List<String> generateParenthesis(int n){
        ArrayList<String> strings = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        dfs(strings,builder,0,0,n);
        return strings;
    }

    private static void dfs(ArrayList<String> strings,StringBuilder builder,int left,int right,int n){
        if (left == n && right == n){
            strings.add(builder.toString());
            return;
        }
        if (left > n || right > n || right > left) return;

        //加左括号
        builder.append("(");
        dfs(strings,builder,left+1,right,n);
        builder.deleteCharAt(builder.length()-1);

        //加右括号
        builder.append(")");
        dfs(strings,builder,left,right+1,n);
        builder.deleteCharAt(builder.length()-1);
    }


}
