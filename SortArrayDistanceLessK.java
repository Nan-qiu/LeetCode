package leetcode;

import java.util.PriorityQueue;

public class SortArrayDistanceLessK {
    public static void main(String[] args){
        int[] a={0,1,2,3,4,5,6,7};
        sortArrayDistanceLessK(a,4);

    }
    public static void sortArrayDistanceLessK(int[] arr,int k){
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index=0;
        for(;index<Math.min(arr.length,k);index++){
            heap.add(arr[index]);
        }
        int i=0;
        for(;index<arr.length;i++,++index){
            heap.add(arr[index]);
            arr[i]=heap.poll();
        }
        while (!heap.isEmpty()){
            arr[i++]=heap.poll();
        }
    }
}
