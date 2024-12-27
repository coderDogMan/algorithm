package writtentest.yongyou2023;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;

public class 坐标系 {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        Class<? extends ArrayList> aClass = list.getClass();
        Method add = aClass.getMethod("add", Object.class);
        add.invoke(list, "abc");
        System.out.println(list);
    }

}
