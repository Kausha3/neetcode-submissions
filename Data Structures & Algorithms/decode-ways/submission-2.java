class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        return recursion(0, s);
    }

    private int recursion(int index, String s) {
        if (index >= s.length()) {
            return 1;
        }

        if (s.charAt(index) == '0') return 0;
        int choose = 0;
        choose += recursion(index + 1, s); 
        if (index + 2 <= s.length()) {
            String str = s.substring(index, index + 2);
            int num = Integer.parseInt(str);
            if (num >= 10 && num <= 26) {
                choose +=recursion (index + 2, s);
            }
        }
         

        return choose;
    }
}
