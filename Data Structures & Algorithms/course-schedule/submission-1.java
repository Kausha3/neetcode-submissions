class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int count = 0;
        int n = prerequisites.length;
        // Build graph: prereq → course
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];
        for (int j = 0; j < n; j++) {
            adj.get(prerequisites[j][0]).add(prerequisites[j][1]);
            inDegree[prerequisites[j][1]]++;
        }
        
       Queue<Integer> queue = new LinkedList<>();
       for (int k = 0; k < numCourses; k++) {
        if(inDegree[k] == 0) {
            queue.offer(k);
        }
       }

// Kahn’s algorithm, counting how many courses we “unlock”

       while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            for (int k: adj.get(node)) {
                inDegree[k]--;
                if (inDegree[k] == 0) {
                    queue.offer(k);
                }
            }
            
       }
    
        return count == numCourses;
    }
}
