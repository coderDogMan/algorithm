package other.mid;

import java.util.LinkedList;
import java.util.Stack;

public class 字符串解码394 {
    public String decodeString(String s) {
        StringBuffer ans=new StringBuffer();
        Stack<Integer> multiStack=new Stack<>();
        Stack<StringBuffer> ansStack=new Stack<>();
        int multi=0;
        for(char c:s.toCharArray()){
            if(Character.isDigit(c))multi=multi*10+c-'0';
            else if(c=='['){
                ansStack.add(ans);
                multiStack.add(multi);
                ans=new StringBuffer();
                multi=0;
            }else if(Character.isAlphabetic(c)){
                ans.append(c);
            }else{
                StringBuffer ansTmp=ansStack.pop();
                int tmp=multiStack.pop();
                for(int i=0;i<tmp;i++)ansTmp.append(ans);
                ans=ansTmp;
            }
        }
        return ans.toString();
    }
}

