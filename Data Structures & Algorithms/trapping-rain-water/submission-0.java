class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int lMax = 0;
        int rMax = 0;
        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            if (lMax < height[l]) {
                lMax = height[l];
            }
            if (rMax < height[r]) {
                rMax = height[r];
            }

            if (lMax < rMax) {
                ans = ans + (lMax - height[l]);
                l++;
            }
            else {
                ans = ans + (rMax - height[r]);
                r--;
            }
        }
        return ans;
    }
}
