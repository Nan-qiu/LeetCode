package leetcode.digitalProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {
    public static void main(String[] args){
        int[] a = {1,3,5,2,4};
        int[] b = {6,5,4,3,2,1,7};
        System.out.println(Arrays.toString(monotonicStack(a,b)));
    }

    public static int[] monotonicStack(int[] nums1,int[] nums2){//单调栈
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = nums2.length - 1; i >= 0; i--){ //倒着来
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {// 如果栈不为空且栈顶元素小于当前元素，就把栈顶元素弹出
                stack.pop();
            }
            map.put(nums2[i],stack.isEmpty() ? -1 : stack.peek());//key为当前数字，栈空时，value=-1，else value=栈顶元素
            stack.push(nums2[i]);// 把当前数字放进栈
        }
        int[] res = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    public static int[] nextGreaterElement(int[] nums1,int[] nums2){
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        int[] maxArr = rightMaxArr(nums2);
        for(int i = nums2.length - 1; i >= 0; i--){
            map.put(nums2[i],i);
        }
        for(int a : nums1){
            if (map.containsKey(a)){
                list.add(maxArr[map.get(a)]);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] rightMaxArr(int[] arr){
        if (arr.length == 1) return new int[]{-1};
        int[] res = new int[arr.length];
        Arrays.fill(res,-1);
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                if (arr[j] > arr[i]){
                    res[i] = arr[j];
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(res));
        return res;
    }
}
