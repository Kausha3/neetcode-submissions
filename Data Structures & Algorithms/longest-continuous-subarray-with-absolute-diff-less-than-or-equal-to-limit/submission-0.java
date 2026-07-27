class Solution {
    public int longestSubarray(int[] array, int limit) {
        Deque<Integer> max = new ArrayDeque<>();
		Deque<Integer> min = new ArrayDeque<>();
		int left = 0;
		int maxLength = -1;

		for (int i = 0; i < array.length; i++) {
			while (!max.isEmpty() && array[max.peekLast()] < array[i]) {
				max.pollLast();
			}

			while (!min.isEmpty() && array[min.peekLast()] > array[i]) {
				min.pollLast();
			}

			max.offerLast(i);
			min.offerLast(i);

			while (Math.abs(array[max.peekFirst()] - array[min.peekFirst()]) > limit ) {
				if (array[max.peekFirst()] == array[left]) max.pollFirst();

				if (array[min.peekFirst()] == array[left]) min.pollFirst();
				left++;
			}

			maxLength = Math.max(maxLength, i - left + 1);
		}
	return maxLength;

    }
}