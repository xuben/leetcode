class Solution {
	
    public int reverse(int x) {
    	String s = x + "";
    	int len = s.length();
    	char[] oldChars = s.toCharArray();
    	char[] newChars = new char[len];
    	if (x < 0) {
    		newChars = new char[len];
    		newChars[0] = '-';
    		for (int i = 1; i < len; i++) {
    			newChars[i] = oldChars[len - i];
    		}
    	} else {
    		newChars = new char[len];
    		for (int i = 0; i < len; i++) {
    			newChars[i] = oldChars[len - 1 - i];
    		}
    	}
    	try {
    		int result = Integer.parseInt(new String(newChars));
    		return result;
    	} catch (NumberFormatException e) {
    		return 0;
    	}
    }
}