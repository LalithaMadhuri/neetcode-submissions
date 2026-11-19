"""
height = [1, 7, 2, 5, 4, 7, 3, 6]

max area or max water 

2 heights => area = min(height[i], height[j]) * (j - i)

area increases as width increases and min height increases

1 < 7 => l = 1, b = 1
1 < 2 => l = 1, b = 2
1 < 5 => l = 1, b = 3
1 < 4 => l = 1, b = 4
1 < 7 => l = 1, b = 5
1 < 3 => l = 1, b = 6
1 < 6 => l = 1, b = 7 => area = 7

7 > 2 => l = 2, b = 1 
7 > 5 => l = 5, b = 2
7 > 4 => l = 4, b = 3
7 >= 7 => l = 7, b = 4
7 > 3 => l = 3, b = 5
7 > 6 => l = 6, b = 6 => area = 36

2 < 5 => l = 2, b = 1
2 < 4 => l = 2, b = 2
2 < 7 => l = 2, b = 3
2 < 3 => l = 2, b = 4
2 < 6 => l = 2, b = 5

5 > 4 => l = 4, b = 1


i = 0, j = 1, area = 1
    
[1, 2, 1]

area = 2 

1. Fixate on the max most length (0, len(nums) - 1)
2. Try to see if you can maximize height
    3. Try to see if you can find a greater minimum height
        height[i] < height[j] => minimum height here is height[i] so see if you can find a higher height by incrementing i
            i += 1
        else 
            j -= 1

1 < 2 
area = 1
i = 1, j = 2


1 < 6 => i ++

7 > 6 => j--
7 > 3 => j--
7 >= 7 => j--
7 > 4 => j--
7 > 5 => j--
7 > 2 => j--



"""
class Solution:
    def maxArea(self, heights: List[int]) -> int:
        i = 0
        j = len(heights) - 1
        area = 0

        while i < j and j < len(heights):
            area = max(area, min(heights[i], heights[j]) * (j - i))
            if heights[i] < heights[j]:
                i += 1
            else:  
                j -= 1
        return area


        