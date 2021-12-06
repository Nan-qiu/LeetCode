package leetcode.digitalProblem;

import java.util.Arrays;

public class ConstructTheRectangle {
    public static void main(String[] args){
        System.out.println(Arrays.toString(constructRectangle(122122)));
    }

    public static int[] constructRectangle(int area){
        int limit = (int) Math.sqrt(area); //limit相当于宽W
        while (area % limit != 0) { //当area%limit==0，说明limit能整除area
            --limit;
            if (limit == 0) return new int[]{0,0};
        }
        return new int[]{area / limit,limit}; //area/limit 就是L
    }

    public static int[] constructRectangle1(int area){
        int limit = (int) Math.sqrt(area);
        int W, L;
        for(W = limit; W >= 1; W--){
            for(L = 1; L * W <= area; L++){
                if (L * W == area) return new int[]{L,W};
            }
        }
        return new int[]{0,0};
    }
}
