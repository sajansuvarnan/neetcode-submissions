class Twitter {

    private Map<Integer,Set<Integer>> followMap;
    private Map<Integer,List<Tweet>> tweetMap;
    private int time;

    class Tweet {
        int tweetId;
        int time; 

        public Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        time  = 0;
    }
    
    public void postTweet(int userId, int tweetId) {

        tweetMap.computeIfAbsent(userId,k -> new ArrayList<>()).add(new Tweet(tweetId, time++));
        
    }
    
    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>( (a,b) -> b.time - a.time);

        if(tweetMap.containsKey(userId)) {
            maxHeap.addAll(tweetMap.get(userId));
        }

        Set<Integer> followees = followMap.getOrDefault(userId, new HashSet<>());
        List<Integer> result = new ArrayList<>();
        for(int followee : followees) {
            maxHeap.addAll(tweetMap.get(followee));
        }

        while(!maxHeap.isEmpty() && result.size()<10) {
            result.add(maxHeap.poll().tweetId);
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId!=followeeId) {
         followMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {

        if(followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
