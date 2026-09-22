
class Solution {
    public int[] twoSum(int[] nums, int target) {
        List<Pair<Integer, Integer>> sortedNums = new ArrayList<>();

        for(int i =0; i < nums.length; i++){
            sortedNums.add(new Pair<>(nums[i], i));
        }

        sortedNums.sort((a, b) -> Integer.compare(a.getKey(), b.getKey()));

        int left = 0, right = sortedNums.size() - 1;

        while(left < right){
            int leftEle = sortedNums.get(left).getKey();
            int rightEle = sortedNums.get(right).getKey();
            if(leftEle + rightEle < target)
                left++;
            else if(leftEle + rightEle > target)
                right--;
            else {
                int idx1 = sortedNums.get(left).getValue();
                int idx2 = sortedNums.get(right).getValue();
                return new int[]{Math.min(idx1, idx2), Math.max(idx1, idx2)};
            }
        }
        return new int[]{};
    
    }
}