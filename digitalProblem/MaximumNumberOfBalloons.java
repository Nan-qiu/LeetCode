package leetcode.digitalProblem;

public class MaximumNumberOfBalloons {

    public static int maxNumberOfBalloons(String text){
        int b = 0;
        int a = 0;
        int n = 0;
        int l = 0;
        int o = 0;
        for(char c : text.toCharArray()){
            if (c == 'a') a++;
            else if (c == 'b') b++;
            else if (c == 'n') n++;
            else if (c == 'l') l++;
            else if (c == 'o') o++;
        }
        l = l / 2;
        o = o / 2;
        return Math.min(b,Math.min(a,Math.min(n,Math.min(l,o))));
    }
}
