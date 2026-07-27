class Solution {
    public void nextPermutation(int[] nums) {
        int index = -1;
        for (int i = nums.length - 2; i >= 0; i-- ) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            reverse(nums, 0);
            return;
        }

        for(int i = nums.length - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                swap(nums, i, index);
                break;
            }
        }
        reverse(nums, index + 1);
    }

    private void reverse(int[] nums, int start) {
        int left = start;
        int right = nums.length - 1;

        while (left <= right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int fIndex, int sIndex) {
        int temp = nums[fIndex];
        nums[fIndex] = nums[sIndex];
        nums[sIndex] = temp;
    }
}