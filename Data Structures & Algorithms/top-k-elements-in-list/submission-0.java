class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countFreq = new HashMap<>();
        //Counting frequency
        for (int i: nums) {
            if(!countFreq.containsKey(i)) {
                countFreq.put(i, 1);
            }
            else {
                int currCount = countFreq.get(i);
                countFreq.put(i, currCount + 1);
            }
        }
        //Creating and initializing bucket to store freq, count
        List<Integer>[] bucketFreq = new List[nums.length + 1];
        for (int j = 0; j < bucketFreq.length; j++ ) {
            bucketFreq[j] = new ArrayList<>();
        } 

        //Filling the bucket
        for (Map.Entry<Integer, Integer> entry : countFreq.entrySet()) {
            int number = entry.getKey();      // The actual number from array
            int frequency = entry.getValue();  // How many times it appears
            
            // Add the number to the bucket at index = frequency
            bucketFreq[frequency].add(number);
        }

        int[] resArray = new int[k];
        int count = 0;
        for (int i = bucketFreq.length - 1; i >=0 && count < k; i--) {
            for(int n: bucketFreq[i]) {
                resArray[count] = n;
                count++;
            }
        }
        return resArray;
    }
}
