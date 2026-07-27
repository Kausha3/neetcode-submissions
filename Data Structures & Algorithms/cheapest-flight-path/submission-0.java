class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    T getFirst() {
        return this.first;
    }
    U getSecond() {
        return this.second;
    }
}

class Triple<T, U, V> {
    private T first;
    private U second;
    private V third;

    public Triple(T first, U second, V third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    T getFirst() {
        return this.first;
    }
    U getSecond() {
        return this.second;
    }
    V getThird() {
        return this.third;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair<Integer,Integer>>> adj = new ArrayList<>();
        int[] cost = new int[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            cost[i] = Integer.MAX_VALUE;
        }
        for (int j = 0; j < flights.length; j++) {
            // f[0] → source, f[1] → destination, f[2] → price
            adj.get(flights[j][0]).add(new Pair<>(flights[j][1], flights[j][2]));
        }
        cost[src] = 0;
        int totalStops = 0;
        Queue<Triple<Integer, Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Triple<>(totalStops, src, cost[src]));

        while(!queue.isEmpty()) {
            Triple<Integer, Integer, Integer> node = queue.poll();
            int stopTaken = node.getFirst();
            int airport = node.getSecond();
            int costTaken = node.getThird();

            if (stopTaken < k + 1) {
                for (Pair subList : adj.get(airport)) {
                    int adjN = (int) subList.getFirst();
                    int edW = (int) subList.getSecond();
                    
                        int totalCost = costTaken + edW;
                        if (totalCost < cost[adjN]) {
                            cost[adjN] = totalCost;
                            queue.offer(new Triple<>(stopTaken + 1, adjN, totalCost));
                        }
                    }
                    
                
            }
            else continue;
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }
}
