class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            //Left half sorted
            if (nums[0] <= nums[mid]) {
                if (target <= nums[mid]) {
                    if (target < nums[0]) {
                        start = mid + 1;
                    }
                    else {
                        end = mid - 1;
                    }
                }
                else {
                    start = mid + 1;
                }
            }
            //Right half sorted
            else if (nums[mid] <= nums[n-1]) {
                if (target >= nums[mid]) {
                    if (target > nums[n-1]) {
                        end = mid - 1;
                    }
                    else {
                        start = mid + 1;
                    }
                }
                else {
                    end = mid - 1;
                }
            }
        }
        return -1;
       
    }
}
