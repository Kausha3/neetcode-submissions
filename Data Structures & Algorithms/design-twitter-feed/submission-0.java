class Twitter {

    class Pair {
        int timeStamp;
        int tweetID;

        Pair(int timeStamp, int tweetID) {
            this.timeStamp = timeStamp;
            this.tweetID = tweetID;
        } 
    }
    int globalTime = 0;
    HashMap<Integer, HashSet<Integer>> forFollowers;
    HashMap<Integer, List<Pair>> tweetPosted;

    public Twitter() {
        forFollowers = new HashMap<>();
        tweetPosted = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetPosted.putIfAbsent(userId, new ArrayList<>());
        tweetPosted.get(userId).add(new Pair(globalTime++, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.timeStamp - a.timeStamp);
        HashSet<Integer> followees = new HashSet<>();
        if (forFollowers.containsKey(userId)) {
           followees = forFollowers.get(userId);
        }
        if (tweetPosted.containsKey(userId)) {
            List<Pair> tweets = tweetPosted.get(userId);
                for (Pair tweet: tweets) {
                    maxHeap.add(tweet);
                }
        }

        for (int followeeId : followees) {
            if (tweetPosted.containsKey(followeeId)) {
                List<Pair> tweets = tweetPosted.get(followeeId);

                for (Pair tweet: tweets) {
                    maxHeap.add(tweet);
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        int k = 0;
       while (!maxHeap.isEmpty() && k < 10) {
            res.add(maxHeap.remove().tweetID);
            k++;
        }
         return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId) {
            
            forFollowers.putIfAbsent(followerId, new HashSet<>());
            forFollowers.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (forFollowers.containsKey(followerId)) {
            forFollowers.get(followerId).remove(followeeId);
        }
    }
}
