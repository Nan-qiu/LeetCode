package leetcode.digitalProblem;

import java.util.ArrayList;
import java.util.Comparator;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args){
        int[] a = {0,0,0,0,0};
        int[] b = {-1,0,0,0,0,0,1};

        System.out.println(findMedianSortedArrays(a,b));
    }

    public static double findMedianSortedArrays(int[] nums1,int[] nums2){
        ArrayList<Integer> list = new ArrayList<>();
        for(int a : nums1){
            list.add(a);
        }
        for(int a : nums2){
            list.add(a);
        }
        double mid = 0;
        list.sort(Comparator.naturalOrder());
        System.out.println(list);
        if (list.size() % 2 == 0){//为偶数时
            mid = (double) ((list.get((list.size()-1)/2) + list.get(list.size()/2)))/2;
        } else{//为奇数
            mid = list.get(list.size()/2);
        }
        return mid;
//        double mid1 = 0;
//        double mid2 = 0;
//        if (nums1.length % 2 == 0){//为偶数时
//            mid1 = (double) (nums1[(nums1.length - 1) / 2] + nums1[((nums1.length - 1) / 2) + 1]) / 2;
//        } else{//为奇数
//            mid1 = nums1[(nums1.length - 1) / 2];
//        }
//        if (nums2.length % 2 == 0){//为偶数时
//            mid2 = (double) (nums1[(nums2.length - 1) / 2] + nums2[((nums2.length - 1) / 2) + 1]) / 2;
//        } else{//为奇数
//            mid2 = nums2[(nums2.length - 1) / 2];
//        }
//        return (mid1 + mid2) / 2;


//        HashSet<Integer> set = new HashSet<>();
//        for(int a : nums1){
//            set.add(a);
//        }
//        for(int a : nums2){
//            set.add(a);
//        }
//        System.out.println(set);
//        Integer[] sum = set.toArray(new Integer[0]);
//        System.out.println(Arrays.toString(sum));
//        if (sum.length % 2 == 0){
//            return (double) (sum[((sum.length - 1) / 2)] + sum[((sum.length - 1) / 2) + 1]) / 2;
//        } else{
//            return (double) sum[((sum.length - 1) / 2)];
//        }

    }
}
