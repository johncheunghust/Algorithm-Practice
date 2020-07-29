import java.util.*;

public class wordSearchII {
    static List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here
        int a = board.length;
        int b = board[0].length;
        TrieNode root = buildTrie(words);

        List<String> ret = new ArrayList<>();

        for(int i=0;i<a;++i) {
            for(int j=0;j<b;++j) {
                dfs(board, i, j, root, ret);
            }
        }
        return ret;
    }

    static void dfs(char[][] board, int i, int j, TrieNode root, List<String> ret) {
        int m = board.length;
        int n = board[0].length;
        char a = board[i][j];
        if(a=='*'||root.next[a-'a']==null) {
            // the location has been used or the word doesnt exist
            return;
        }
        TrieNode p = root.next[a-'a'];
        if(p.word!=null) {
            ret.add(p.word);
            p.word=null;
        }
        board[i][j]='*';
        if(i>0) dfs(board, i-1, j, p, ret);
        if(i<m-1) dfs(board, i+1,j,p,ret);
        if(j>0) dfs(board, i, j-1, p,ret);
        if(j<n-1) dfs(board, i, j+1, p, ret);
        board[i][j]=a;
    }

    static TrieNode buildTrie(List<String> words) {
        TrieNode root = new TrieNode();
        for(String s: words) {
            TrieNode p = root;
            char[] cs = s.toCharArray();
            for(char c: cs) {
                if(p.next[c-'a']==null) p.next[c-'a'] = new TrieNode();
                p = p.next[c-'a'];
            }
            p.word = s;
        }
        return root;
    }
}

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    String word;
}