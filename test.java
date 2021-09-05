package leetcode;

import java.util.Arrays;

public class test {
    public static void main(String[] args){
        int[] arr ={1,1,2,3,3};
        System.out.println(method(arr));

    }
    public static int method(int[] arrs){
        int single = 0;
        for (int num : arrs) {
            single ^= num;
        }
        return single;

//        boolean[] tar=new boolean[arrs.length];
//        Arrays.fill(tar,false);
//        for(int i = 0; i < arrs.length; i++){
//            for(int j = i+1; j < arrs.length; j++){
//                if (arrs[i]==arrs[j]){
//                    tar[i]=true;
//                    tar[j]=true;
//                }
//            }
//        }
//        for(int i = 0; i < tar.length; i++){
//            if (!tar[i]){
//                return arrs[i];
//            }
//        }
//        return 0;
    }
}
