package leetcode;

import java.util.Arrays;

public class MergeSortArray {
    public static void main(String[] args){
        int[] nums1 = {0};
        int[] nums2 = {1};
        int m = 0;
        int n = 1;
        merge(nums1,m,nums2,n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1,int m,int[] nums2,int n){
        for(int i = 0; i < n; i++){
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
//        if (nums1==null) return;
//        int p1=0,p2=0,i=0;
//        int[] help=new int[nums1.length];
//        while (p1<m&&p2<n){
//            help[i++]=nums1[p1]<nums2[p2]?nums1[p1++]:nums2[p2++];
//        }
//        while (p1<m){
//            help[i++]=nums1[p1++];
//        }
//        while (p2<m){
//            help[i++]=nums2[p2++];
//        }
//
//        System.arraycopy(help,0,nums1,0,help.length);
    }
}
