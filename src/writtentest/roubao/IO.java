package writtentest.roubao;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class IO {
    public static void main(String[] args) {
        try {
            io();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void io() throws IOException {
        File file = new File("H:\\test\\Exercisel.txt");
        if (!file.exists()) {
            boolean newFile = file.createNewFile();
        }
        file.canWrite();
        FileWriter fileWriter = new FileWriter(file);
        Random random = new Random();
        int[] nums = new int[100];
        for (int i = 0; i < 100; i++) nums[i] = random.nextInt();
        Arrays.sort(nums);
        for (int i = 0; i < 100; i++) {
            fileWriter.write('a');
//            fileWriter.append((char) ('0' + 49 + nums[i]));
        }
        fileWriter.flush();

    }

}
