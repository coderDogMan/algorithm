package other.mid;

public class 剑指Offer12矩阵中的路径 {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (word.charAt(index) != board[i][j]) return false;
        index++;
        if (index == word.length()) return true;
        char temp = board[i][j];
        board[i][j] = '1';
        //上
        if (i > 0 && board[i - 1][j] != '1') {
            if (dfs(board, i - 1, j, word, index)) return true;
        }
        // 下
        if (i < board.length - 1 && board[i + 1][j] != '1') {
            if (dfs(board, i + 1, j, word, index)) return true;
        }
        //左
        if (j > 0 && board[i][j - 1] != '1') {
            if (dfs(board, i, j - 1, word, index)) return true;
        }
        //右
        if (j < board[0].length - 1 && board[i][j + 1] != '1') {
            if (dfs(board, i, j + 1, word, index)) return true;
        }
        board[i][j] = temp;
        index--;
        return false;
    }
}
//
//class Test {
//    public static void main(String[] args) {
////        System.out.println(Math.pow(2, -2147483648));
//        System.out.println((double) (1.0 / 21000000000000.0));
//
//    }
//}
//        {'A','B','C','E'},
//        {'S','F','C','S'},
//        {'A','D','E','E'}