class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0)
        {
            return 0;
        }
        Set<Integer> numSet = new HashSet<>();
        for(int i =0; i< nums.length; i++) {
            numSet.add(nums[i]);
        }

        int longestSub =1;

        for(Integer num : numSet) {

            if(numSet.contains(num-1)) {
                continue;

            } else {
                int currentNum = num;
                int currentSub = 1;

                while(numSet.contains(currentNum+1)) {
                    currentSub++;
                    currentNum++;
                }

                longestSub = Math.max(longestSub,currentSub);
            }

        }
        return longestSub;
        
    }
}
