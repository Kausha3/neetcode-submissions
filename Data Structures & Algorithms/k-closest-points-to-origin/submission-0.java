class Solution {
    public int[][] kClosest(int[][] arr, int k) {
        
        		PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0] - a[0]);
		
		for (int i = 0; i < arr.length; i++) {
			int x = arr[i][0];
			int y = arr[i][1];
			int dist=(x * x)+(y * y);
			maxHeap.add(new int[]{dist,x, y});
			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		int[][] result = new int[k][2];
		int i = 0;
		while (maxHeap.size() != 0) {
			int[] coord = maxHeap.poll();
			result[i] = new int[]{coord[1], coord[2]};
			i++;
		}
		return result;
    }
}
