public class Solution {

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public int maxArea(int[] height) {
        int area = 0;
        int w = 0;
        int h = 0;
        int len = height.length;
        for (int i = 0; i < len - 1; i++) {
            if (i != 0 && height[i] <= height[i-1]) {
                continue;
            }
            w = len - 1 - i;
            h = Math.min(height[i], height[len-1]);
            area = Math.max(area, w * h);
            for (int j = len - 2; j > i; j--) {
                if (height[j] <= height[j+1]) {
                    continue;
                }
                w = j - i;
                h = Math.min(height[i], height[j]);
                area = Math.max(area, w * h);
            }
        }
        return area;
    }
}
