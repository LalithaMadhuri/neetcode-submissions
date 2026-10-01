/*

nums = [1, 2, 3, 4]

1. Divide the input array into 2 subsets 
2. sum(subset1) == sum(subset2)

Conditions:

(i) If totalSum == odd => return false
(ii) targetSum of each subset = totalSum/2

2D DP

1. Optimal substructure


2 choices 
 a) Include current num as part of sum
 b) Exclude current num as part of sum 

 nums[index] + currSum, currSum

2. Definition of dp
 
    index -> to track the current element in nums
    currSum -> to specify if target sum can be achieved using current sum

    dp[index][currSum] specifies if target sum is achievable using currSum and nums from index 




 Recurrence relation 

 dp[index][currSum] = dp[index + 1][currSum + nums[index]] || dp[index + 1][currSum]

 3. Base case

 index == nums.length => reached end of nums and cannot find any subsets to reach target => return false

 currSum == targetSum => return true

 


  



*/


class Solution {
    int targetSum;
    int[] nums;
    public boolean canPartition(int[] nums) {
        this.nums = nums;
        
        int totalSum = 0;

        for(int num: nums)
            totalSum += num;

        if(totalSum % 2 != 0)
            return false;

        this.targetSum = totalSum/2;



        return bottomUp(new Boolean[nums.length + 1][targetSum + 1], 0, 0);
        
    }

    private boolean bottomUp(Boolean[][] memo, int index, int currSum){
        if(index == nums.length) return false;
        if(currSum == targetSum) return true;
        if(currSum > targetSum) return false;
        if(memo[index][currSum] != null) return memo[index][currSum];

        boolean include = false, exclude = false;

        if((index + 1) < nums.length){
            include = bottomUp(memo, index + 1, nums[index + 1] + currSum);
            exclude = bottomUp(memo, index +1, currSum);
        }

        memo[index][currSum] = include || exclude;

        return memo[index][currSum];
            

    }
}
