/*
input = [1, 7, 2, 5, 4, 7, 3, 6] output = 36

Maximum area = length * breadth (more the length more the area and more breadth moe the area)

Breadth is limited by shorted height between 2 bars (1, 6) area = 7 * 1(breadth)

move the pointer at shorter breadth to see if you can find a better breadth than curr shorter breadth

(left, right) = (0, nums.length - 1)

(1, 6) => area and increment left++ to see if higher breadth can be obtained




max area between 2 bars 

1. Calculate area between 2 bars and move horizontally to see if area can be maximized

=> (7, 6) => area = 6 * 6 = 36

=> (1, 7) => area = 1 * 1 = 1 
=> (1, 2) => area = 2 * 1 = 2
=> (1, 5) => area = 3 * 1 = 3
=> (1, 4) => area = 4 * 1 = 4
=> (1, 7) => area = 5 * 1 = 5
=> (1, 3) => area = 6 * 1 = 6
=> (1, 6) => area = 7 * 1 = 7

=> (7, 2) => area = 1 * 2
=> (7, 5) => area = 2 * 5
=> (7, 4) => area = 3 * 4
=> (7, 7) => area = 4 * 7 = 28
=> (7, 3) => area = 5 * 3 = 15
=> (7, 6) => area = 6 * 6 = 36

keep track of max length and max breadth pbserved so far

*/

class Solution {
    public int maxArea(int[] heights) {

        int res = 0, left = 0, right = heights.length - 1;

        while(left < right){
            int area = Math.min(heights[left], heights[right]) * (right - left);
            res = Math.max(area, res);

            if(heights[left] >= heights[right])
                right--; // decrement to see if we can find a better breadth
            else
                left++;
        }
        return res;

        
    }
}
