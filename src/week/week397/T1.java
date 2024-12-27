package week.week397;

import week.week.year2024firstQuarter.石子游戏VII1690;

import java.util.HashMap;

/**
 * @Author: min
 * @Date:
 */
class T1 {

    public int findPermutationDifference(String s, String t) {
        int ans = 0;
        int $Usdollars;
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            map1.put(s.charAt(i) - 'a', i);
        for (int i = 0; i < s.length(); i++)
            map2.put(t.charAt(i) - 'a', i);
        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - 'a';
            ans += Math.abs(map1.get(x) - map2.get(x));
        }
        return ans;
    }

    public float aMethod(float a,float b){return 0;}
    public int aMethod(int a, int b){return 0;}
}
class Super {
    public Integer getLenght() { return new Integer(4); }
}
class Sub extends Super {

    public static void main(String[] args) {
        Super sooper = new Super();
        Sub sub = new Sub();
        System.out.println(sooper.getLenght().toString() + "," +
                sub.getLenght().toString() );
    }
}

class Example{
    String str=new String("hello");
    char[]ch={'a','b'};
    public static void main(String args[]){
        Example ex=new Example();
        ex.change(ex.str,ex.ch);
        System.out.print(ex.str+" and ");
        System.out.print(ex.ch);
    }
    public void change(String str,char ch[]){
        str="test ok";
        ch[0]='c';
    }
}