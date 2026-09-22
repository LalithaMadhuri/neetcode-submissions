/*

input = [2, 20, 4, 10, 3, 4, 5]

output = longest consecutive sequence that can be formed => 4

SORT
[2,3,4,5,10,20] => output = 4

TC: O(NlogN)
SC: o(1)

Set

<2, 20, 4, 10, 3, 5>

Loop through every ele in set

=> 2 => 2 - 1 is in hashset => If not, then length = 1; currNum + length is in hashset and keep updating our length to store max length

=> 2 => 2 - 1 not in set => len = 1=> 2 + 1 in set ? length = 2 => 2 + 2 = 4 in set? len = 3 2 + 3 = 5 in set? len = 4 and 2 + 4 = 6 in set ? No store max len into res

=> 20 => 20 -1 in set ? No len = 1 => 20 + 1 in set ? No skip while loop 

=> 4 => 4 - 1 = 3 in set ? Yes skip
=> 10 - 1 = 9 in set ? No => len = 1 10 + 1 in set ? No skip while loop

TC: O(N) for adding ele to set + O(N) avergae case for hash set
SC: O(U)








*/

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> unique = new HashSet<>();
        int res = 0;
        for(int num: nums){
            unique.add(num);
        }

        for(int num: unique){
            if(!unique.contains(num - 1)){ // this is where our consecutive seq can start
                int len = 1; 

                while(unique.contains(num + len))
                    len++;

                res = Math.max(len, res);
            }
        }
        return res;
        
    }
}
