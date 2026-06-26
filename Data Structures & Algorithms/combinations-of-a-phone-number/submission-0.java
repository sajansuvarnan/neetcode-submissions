class Solution {

    private final String[] map = {
         "",
         "",
         "abc",
         "def",
         "ghi",
         "jkl",
         "mno",
         "pqrs",
         "tuv",
         "wxyz"
    };


    public List<String> letterCombinations(String digits) {


        List<String> result = new ArrayList<>();

        if(digits == null || digits.length() < 1) {
            return result;
        }

        backtrack(digits, result, new StringBuilder(), 0);
        return result;
    }


    public void backtrack(String digits, List<String> result, StringBuilder current, int start) {

        if(start == digits.length()){
            result.add(current.toString());
            return;
        }

        String letters = map[digits.charAt(start) - '0'];

        for(char ch : letters.toCharArray()) {
            current.append(ch);
            backtrack(digits, result, current, start + 1);
            current.deleteCharAt(current.length() -1);
        }
    }
}
