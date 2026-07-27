class Solution {
    class Pair {
        int time;
        int freq;
        
        Pair (int freq, int time) {
            this.time = time;
            this.freq = freq;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> freqMap = new HashMap<>();

        for (char ch: tasks) {
           freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.addAll(freqMap.values());
        int globalTime = 0;
        Queue<Pair> queue = new LinkedList<>();
        while(!maxHeap.isEmpty() || !queue.isEmpty()) {
            int task = 0;
            if (!queue.isEmpty() && queue.peek().time == globalTime) {
                maxHeap.add(queue.poll().freq);
            }
            
            if (!maxHeap.isEmpty()) {
                task = maxHeap.poll();
            }
            globalTime++;
            if (task - 1 > 0) {
                queue.add(new Pair(task - 1, globalTime + n));
            }
        }
        return globalTime;
       
    }
}
