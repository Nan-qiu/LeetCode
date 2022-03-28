package leetcode.stringProblem;

import java.util.Arrays;

public class PlatesBetweenCandles {
    public static void main(String[] args){
        int[][] n = {{2,5},{5,9}};
        String s = "**|**|***|";
        System.out.println(Arrays.toString(platesBetweenCandles1(s,n)));
    }

    //前缀数组的用法
    public static int[] platesBetweenCandles1(String s,int[][] queries){
        char[] chars = s.toCharArray();
        int[] res = new int[queries.length];
        //从后往前看的蜡烛数量
        int[] next = new int[chars.length];
        //从前往后看的蜡烛数量
        int[] pre = new int[chars.length];
        //盘子数量
        int[] value = new int[chars.length];
        int index = -1;
        //next
        for(int i = 0; i < chars.length; i++){

            if (chars[i] == '|') index = i;
            next[i] = index;
        }
        System.out.println("next = " + Arrays.toString(next));
        //pre
        index = -1;
        for(int i = chars.length - 1; i >= 0; i--){
            if (chars[i] == '|') index = i;
            pre[i] = index;
        }
        System.out.println("pre = " + Arrays.toString(pre));
        //value
        //boolean flag = false;
        int count = 0;
        for(int i = 0; i < chars.length; i++){

//            if (!flag && chars[i] == '|'){
//                flag = true;
//            } else if (flag && chars[i] == '*'){
//                count++;
//            }
//            value[i] = count;
            if (chars[i] == '*') count++;
            value[i] = count;
        }
        System.out.println("value = " + Arrays.toString(value));

        for(int i = 0; i < queries.length; i++){
            if (next[queries[i][1]] == -1 || pre[queries[i][0]] == -1 || pre[queries[i][0]] >= next[queries[i][1]])
                res[i] = 0;
            else res[i] = value[next[queries[i][1]]] - value[pre[queries[i][0]]];
        }
        return res;
    }


    public static int[] platesBetweenCandles(String s,int[][] queries){
        char[] chars = s.toCharArray();
        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            boolean flag = false;
            int index = 0;
            for(int j = queries[i][0]; j <= queries[i][1]; j++){
                if (!flag && chars[j] == '|'){
                    flag = true;
                    index = j;
                } else if (flag && chars[j] == '|'){
                    res[i] += j - index - 1;
                    index = j;
                }
            }
        }
        return res;
    }
}
