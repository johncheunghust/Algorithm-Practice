public class exist {
    public static void main(String[] args) {
        char[][] board = {{'a', 'b'}};
        String word = "ba";
        System.out.println(exist(board, word));
    }
    static boolean exist(char[][] board, String word) {
        int m = board.length;
        if(m==0) return false;
        int n = board[0].length;
        if(n==0) return false;
        for(int i=0; i<m; ++i) {
            for(int j=0; j<n; ++j) {
                if(board[i][j]==word.charAt(0)) {
                    if(dfs(board, 1, word, i, j)) return true;
                }
            }
        }
        return false;
    }

    static boolean dfs(char[][] board, int idx,String word, int i, int j) {
        if(idx==word.length()) return true;
        char t = board[i][j];
        board[i][j] = 0;
        int m = board.length;
        int n = board[0].length;
        char w = word.charAt(idx);
        if(i-1>=0&&board[i-1][j]==w) {
            if(dfs(board, idx+1, word, i-1, j)) return true;
        }
        if(i+1<m&&board[i+1][j]==w) {
            if(dfs(board, idx+1, word, i+1, j)) return true;
        }
        if(j-1>=0&&board[i][j-1]==w) {
            if(dfs(board, idx+1, word, i, j-1)) return true;
        }
        if(j+1<n&&board[i][j+1]==w) {
            if(dfs(board, idx+1, word, i, j+1)) return true;
        }
        board[i][j] = t;
        return false;

    }
}
