class Solution {
    public boolean isValid(String s) {
        
        HashMap<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');

        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){

            if(ch=='(' || ch=='[' ||ch=='{'){
                stack.push(ch);
            } else {

                if(stack.isEmpty()){
                    return false;
                }

                char ph = stack.pop();
                if(ch == map.get(ph)){
                    continue;
                } else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
