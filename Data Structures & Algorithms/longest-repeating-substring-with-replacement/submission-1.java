class Solution {
    public int characterReplacement(String s, int k) {

        int left = 0;
        int right = 0;
        int max = 0;
        int[] ar = new int[26];

        while(right<s.length()){

            ar[s.charAt(right) -'A']++;
            int freq = Arrays.stream(ar).max().getAsInt();
            int valid = (right -left +1) - freq;

            if(valid <=k){
                max = Math.max(max,right -left+1);
            } else {
                ar[s.charAt(left) -'A']--;
                left++;
            }

            right++;
        }

        return max;
    }
}
