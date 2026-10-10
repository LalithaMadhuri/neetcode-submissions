/*

nums1 = [1, 4, 7]
nums2 = [2, 3, 8, 9]

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




*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        List<Integer> res = new ArrayList<>();

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
        return res.get((m + n - 1)/2);
        
    }
}
