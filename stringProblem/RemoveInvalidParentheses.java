package leetcode.stringProblem;

import java.util.*;

public class RemoveInvalidParentheses {
    public static void main(String[] args){
        System.out.println(removeInvalidParentheses("()())()"));
    }


    public static List<String> removeInvalidParentheses(String s){
        int leftPt = 0;
        int rightPt = 0;

        char[] chars = s.toCharArray();
        for(char aChar : chars){
            if (aChar == '(') leftPt++;
            else if (aChar == ')'){
                if (leftPt == 0){
                    rightPt++;
                } else leftPt--;
            }
        }

        if (leftPt == 0 && rightPt == 0) return Collections.singletonList(s);
        Set<String> res = new HashSet<>();
        process(res,s,new StringBuilder(),0,0,leftPt,rightPt);

        return new ArrayList<>(res);
    }

    /**
     * @param res     把答案加如res去重
     * @param s       原字符串s
     * @param builder 方便计算
     * @param diff    左括号比右括号多多少
     * @param i       当前下标
     * @param leftPt  左括号的数量
     * @param rightPt 右括号的数量
     */
    public static void process(Set<String> res,String s,StringBuilder builder,int diff,int i,int leftPt,int rightPt){
        if (i == s.length()){
            if (diff == 0 && isValid(builder)){
                res.add(builder.toString());
            }
            return;
        }
        char c = s.charAt(i);
        if (c == '('){
            builder.append(c);
            process(res,s,builder,diff + 1,i + 1,leftPt,rightPt); // 选择此括号
            builder.deleteCharAt(builder.length() - 1);

            if (leftPt > 0){//如果左括号还有的话
                process(res,s,builder,diff,i + 1,leftPt - 1,rightPt); //不选择此括号
            }
        } else if (c == ')'){
            if (diff > 0){ //还有右括号存在的话
                builder.append(c);
                process(res,s,builder,diff - 1,i + 1,leftPt,rightPt); // 选择此括号
                builder.deleteCharAt(builder.length() - 1);
            }

            if (rightPt > 0) process(res,s,builder,diff,i + 1,leftPt,rightPt - 1);//不选此括号

        } else{
            builder.append(c);
            process(res,s,builder,diff,i + 1,leftPt,rightPt);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public static boolean isValid(StringBuilder builder){
        int left = 0;
        for(int i = 0; i < builder.length(); i++){
            char c = builder.charAt(i);
            if (c == '('){
                left++;
            } else if (c == ')'){
                if (left == 0){
                    return false;
                } else{
                    left--;
                }
            }
        }
        return left == 0;
    }
}
