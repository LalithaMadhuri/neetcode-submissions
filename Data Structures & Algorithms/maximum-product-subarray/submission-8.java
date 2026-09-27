/*

nums = [2, 4, -3, 5]

1. Maximum product of a subarray
2. Array should be contiguous

Kadane's algorithm!

1. Extend current subarray
2. Start a new subarray

currProduct = 1, maxProduct = Integer.MIN_VALUE;

for each num:
    extend = currProduct * num;
    start = num;

    currProd = Math.max(extend, start)
    maxProd = Math.max(currProd, maxProd)

[-2,3, -4] => 

maxProd = 24
minProd = 24
num = -4

newMin = -4
newMax = 24

finalProd = 24

[10, 0, 5, 6, 0, 10]

maxProd = 30
minProd = 0
num = 6

newMin = 0
newMax = 30

prod = 30


*/
class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 1)
            return nums[0];

        int maxProd = nums[0], minProd = nums[0], finalProd = nums[0];

        for(int i = 1; i < nums.length; i++){
            maxProd = maxProd * nums[i];
            minProd = minProd * nums[i];

            int newMinProd = Math.min(maxProd, Math.min(minProd, nums[i]));
            int newMaxProd = Math.max(maxProd, Math.max(minProd, nums[i]));

            maxProd = newMaxProd;
            minProd = newMinProd;

            finalProd = Math.max(finalProd, Math.max(newMinProd, newMaxProd));


            
        }
        return finalProd;
        
    }
}
