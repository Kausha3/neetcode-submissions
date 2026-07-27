class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int maxArea = 0;

        while (l < r) {
            int width = r - l;
            int area = heights[l] < heights[r] ? heights[l] * width : heights[r] * width;
            if (area > maxArea) {
                maxArea = area;
            }
            if (heights[l] < heights[r]) {
                l++;
            }
            else {
                r--;
            }
        }
        return maxArea;
    }
}
