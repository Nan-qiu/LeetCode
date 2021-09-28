package leetcode.sort;

import java.util.Arrays;

public class RadixSort { // 基数排序 桶排序
    public static void main(String[] args){
        int[] a = {234,101,4021,334,72,5,646,21,23};
        radixSort(a,0,a.length - 1,maxSize(a));
        System.out.println(Arrays.toString(a));
    }

    public static int maxSize(int[] arr){ //返回数组中最大值的位数
        if (arr.length < 2) return 0;
        int max = Integer.MIN_VALUE;
        for(int n : arr){
            max = Math.max(max,n);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    public static void radixSort(int[] arr,int L,int R,int digit){// digit是最大值的位数
        final int radix = 10;
        int i, j;
        int[] bucket = new int[R - L + 1];
        for(int d = 1; d <= digit; d++){// 从最低位开始，到最高位
            int[] count = new int[radix];
            for(i = L; i <= R; i++){
                j = getDigit(arr[i],d);// 取出当前arr[i]这个数的 digit位的值
                count[j]++;
            }
            for(i = 1; i < radix; i++){
                count[i] = count[i - 1] + count[i];//累加
            }
            for(i = R; i >= L; i--){// 从右往左遍历
                j = getDigit(arr[i],d);
                bucket[--count[j]] = arr[i];// 若arr[i] 的d位是j，然后去找count数组对应的下标j，若count[j]=n，
            }                               // 那么arr[i] 在bucket数组的下标就为n-1,然后n--
            for(i = L; i <= R; i++){
                arr[i] = bucket[i];
            }
        }
    }

    public static int getDigit(int i,int d){
        return (i / (int) Math.pow(10,d - 1)) % 10;
    }
}
