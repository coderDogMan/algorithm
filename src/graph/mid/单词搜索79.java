package graph.mid;

public class 单词搜索79 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (traversal(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    public boolean traversal(char[][] board, String word, int i, int j, int k) {
        if (word.charAt(k) != board[i][j]) return false;
        k++;
        if (k == word.length()) return true;
        //上
        board[i][j] += 256;
        if (i > 0 && board[i - 1][j] <= 'z' &&  board[i - 1][j] >= 'A')
            if (traversal(board, word, i - 1, j, k)) return true;
        //下
        if (i < board.length - 1 && board[i + 1][j] <= 'z' &&  board[i + 1][j] >= 'A')
            if (traversal(board, word, i + 1, j, k)) return true;
        //左
        if (j > 0 && board[i][j - 1] <= 'z' &&  board[i][j - 1] >= 'A')
            if (traversal(board, word, i, j - 1, k)) return true;
        //右
        if (j < board[0].length - 1 && board[i][j + 1] <= 'z' &&  board[i][j + 1] >= 'A')
            if (traversal(board, word, i, j + 1, k)) return true;
        board[i][j] -= 256;
        k--;
        return false;
    }
}
