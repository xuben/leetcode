class Solution {

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("aa", "a"));
        System.out.println(solution.isMatch("aa", "a*"));
        System.out.println(solution.isMatch("ab", ".*"));
        System.out.println(solution.isMatch("aab", "c*a*b"));
        System.out.println(solution.isMatch("mississippi", "mis*is*p*."));
        System.out.println(solution.isMatch("", ".*"));
        System.out.println(solution.isMatch("", ""));
    }

    public boolean isMatch(String s, String p) {
        if (null == s) {
            return null == p;
        } else if (null == p) {
            return false;
        }
        int sLen = s.length();
        int pLen = p.length();

        boolean[][] table = new boolean[sLen + 1][pLen + 1];
        table[0][0] = true;
        for (int i = 1; i <= sLen; i++) {
            table[i][0] = false;
        }

        for (int i = 0; i <= sLen; i++) {
            char sVal = i > 0 ? s.charAt(i-1) : 0;
            for (int j = 1; j <= pLen; j++) {
                char prevPVal = j > 1 ? p.charAt(j-2):0;
                char pVal = p.charAt(j-1);
                boolean isNextStar = j < pLen && '*' == p.charAt(j);
                if (i > 0 && table[i - 1][j - 1]) {
                    if (equals(sVal, pVal)) {
                        table[i][j] = true;
                        continue;
                    } else if ('*' == pVal && equals(sVal, prevPVal)) {
                        table[i][j] = true;
                        continue;
                    }
                }
                if (i > 0 && table[i - 1][j]) {
                    if (isNextStar && equals(sVal, pVal)) {
                        table[i][j] = true;
                        continue;
                    } else if ('*' == pVal && equals(sVal, prevPVal)) {
                        table[i][j] = true;
                        continue;
                    }
                }
                if (table[i][j-1]) {
                    if ('*' == pVal || isNextStar) {
                        table[i][j] = true;
                        continue;
                    }
                }
                table[i][j] = false;
            }
        }
        return table[sLen][pLen];
    }

    private boolean equals(char sVal, char pVal) {
        return sVal == pVal || '.' == pVal || '.' == sVal;
    }
}