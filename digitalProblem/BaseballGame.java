package leetcode.digitalProblem;

public class BaseballGame {
    public int calPoints(String[] ops){
        int[] res = new int[ops.length];
        int index = 0;
        for(String op : ops){
            switch (op) {
                case "+":
                    res[index] = res[index - 1] + res[index - 2];
                    index++;
                    break;
                case "D":
                    res[index] = 2 * res[index - 1];
                    index++;
                    break;
                case "C":
                    res[index - 1] = 0;
                    index -= 1;
                    break;
                default:
                    res[index] = Integer.parseInt(op);
                    index++;
                    break;
            }
        }
        int ans = 0;
        for(int re : res){
            ans += re;
        }
        return ans;
    }
}
