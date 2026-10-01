/*

nums = [2, 2, 2], targetSum = 2

Number of ways to ADD or SUBTRACT each number to make a targetSum

2D DP

1. Optimal substructure

 2 choices 
    a) Add element at curr index
    b) Subtract element at curr index

 Add a) and b)

2. Definition of dp

index => index of nums
remaining => remaining amount in target

dp[index][rem] represents the number of different ways using num from index to make up the remaining amount

3. Base case

index == nums.length && rem > 0 => return 0
rem < 0 => return 0
rem == 0 => return 1

[2, 2, 2] target = 2

remaining = 2 - 6 = -4 => 6 + 4 = 10

[-6, 6] => [0, 12] 


*/

class Solution {
    int[] nums;
    int target;
    int sum;
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        

        sum = 0;

        for(int num: nums)
            sum += num;

        return targetSumWays(0, 0, new Integer[nums.length + 1][(2*sum) + 1]);

        
    }
    private int targetSumWays(int index, int currSum, Integer[][] memo){
        if(index == nums.length){
            if(currSum == target) return 1;
            else return 0;
        }

        
        int remIndex = sum - currSum;


        if(memo[index][remIndex] != null) return memo[index][remIndex];
       

        int add = targetSumWays(index + 1, nums[index] + currSum, memo);
        int subtract = targetSumWays(index + 1, -nums[index] + currSum, memo);

        memo[index][remIndex] = add + subtract;

        return memo[index][remIndex];
    }
}
