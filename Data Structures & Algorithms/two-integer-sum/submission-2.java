class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int temp =0;
        Map<Integer,Integer> st = new HashMap<>();
        int[] result = new int[2];

        for(int i =0;i<nums.length;i++)
        {
          
                temp = target - nums[i];

                if(st.containsKey(temp))
                {
                    result[0] = st.get(temp);
                    result[1] = i;
                }
                else 
                {
                    st.put(nums[i],i);
                }
          
        }

        return(result);
    }
}
