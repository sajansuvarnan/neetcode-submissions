class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n - 1; i++) {

            if (temperatures[i] < temperatures[i + 1]) {
                ans[i] = 1;
            } else {
                stack.push(i);
            }

            while (!stack.isEmpty()
                    && temperatures[stack.peek()] < temperatures[i + 1]) {

                int j = stack.pop();
                ans[j] = i + 1 - j;
            }
        }

        return ans;
    }
}