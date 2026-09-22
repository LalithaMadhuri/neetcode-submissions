/*

nums = [1, 2, 4, 6]

res = [48,24, 12, 8]

index 0(starting index) -> product of all elements from i + 1 to n
index 1 -> nums[0] * product of all elements from i+1 to n
index 2 -> nums[0] * nums[1] * product of all elements from i+1 to n
index 3(last index) -> product of elements from 0 to n - 1


formula = product of elements from 0 to i - 1 * product of elements from i + 1 to n;

res[i] = product(elements[0:i -1], elements[i + 1, n])

product of elements from 0 to i - 1 => prefix[i] = prefix[i - 1] * nums[i - 1]

prefix = [1, 1, 2, 8]

[1, 2, 4, 6] => prefix[1] = 1 * 1 = 1
prefix[2] = 1 * 2 = 2
prefix[3] = 2 * 4 = 8

suffix = [48, 24, 6, 1]

[1, 2, 4, 6] => suffix[i] = suffix[i + 1] * nums[i + 1];

suffix[2] = 1 * 6 = 6, suffix[1] = 6 * 4 = 24
suffix[0] = 24 * 2 = 48 

TC: O(N) + O(N) + O(N) = O(N)
SC: O(N) + O(N) + O(N) = O(N)



-------

prefix = 1; [1, 2, 4, 6] prefix *= nums[i - 1] 

res = [48, 24, 12, 8]

First pass => res =  [1, 1, 2, 8] 
                     [1, 2, 4, 6]

                     [48,24,6,1]

                     2 x 24,4 x 6,1x 6,1
                     

suffix = suffix[i + 1] * nums[i + 1]; 

suffix = 1; suffix = nums[i + 1] * res[i + 1] * suffix;
            res[i] = suffix;

Second pass => [1(pre) x 2 x 4 x 6(suff) ,1(pre) x 4 x 6(suff), 2(pre) x 6 x 1(suff),8(pre) x 1(suff)]

suffix = 1

res[i] = res[i] * suffix 
suffix = suffix * nums[i]

=> [ ,4824,12,8]




*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] prefix = new int[n], suffix = new int[n], res = new int[n];

        prefix[0] = 1;
        suffix[n - 1] = 1;

        for(int i = 1; i < n; i++)
            prefix[i] = prefix[i - 1] * nums[i - 1];

        for(int i = n - 2; i >= 0; i--)
            suffix[i] = suffix[i + 1] * nums[i + 1];

        for(int i = 0; i < n; i++)
            res[i] = prefix[i] * suffix[i];

        return res;

        
        
    }
}  
