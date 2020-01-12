public class LC36 {
    public boolean isValidSudoku(char[][] board) {
        for (int i=0;i<9;i++) {
            if (!isValidRow(board,i)) return false;
            if (!isValidCol(board,i)) return false;
            if (!isValidBox(board,i)) return false;
        }
        return true;
    }

    private boolean isValidRow(char[][] board,int index) {
        boolean[] cell = new boolean[9];
        for (int i=0;i<9;i++) {
            if (board[index][i]!='.') {
                if (cell[board[index][i]-'1']) return false;
                cell[board[index][i]-'1'] = true;
            }
        }
        return true;
    }

    private boolean isValidCol(char[][] board,int index) {
        boolean[] cell = new boolean[9];
        for (int i=0;i<9;i++) {
            if (board[i][index]!='.') {
                if (cell[board[i][index]-'1']) return false;
                cell[board[i][index]-'1'] = true;
            }
        }
        return true;
    }


    private boolean isValidBox(char[][] board,int index) {
        boolean[] cell = new boolean[9];
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++){
                int x = i+3*(index/3), y = j+3*(index%3);
                if (board[x][y]!='.') {
                    if (cell[board[x][y]-'1']) return false;
                    cell[board[x][y]-'1'] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC36 ans = new LC36();
        char[][] input = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(ans.isValidSudoku(input));
    }
}
