package leetcode.digitalProblem;

public class RangeSumQueryMutable {

    class NumArray {

        int[] cur;
        int[] preSum;

        public NumArray(int[] nums){
            cur = nums;
            preSum = new int[nums.length + 1];
            for(int i = 0; i < cur.length; i++){
                insert(i, cur[i]);
            }
        }

        public void update(int index, int val){
            int x = index + 1;
            while (x < preSum.length) {
                preSum[x] += -cur[index] + val;
                x += lowBit(x);
            }
            cur[index] = val;
        }

        public int sumRange(int left, int right){
            return query(right + 1) - query(left);
        }

        private int lowBit(int x){
            return x & -x;
        }

        private void insert(int i, int val){
            int x = i + 1;
            while (x < preSum.length) {
                preSum[x] += val;
                x += lowBit(x);
            }
        }

        private int query(int x){
            int res = 0;
            while (x > 0) {
                res += preSum[x];
                x -= lowBit(x);
            }
            return res;
        }

    }


    class NumArray1 {

        int[] cur;
        int[] preSum;

        public NumArray1(int[] nums){
            cur = nums;
            preSum = new int[nums.length + 1];
            for(int i = 1; i < preSum.length; i++){
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
        }

        public void update(int index, int val){
            int i1 = cur[index] - val;
            cur[index] = val;
            for(int i = index + 1; i < preSum.length; i++){
                preSum[i] -= i1;
            }
        }

        public int sumRange(int left, int right){
            return preSum[right + 1] - preSum[left];
        }
    }

}
