package writtentest.上海施福圣科技有限公司面试题;


import java.util.*;

//离线搜索
public class Main {
    private static ArrayList<Student> list;
    public static void main(String[] args) {
        init();
        // 记录三个状态 姓名 年份 平均分 同时减小空间复杂度
        HashMap<String, HashMap<Integer, Integer>> map = new HashMap<>();
        // 记录出现过的年份 用于格式化输出
        HashSet<Integer> years = new HashSet<>();
        for (Student student : list) {
            years.add(student.getYear());
            if (map.containsKey(student.getName()) && map.get(student.getName()).containsKey(student.getYear())) {
                HashMap<Integer, Integer> year = map.get(student.getName());
                year.put(student.getYear(), (year.get(student.getYear()) + student.getFenshu()) >> 1);
            } else if (map.containsKey(student.getName())) {
                map.get(student.getName()).put(student.getYear(), student.getFenshu());
            } else {
                HashMap<Integer, Integer> year = new HashMap<>();
                year.put(student.getYear(), student.getFenshu());
                map.put(student.getName(), year);
            }
        }
        //格式化输出
        int[] sortYears = years.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(sortYears);
        for (int sortYear : sortYears) {
            System.out.print("       " + sortYear);
        }
        System.out.println();
        for (String name : map.keySet()) {
            System.out.print(name + "     ");
            for (int year : sortYears) {
                if (map.get(name).containsKey(year)) {
                    System.out.print(map.get(name).get(year) + "        ");
                } else {
                    System.out.print("          ");
                }
            }

            System.out.println();
        }


    }

    private static void init() {
        list = new ArrayList<>();
        list.add(new Student("张三","语文",82,2014));
        list.add(new Student("张三","数学",88,2014));
        list.add(new Student("张三","语文",73,2015));
        list.add(new Student("张三","数学",73,2015));

        list.add(new Student("李四","语文",80,2014));
        list.add(new Student("李四","数学",60,2014));
        list.add(new Student("李四","语文",78,2015));
        list.add(new Student("李四","数学",82,2015));

        list.add(new Student("王五","英语",90,2016));
        list.add(new Student("王五","英语",90,2014));
        list.add(new Student("王五","英语",90,2015));

        list.add(new Student("赵六","英语",90,2017));
        list.add(new Student("赵六","英语",90,2018));

    }
}

class Student {
    private String name;
    private String kecheng;
    private Integer fenshu;
    private Integer year;

    public Student(String name, String kecheng, Integer fenshu, Integer year) {
        this.name = name;
        this.kecheng = kecheng;
        this.fenshu = fenshu;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKecheng() {
        return kecheng;
    }

    public void setKecheng(String kecheng) {
        this.kecheng = kecheng;
    }

    public Integer getFenshu() {
        return fenshu;
    }

    public void setFenshu(Integer fenshu) {
        this.fenshu = fenshu;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
