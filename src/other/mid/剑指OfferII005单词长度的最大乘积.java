package other.mid;

public class 剑指OfferII005单词长度的最大乘积 {
    public int maxProduct(String[] words) {
        // O(mn)
        int n = words.length;
        int[] masks = new int[n];
        for (int i = 0; i < n; i++) {
            int bitMask = 0;
            for (char c : words[i].toCharArray()) {
                bitMask |= (1 << (c - 'a'));
            }
            masks[i] = bitMask;
        }

        // O(n^2)
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            String word1 = words[i];
            for (int j = i + 1; j < words.length; j++) {
                String word2 = words[j];
                if ((masks[i] & masks[j]) == 0) {
                    ans = Math.max(ans, word1.length() * word2.length());
                }
            }
        }
        return ans;
    }
}

class Test12 {
    public static void main(String[] args) {
        剑指OfferII005单词长度的最大乘积 test = new 剑指OfferII005单词长度的最大乘积();
        test.maxProduct(new String[]{"abcw","baz","foo","bar","fxyz","abcdef"});
    }
}