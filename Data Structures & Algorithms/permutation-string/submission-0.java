class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s2.length()<s1.length()){
            return false;
        }

        int[] ar = new int[26];
        for(char s : s1.toCharArray()){
            ar[s -'a']++;
        }

        int[] occurence = new int[26];

        int left=0;

        for(int right = 0; right< s2.length(); right++){

            char ch = s2.charAt(right);
            occurence[ch -'a']++;

            if(right-left+1==s1.length()){
                
                if(Arrays.equals(ar,occurence)){
                    return true;
                } else {
                    occurence[s2.charAt(left) -'a']--;
                    left++;
                }
            }

        }

        return false;
    }
}
