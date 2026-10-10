/*

nums1 = [1, 4, 7]
nums2 = [2, 3, 8, 9] 

left1 = 4, right1 = 7, right2 = 8, left2 = 3
[1, 4 | 7] left1 <= right1 
[2, 3 | 8, 9] left2 <= right2

left = 0 in nums1 
right = 0 in nums2

a) nums1[left] <= nums2[right] 
    add nums1[left] to res
    left++;
       
b) nums1[left] > nums2[right] 
    add nums2[right] to res
    right++;


c) If either one of the array reaches end
    add remaining elements in array that dint reach end to res

left = 3, right = 2, res = [1 2 3 4 7 8 9]
1 < 2 

 [1, 3] [2, 4]

 res = [1, 2, 3, 4]


 Binary Search

 1. Choose a smaller array
 2. low = 0, high = m 
 3. while low <= high 
    i = low + high // 2
    j = (m + n + 1)/2 - 1;

    if(left1 > right2) 
        i--;
        j++;
    else if(left2 > right1)
        i++;
        j--;
    else
        // found a valid partition
            return median




*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;

        int[] smallerArray = m <= n ? nums1: nums2;
        int[] biggerArray = m <= n ? nums2: nums1;

        


        int low = 0, high = smallerArray.length;
        int half = (m + n + 1)/2;

        while(low <= high){
            int i = (low + high)/2;
            int j = half - i;


            int left1 = (i == 0) ? Integer.MIN_VALUE: smallerArray[i - 1]; 
            int right1 = (i == smallerArray.length)? Integer.MAX_VALUE: smallerArray[i];
            int left2 = (j == 0) ? Integer.MIN_VALUE: biggerArray[j - 1]; 
            int right2 = (j == biggerArray.length) ? Integer.MAX_VALUE:  biggerArray[j];

            if(left1 > right2)
                high = i - 1;
            else if(left2 > right1)
                low = i + 1;
            else
            {
                
                // odd or even
                return (m + n) % 2 == 0 ? (Math.max(left1, left2) + Math.min(right1, right2))/2.0: Math.max(left1, left2);

                
            }
        }
        return 0.0;



        /*List<Integer> res = new ArrayList<>();

        // 2 pointer approach to merge array

        int left = 0, right = 0;

        while(left < m && right < n){
            if(nums1[left] <= nums2[right]){
                res.add(nums1[left]);
                left++;
            }
            else
            {
                res.add(nums2[right]);
                right++;
            }
        }

        if(left == m){
            for(int i = right; i < n; i++)
                res.add(nums2[i]);
        }
        if(right == n){
            for(int j = left; j < m; j++)
                res.add(nums1[j]);

        }


        if((m + n)%2 == 0){
            int middle = (m + n - 1)/2;
            
            return (res.get(middle) + res.get(middle + 1))/2.0;

        }
        return res.get((m + n - 1)/2); */
        
    }
}
