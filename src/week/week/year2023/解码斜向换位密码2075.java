package week.week.year2023;

public class 解码斜向换位密码2075 {
    public String decodeCiphertext(String encodedText, int rows) {
        if (encodedText.equals("")) return "";
        int n = encodedText.length();
        int cols = n / rows;
        char[][] map = new char[rows][cols];
        int num = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                map[i][j] = encodedText.charAt(i * cols + j);
                if (map[i][j] <= 'z' && map[i][j] >= 'a') num++;
            }
        }
        StringBuilder sb = new StringBuilder();


        for (int j = 0; j < cols; j++) {
            int c = j;
            for (int r = 0; c < cols && r < rows; r++, c++) {
                sb.append(map[r][c]);
                if (map[r][c] <= 'z' && map[r][c] >= 'a') num--;
                if (num == 0) return sb.toString();
            }
        }

        return null;
    }
}

class Test21 {
    public static void main(String[] args) {
        解码斜向换位密码2075 test = new 解码斜向换位密码2075();
//        test.decodeCiphertext("iveo    eed   l te   olc", 4);
//        test.decodeCiphertext("ch   ie   pr", 3);
        test.decodeCiphertext(" b  ac", 2);
    }
}