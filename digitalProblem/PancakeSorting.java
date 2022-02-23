package leetcode.digitalProblem;

import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {

    public static void main(String[] args){
        int[] a = {1};

        System.out.println(pancakeSort(a));
    }

    public static List<Integer> pancakeSort(int[] arr){
        int k = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        if (k == 1) return res;
        int[] table = new int[k + 1];
        int maxIndex = findMaxIndex(arr,table,k);
        while (maxIndex != 1 || k != 2) {
            if (maxIndex != k - 1){
                if (maxIndex == 0){
                    flip(arr,k);
                    res.add(k);
                    maxIndex = k - 1;
                } else{
                    flip(arr,maxIndex + 1);
                    res.add(maxIndex + 1);
                    maxIndex = 0;
                }
            } else{
                k--;
                maxIndex = findMaxIndex(arr,table,k);
            }
        }

        return res;
    }

    private static void flip(int[] arr,int k){
        if (k == 1) return;
        int curK = k;
        int i = 0;//起始点
        if (curK % 2 == 0){
            do {
                arr[i] = arr[i] ^ arr[curK - 1];
                arr[curK - 1] = arr[i] ^ arr[curK - 1];
                arr[i] = arr[i] ^ arr[curK - 1];
                i++;
                curK--;
            } while (i != curK);
        } else{
            do {
                arr[i] = arr[i] ^ arr[curK - 1];
                arr[curK - 1] = arr[i] ^ arr[curK - 1];
                arr[i] = arr[i] ^ arr[curK - 1];
                i++;
                curK--;
            } while (i != curK - 1);
        }
    }

    private static int findMaxIndex(int[] arr,int[] table,int k){
        if (k == 1) return 0;
        int max = 0;

        for(int i = 0; i < k; i++){
            if (max < arr[i]){
                max = arr[i];
                table[max] = i;
            }
        }
        return table[max];
    }
}
