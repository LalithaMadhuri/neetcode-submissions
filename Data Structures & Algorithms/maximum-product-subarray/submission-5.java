class Solution {
    public int maxProduct(int[] nums) {
        int min = nums[0], max = nums[0], res = nums[0];

        for(int i =1; i<nums.length; i++){
            int num= nums[i];

            if(num<0){ // swap maxProduct with minProduct since multiplying with a negative number will flip the max and min products
                int val = min;
                min = max;
                max = val;
            }

            // 2 choices: 1. start a new subarray with curr ele or extend max/min product
            min = Math.min(num, num * min);
            max = Math.max(num, num * max);
            res = Math.max(res, max);
        }
        return res;
        
    }
}
