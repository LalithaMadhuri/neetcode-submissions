class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            int search = nums[i];
            int l = i + 1, r = nums.length - 1;
            while(l < r){
                if(nums[l] + nums[r] + search < 0)
                    l++;
                else if(nums[l] + nums[r] + search > 0)
                    r--;
                else if(nums[l] + nums[r] + search == 0){
                    res.add(List.of(nums[l], nums[r], search));
                    l++;
                    r--;
                }
                else{
                    l++;
                    r--;
                }   
            }
        }
        return new ArrayList(res);
        
    }
}
