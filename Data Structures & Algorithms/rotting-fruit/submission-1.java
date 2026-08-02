class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
		int freshCount = 0;
		Queue<int[]> queue = new ArrayDeque<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 2) {
					queue.offer(new int[]{i, j});
				}
				else if (grid[i][j] == 1) freshCount++;
			}
		}
		if (freshCount == 0) return 0;
		int time = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
            time += 1;
			while (size-- != 0) {
				int[] coord = queue.poll(); 

				for (int[] dir: dirs) {
					int newRow = coord[0] + dir[0];
					int newCol = coord[1] + dir[1];
					if (newRow >= 0 && newRow < grid.length && newCol >= 0 && 
                            newCol < grid[0].length && grid[newRow][newCol] == 1) {
						grid[newRow][newCol] = 2;
						queue.offer(new int[]{newRow, newCol});
						freshCount--;
					}
				}
			}
            if (freshCount == 0) return time;
			
		}
		return -1;

    }
}
