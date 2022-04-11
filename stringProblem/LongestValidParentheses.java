package leetcode.stringProblem;

public class LongestValidParentheses {
    public static void main(String[] args){
        String s = "(()(()((()(()()))))((((()()()(()))()((()()(()))()(()";
        System.out.println(longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s){
        char[] chars = s.toCharArray();
        if (chars.length < 2) return 0;
        int res1 = 0;
        int res2 = 0;
        int balance = 0;
        int count = 0;

        //当balance=0时，统计一次最大值，
        //当balance<0时，重置
        for(int i = 0; i < chars.length; i++){
            if (chars[i] == '('){
                balance++;
                count++;
            } else if (chars[i] == ')'){
                balance--;
                count++;
            }
            if (balance==0) res1=Math.max(res1,count);
            else if (balance<0) {
                balance=0;
                count=0;
            }
        }

        balance=0;
        count=0;

        //反过来再走一遍
        for(int i = chars.length-1; i >= 0; i--){
            if (chars[i] == ')'){
                balance++;
                count++;
            } else if (chars[i] == '('){
                balance--;
                count++;
            }
            if (balance==0) res2=Math.max(res2,count);
            else if (balance<0) {
                balance=0;
                count=0;
            }
        }

        //取最大值
        return Math.max(res1,res2);
    }


    //我是傻逼
    public static int longestValidParentheses1(String s){
        char[] chars = s.toCharArray();
        if (chars.length < 2) return 0;
        int res = 0;
        for(int j = 0; j < chars.length; j++){
            int balance = 0;
            int count = 0;
            for(int i = j; i < chars.length; i++){
                if (chars[i] == '('){
                    balance++;
                    count++;
                } else if (chars[i] == ')'){
                    balance--;
                    count++;
                }
                if (balance < 0){
                    res = Math.max(res,count - 1);
                    balance = 0;
                    count = 0;
                } else if (balance == 0){
                    res = Math.max(res,count);
                }
            }
        }

        return res;
    }


}
