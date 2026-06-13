class Solution {
    public int leastInterval(char[] tasks, int n) {


        HashMap<Character,Integer> freqMap = new HashMap<>();

        for(char task : tasks) {
            freqMap.put(task, freqMap.getOrDefault(task,0)+1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(Map.Entry<Character,Integer> entry : freqMap.entrySet()) {
            maxHeap.offer(entry.getValue());
        }

        int time = 0;
        while(!maxHeap.isEmpty()) {

            List<Integer> temp = new ArrayList<>();
            // each cycle n + 1
            for(int i = 0; i<n+1;i++) {
                if(!maxHeap.isEmpty()) {
                    temp.add(maxHeap.poll());
                }
            }

            for(int freq: temp) {
                if(--freq>0) {
                    maxHeap.offer(freq);
                }
            }

            time += maxHeap.isEmpty() ? temp.size() : n + 1;
        }

        return time;
    }
}
 