class Solution {
    public int[] productExceptSelf(int[] nums) {

        int prefix = 1;
        int sufix = 1;

        int[] total = new int[nums.length];

        Arrays.fill(total,1);

        for(int i =0;i<nums.length;i++)
        {
            total[i] = prefix;
            prefix = prefix  * nums[i];
        }
        for(int j = nums.length-1;j>=0;j--)
        {
            total[j] = total[j] * sufix;
            sufix = sufix * nums[j];
        }

        return(total);
        
    }
}  
