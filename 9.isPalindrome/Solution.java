class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
        	return false;
        }
        int t = x;
        int y = 0;
        int Y_LIMIT = Integer.MAX_VALUE / 10;
        while (t > 0) {
        	int remainder = t % 10;
        	if (y > Y_LIMIT || (y == Y_LIMIT && remainder > 7)) {
        		return false;
        	}
        	
        	t = t / 10;
        	y = y * 10 + remainder;
        }
        return x == y;
    }
}