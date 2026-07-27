class Triple<T, U, V> {
    private T first;
    private U second;
    private V third;

    public Triple(T first, U second, V third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
    
    public T getFirst() {
        return first;
    }
    
    public U getSecond() {
        return second;
    }
    
    public V getThird() {
        return third;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int time = 0;
        int count = 0;
        int[] di = {-1,0,1,0};
        int[] dj = {0,1,0,-1};
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        Queue<Triple<Integer, Integer, Integer>> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 1) count++;
                if(grid[i][j] == 2 && !visited[i][j]) {
                    queue.offer(new Triple<>(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty()) {

            Triple<Integer, Integer, Integer> current = queue.poll();
            int x = current.getFirst();
            int y = current.getSecond();
            int t = current.getThird();

            time = Math.max(time, t);

            for (int i = 0; i < 4; i++) {
                int nx = x + di[i];
                int ny = y + dj[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && grid[nx][ny] == 1) {
                    queue.offer(new Triple<>(nx, ny, t + 1));
                    count--;
                    visited[nx][ny] = true;
                }
            }
        }
        
        if (count == 0) {
            return time;
        }
        return -1;
    }
}
