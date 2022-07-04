package leetcode.digitalProblem;

import java.util.ArrayList;
import java.util.HashMap;

public class InsertDeleteGetRandomO1 {
    public static void main(String[] args){
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(0);
        randomizedSet.getRandom();
        randomizedSet.remove(0);
        System.out.println(randomizedSet.insert(0));

    }

    static class RandomizedSet {
        ArrayList<Integer> list;
        HashMap<Integer, Integer> map;

        public RandomizedSet(){
            list = new ArrayList<>();
            map = new HashMap<>();
        }

        public boolean insert(int val){
            if (map.containsKey(val)) return false;
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }

        public boolean remove(int val){
            if (!map.containsKey(val)) return false;
            int index = map.get(val);
            int last = list.get(list.size() - 1);
            list.set(index,last);

            map.put(last,index);
            map.remove(val);
            list.remove(list.size() - 1);
            return true;
        }

        public int getRandom(){
            int size = list.size();
            int random = (int) (Math.random() * size);
            return list.get(random);
        }
    }
}
