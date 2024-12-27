package writtentest.上海施福圣科技有限公司面试题;

import java.io.File;

public class FindFile {
    public static void main(String[] args) {
        File file = new File("C:\\MSDOS622\\Command\\com");
        dfs(file);
    }

    private static void dfs(File file) {
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                dfs(f);
            }
        } else {
            System.out.println(file.getName());
        }
    }
}
