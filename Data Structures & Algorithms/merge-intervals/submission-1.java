class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.<int[]>comparingInt(a -> a[0])
                               .thenComparingInt(a -> a[1]));
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (!list.isEmpty() && list.get(list.size() - 1)[1] >= intervals[i][0]) {
                    if (list.get(list.size() - 1)[1] < intervals[i][1]) {
                        list.get(list.size() - 1)[1] = intervals[i][1];
                    }
            }
            else {
                list.add(intervals[i]);
            }
        }
        int[][] array2D = list.toArray(new int[0][]);
        return array2D;
    }
}
