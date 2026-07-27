class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> preList = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        int n = prerequisites.length;
        for (int i = 0; i < numCourses; i++) {
            preList.add(new ArrayList<>());
        }

        for (int j = 0; j < n; j++) {
            preList.get(prerequisites[j][0]).add(prerequisites[j][1]);
            inDegree[prerequisites[j][1]]++;
        }

       Queue<Integer> queue = new LinkedList<>();
       for (int k = 0; k < numCourses; k++) {
        if(inDegree[k] == 0) {
            queue.offer(k);
        }
       }

       while (!queue.isEmpty()) {
            int course = queue.poll();
            List<Integer> preReq = preList.get(course);

            if (!preReq.isEmpty()) {
                for (int k: preReq) {
                    inDegree[k]--;
                    if (inDegree[k] == 0) {
                        queue.offer(k);
                    }
                }
            }
       }
       for (int check = 0; check < numCourses; check++) {
            if (inDegree[check] != 0) return false;
       }
        return true;
    }
}
