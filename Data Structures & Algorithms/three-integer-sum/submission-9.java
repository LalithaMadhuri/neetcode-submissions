class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> res = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            int curr = nums[i], left = i + 1, right = nums.length - 1;

            while(left < right){
                if(curr + nums[left] + nums[right] == 0)
                {
                    res.add(List.of(curr, nums[left], nums[right]));
                    left++;
                    right--;
                    continue;
                }
                else if(curr + nums[left] + nums[right] > 0)
                    right--;
                else
                    left++;
            }
        }
        return new ArrayList<>(res);
        
    }
}
