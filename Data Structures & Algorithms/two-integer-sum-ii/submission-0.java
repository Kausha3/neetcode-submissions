class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0; 
        int end = numbers.length - 1;

        while (start <= end) {
            if (numbers[start] + numbers[end] == target && start != end) {
                return new int[]{start + 1, end + 1};
            } 

            if (numbers[start] + numbers[end] > target) {
                end--;
            }

            else if(numbers[start] + numbers[end] < target) {
                start++;
            }
        }
        return new int[0];
    }
}
