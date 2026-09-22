class Solution {
    public int maxArea(int[] heights) {
        int res = Integer.MIN_VALUE;
        int left = 0, right = heights.length - 1;

        while(left < right){
            int area = Math.min(heights[left], heights[right]) * (right - left);
            res = Math.max(res, area);
            if(heights[left] >= heights[right]){
                right--;  
            }
            else{
                left++;
            }
        }
        return res;
        
    }
}
