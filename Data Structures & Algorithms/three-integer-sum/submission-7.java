class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int left = i+1, right = nums.length - 1;
            while(left < right){
                if(nums[left] + nums[right] + num == 0){
                    res.add(List.of(num, nums[left], nums[right]));
                    left++;
                    right--;
                    continue;
                }
                else if(nums[left] + nums[right] + num < 0){
                    left++;
                    continue;
                }
                else if(nums[left] + nums[right] + num > 0){
                    right--;
                    continue;
                }
                    
            }
        }
        return new ArrayList<>(res);
        
    }
}
