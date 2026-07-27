class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) return stones[0];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int n: stones) {
            maxHeap.offer(n);
        }

        while (maxHeap.size() > 1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();

            if (first > second) {
                maxHeap.offer(first - second);
            }
        } 

        return maxHeap.isEmpty()? 0: maxHeap.peek();
        
    }
}
