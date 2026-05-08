class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {


        if(nums==null || nums.length == 0 || k<=0){
            return new int[0];
        }

        int n = nums.length;
        
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[n -k +1];


        for(int i = 0; i< n; i++){

            while(!deque.isEmpty() && deque.peek() < i-k+1 ){
                deque.poll();
            }

            while(!deque.isEmpty() && nums[deque.peekLast()]< nums[i]){
                deque.pollLast();
            }

            deque.offerLast(i);

            if(i+1>=k){
                result[i-k+1] = nums[deque.peek()];
            }
        }

        return result;
        
    }
}
