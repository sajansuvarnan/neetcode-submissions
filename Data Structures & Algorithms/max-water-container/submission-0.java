class Solution {
    public int maxArea(int[] heights) {

        int capacity = 0;
        int max =0;

        int left = 0;
        int right = heights.length-1;

        while(left<right) {

            capacity = (right-left) * Math.min(heights[left],heights[right]);
            if(max<capacity) {
                max = capacity;
            }

            if(heights[left]<heights[right]){
                left++;
            } else{
                right--;
            }
        }
        
        return max;
    }
}
