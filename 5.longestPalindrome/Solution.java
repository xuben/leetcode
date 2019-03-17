class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = 1;
            for (int j = 1; i - j >= 0 && i + j < s.length(); j++) {
                if (s.charAt(i-j) != s.charAt(i+j)) {
                    break;
                }
                len += 2;
            }
            if (len > maxLen) {
                maxLen = len;
                start = i - (len-1)/2;
            }
            
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
                len = 2;
                for (int j = 1; i - j >= 0 && i + 1 + j < s.length(); j++) {
                    if (s.charAt(i-j) != s.charAt(i+1+j)) {
                        break;
                    }
                    len += 2;
                }
                if (len > maxLen) {
                    maxLen = len;
                    start = i + 1 - len/2;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}