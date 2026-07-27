class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
		// int[0] = destnode, int[1] = weight
        Map<Integer, List<int[]>> adjList = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			adjList.put(i, new ArrayList<>());
		}

		for (int[] arr: times) {
			int source = arr[0];
			int dest = arr[1];
			int weight = arr[2];
			adjList.get(source).add(new int[]{dest, weight});
		}

		//int[0] = distance, int[1] = node
		PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[0] - b[0]);
		queue.offer(new int[]{0, k});
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[k] = 0;

		while (!queue.isEmpty()) {
			int[] distNode = queue.poll();
			int source = distNode[1];
			int distance = distNode[0]; 

			List<int[]> adjNode = adjList.get(source);

			for (int[] node: adjNode) {
				int neighbor = node[0];
				int w = node[1];
				if (dist[neighbor] > w + distance) {
					dist[neighbor] = w + distance;
					queue.offer(new int[]{w + distance, neighbor});
				}
			}

		}
		int maxTime = 0;

		for (int i = 1; i <= n; i++) {
			if (dist[i] == Integer.MAX_VALUE) return -1;
			maxTime = Math.max(maxTime, dist[i]);
		}
		return maxTime;
    }
}
