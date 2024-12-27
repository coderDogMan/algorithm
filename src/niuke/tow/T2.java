package niuke.tow;

import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] arr = new String[]{
        "Rat"
        ,"Ox"
        ,"Tiger"
        ,"Rabbit"
        ,"Dragon"
        ,"Snake"
        ,"Horse"
        ,"Sheep"
        ,"Monkey"
        ,"Rooster"
        ,"Dog"
        ,"Pig"};
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            System.out.println(arr[(num + 8) % 12]);
        }

    }
}
