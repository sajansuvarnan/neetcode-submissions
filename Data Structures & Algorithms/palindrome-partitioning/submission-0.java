class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();
        backtrack(s, result, new ArrayList<>(), 0);
        return result;
    }

    public void backtrack(String s, List<List<String>> result,
     List<String> current, int start) {

        if(s.length() == start) {
            result.add(new ArrayList<>(current));
        }


        for(int end = start; end < s.length(); end++) {

            if(isPalindrome(s, start, end)) {
                current.add(s.substring(start, end+1));
                backtrack(s, result, current, end+1);
                current.remove(current.size() - 1);
            }
        }
     }


    public boolean isPalindrome(String str, int left, int right) {

        while(left<right) {

            if(str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
