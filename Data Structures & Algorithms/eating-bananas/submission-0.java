class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = -1;
        int start = 1;

        for (int i = 0; i < piles.length; i++) {
            if (max < piles[i]) {
                max = piles[i];
            }
        }
        
        int end = max;
        int res = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            int hour = 0;
            for (int i = 0; i < piles.length; i++) {
                // hour += Math.ceil((double) piles[i] / mid);
                hour += (piles[i] + mid - 1) / mid;
            }
            if (hour <= h) {
                res = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return res;
    }
}
