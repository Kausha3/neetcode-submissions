class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];

        Deque<Integer> deque = new LinkedList<>();

        int left = 0;
        int right = 0;

        while (right < nums.length) {
            if (!deque.isEmpty() && deque.peekFirst() < left) deque.pollFirst();
            while (!deque.isEmpty() && nums[right] > nums[deque.peekLast()]) {
                    deque.pollLast();
            }
            deque.addLast(right);
            if (right - left + 1 == k) {
                ans[left] = nums[deque.peekFirst()];
                left++;
            }
            right++;
        }
        return ans;
    }
}
