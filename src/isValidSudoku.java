public class isValidSudoku {
    public static void main(String[] args) {
//        [[".",".",".",".","5",".",".","1","."]
//        ,[".","4",".","3",".",".",".",".","."]
//        ,[".",".",".",".",".","3",".",".","1"]
//        ,["8",".",".",".",".",".",".","2","."]
//        ,[".",".","2",".","7",".",".",".","."]
//        ,[".","1","5",".",".",".",".",".","."]
//        ,[".",".",".",".",".","2",".",".","."]
//        ,[".","2",".","9",".",".",".",".","."]
//        ,[".",".","4",".",".",".",".",".","."]]

        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'3', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '.', '9'},
        };
        System.out.println(isValidSudoku(board));
    }

    static boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; ++i) {
            int[] bool = new int[9];
            for(int j=0; j<9;++j) {
                if(board[i][j]=='.') continue;
                int t = board[i][j]-'1';
                if(bool[t]==1)  return false;
                else bool[t] = 1;
            }
        }
        for(int i=0; i<9; ++i) {
            int[] bool = new int[9];
            for(int j=0; j<9;++j) {
                if(board[j][i]=='.') continue;
                int t = board[j][i]-'1';
                if(bool[t]==1)  return false;
                else bool[t] = 1;
            }
        }
        for(int i=0;i<9;i+=3) {
            for(int j=0;j<9;j+=3) {
                if(isLegal(board, i,j)) {
                    continue;
                }
                else return false;
            }
        }
        return true;
    }
    static boolean isLegal(char[][] board, int i, int j) {
        int[] bool = new int[9];
        for(int a=i; a<i+3; a++) {

            for(int b=j; b<j+3; b++)  {
                if(board[a][b]=='.') continue;
                int t = board[a][b]-'1';
                if(bool[t]==1) return false;
                else bool[t]=1;
            }
        }
        return true;
    }
}
