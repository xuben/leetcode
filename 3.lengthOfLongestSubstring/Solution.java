class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        HashMap<Integer, Integer> lastMap = new HashMap<>();
        int[] lastPositions = new int[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer lastPosition = lastMap.get((int)c);
            if (null == lastPosition) {
                lastPositions[i] = -1;
            } else {
                lastPositions[i] = lastPosition;
            }
            lastMap.put((int)c, i);
        }
        
        int maxLen = 0;
        int start = 0, end = -1;
        for (int i = 0; i < lastPositions.length; i++) {
            if (-1 == lastPositions[i] || lastPositions[i] < start || lastPositions[i] > end) {
                end++;
            } else {
                if (end - start + 1 > maxLen) {
                    maxLen = end - start + 1;
                }
                start = lastPositions[i] + 1;
                end = i;
            }
        }
        if (end - start + 1 > maxLen) {
            maxLen = end - start + 1;
        }
        return maxLen;
    }
}