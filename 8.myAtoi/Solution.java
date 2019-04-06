class Solution {
	
	public int myAtoi(String str) {
		if (null == str || str.length() == 0) {
			return 0;
		}
		boolean negative = false;
		int p = -1;
		int value = 0;
        for (int i = 0; i < str.length(); i++) {
        	char c = str.charAt(i);
        	if (c == ' ') {
        	} else if (c == '+') {
        		p = i;
        		break;
        	} else if (c == '-') {
        		negative = true;
        		p = i;
        		break;
        	} else if (c >= '0' && c <= '9') {
        		value = c - '0';
        		p = i;
        		break;
        	} else {
        		return 0;
        	}
        }
        if (p < 0) {
        	return 0;
        }
        for (int i = p + 1; i < str.length(); i++) {
        	char c = str.charAt(i);
        	if (c >= '0' && c <= '9') {
        		int v = c - '0';
        		if (negative) {
        			if (value < Integer.MIN_VALUE / 10 
        					|| (value == Integer.MIN_VALUE / 10 && -v <= Integer.MIN_VALUE % 10)) {
        				return Integer.MIN_VALUE;
        			} else {
        				value = value * 10 -v;
        			}
        		} else {
        			if (value > Integer.MAX_VALUE / 10 
        					|| (value == Integer.MAX_VALUE / 10 && v >= Integer.MAX_VALUE % 10)) {
        				return Integer.MAX_VALUE;
        			} else {
        				value = value * 10 + v;
        			}
        		}
        	} else {
        		return value;
        	}
        }
        return value;
    }
}