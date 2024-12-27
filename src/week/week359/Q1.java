package week.week359;

import java.util.List;

public class Q1 {

    public boolean isAcronym(List<String> words, String s) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word.charAt(0));
        }
        return s.equals(sb.toString());

    }
}
