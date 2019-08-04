class Solution {

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("III"));
        System.out.println(solution.romanToInt("IV"));
        System.out.println(solution.romanToInt("IX"));
        System.out.println(solution.romanToInt("LVIII"));
        System.out.println(solution.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        int sum = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            char nc;
            switch (c) {
                case 'M':
                    sum += 1000;
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'C':
                    if (i < len - 1) {
                        nc = s.charAt(i+1);
                        if ('M' == nc) {
                            sum += 900;
                            i++;
                        } else if ('D' == nc) {
                            sum += 400;
                            i++;
                        } else {
                            sum += 100;
                        }
                    } else {
                        sum += 100;
                    }
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'X':
                    if (i < len - 1) {
                        nc = s.charAt(i+1);
                        if ('C' == nc) {
                            sum += 90;
                            i++;
                        } else if ('L' == nc) {
                            sum += 40;
                            i++;
                        } else {
                            sum += 10;
                        }
                    } else {
                        sum += 10;
                    }
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'I':
                    if (i < len - 1) {
                        nc = s.charAt(i+1);
                        if ('X' == nc) {
                            sum += 9;
                            i++;
                        } else if ('V' == nc) {
                            sum += 4;
                            i++;
                        } else {
                            sum += 1;
                        }
                    } else {
                        sum += 1;
                    }
                    break;
                default:
                    break;
            }
        }
        return sum;
    }
}