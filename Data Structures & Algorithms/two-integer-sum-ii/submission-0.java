class Solution {
    public int[] twoSum(int[] numbers, int target) {

        
        int[] answer = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {

                if (i != j && (numbers[i] + numbers[j] == target)) {
                 answer[0]=i+1;
                 answer[1]=j+1;

                 return answer;
                }
            }
        }

        return answer;
    }
        
}
