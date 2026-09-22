/*

nums = [1, 2, 4, 6]

output = [48, 24, 12, 8]

forward = [1, 1, 2, 8]

backward = [48, 24, 6, 1]

res = forward x backward

optimization:

nums = [1, 2, 4, 6]

output = [48, 24, 12, 8]

res = [1, 1, 2, 8]

prefix = 1, 2, 

res[i] = prefix * nums[i - 1]
prefix = res[i]

res[1] = 1 x 1 = 1; prefix = 1 x 1 = 1
res[2] = 1 x 2 = 2; prefix = 1 x 2 = 2
res[3] = 2 x 4 = 8; prefix = 8 

res = [1, 1, 2, 8] [1, 2, 4, 6]

[48, 24, 6, 1]

suffix = 1

res[i] = suffix * res[i] * nums[i + 1]
suffix = suffix * nums[i+1]

res[2] = 1 x 2 x 6 = 12
suffix = 1 x 6 = 6

res[1] = 6 x 1 x 4 = 24
suffix = 24

res[0] = 24 x 1 x 2 = 48

res = [.     ,12 ,8]




*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        // int[] forward = new int[nums.length];
        // int[] backward = new int[nums.length];
        int[] res = new int[nums.length];
        int suffix = 1;

        Arrays.fill(res, 1);
        // Arrays.fill(backward, 1);

        for(int i = 1; i < nums.length; i++)
            res[i] = res[i - 1] * nums[i - 1];

        for(int i = nums.length - 2; i >= 0; i--){
            res[i] = res[i] * suffix * nums[i + 1];
            suffix = suffix * nums[i + 1];
        }
        //     backward[i] = backward[i + 1] * nums[i + 1];

        // for(int i =0; i < nums.length; i++)
        //     res[i] = forward[i] * backward[i];

        return res;
        
    }
}  
