class Solution {

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(3));
        System.out.println(solution.intToRoman(4));
        System.out.println(solution.intToRoman(9));
        System.out.println(solution.intToRoman(58));
        System.out.println(solution.intToRoman(1994));
    }

    public String intToRoman(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        int remain = num;
        while (remain > 0) {
            if (remain >= 1000) {
                stringBuilder.append("M");
                remain -= 1000;
            } else if(remain >= 900) {
                stringBuilder.append("CM");
                remain -= 900;
            } else if (remain >= 500) {
                stringBuilder.append("D");
                remain -= 500;
            } else if (remain >= 400) {
                stringBuilder.append("CD");
                remain -= 400;
            } else if (remain >= 100) {
                stringBuilder.append("C");
                remain -= 100;
            } else if (remain >= 90) {
                stringBuilder.append("XC");
                remain -= 90;
            } else if (remain >= 50) {
                stringBuilder.append("L");
                remain -= 50;
            } else if (remain >= 40) {
                stringBuilder.append("XL");
                remain -= 40;
            } else if (remain >= 10) {
                stringBuilder.append("X");
                remain -= 10;
            } else if (remain >= 9) {
                stringBuilder.append("IX");
                remain -= 9;
            } else if (remain >= 5) {
                stringBuilder.append("V");
                remain -= 5;
            } else if (remain >= 4) {
                stringBuilder.append("IV");
                remain -= 4;
            } else {
                stringBuilder.append("I");
                remain -= 1;
            }
        }
        return stringBuilder.toString();
    }
}