class Solution {
    public int findMin(int[] nums) {

        int left = 0, right = nums.length - 1, ans = nums[0];

        while(left<=right){

            if(nums[left]<nums[right]){
                ans = Math.min(ans,nums[left]);
                break;
            }

            int mid = left + (right-left)/2;
            ans = Math.min(ans,nums[mid]);

            if(nums[left]<=nums[mid]){
                left = mid+1;
            } else {
                right = right -1;
            }
        }

        return ans;
        
    }
}
