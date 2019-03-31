class Solution {
    public String convert(String s, int numRows) {
        int len = s.length();
        char[] result = new char[len];
        int count = 0;
        for (int i = 0; i < numRows; i++) {
            int cur = i;
            boolean nextEven = true;
            while (cur < len) {
                result[count++] = s.charAt(cur);
                if (numRows <= 1) {
                    cur += 1;
                } else if (i == 0) {
                    cur += 2*(numRows-1-i);
                } else if (i == numRows - 1) {
                    cur += 2*i;
                } else if (nextEven) {
                    cur += 2*(numRows-1-i);
                } else {
                    cur += 2*i;
                }
                nextEven = !nextEven;
            }
        }
        return new String(result);
    }
}