class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (k == 1) return nums;
        int[] resArray = new int[n - k + 1];
        Deque<Integer> queue = new ArrayDeque<>(); // Storing indices

        int l = 0;
        int r = 0;

        while (r < n) {
 
            while (!queue.isEmpty() && nums[r] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offerLast(r);
            if (l > queue.peekFirst()) {
                queue.pollFirst();
            }
            if (r - l + 1 == k) {
                resArray[l] = nums[queue.peekFirst()];
                l++;
            }
            r++;
        }
        return resArray;
        
    }
}
