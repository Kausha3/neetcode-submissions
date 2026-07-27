class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        list.add(intervals[0]);
        int j = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= list.get(j)[1]) {
                if (intervals[i][1] > list.get(j)[1]) {
                    list.get(j)[1] = intervals[i][1];
                }
            }
            else {
                j += 1;
                list.add(intervals[i]);
            }
        }

        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
