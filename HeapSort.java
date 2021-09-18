package leetcode;

public class HeapSort {
    public static void main(String[] args){
        int[] a = {2,1,4,3,7,5,6,0,2};
        heapSort(a);
        for(int n : a){
            System.out.println(n);
        }
    }

    public static void heapSort(int[] arr){
        if (arr.length < 2 || arr == null){
            return;
        }
        for(int i = 0; i < arr.length; i++){
            heapInsert(arr,i);
        }
        int heapSize = arr.length;
        while (heapSize > 0) {
            swap(arr,0,--heapSize);
            heapify(arr,0,heapSize);
        }
    }

    public static void heapInsert(int[] arr,int index){// 和它的父比较，大就和父交换
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr,index,(index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr,int index,int heapSize){
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = arr[left] > arr[left + 1] && left + 1 < heapSize
                    ? left : left + 1;// 两个孩子比大小，大的赋给largest
            largest = arr[index] > arr[largest] ? index : largest;
            if (largest == index){
                break;
            }
            swap(arr,index,largest);
            index = largest;// 目标下标来到大孩子的位置
            left = index * 2 + 1;// 生成新的左孩子
        }
    }

    public static void swap(int[] arr,int i,int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
