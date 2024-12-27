package graph.easy;

public class 判断国际象棋棋盘中一个格子的颜色1812 {
    public static void main(String[] args) {
        squareIsWhite("a1");
    }

    public static boolean squareIsWhite(String coordinates) {
        int x = coordinates.charAt(0) - 96;
        int y = coordinates.charAt(1) - 48;
        return (x + y) % 2 == 0 ? false : true;
    }
}
