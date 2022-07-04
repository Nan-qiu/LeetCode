package leetcode.sort;

import java.util.Arrays;

public class AllSort {
    public static void main(String[] args){
        int[] a = {2, 6, 8, 1, 3, 7, 12, 4, -8, 5, 13, 8, 0};
        AllSort allSort = new AllSort();
//        allSort.BubbleSort(a);
//        allSort.selectionSort(a);
//        allSort.insertionSort(a);
        allSort.shellSort(a);
        System.out.println(Arrays.toString(a));
    }

    public void BubbleSort(int[] nums){
        for(int i = 1; i < nums.length; i++){
            boolean flag = true;
            for(int j = 0; j < nums.length - i; j++){
                //当前位置和下一个位置比
                if (nums[j] > nums[j + 1]){
                    swap(nums, j, j + 1);
                    flag = false;
                }
            }
            //若flag是true，说明整个数组都是升序了，就排好了
            if (flag) break;
        }
    }


    public void selectionSort(int[] nums){

        for(int i = 0; i < nums.length; i++){
            //记录最小值的下标
            int min = i;
            for(int j = i + 1; j < nums.length; j++){
                //找到更小的就更新 min
                if (nums[min] > nums[j]) min = j;
            }
            //如果min和起始位置i不一样的话，就说明找到了更小的数，交换
            if (i != min) swap(nums, i, min);
        }
    }


    public void insertionSort(int[] nums){
        //0位置默认有序
        for(int i = 1; i < nums.length; i++){

            //选择当前下标为i的元素
            int tem = nums[i];
            int j = i;
            //把当前元素和它的前一个比较，
            while (j > 0 && tem < nums[j - 1]) {
                nums[j] = nums[j - 1];
                j--;
            }
            if (i != j) nums[j] = tem;

//            for(int j = i - 1; j >= 0; j--){
//                if (nums[j] > nums[j+1]) swap(nums, j, j+1);
//                else break;
//            }
        }
    }


    public void shellSort(int[] nums){
        int length = nums.length;
        while (length > 0) {
            //选择一个增量
            length /= 2;
            for(int i = length; i < nums.length; i++){
                int j = i;
                int tem = nums[j];
                while (j - length >= 0 && tem < nums[j - length]) {
                    nums[j] = nums[j - length];
                    j -= length;
                }
                if (i != j) nums[j] = tem;
            }
        }
    }


    private void swap(int[] nums, int i, int j){
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
}
