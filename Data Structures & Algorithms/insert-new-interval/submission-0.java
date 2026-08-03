class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            int[][] result = new int[1][2];
            result[0] = newInterval;
            return result;
        }
        List<int[]> list = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && newInterval[0] > intervals[i][1]) {
            list.add(intervals[i]);
            i++;
        }

        int start = newInterval[0];
        int end = newInterval[1];
        while (i < intervals.length && start <= intervals[i][1] 
                && end >= intervals[i][0]) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        list.add(new int[]{start, end});

        while(i < intervals.length) {
            list.add(intervals[i]);
            i++;
        }       
        return list.toArray(new int[list.size()][]);
    }
}
                
