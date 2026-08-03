class Solution {
    public boolean isHappy(int num) {
        Set<Integer> seen = new HashSet<>();
        while (true) {
            int sum = fun(num);
            if (sum == 1) return true;
            if (seen.contains(sum)) return false;
            seen.add(sum);
            num = sum;
        }
    }
    int fun (int n) {
        int sum = 0;
        while (n > 0) {
            int s = n % 10;
            System.out.println("n % 10 " + "" + s);
            sum += s * s;
            n = n / 10;
            System.out.println("n / 10 " + "" + n);
        }
        return sum;
    }
}
