class Solution {

    public String encode(List<String> strs) {

        String encode="";

        for(String s: strs)
        {
            encode = encode + s + '-';
        }

        return(encode);

    }

    public List<String> decode(String str) {

        ArrayList<String> list = new ArrayList<>();

        String temp ="";

        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='-')
            {
                list.add(temp);
                temp="";
            }
            else
            {
                temp = temp + str.charAt(i);
            }
        }

        return(list);

    }

}
