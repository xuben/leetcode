class Solution {

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (0 == strs.length) {
            return "";
        } else if (1 == strs.length) {
            return strs[0];
        }
        String prefix = "";
        String template = strs[0];
        int len = template.length();
        outter:
        for (int i = 0; i < len; i++) {
            char c = template.charAt(i);
            for (String str : strs) {
                if (str.length() <= i) {
                    break outter;
                } else if (str.charAt(i) != c) {
                    break outter;
                }
            }
            prefix += c;
        }
        return prefix;
    }
}