class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet <Character>[] rows = new HashSet[9];
        HashSet <Character>[] columns = new HashSet[9];
        HashSet <Character>[] box = new HashSet[9];

        for(int r=0;r<9;r++)
        {
            rows[r] =new HashSet<Character>();
            columns[r] =new HashSet<Character>();
            box[r] =new HashSet<Character>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                char val = board[r][c];

                if (val == '.') {
                    continue;
                }

                if (rows[r].contains(val)) {
                    return false;
                }
                rows[r].add(val);


                if (columns[c].contains(val)) {
                    return false;
                }

                columns[c].add(val);

                int idx = (r/3) * 3 + c/3;
                if (box[idx].contains(val)) {
                    return false;
                }

                 box[idx].add(val);



            }
        }

        return true;
    }

}